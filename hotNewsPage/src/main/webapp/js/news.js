$(function () {
    var E = window.wangEditor;
    var editor = new E('#editor');
    editor.create();

    var id = $('[name="newsId"]')[0]['content'];
    $.ajax({
        url: '/news/' + id + '/content',
        success: function (result) {
            $('#title').html(result.title);
            $('#time').html(result.time);
            $('#type').html(result.type);
            $('#rank').html(result.rank);
            $('#content').html(result.content);
        }
    });

    $.ajax({
        url: '/news/' + id + '/comments',
        success: function (result) {
            var template = $('#comment_template');
            $.each(result, function (idx, elem) {
                var node = $(template).clone(true);
                node.find('.comment_user').html(elem.userName);
                node.find('.comment_time').html(elem.time);
                node.find('.comment_content').html(elem.content);
                $(node).attr('hidden', false);
                node.insertAfter(template);
            })
        }
    });
});