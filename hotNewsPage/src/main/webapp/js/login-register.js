$(function () {

    function showRegisterForm() {
        $('.loginBox').fadeOut('fast', function () {
            $('.registerBox').fadeIn('fast');
            $('.login-footer').fadeOut('fast', function () {
                $('.register-footer').fadeIn('fast');
            });
            $('.modal-title').html('注册');
        });
        $('.error').removeClass('alert alert-danger').html('');
    }

    $('#show_register').click(function () {
        showRegisterForm()
    });

    function showLoginForm() {
        $('#loginModal').find('.registerBox').fadeOut('fast', function () {
            $('.loginBox').fadeIn('fast');
            $('.register-footer').fadeOut('fast', function () {
                $('.login-footer').fadeIn('fast');
            });

            $('.modal-title').html('登陆');
        });
        $('.error').removeClass('alert alert-danger').html('');
    }

    $('#show_login').click(function () {
        showLoginForm()
    });

    $('#openLoginModal').click(function openLoginModal() {
        showLoginForm();
        setTimeout(function () {
            $('#loginModal').modal('show');
        }, 230);
    });

    function openRegisterModal() {
        showRegisterForm();
        setTimeout(function () {
            $('#loginModal').modal('show');
        }, 230);
    }

    function loginAjax() {
        /*   Remove this comments when moving to server
        $.post( "/login", function( data ) {
                if(data == 1){
                    window.location.replace("/home");
                } else {
                     shakeModal();
                }
            });
        */

        /*   Simulate error message from the server   */
        shakeModal();
    }

    var registerForm = $('.registerBox > .form')[0];
    var register_name = $(registerForm).find('[name="name"]');
    var register_password = $(registerForm).find('[name="password"]');
    var password_confirmation = $(registerForm).find('[name="password_confirmation"]');
    $('#register_button').click(function () {
        $.ajax({
            type: 'POST',
            url: '/register',
            data: {
                name: register_name.val(),
                password: register_password.val()
            },
            beforeSend: function (xhr) {
                return password_confirmation.val() === register_password.val();
            },
            success: function (result) {
                showLoginForm();
            }
        })
    });

    function shakeModal() {
        $('#loginModal').find('.modal-dialog').addClass('shake');
        $('.error').addClass('alert alert-danger').html("Invalid email/password combination");
        $('input[type="password"]').val('');
        setTimeout(function () {
            $('#loginModal').find('.modal-dialog').removeClass('shake');
        }, 1000);
    }
});
   