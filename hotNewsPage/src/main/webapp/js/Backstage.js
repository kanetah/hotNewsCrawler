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


    $("#showUserInfo").click(function(){
        var currenTd = $(this).find("td")
        var id=currenTd[1].innerHTML;
        var username=currenTd[2].innerHTML;

        $("#IDText").val(id)
        $("#userNameText").val(username)
    })

    $.ajax({
		url:"/getAllUsers",
		success: function (result) {
            var showInfo = $('#showUserInfo');
            $.each(result, function (idx,elem) {
                var node = $(showInfo).clone(true);
                node.find('.userID').html(elem.id);
                node.find('.userName').html(elem.username);
                $(node).attr('hidden',false);
                node.insertBefore(showInfo);
            })
        }
	})
})
