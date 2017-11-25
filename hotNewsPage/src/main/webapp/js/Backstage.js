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
	
	$(".UserSA").click(function(){
		if($(".UserAe").prop("checked") == true){
			$(".UserAe").prop("checked",false)
		}
		if($(".UserSA").prop("checked") == true){
			$("input[name='userCheckbox']").prop("checked",true);
		}
		else if($(".UserSA").prop("checked") == false){
			$("input[name='userCheckbox']").prop("checked",false);
		}
	})
	$(".UserAe").click(function(){
		if($(".UserSA").prop("checked") == true){
			$(".UserSA").prop("checked",false)
		}
		if($(".UserAe").prop("checked") == true){
			if($("input[name='userCheckbox']").is(":checked")){
			$("input[name='userCheckbox']").prop("checked",false);
			}else{
				$("input[name='userCheckbox']").prop("checked",true);
			}
		}
		else if($(".UserAe").is(":checked") == false){
			if($("input[name='userCheckbox']").is(":checked")){
			$("input[name='userCheckbox']").prop("checked",false);
			}else{
				$("input[name='userCheckbox']").prop("checked",true);
			}
		}
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
				node.insertAfter(showInfo);
            })
        }
	})
})
