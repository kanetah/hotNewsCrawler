<%--
  Created by IntelliJ IDEA.
  User: 老幺
  Date: 2017/11/14
  Time: 17:33
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="newsId" content="${id}">
    <link rel="icon" href="images/favicon.png">
    <base href="/">

    <title>news view</title>

    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/Customize.css">
    <link rel="stylesheet" href="css/news.css">
    <link rel="stylesheet" href="css/login-register.css"/>
    <link rel="stylesheet" href="css/vendor/icomoon.css">
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top mybar">
    <div class="container">
        <div class="navbar-header">
            <a id="name" class="navbar-brand">Name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="btn btn-block">
                    <a id="openLoginModal" data-toggle="modal" href="javascript:void(0)">
                        登陆
                    </a>
                    <a id="logout_button">注销</a>
                </li>
                <li class="home"><a href="">首页</a></li>
                <li><a href="/about">About</a></li>
                <li><a href="/contact">Contact</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="starter-template">
        <h2 class="title" id="title"></h2>
        <div class="time-time" id="time"></div>
        <div id="type"></div>
        <div id="rank"></div>
        <br>
        <hr>
        <div class="content" id="content"></div>
    </div>
    <hr>
    <h3 style="margin-left: 100px">评论区</h3>
    <div id="editor-div">
        <input type="button" class="btn btn-primary btn-sm" id="comment" value="发布评论">
        <div id="editor"></div>
    </div>
</div>
<div class="container">
    <div class="comment" id="comment_template" hidden="hidden">
        <hr>
        <div>
            <div class="comment_info">
                <div class="comment_user"></div>
                <div class="comment_time"></div>
            </div>
            <div class="comment_content"></div>
        </div>
    </div>
    <div class="sider">
        <h2 style="text-align: center">相关新闻</h2>
        <ul class="list-group" id="relatedNews">
        </ul>
    </div>
</div>
<footer id="fh5co-footer">
    <div class="container">
        <div class="row row-padded">
            <div class="col-md-12 text-center">
                <p>
                    <span style="font-size: small;">nico | poi | duang</span>
                </p>
            </div>
        </div>
    </div>
</footer>

<div>
    <a href="javascript:window.scrollTo(0,0)" class="BackToTop">
            <span class="glyphicon glyphicon-menu-up" aria-hidden="true">
                <br>Back<br>to<br>top
            </span>
    </a>
</div>
<div class="modal fade login" id="loginModal">
    <div class="modal-dialog login animated">
        <div class="modal-content" id="loginContent">
            <div class="modal-header">
                <button id="loginModalClose" type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">登陆</h4>
            </div>
            <div class="modal-body">
                <div class="box">
                    <div class="content">
                        <div class="error"></div>
                        <div class="form loginBox">
                            <input class="form-control" type="text" placeholder="昵称" name="name">
                            <input class="form-control" type="password" placeholder="密码"
                                   name="password">
                            <input id="login_button" class="btn btn-default btn-login" type="button" value="登陆">
                        </div>
                    </div>
                </div>
                <div class="box">
                    <div class="content registerBox" style="display:none;">
                        <div class="form">
                            <input class="form-control" type="text" placeholder="昵称" name="name">
                            <input class="form-control" type="password" placeholder="密码"
                                   name="password">
                            <input id="password_confirmation" class="form-control" type="password"
                                   placeholder="确认密码" name="password_confirmation">
                            <input id="register_button" class="btn btn-default btn-register" type="button" value="创建账号">
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <div class="forgot login-footer">
                            <span>想要
                                 <a id="show_register">创建一个账号</a>
                            ?</span>
                </div>
                <div class="forgot register-footer" style="display:none">
                    <span>已经有一个账号?</span>
                    <a id="show_login">去登陆</a>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

<script type="text/javascript" src="https://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript" src="js/wangEditor.min.js"></script>
<script type="text/javascript" src="js/login-register.js"></script>
<script type="text/javascript" src="js/news.js"></script>
</html>
