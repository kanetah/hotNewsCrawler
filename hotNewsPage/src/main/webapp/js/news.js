$(function () {
    var E = window.wangEditor;
    var editor = new E('#editor');
    editor.customConfig.uploadImgShowBase64 = true;
    editor.customConfig.menus = [
        'head',  // 标题
        'bold',  // 粗体
        'italic',  // 斜体
        'underline',  // 下划线
        'strikeThrough',  // 删除线
        'foreColor',  // 文字颜色
        'backColor',  // 背景颜色
        'link',  // 插入链接
        'list',  // 列表
        'justify',  // 对齐方式
        'quote',  // 引用
        'emoticon',  // 表情
        'image',  // 插入图片
        'table',  // 表格
        'video',  // 插入视频
        'code',  // 插入代码
        'undo',  // 撤销
        'redo'  // 重复
    ];
    editor.create();

    var id = $('[name="newsId"]')[0]['content'];
    $.ajax({
        url: '/news/' + id + '/content',
        success: function (result) {
            $('title').html(result.title);
            $('#title').html(result.title);
            $('#time').html(result.time);
            $('#type').html(result.type);
            $('#rank').html(result.rank);
            $('#content').html(result.content);

            $.ajax({
                url: '/news/related/' + result.title,
                success: function (res) {
                    var relatedNews = $('#relatedNews');
                    $.each(res, function (idx, elem) {
                        var li = document.createElement('li');
                        li.setAttribute('class', 'list-group-item');
                        li.innerHTML = elem.title;
                        li.onclick = function () {
                            window.open("/news/" + elem['id'], "_blank");
                        };
                        relatedNews[0].appendChild(
                            li
                        )
                    });
                }
            })
        }
    });

    var items = [];
    var template = $('#comment_template');
    var loadComment = function () {
        $.ajax({
            url: '/news/' + id + '/comments',
            success: function (result) {
                editor.txt.html('');
                $.each(items, function (idx, elem) {
                    elem.remove()
                });
                items = [];
                $.each(result, function (idx, elem) {
                    var node = $(template).clone(true);
                    node.find('.comment_user').html(elem.userName);
                    node.find('.comment_time').html(elem.time);
                    node.find('.comment_content').html(elem.content);
                    $(node).attr('hidden', false);
                    $(node).attr('id', null);
                    items.push(node);
                    node.insertAfter(template);
                })
            }
        });
    };
    loadComment();

    $.setName();

    var comment_btn = $('#comment');
    $(comment_btn).trigger('focus');
    $(comment_btn).click(function () {
        $.ajax({
            url: '/user/leaveComment',
            type: 'POST',
            data: {
                name: $.cookie('name'),
                newsId: id,
                content: editor.txt.html()
            },
            beforeSend: function () {
                if (void(0) === $.cookie('name') || 0 === $.cookie('name').length) {
                    alert('请先登陆');
                    return false;
                } else
                    return true;
            },
            success: function () {
                loadComment()
            }
        })
    });
});
