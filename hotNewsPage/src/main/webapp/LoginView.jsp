<%--
  Created by IntelliJ IDEA.
  User: 老幺
  Date: 2017/11/6
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <div class = "row">
        <form action="MainView.jsp" class = "fh5co-form animate-box" data-animate-effect="fadeIn">
            <h2>Sign In</h2>
            <div class="form-group">
                <label for="username" class="sr-only">Username</label>
                <input type="text" class="form-control" id="username" placeholder="Username" autocomplete="off">
            </div>
            <div class="form-group">
                <label for="password" class="sr-only">Password</label>
                <input type="password" class="form-control" id="password" placeholder="Password" autocomplete="off">
            </div>
            <div class="form-group">
                <p>Not registered? <a href="sign-up.html">Sign Up</a> | <a href="forgot.html">Forgot Password?</a></p>
            </div>
            <div class="form-group">
                <input type="submit" value="Sign In" class="btn btn-primary">
            </div>
        </form>
    </div>
</body>
</html>
