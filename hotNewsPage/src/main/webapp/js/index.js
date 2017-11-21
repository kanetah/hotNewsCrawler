;(function () {

    // iPad and iPod detection
    var isiPad = function () {
        return (navigator.platform.indexOf("iPad") !== -1);
    };

    var isiPhone = function () {
        return (
            (navigator.platform.indexOf("iPhone") !== -1) ||
            (navigator.platform.indexOf("iPod") !== -1)
        );
    };

    // OffCanvass
    var offCanvass = function () {
        $('body').on('click', '.js-fh5co-menu-btn, .js-fh5co-offcanvass-close', function () {
            $('#fh5co-offcanvass').toggleClass('fh5co-awake');
        });
    };

    // Click outside of offcanvass
    var mobileMenuOutsideClick = function () {
        var fh5coOffCanvass = $('#fh5co-offcanvass');

        $(document).click(function (e) {
            var container = $("#fh5co-offcanvass, .js-fh5co-menu-btn");
            if (!container.is(e.target) && container.has(e.target).length === 0) {
                if (fh5coOffCanvass.hasClass('fh5co-awake')) {
                    fh5coOffCanvass.removeClass('fh5co-awake');
                }
            }
        });

        $(window).scroll(function () {
            if ($(window).scrollTop() > 500) {
                if (fh5coOffCanvass.hasClass('fh5co-awake')) {
                    fh5coOffCanvass.removeClass('fh5co-awake');
                }
            }
        });
    };

    var animateBoxWayPoint = function () {
        var animateBox = $('.animate-box');
        if (animateBox.length > 0) {
            animateBox.waypoint(function (direction) {
                if (direction === 'down' && !$(this).hasClass('animated')) {
                    $(this.element).addClass('bounceIn animated');
                }
            }, {offset: '75%'});
        }
    };

    var grid = document.querySelector('#fh5co-board');
    var news_index = void 0;
    var doAjax = function () {
        $.ajax({
            url: '/news',
            type: 'POST',
            success: function (result) {
                news_index = result;
                salvattore.rescanMediaQueries();
                for (var i = 0; i < 15; ++i)
                    lazyLoad();
            }
        })
    };

    var template = $('#itemTemplate');
    var lazyLoad = function () {
        if (void 0 === news_index)
            return;
        var id = news_index.pop();
        $.ajax({
            url: '/news/' + id,
            type: 'POST',
            success: function (result) {
                var node = $(template).clone(true);
                var box = node.find('.animate-box > a');
                box.attr('href', 'javascript:void(0)');//src
                box.attr('title', result['title']);
                var img = box.find('img');
                img.attr('src', result['imgSrc']);
                img.attr('alt', result['imgSrc'] === null ? null : result['title']);

                var desc = node.find('.fh5co-desc');
                desc.find('> .desc-title').html(result['title']);
                desc.find('> .desc-type').html(result['type']);
                desc.find('> .desc-rank').html(result['rank']);
                $(desc).click(function () {
                    window.open("/news/" + result['id'], "_blank");
                });

                $(node).attr('id', '');
                $(node).attr('hidden', false);
                node.insertBefore(template);
                salvattore.appendElements(grid, [node[0]]);
            }
        })
    };

    $(function () {
        doAjax();
        offCanvass();
        mobileMenuOutsideClick();
        animateBoxWayPoint();

        $(window).scroll(function () {
            var scrollBottom = $(document).height() - $(window).height() - $(window).scrollTop();
            if (scrollBottom < 2500)
                lazyLoad();
        });
    });
}());