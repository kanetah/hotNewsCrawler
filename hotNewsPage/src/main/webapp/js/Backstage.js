$(function () {

    $("#SelectAll_UserSA").click(function () {
        if ($("#Anti-election_UserAe").prop("checked")) {
            $("#Anti-election_UserAe").removeAttr("checked");
        }
        if ($("#SelectAll_UserSA").prop("checked")) {
            $("input[name = 'checkbox']").prop("checked", true);
        }
        else {
            $("input[name = 'checkbox']").prop("checked", false);
        }
    })
    $("#Anti-election_UserAe").click(function () {
        if ($("#SelectAll_UserSA").prop("checked")) {
            $("#SelectAll_UserSA").removeAttr("checked");
        }
        if ($("#Anti-election_UserAe").prop("checked")) {
            $("input[name = 'checkbox']").each(function () {
                if ($(this).prop("checked")) {
                    $(this).removeAttr("checked")
                } else {
                    $(this).prop("checked", true);
                }
            })
        }
        else {
            $("input[name = 'checkbox']").each(function () {
                if ($(this).prop("checked")) {
                    $(this).removeAttr("checked")
                } else {
                    $(this).prop("checked", true);
                }
            })
        }
    });
    $(".showUserInfo").dblclick(function () {
        var currentTd = $(this).find("td")
        var id = currentTd[1].innerHTML;
        var username = currentTd[2].innerHTML;

        $("#UserEditor").modal("show")

        $("#IDText").val(id)
        $("#userNameText").val(username)
    });
    $("#updateUserBtn").click(function () {
        var id = $("#IDText").val()
        var name = $("#userNameText").val()
        var regEn = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im,
            regCn = /[·！#￥（——）：；“”‘、，|《。》？、【】[\]]/im;

        if(regEn.test(name) || regCn.test(name)) {
            alert("名称不能包含特殊字符.");
            return false;
        }
        $.ajax({
            url: '/updateUserInfo',
            data: {
                id: id,
                name: name
            },
            success: function () {
                $('#UserEditor').modal('hide')
                $('#' + id).find('.userName').html(name)
            },
            error: function () {
                alert("error")
            }
        })
    });

    var pageCode;
    var items = [];
    var removeItems = function () {
        $.each(items, function (index, elem) {
            elem.remove();
        });
        items = [];
    };
    var showPageList = function (result, count) {
        for (var i = 0; i < result; i++) {
            $(".pagination > li:last-child").before('<li id="li_' + count + '"><a href="javascript:void(0)">' + count + '</a></li>');
            count++;
        }
        $('#li_1').addClass('active');
    };
    var insertUsers = function (showInfo,elem) {
            var node = $(showInfo).clone(true);
            node.find('.userID').html(elem.id);
            node.find('.userName').html(elem.username);
            node.attr("id", elem.id);
            node.removeClass('showUserInfo');
            node.removeClass('showUserInfo1');
            $(node).attr('hidden', false);
            items.push(node);
            node.insertBefore(showInfo);
    };
    var showUsers = function (pageCode) {
        var showInfo = $('.showUserInfo');
        $.ajax({
            url: "/userPagination",
            data: {
                pageCode: pageCode
            },
            success: function (result) {
                removeItems();
                $.each(result, function (idx, elem) {
                    insertUsers(showInfo,elem);
                });
            },
            error: function () {
                alert('show user error')
            }
        })
    };
    var userPage = function (count, pageCode) {
        $.ajax({
            url: "/userPageCount",
            success: function (result) {
                showPageList(result,count);
                showUsers(1);
                $(".pagination li a").click(function () {
                    var id = $(this).parent().attr('id');
                    if ($('#user').attr('class') === 'active') {
                        if (id === "previous") {
                            if (pageCode > 1) {
                                pageCode = Number(pageCode) - 1;
                                showUsers(pageCode);
                                $('.pagination li').removeClass('active');
                                $('#li_' + pageCode).addClass('active');
                            }
                        }
                        else if (id === "next") {
                            if (pageCode < (result)) {
                                pageCode = Number(pageCode) + 1;
                                showUsers(pageCode);
                                $('.pagination li').removeClass('active');
                                $('#li_' + pageCode).addClass('active');
                            }
                        }
                        else {
                            pageCode = id.substring(3, id.length + 1);
                            $('.pagination li').removeClass('active');
                            $(this).parent().addClass('active');
                            showUsers(pageCode)
                        }
                    }
                })
            }
        })
    };

    userPage(1, 1);

    $("#Delete-btn").click(function () {
        $('input[name="checkbox"]:checked').each(function () {
            var id = $(this).parent().parent().attr('id');
            $.ajax({
                url: "/deleteUserById",
                data: {
                    id: id
                },
                success: function () {
                    $('#' + id).remove();
                    $.ajax({
                        url: '/deleteCommentByUserId',
                        data: {
                            userId: id
                        },
                        success: function () {
                        }
                    })
                    location.replace()
                },
                error: function () {
                    alert("delete error");
                }
            });
        })
    });
    $('#Add-btn').click(function () {
        $('#UserAdd').modal('show')
    });
    $('#AddUserBtn').click(function () {
        var newName = $('#newNameText').val();
        var password = $('#passwordText').val();
        var regEn = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\] ]/im,
            regCn = /[·！#￥（——）：；“”‘、，|《。》？、【】[\]]/im;

        if(regEn.test(newName) || regCn.test(newName)) {
            alert("名称不能包含特殊字符.");
            return false;
        }
        $.ajax({
            url: "/insertUser",
            data: {
                name: newName,
                password: password
            },
            success: function () {
                $('#UserAdd').modal('hide');
                $('#newNameText').val("");
                $('#passwordText').val("");
                $.ajax({
                    url: '/userPageCount',
                    success: function (result) {
                        if (pageCode !== result) {
                            showUsers(result);
                            $('.pagination li').removeClass('active');
                            $('#li_' + result).attr('class', 'active');
                        } else {
                            showUsers(result);
                        }
                    }
                })
            },
            error: function () {
                alert("error")
            }
        })
    });
    $("#showAllInfo1").click(function () {
        $.each($(".pagination li"), function (index, elem) {
            if ($(this).attr('id') !== 'previous') {
                if ($(this).attr('id') !== 'next') {
                    elem.remove();
                }
            }
        })
        $("#showAllInfo1").hide();
        $("#searchGroup").css('marginLeft', 845);
        showUsers(1);
        userPage(1, 1);
    });

    $("#SelectAll_NewsSA").click(function () {
        if ($("#Anti-election_NewsAe").prop("checked")) {
            $("#Anti-election_NewsAe").removeAttr("checked");
        }
        if ($("#SelectAll_NewsSA").prop("checked")) {
            $("input[name = 'newsCheckbox']").prop("checked", true);
        }
        else {
            $("input[name = 'newsCheckbox']").prop("checked", false);
        }
    })
    $("#Anti-election_NewsAe").click(function () {
        if ($("#SelectAll_UserSA").prop("checked")) {
            $("#SelectAll_UserSA").removeAttr("checked");
        }
        if ($("#Anti-election_NewsAe").prop("checked")) {
            $("input[name = 'newsCheckbox']").each(function () {
                if ($(this).prop("checked")) {
                    $(this).removeAttr("checked")
                } else {
                    $(this).prop("checked", true);
                }
            })
        }
        else {
            $("input[name = 'newsCheckbox']").each(function () {
                if ($(this).prop("checked")) {
                    $(this).removeAttr("checked")
                } else {
                    $(this).prop("checked", true);
                }
            })
        }
    });
    var showNews = $('.showNewsInfo');
    var insertNews = function (elem,showNews) {
            var node = $(showNews).clone('true');
            node.find('.newsID').html(elem.id);
            if (elem.title.length > 21) {
                var title = elem.title.substring(0, 21) + '...'
                node.find('.newsTitle').attr('title', elem.title);
            } else {
                var title = elem.title;
            }
            node.find('.newsTitle').html(title);
            node.find('.newsDate').html(elem.date);
            node.find('.newsType').html(elem.type);
            node.find('.newsRank').html(elem.rank);
            if (elem.src.length > 30) {
                var src = elem.src.substring(0, 30) + '...'
                node.find('.newsSrc').attr('title', elem.src);
            } else {
                var src = elem.src;
            }
            node.find('.newsSrc').html(src);
            node.attr('id', elem.id);
            node.removeClass('showNewsInfo');
            node.removeClass('showNewsInfo1');
            $(node).attr('hidden', false);
            items.push(node);
            node.insertBefore(showNews);
    };
    var newsList = function (pageCode) {
        $.ajax({
            url: "/newsPagination",
            data: {
                pageCode: pageCode
            },
            success: function (result) {
                removeItems();
                $.each(result, function (index, elem) {
                    insertNews(elem,showNews);
                });
            },
            error: function () {
                alert("error")
            }
        })
    };
    var newsPagination = function (count, pageCode) {
        $.ajax({
            url: "/newsPageCount",
            success: function (result) {
                showPageList(result,count);
                $(".pagination li a").click(function () {
                    var id = $(this).parent().attr('id');
                    if ($('#news').attr('class') === 'active') {
                        if (id === "previous") {
                            if (pageCode > 1) {
                                pageCode = Number(pageCode) - 1;
                                newsList(pageCode);
                                $('.pagination li').removeClass('active');
                                $('#li_' + pageCode).addClass('active');
                            }
                        }
                        else if (id === "next") {
                            if (pageCode < (result)) {
                                pageCode = Number(pageCode) + 1;
                                newsList(pageCode);
                                $('.pagination li').removeClass('active');
                                $('#li_' + pageCode).addClass('active');
                            }
                        }
                        else {
                            pageCode = id.substring(3, id.length + 1);
                            $('.pagination li').removeClass('active');
                            $(this).parent().addClass('active');
                            newsList(pageCode)
                        }
                    }

                })
            }
        })
    };
    $("#SearchType").bind("change", function () {
        if (this.value == "newsDateKey") {
            $('.dateChoose').show();
            $('#SearchText').hide();
            $('#SearchBtn').css('border-radius', '5px');
            $('#searchGroup').css('marginLeft','775px');
        } else {
            $('.dateChoose').hide();
            $('#SearchText').show();
            $('#SearchBtn').css('border-radius', '0px 5px 5px 0px');
            $('#searchGroup').css('marginLeft','845px');
            $('#showAllBtn').css('marginLeft','745px');
        }
    });
    $("#Delete-btn-news").click(function () {
        $('input[name="newsCheckbox"]:checked').each(function () {
            var id = $(this).parent().parent().attr('id');
            $.ajax({
                url: "/deleteNewsById",
                data: {
                    id: id
                },
                success: function () {
                    $('#' + id).remove();
                    $.ajax({
                        url: '/deleteCommentByNewsId',
                        data: {
                            userId: id
                        },
                        success: function () {
                        }
                    })
                },
                error: function () {
                }
            });
        })
    });
    $("#showAllInfo2").click(function () {
        $.each($(".pagination li"), function (index, elem) {
            if ($(this).attr('id') !== 'previous') {
                if ($(this).attr('id') !== 'next') {
                    elem.remove();
                }
            }
        })
        $("#showAllInfo2").hide();
        $("#searchGroup").css('marginLeft', 845);
        newsList(1);
        newsPagination(1, 1);
    });

    var showComment = $(".showCommentInfo");
    var insertComments = function (elem,showComment) {
            var node = $(showComment).clone(true);
            node.find('.CommentId').html(elem.id);
            node.find('.UserId').html(elem.userName);
            node.find('.NewsId').html(elem.newsTitle);
            // var contents;
            // var content = elem.content.substring(0, elem.content.length - 8) + elem.content.substring(elem.content.length - 4, elem.content.length);
            var contents = elem.content.substring(3, elem.content.length - 4);
            var content;
            if (contents.length > 30) {
                content = elem.content.substring(0, 25) + '...';
                node.find('.CommentContent').attr('title', contents);
            }else{
                content = contents;
            }
            node.find('.CommentContent').html(content);
            node.find('.CommentTime').html(elem.time);
            node.attr("id", elem.id);
        node.removeClass('showCommentInfo');
        node.removeClass('showCommentInfo1');
            $(node).attr('hidden', false);
            items.push(node);
            node.insertBefore(showComment);
    };
    var commentList = function (pageCode) {
        $.ajax({
            url: "/commentPagination",
            data: {
                pageCode: pageCode
            },
            success: function (result) {
                removeItems();
                $.each(result, function (index, elem) {
                    insertComments(elem,showComment);
                });
            },
            error: function () {
            }
        })
    };
    var commentPagination = function (count, pageCode) {
        $.ajax({
            url: "/commentPageCount",
            success: function (result) {
                showPageList(result,count);
                $(".pagination li a").click(function () {
                    var id = $(this).parent().attr('id');
                    if ($('#comment').attr('class') === 'active') {
                        if (id === "previous") {
                            if (pageCode > 1) {
                                pageCode = Number(pageCode) - 1;
                                commentList(pageCode);
                                $('.pagination li').removeClass('active');
                                $('#li_' + pageCode).addClass('active');
                            }
                        }
                        else if (id === "next") {
                            if (pageCode < (result)) {
                                pageCode = Number(pageCode) + 1;
                                commentList(pageCode);
                                $('.pagination li').removeClass('active');
                                $('#li_' + pageCode).addClass('active');
                            }
                        }
                        else {
                            pageCode = id.substring(3, id.length + 1);
                            $('.pagination li').removeClass('active');
                            $(this).parent().addClass('active');
                            commentList(pageCode)
                        }
                    }

                })
            }
        })
    };

    $("#SelectAll_CSA").click(function () {
        if ($("#Anti-election_CAe").prop("checked")) {
            $("#Anti-election_CAe").removeAttr("checked");
        }
        if ($("#SelectAll_CSA").prop("checked")) {
            $("input[name = 'commentCheckbox']").prop("checked", true);
        }
        else {
            $("input[name = 'commentCheckbox']").prop("checked", false);
        }
    })
    $("#Anti-election_CAe").click(function () {
        if ($("#SelectAll_CSA").prop("checked")) {
            $("#SelectAll_CSA").removeAttr("checked");
        }
        if ($("#Anti-election_CrAe").prop("checked")) {
            $("input[name = 'commentCheckbox']").each(function () {
                if ($(this).prop("checked")) {
                    $(this).removeAttr("checked")
                } else {
                    $(this).prop("checked", true);
                }
            })
        }
        else {
            $("input[name = 'commentCheckbox']").each(function () {
                if ($(this).prop("checked")) {
                    $(this).removeAttr("checked")
                } else {
                    $(this).prop("checked", true);
                }
            })
        }
    });
    $("#Delete-btn-comment").click(function () {
        $('input[name="commentCheckbox"]:checked').each(function () {
            var id = $(this).parent().parent().attr('id');
            $.ajax({
                url: "/deleteComments",
                data: {
                    id:id,
                },
                success: function () {
                    $('#' + id).remove();
                },
                error: function () {
                    alert("delete error");
                }
            });
        })
    });
    $("#showAllInfo3").click(function () {
        $.each($(".pagination li"), function (index, elem) {
            if ($(this).attr('id') !== 'previous') {
                if ($(this).attr('id') !== 'next') {
                    elem.remove();
                }
            }
        })
        $("#showAllInfo3").hide();
        $("#searchGroup").css('marginLeft', 845);
        commentList(1);
        commentPagination(1, 1);
    });

    var pageList = function () {
        $.each($(".pagination li"), function (index, e) {
            if ($(this).attr('id') !== 'previous') {
                if ($(this).attr('id') !== 'li_1') {
                    if ($(this).attr('id') !== 'next') {
                        e.remove();
                    }
                }
            }
        });
        $("#searchGroup").css('marginLeft', 1);
    };
    var showAlert = function () {
        $("#myAlert").show();
        $("#return").css('marginTop',25);
    };
    $(".close").click(function(){
        $("#myAlert").hide();
        $("#return").css('marginTop',0);
    });
    $('#SearchBtn').click(function () {
        var key = $("#SearchText").val();
        var newsKeyType = $(".selectpicker:eq(0)").val();
        var commentKeyType = $(".selectpicker:eq(1)").val();
        var showInfo = $('.showUserInfo1');
        var showNewsInfo = $('.showNewsInfo1');
        var showCommentInfo = $('.showCommentInfo1');
        if ($('#userIdKey').prop('checked')) {
            if (!isNaN(key)){
                $.ajax({
                    url: '/findUserById',
                    data: {
                        id: key
                    },
                    success: function (result) {
                        if (result.length < 1)
                            showAlert();
                        else{
                            pageList();
                            removeItems();
                            insertUsers(showInfo,result);
                            $("#showAllInfo1").show();
                        }
                    },
                    error: function () {
                        alert("error!");
                    }
                });
            }
        }
        else if ($('#userNameKey').prop('checked')) {
            $.ajax({
                url: '/findUserByName',
                data: {
                    name: key
                },
                success: function (result) {
                    if (result.length < 1)
                        showAlert();
                    else{
                        pageList();
                        removeItems();
                        insertUsers(showInfo,result);
                        $("#showAllInfo1").show();
                    }
                },
                error: function () {
                    alert("error!");
                }
            });
        }
        else if ($("#SearchType").is(':visible')) {
            if (newsKeyType === 'newsIdKey') {
                if(!isNaN(key)){
                    $.ajax({
                        url: '/findNewsById',
                        data: {
                            id: key
                        },
                        success: function (result) {
                            if (result.length < 1)
                                showAlert();
                            else{
                                pageList();
                                removeItems();
                                insertNews(result,showNewsInfo);
                                $("#showAllInfo2").show();
                            }
                        },
                        error: function () {
                            alert("error!");
                        }
                    });
                }
            }
            else if (newsKeyType === 'newsTitleKey') {
                $.ajax({
                    url: '/findNewsByTitle',
                    data: {
                        title: key
                    },
                    success: function (result) {
                        if (result.length < 1)
                            showAlert();
                        else{
                            pageList();
                            removeItems();
                            $.each(result, function (index, elem) {
                                insertNews(elem, showNewsInfo);
                            });
                            $("#showAllInfo2").show();
                        }
                    },
                    error: function () {
                        alert("error!");
                    }
                });
            }
            else if (newsKeyType === 'newsDateKey') {
                $("#searchGroup").css('marginLeft', 725);
                var Date1;
                var Date2;
                if($("#From").val() > $("#To").val()){
                    Date1 = $("#To").val();
                    Date2 = $("#From").val();
                }else {
                    Date1 = $("#From").val();
                    Date2 = $("#To").val();
                }
                $.ajax({
                    url: '/findNewsByDate',
                    data: {
                        fromDate: Date1,
                        toDate:Date2
                    },
                    success: function (result) {
                        if (result.length < 1)
                            showAlert();
                        else{
                            pageList();
                            removeItems();
                            $.each(result, function (index, elem) {
                                insertNews(elem, showNewsInfo);
                            });
                            $("#showAllBtn").css('marginLeft', 730);
                            $('#showAllBtn').css('marginLeft',665);
                            $("#showAllInfo2").show();
                        }
                    },
                    error: function () {
                        alert("error!");
                    }
                });
            }
        }
        else if ($("#SearchComment").is(":visible")) {
            if (commentKeyType === 'commentIdKey') {
                if (!isNaN(key)){
                    $.ajax({
                        url: '/findCommentById',
                        data: {
                            id: key
                        },
                        success: function (result) {
                            if (result.length < 1)
                                showAlert();
                            else{
                                pageList();
                                removeItems();
                                insertComments(result,showCommentInfo);
                                $("#showAllInfo3").show();
                            }
                        },
                        error: function () {
                            alert("error!");
                        }
                    });
                }
            }
            else if (commentKeyType === 'commentNewsIdKey') {
                $.ajax({
                    url: '/findCommentsByNewsId',
                    data: {
                        newsId: key
                    },
                    success: function (result) {
                        if (result.length < 1)
                            showAlert();
                        else{
                            pageList();
                            removeItems();
                            $.each(result, function (index, elem) {
                                insertComments(elem,showCommentInfo);
                            });
                            $("#showAllInfo3").show();
                        }
                    },
                    error: function () {
                        alert("error!");
                    }
                });
            }
            else if (commentKeyType === 'commentUserIdKey') {
                $.ajax({
                    url: '/findCommentsByUserId',
                    data: {
                        userId: key
                    },
                    success: function (result) {
                        if (result.length < 1)
                            showAlert();
                        else{
                            pageList();
                            removeItems();
                            $.each(result, function (index, elem) {
                                insertComments(elem,showCommentInfo);
                            });
                            $("#showAllInfo3").show();
                        }
                    },
                    error: function () {
                        alert("error!");
                    }
                });
            }
        }
    });

    var pageList2 = function () {
        $('#SearchBtn').css('border-radius', '0px 5px 5px 0px');
        $("#searchGroup").css('marginLeft', 845);
        $.each($(".pagination li"), function (index, elem) {
            if ($(this).attr('id') !== 'previous') {
                if ($(this).attr('id') !== 'next') {
                    elem.remove();
                }
            }
        })
    };
    var hideShowBtn = function () {
        $("#showAllInfo1").hide();
        $("#showAllInfo2").hide();
        $("#showAllInfo3").hide();
    };
    $("#user").click(function () {
        $("#user").addClass("active");
        $("#comment").removeClass("active");
        $("#news").removeClass("active");
        $(".user-info").show();
        $(".comment-info").hide();
        $(".news-info").hide();
        $("#Add-btn").show();
        $("#Delete-btn").show();
        $("#Delete-btn-news").hide();
        $("#Delete-btn-comment").hide();
        hideShowBtn();
        $("#userIdKey").show();
        $('#userIdKey').prop('checked', true);
        $("label").show();
        $('#SearchText').show();
        $("#userNameKey").show();
        $(".dateChoose").hide();
        $(".selectButton").hide();
        $(".commentSelectButton").hide();
        pageList2();
        showUsers(1);
        userPage(1, 1);
    });
    $("#news").click(function () {
        $("#user").removeClass("active");
        $("#comment").removeClass("active");
        $("#news").addClass("active");
        $(".user-info").hide();
        $(".comment-info").hide();
        $(".news-info").show();
        $("#Add-btn").hide();
        $("#Delete-btn").hide();
        $("#Delete-btn-news").show();
        $("#Delete-btn-comment").hide();
        hideShowBtn();
        $("#userIdKey").hide();
        $('#userIdKey').prop('checked', false);
        $('#userNameKey').prop('checked', false);
        $("#userNameKey").hide();
        $(".commentSelectButton").hide();
        $("input[type='radio']").hide();
        $('label').hide();
        $('#SearchText').show();
        $(".dropdown-toggle").attr('title', 'ID');
        $(".filter-option").html("ID");
        $(".selectButton").show();
        $("#From").val('');
        $("#To").val('');
        pageList2();
        newsList(1);
        newsPagination(1, 1);
    });
    $("#comment").click(function () {
        $("#user").removeClass("active")
        $("#comment").addClass("active")
        $("#news").removeClass("active")
        $(".user-info").hide()
        $(".news-info").hide()
        $(".comment-info").show()
        $("#Add-btn").hide();
        $("#Delete-btn").hide();
        $("#Delete-btn-news").hide();
        $("#Delete-btn-comment").show();
        hideShowBtn();
        $(".dateChoose").hide();
        $("#userIdKey").parent().hide();
        $("#userNameKey").parent().hide();
        $(".commentSelectButton").show();
        $('#SearchText').show();
        $(".selectButton").hide();
        $('#userIdKey').prop('checked', false);
        $('#userNameKey').prop('checked', false);
        pageList2();
        commentList(1);
        commentPagination(1, 1);
    });

    $("input[type='checkbox']").prop("checked", false);
    $("#Delete-btn-news").hide();
    $("#Delete-btn-comment").hide();
    $("#SearchText").val('');
    hideShowBtn();

    $('#return').click(function () {
        $.ajax({
            url: '/backLogout',
            complete: function () {
                window.location.href="/"
            }
        })
    })
})