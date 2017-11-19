<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>热点新闻</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="hot news"/>

    <!-- Facebook and Twitter integration -->
    <meta property="og:title" content=""/>
    <meta property="og:image" content=""/>
    <meta property="og:url" content=""/>
    <meta property="og:site_name" content=""/>
    <meta property="og:description" content=""/>
    <meta name="twitter:title" content=""/>
    <meta name="twitter:image" content=""/>
    <meta name="twitter:url" content=""/>
    <meta name="twitter:card" content=""/>

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="shortcut icon" href="images/favicon.png">
    <!-- Animate.css -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/animate.css/3.5.2/animate.min.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="css/vendor/icomoon.css">
    <!-- Magnific Popup -->
    <link rel="stylesheet" href="css/vendor/magnific-popup.css">
    <!-- Salvattore -->
    <link rel="stylesheet" href="css/vendor/salvattore.css">
    <!--Theme Style -->
    <link rel="stylesheet" href="css/vendor/style.css">
    <link rel="stylesheet" href="css/index.css">

</head>
<body>

<div id="fh5co-offcanvass">
    <a href="#" class="fh5co-offcanvass-close js-fh5co-offcanvass-close">Menu <i class="icon-cross"></i> </a>
    <h1 class="fh5co-logo"><a class="navbar-brand" href="index.jsp">热点新闻</a></h1>
    <ul>
        <li class="active"><a href="index.jsp">主页</a></li>
        <li><a href="login">登陆</a></li>
        <li><a href="filter">过滤</a></li>
        <li><a href="about">关于</a></li>
    </ul>
    <h3 class="fh5co-lead">联系我们</h3>
    <p class="fh5co-social-icons">
        <a href="#"><i class="icon-twitter"></i></a>
        <a href="#"><i class="icon-facebook"></i></a>
        <a href="#"><i class="icon-instagram"></i></a>
        <a href="#"><i class="icon-dribbble"></i></a>
        <a href="#"><i class="icon-youtube"></i></a>
    </p>
</div>
<header id="fh5co-header" role="banner">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <a href="#" class="fh5co-menu-btn js-fh5co-menu-btn">菜单<i class="icon-menu"></i></a>
                <a class="navbar-brand" href="index.jsp">热点新闻</a>
            </div>
        </div>
    </div>
</header>
<!-- END .header -->

<div id="fh5co-main">
    <div class="container">
        <div class="row">
            <div id="fh5co-board" data-columns>

                <!-- START content -->
                <div class="item" hidden id="itemTemplate">
                    <div class="animate-box">
                        <a href="" title="" class="image-popup fh5co-board-img">
                            <img src="" alt=""/>
                        </a>
                    </div>
                    <div class="fh5co-desc">
                        内容
                    </div>
                </div>
                <!-- END content -->

            </div>
        </div>
    </div>
</div>

<footer id="fh5co-footer">

    <div class="container">
        <div class="row row-padded">
            <div class="col-md-12 text-center">
                <p class="fh5co-social-icons">
                    <a href="#"><i class="icon-twitter"></i></a>
                    <a href="#"><i class="icon-facebook"></i></a>
                    <a href="#"><i class="icon-instagram"></i></a>
                    <a href="#"><i class="icon-dribbble"></i></a>
                    <a href="#"><i class="icon-youtube"></i></a>
                </p>
                <p>
                    <small>nico | poi | duang</small>
                </p>
            </div>
        </div>
    </div>
</footer>

<!-- Modernizr JS -->
<script src="https://cdn.bootcss.com/modernizr/2.6.2/modernizr.min.js"></script>
<!-- jQuery -->
<script src="https://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="https://cdn.bootcss.com/jquery-easing/1.3/jquery.easing.js"></script>
<!-- Bootstrap -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="js/vendor/jquery.waypoints.min.js"></script>
<!-- Magnific Popup -->
<script src="js/vendor/jquery.magnific-popup.min.js"></script>
<!-- Salvattore -->
<script src="https://cdn.bootcss.com/salvattore/1.0.8/salvattore.min.js"></script>
<!-- Main JS -->
<script src="js/index.js"></script>

</body>
</html>
