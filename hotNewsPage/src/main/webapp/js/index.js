$(function () {
    function a() {
        alert('poi');
        $.ajax({
            url: "/out",
            success: function (result) {
                $('.p1').remove();
                $.each(result, function (index, elem) {
                    $('.d1').append('<p>' + elem + '</p>');
                })
            }
        })
    }

    $('input').click(a);
});
