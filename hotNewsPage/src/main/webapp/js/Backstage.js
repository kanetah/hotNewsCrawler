$(function(){
	$("#user").click(function(){
		$("#user").addClass("active")
		$("#comment").removeClass("active")
		$("#news").removeClass("active")
		
		$(".user-info").show()
		$(".comment-info").hide()
		$(".news-info").hide()
	})
	$("#news").click(function(){
		$("#user").removeClass("active")
		$("#comment").removeClass("active")
		$("#news").addClass("active")
		
		$(".user-info").hide()
		$(".comment-info").hide()
		$(".news-info").show()
	})
	$("#comment").click(function(){
		$("#user").removeClass("active")
		$("#comment").addClass("active")
		$("#news").removeClass("active")
		
		$(".user-info").hide()
		$(".comment-info").show()
		$(".news-info").hide()
	})

	$("input[type='checkbox']").prop("checked",false)

    $(".UserSA").click(function(){
        if($(".UserAe").prop("checked")){
            $(".UserAe").removeAttr("checked");
        }
        if($(".UserSA").prop("checked")){
            $("input[name='userCheckbox']").prop("checked",true);
        }
        else{
            $("input[name='userCheckbox']").removeAttr("checked");
        }
    })
    $(".UserAe").click(function(){
        if($(".UserSA").prop("checked")){
            $(".UserSA").removeAttr("checked");
        }
        if($(".UserAe").prop("checked")){
            $("input[name='userCheckbox']").each(function () {
                if($(this).prop("checked")){
                    $(this).removeAttr("checked")
                }else{
                    $(this).prop("checked",true);
                }
            })
        }
        else{
            $("input[name='userCheckbox']").each(function () {
                if($(this).prop("checked")){
                    $(this).removeAttr("checked")
                }else{
                    $(this).prop("checked",true);
                }
            })
        }
    })


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
    var show = function (pageCode) {
        var showInfo = $('.showUserInfo');
        $.ajax({
            url:"/pagination",
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
                alert('error')
            }
        })
    }

    show(1);

    var count = 1;
    $.ajax({
        url:"/pageCount",
        success:function (result) {
            for (var i = 0; i < result; i++){
                $(".pagination > li:last-child").before('<li id="li_'+count+'"><a href="javascript:void(0)">'+count+'</a></li>');
                count++;
            }
            $('#li_1').addClass('active');
            $(".pagination li a").click(function () {
                var id = $(this).parent().attr('id');
                if(id === "previous"){
                    if (pageCode > 1){
                        pageCode = Number(pageCode)-1;
                        show(pageCode);
                        $('.pagination li').removeClass('active');
                        $('#li_'+ pageCode).addClass('active');
                    }
                }
                else if (id === "next"){
                    if (pageCode < (result)){
                        pageCode = Number(pageCode)+1;
                        show(pageCode);
                        $('.pagination li').removeClass('active');
                        $('#li_'+ pageCode).addClass('active');
                    }
                }
                else{
                    pageCode = id.substring(3,id.length+1);
                    $('.pagination li').removeClass('active');
                    $(this).parent().addClass('active');
                    show(pageCode)
                }

            })
        }
    })

    $("#Delete-btn").click(function () {
        // alert($('input[name="userCheckbox"]:checked').size());
        $('input[name="userCheckbox"]:checked').each(function () {
            var id = $(this).parent().parent().attr('id');
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
            })
        })
    })

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
                $.ajax({
                    url:'/pageCount',
                    success:function (result) {
                        if(pageCode !== result){
                            show(result);
                            $('.pagination li').removeClass('active');
                            $('#li_'+result).attr('class','active');
                        }else {
                            show(result);
                        }
                    }
                })
            },
            error:function () {
                alert("error")
            }
        })
    })
})
