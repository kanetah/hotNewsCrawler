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

    // Magnific Popup
    var magnifPopup = function () {
        $('.image-popup').magnificPopup({
            type: 'image',
            removalDelay: 300,
            mainClass: 'mfp-with-zoom',
            titleSrc: 'title',
            gallery: {
                enabled: true
            },
            zoom: {
                enabled: true,
                duration: 300,
                easing: 'ease-in-out',
                opener: function (openerElement) {
                    return openerElement.is('img') ? openerElement : openerElement.find('img');
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

    var doAjax = function () {
        $.ajax({
            url: '/news',
            success: function (result) {
                var template = $('#itemTemplate');
                $.each(result, function (idx, elem) {
                    var content = elem['content'];
                    var img = content.match(/<img[^>]*>/i);
                    if (img !== null && img.toString().indexOf('class="icon"') < 0) {
                        var src = img.toString().match(/src=("[^"]*")|('[^']*')/i)[0].toString();
                        src = src.replace("'", '"');
                        src = src.substr(src.indexOf('"') + 1);
                        src = src.substr(0, src.indexOf('"'));
                        var node = $(template).clone(true);

                        var box = node.find('.animate-box > a');
                        box.attr('href', src);
                        box.attr('title', elem['title']);
                        img = box.find('img');
                        img.attr('src', src);
                        img.attr('alt', elem['title']);

                        var desc = node.find('.fh5co-desc');
                        desc.html(elem['title']);
                        $(desc).click(function () {
                            window.open("/news/" + elem['id'], "_blank");
                        });

                        $(node).attr('hidden', false);
                        node.insertAfter(template);
                    }
                });
                salvattore.rescanMediaQueries();
                magnifPopup();
            }
        })
    };

    $(function () {
        doAjax();
        magnifPopup();
        offCanvass();
        mobileMenuOutsideClick();
        animateBoxWayPoint();
    });

}());