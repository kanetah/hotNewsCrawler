$(function(){

	$("input[type='checkbox']").prop("checked",false);
    $("#Delete-btn-news").hide();


    /**
     * User
     */
    $("#SelectAll_UserSA").click(function(){
        if($("#Anti-election_UserAe").prop("checked")){
            $("#Anti-election_UserAe").removeAttr("checked");
        }
        if($("#SelectAll_UserSA").prop("checked")){
            $("input[name = 'checkbox']").prop("checked",true);
        }
        else{
            $("input[name = 'checkbox']").prop("checked",false);
        }
    })
    $("#Anti-election_UserAe").click(function(){
        if($("#SelectAll_UserSA").prop("checked")){
            $("#SelectAll_UserSA").removeAttr("checked");
        }
        if($("#Anti-election_UserAe").prop("checked")){
            $("input[name = 'checkbox']").each(function () {
                if($(this).prop("checked")){
                    $(this).removeAttr("checked")
                }else{
                    $(this).prop("checked",true);
                }
            })
        }
        else{
            $("input[name = 'checkbox']").each(function () {
                if($(this).prop("checked")){
                    $(this).removeAttr("checked")
                }else{
                    $(this).prop("checked",true);
                }
            })
        }
    });


    $(".showUserInfo").dblclick(function(){
        var currentTd = $(this).find("td")
        var id=currentTd[1].innerHTML;
        var username=currentTd[2].innerHTML;

        $("#UserEditor").modal("show")

        $("#IDText").val(id)
        $("#userNameText").val(username)
    })

    $("#updateUserBtn").click(function () {
        var id = $("#IDText").val()
        var name = $("#userNameText").val()

        $.ajax({
            url: '/updateUserInfo',
            data: {
                id: id,
                name: name
            },
            success: function () {
                $('#UserEditor').modal('hide')
                $('#'+id).find('.userName').html(name)
            },
            error:function () {
                alert("error")
            }
        })
    })

    var pageCode;
    var items = [];
    var showUsers = function (pageCode) {
        var showInfo = $('.showUserInfo');
        $.ajax({
            url:"/userPagination",
            data:{
                pageCode:pageCode
            },
            success:function (result) {
                $.each(items, function (index,elem) {
                    elem.remove();
                });
                items=[];
                $.each(result, function (idx,elem) {
                    var node = $(showInfo).clone(true);
                    node.find('.userID').html(elem.id);
                    node.find('.userName').html(elem.username);
                    node.attr("id",elem.id)
                    node.removeClass('showUserInfo')
                    $(node).attr('hidden',false);
                    items.push(node);
                    node.insertBefore(showInfo);
                })
            },
            error: function () {
                alert('show user error')
            }
        })
    }

    var userPage = function (count, pageCode) {
        $.ajax({
            url:"/userPageCount",
            success:function (result) {
                for (var i = 0; i < result; i++){
                    $(".pagination > li:last-child").before('<li id="li_'+count+'"><a href="javascript:void(0)">'+count+'</a></li>');
                    count++;
                }
                showUsers(1);
                $('#li_1').addClass('active');
                $(".pagination li a").click(function () {
                    var id = $(this).parent().attr('id');
                    if($('#user').attr('class') === 'active'){
                        if(id === "previous"){
                            if (pageCode > 1){
                                pageCode = Number(pageCode)-1;
                                showUsers(pageCode);
                                $('.pagination li').removeClass('active');
                                $('#li_'+ pageCode).addClass('active');
                            }
                        }
                        else if (id === "next"){
                            if (pageCode < (result)){
                                pageCode = Number(pageCode)+1;
                                showUsers(pageCode);
                                $('.pagination li').removeClass('active');
                                $('#li_'+ pageCode).addClass('active');
                            }
                        }
                        else{
                            pageCode = id.substring(3,id.length+1);
                            $('.pagination li').removeClass('active');
                            $(this).parent().addClass('active');
                            showUsers(pageCode)
                        }
                    }
                })
            }
        })
    }

    userPage(1,1);

    $("#Delete-btn").click(function () {
        // alert($('input[name="userCheckbox"]:checked').size());
        $('input[name="checkbox"]:checked').each(function () {
            var id = $(this).parent().parent().attr('id');
            alert("user active");
            alert("user id");
            $.ajax({
                url:"/deleteUserById",
                data:{
                    id:id
                },
                success:function () {
                    $('#'+ id).remove();
                },
                error:function () {
                    alert("delete error");
                }
            });
        })
    });

    $('#Add-btn').click(function () {
        $('#UserAdd').modal('show')
    });
    $('#AddUserBtn').click(function () {
        // newNameText  passwordText
        var newName = $('#newNameText').val();
        var password = $('#passwordText').val();
        $.ajax({
            url:"/insertUser",
            data:{
                name:newName,
                password:password
            },
            success:function () {
                $('#UserAdd').modal('hide');
                $('#newNameText').val("");
                $('#passwordText').val("");
                $.ajax({
                    url:'/userPageCount',
                    success:function (result) {
                        if(pageCode !== result){
                            showUsers(result);
                            $('.pagination li').removeClass('active');
                            $('#li_'+result).attr('class','active');
                        }else {
                            showUsers(result);
                        }
                    }
                })
            },
            error:function () {
                alert("error")
            }
        })
    })


    /**
     * 新闻
     * */


    $("#SelectAll_NewsSA").click(function(){
        if($("#Anti-election_NewsAe").prop("checked")){
            $("#Anti-election_NewsAe").removeAttr("checked");
        }
        if($("#SelectAll_NewsSA").prop("checked")){
            $("input[name = 'newsCheckbox']").prop("checked",true);
        }
        else{
            $("input[name = 'newsCheckbox']").prop("checked",false);
        }
    })
    $("#Anti-election_NewsAe").click(function(){
        if($("#SelectAll_UserSA").prop("checked")){
            $("#SelectAll_UserSA").removeAttr("checked");
        }
        if($("#Anti-election_NewsAe").prop("checked")){
            $("input[name = 'newsCheckbox']").each(function () {
                if($(this).prop("checked")){
                    $(this).removeAttr("checked")
                }else{
                    $(this).prop("checked",true);
                }
            })
        }
        else{
            $("input[name = 'newsCheckbox']").each(function () {
                if($(this).prop("checked")){
                    $(this).removeAttr("checked")
                }else{
                    $(this).prop("checked",true);
                }
            })
        }
    });

    $("#Delete-btn-news").click(function () {
        // alert($('input[name="userCheckbox"]:checked').size());
        $('input[name="newsCheckbox"]:checked').each(function () {
            var id = $(this).parent().parent().attr('id');
            $.ajax({
                url:"/deleteNewsById",
                data:{
                    id:id
                },
                success:function () {
                    $('#'+ id).remove();
                },
                error:function () {
                    alert("delete error");
                }
            });
        })
    });

    var showNews = $('.showNewsInfo')
    var newsList = function (pageCode) {
        $.ajax({
            url:"/newsPagination",
            data:{
                pageCode:pageCode
            },
            success:function (result) {
                $.each(items, function (index,elem) {
                    elem.remove();
                })
                items = [];
                $.each(result, function (index,elem) {
                    var node = $(showNews).clone('true');
                    node.find('.newsID').html(elem.id);
                    if(elem.title.length > 21){
                        var title = elem.title.substring(0,21) + '...'
                        node.find('.newsTitle').attr('title',elem.title);
                    }
                    node.find('.newsTitle').html(title);
                    node.find('.newsDate').html(elem.date);
                    node.find('.newsType').html(elem.type);
                    node.find('.newsRank').html(elem.rank);
                    node.find('.newsSrc').html(elem.src);
                    node.attr('id',elem.id);
                    node.removeClass('showUserInfo')
                    $(node).attr('hidden',false);
                    items.push(node);
                    node.insertBefore(showNews);
                })
            },
            error:function () {
                alert("error")
            }
        })
    }

    var newsPagination = function (count,pageCode) {
        $.ajax({
            url:"/newsPageCount",
            success:function (result) {
                for (var i = 0; i < result; i++){
                    $(".pagination > li:last-child").before('<li id="li_'+count+'"><a href="javascript:void(0)">'+count+'</a></li>');
                    count++;
                }
                $('#li_1').addClass('active');
                $(".pagination li a").click(function () {
                    var id = $(this).parent().attr('id');
                    if($('#news').attr('class')==='active'){
                        if(id === "previous"){
                            if (pageCode > 1){
                                pageCode = Number(pageCode)-1;
                                newsList(pageCode);
                                $('.pagination li').removeClass('active');
                                $('#li_'+ pageCode).addClass('active');
                            }
                        }
                        else if (id === "next"){
                            if (pageCode < (result)){
                                pageCode = Number(pageCode)+1;
                                newsList(pageCode);
                                $('.pagination li').removeClass('active');
                                $('#li_'+ pageCode).addClass('active');
                            }
                        }
                        else{
                            pageCode = id.substring(3,id.length+1);
                            $('.pagination li').removeClass('active');
                            $(this).parent().addClass('active');
                            newsList(pageCode)
                        }
                    }

                })
            }
        })
    }













    $("#user").click(function(){
        $("#user").addClass("active");
        $("#comment").removeClass("active");
        $("#news").removeClass("active");

        $(".user-info").show();
        $(".comment-info").hide();
        $(".news-info").hide();
        $("#Add-btn").show();
        $("#Delete-btn").show();
        $("#Delete-btn-news").hide();
        showUsers(1);
        userPage(1,1);
        $.each($(".pagination li"), function (index, elem) {
            if ($(this).attr('id')!== 'previous'){
                if ($(this).attr('id')!== 'next'){
                    elem.remove();
                }
            }
        })
    })
    $("#news").click(function(){
        $("#user").removeClass("active");
        $("#comment").removeClass("active");
        $("#news").addClass("active");

        $(".user-info").hide();
        $(".comment-info").hide();
        $(".news-info").show();
        $("#Add-btn").hide();
        $("#Delete-btn").hide();
        $("#Delete-btn-news").show();
        // $("#Delete-btn").click();
        // $("input[type='checkbox']").prop("checked",false);
        // alert($("input[name = 'SelectAll']").prop("checked"));
        // $("script[src = './js/Backstage.js']").attr('src','./js/Backstage.js');
        var pageCode = 1;
        newsList(pageCode);
        newsPagination(1,pageCode);
        $.each($(".pagination li"), function (index, elem) {
            if ($(this).attr('id')!== 'previous'){
                if ($(this).attr('id')!== 'next'){
                    elem.remove();
                }
            }
        });
        /*var showNews = $(".showNewsInfo");
        $.ajax({
            url:'/getAllNews',
            success:function (result) {
                alert(result.length)
                $.each(result, function (idx,elem) {
                    var node = $(showNews).clone(true);
                    node.find('.newsID').html(elem.id);
                    node.find('.newsTitle').html(elem.title);
                    node.find('.newsDate').html(elem.date);
                    node.find('.newsType').html(elem.type);
                    node.find('.newsRank').html(elem.rank);
                    node.find('.newsSrc').html(elem.src);
                    node.attr("id",elem.id);
                    node.removeClass('showNewsInfo');
                    $(node).attr('hidden',false);
                    node.insertBefore(showNews);
                });
            },
            error:function () {
                alert("fanews error")
            }
        })*/
    })
    $("#comment").click(function(){
        $("#user").removeClass("active")
        $("#comment").addClass("active")
        $("#news").removeClass("active")

        $(".user-info").hide()
        $(".comment-info").show()
        $(".news-info").hide()
    })
})
