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
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="newsId" content="${id}">
    <link rel="icon" href="images/favicon.ico">
    <base href="/">

    <title>news view</title>

    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="css/Customize.css" rel="stylesheet">
    <link rel="stylesheet" href="css/news.css">
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top mybar">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="MainView.jsp">Name</a>
        </div>
        <%--<div id="navbar" class="collapse navbar-collapse">--%>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Login</a></li>
            <li class="home"><a href="#">Home</a></li>
            <li><a href="/about">About</a></li>
            <li><a href="/contact">Contact</a></li>
        </ul>
        <%--</div>--%>
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
    <input type="submit" class="btn btn-default" id="submit" value="评论">
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
            <%--如果你的modal弹窗里面加上这个按钮，那么点击则会关闭当前弹窗，关键在于data-dismiss="modal"，它让按钮有了这个功能。--%>
            <div class="modal-body">
                <div ng-controller="loginCtrl"><%--ng-controller 指令用于为你的应用添加控制器--%>
                    <div ng-show="showLoginForm"><%--ng-show 指令在表达式为 true 时显示指定的 HTML 元素，否则隐藏指定的 HTML 元素。--%>
                        <div class="welcome-text">
                            <h2>Sign In</h2>
                        </div>
                        <form role="form" ng-model="signInForm"></form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"
        type="javascript"></script>
<script type="text/javascript" src="js/wangEditor.min.js"></script>
<script type="text/javascript" src="js/news.js"></script>
</html>
