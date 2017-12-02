<%--
  Created by IntelliJ IDEA.
  User: 33
  Date: 2017/11/25
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>后台信息</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/Backstage.css" />
</head>
<body>
<nav>
    <ul class="nav nav-tabs">
        <li role="presentation" class="active" id="user"><a href="javascript:void(0)">用户信息</a></li>
        <li role="presentation" id="news"><a href="javascript:void(0)">新闻信息</a></li>
        <li role="presentation" id="comment"><a href="javascript:void(0)">评论信息</a></li>
        <li><input type="text" id="SearchText" placeholder="bugjhvu"/></li>
        <li><input type="button" id="SearchBtn" value="Search"/></li>
    </ul>
</nav>
<div class="user-info">
    <table class="table table-striped user-info-table">
        <tr>
            <td>
                <input type="checkbox" name="SelectAll" id="SelectAll_UserSA" class="SelectAll"/>全选 &nbsp;
                <input type="checkbox" name="Anti-election" id="Anti-election_UserAe" class="Anti-election"/>反选
            </td>
            <td>ID</td>
            <td>Name</td>
        </tr>
        <tr hidden  class="showUserInfo">
            <td><input type="checkbox"  name="checkbox"/></td>
            <td class="userID"></td>
            <td class="userName"></td>
        </tr>
    </table>
</div>
<div class="news-info" hidden="hidden">
    <table class="table table-striped">
        <tr>
            <td>
                <input type="checkbox" name="SelectAll" id="SelectAll_NewsSA" class="SelectAll" />全选 &nbsp;
                <input type="checkbox" name="Anti-election" id="Anti-election_NewsAe" class="Anti-election" />反选
            </td>
            <td>ID</td>
            <td>Title</td>
            <td>Date</td>
            <td>Type</td>
            <td>Rank</td>
            <td>Src</td>
        </tr>
        <tr hidden class="showNewsInfo">
            <td><input type="checkbox"  name="newsCheckbox"/></td>
            <td class="newsID"></td>
            <td class="newsTitle" data-toggle="tooltip" data-placement="bottom" title=""></td>
            <td class="newsDate"></td>
            <td class="newsType"></td>
            <td class="newsRank"></td>
            <td class="newsSrc"></td>
        </tr>
    </table>
</div>
<div class="comment-info" hidden="hidden">
    <table class="table table-striped">
        <tr>
            <td></td>
            <td>ID</td>
            <td>UserID</td>
            <td>News_ID</td>
            <td>Content</td>
            <td>Time</td>
        </tr>
        <tr hidden class="showCommentInfo">
            <td><input type="checkbox" name="commentCheckbox"/></td>
            <td class="CommentId"></td>
            <td class="UserId"></td>
            <td class="NewsId"></td>
            <td class="CommentContent"></td>
            <td class="CommentTime"></td>
        </tr>
    </table>
</div>
<div class="container">
    <input type="button" name="Delete-btn" id="Delete-btn" class="btn btn-danger" value="删除"/>
    <input type="button" name="Delete-btn" id="Delete-btn-news" class="btn btn-danger" value="删除"/>
    <input type="button" name="Delete-btn" id="Delete-btn-comment" class="btn btn-danger" value="删除"/>
    <input type="button" name="Add-btn" id="Add-btn" class="btn btn-default" value="添加" />
    <ul class="pagination">
        <li id="previous"><a href="javascript:void(0)">&laquo;</a></li>
        <%--<li class="active" id="li_1"><a href="javascript:void(0)">1</a></li>--%>
        <%--<li><a href="#">2</a></li>--%>
        <li id="next"><a href="javascript:void(0)">&raquo;</a></li>
    </ul>
</div>

<div class="modal" id="UserEditor" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4>用户编辑</h4>
            </div>
            <div class="modal-body">
                <label>ID:</label><input type="text" readonly="readonly" id="IDText"/>
                <label>用户名:</label><input type="text" id="userNameText"/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-submit" id="updateUserBtn">提交</button>
            </div>
        </div>
    </div>
</div>
<div class="modal" id="UserAdd" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4>用户编辑</h4>
            </div>
            <div class="modal-body">
                <%--<label>ID:</label><input type="text" readonly="readonly" value="1" id="newIDText"/>--%>
                <label>用户名:</label><input type="text"  id="newNameText" value=""/>
                <label>密码:</label><input type="password" id="passwordText"/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-submit" id="AddUserBtn">提交</button>
            </div>
        </div>
    </div>
</div>
</body>
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/Backstage.js" ></script>
</html>
