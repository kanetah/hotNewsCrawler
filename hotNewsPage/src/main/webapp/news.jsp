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
    <link rel="icon" href="images/favicon.ico">
    <base href="/">

    <title>news view</title>

    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="css/Customize.css" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top mybar">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="MainView.jsp">Name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="btn btn-block">
                    <a data-toggle="modal" data-target="#loginModal"
                       class="account-setting-seperator polyglot">Login</a>
                </li>
                <%--<li><a href="#">Login</a></li>--%>
                <li class="home"><a href="#">Home</a></li>
                <li><a href="/about">About</a></li>
                <li><a href="/contact">Contact</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="starter-template">
        <div class="title" id="title"></div>
        <hr>
        <div class="time-time" id="time"></div>
        <div id="type"></div>
        <div id="rank"></div>
        <div class="content" id="content"></div>
    </div>
</div>
<div class="container">
    <div id="editor"></div>
    <input type="button" class="btn btn-default" id="comment" value="评论">
</div>
<div class="container">
    <div class="comment" id="comment_template" hidden="hidden">
        <div class="comment_user"></div>
        <div class="comment_time"></div>
        <div class="comment_content"></div>
    </div>
</div>
<div>
    <a href="javascript:window.scrollTo(0,0)" class="BackToTop">
            <span class="glyphicon glyphicon-menu-up" aria-hidden="true">
                <br>Back<br>to<br>top
            </span>
    </a>
</div>
<div class="modal" id="loginModal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <button type="button" class="close" data-dismiss="modal">×</button>
            <div class="modal-body">
                <div ng-controller="loginCtrl">
                    <div ng-show="showLoginForm">
                        <div class="welcome-text">
                            <h2>Sign In</h2>
                        </div>
                        <form role="form" novalidate="" ng-model="signInForm" name="signInForm">
                            <div class="form-group form-group-lg label-floating is-empty">
                                <input class="form-control" name="loginId" type="text" id="loginId"
                                       placeholder="Username" required/>
                            </div>
                            <div class="form-group form-group-lg label-floating is-empty">
                                <input name="password" type="password" id="signInPassword" required class="form-control"
                                       placeholder="Password"/>
                            </div>
                            <div class="SignUp-text">
                                <p class="text-right"><a href="#">Sign Up</a>|<a href="#">Forgotten Password</a></p>
                            </div>
                            <button type="submit" class="btn btn-default">Login</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript" src="https://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/wangEditor.min.js"></script>
<script type="text/javascript" src="js/news.js"></script>
</html>
