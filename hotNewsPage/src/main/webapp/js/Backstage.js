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
            alert("AeIsnotChecked")
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

    var pageCode = 1;
    var show = function () {
        var items = [];
        var showInfo = $('.showUserInfo');
        $.ajax({
            url:"/pagination",
            data:{
                pageCode:pageCode
            },
            success:function (result) {
                $('items').each(function (index,elem) {
                    elem.remove();
                })
                items=[];
                $.each(result, function (idx,elem) {
                    var node = $(showInfo).clone(true);
                    node.find('.userID').html(elem.id);
                    node.find('.userName').html(elem.username);
                    node.attr("id",elem.id)
                    $(node).attr('hidden',false);
                    items.push(node);
                    node.insertBefore(showInfo);
                })
            }
        })
    }

    show(pageCode);

    var count = 2;
    $.ajax({
        url:"/pageCount",
        success:function (result) {
            for (var i = 1; i < result; i++){
                $(".pagination > li:last-child").before('<li id="'+count+'"><a href="#">'+count+'</a></li>');
                count++;
            }
            $(".pagination li a").click(function () {
                pageCode = $(this).parent().attr('id');
                alert(pageCode)
                show(pageCode);
            })
        }
    })

    /*$.ajax({
		url:"/getAllUsers",
		success: function (result) {
            var showInfo = $('.showUserInfo');
            $.each(result, function (idx,elem) {
                var node = $(showInfo).clone(true);
                node.find('.userID').html(elem.id);
                node.find('.userName').html(elem.username);
                node.attr("id",elem.id)
                $(node).attr('hidden',false);
                node.insertBefore(showInfo);
            })
        }
	})*/

    // $("#Delete-btn").click(function () {
    //
    // })
})
