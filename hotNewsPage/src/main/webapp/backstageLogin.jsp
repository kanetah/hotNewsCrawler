<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登陆后台</title>
    <link rel="stylesheet" href="css/backstageLogin.css">
</head>
<body>
<a id="return" href="/">返回</a><h1>登陆后台</h1>
<form>
    <div>
        <input class="inp" id="password" type="password" placeholder="口令">
    </div>
    <br>
    <div>
        <div id="captcha">
            <p id="wait" class="show">正在加载验证码......</p>
        </div>
    </div>
    <br>
    <input class="btn" id="submit" type="submit" value="登陆">
    <p id="notice" class="hide">请先完成验证</p>
    <p id="fail" class="hide">请输入正确的口令</p>
</form>
<script src="js/vendor/gt.js"></script>
<script src="https://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script src="js/backstageLogin.js"></script>
</body>
</html>