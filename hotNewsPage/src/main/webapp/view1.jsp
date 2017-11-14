<%@ page language="java" import="java.util.*,javax.annotation.Resource" pageEncoding="utf-8"%>
<%@ page import="top.kanetah.hotNewsCrawler.dao.NewsDAO" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <base href="<%=basePath%>">
    
    <title>Test view</title>

	  <script type="text/javascript" src="js/index.js"></script>
	<!-- JQuery -->
	<script src="https://cdn.bootcss.com/jquery/3.2.1/core.js"></script>
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	<link rel = "stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <!-- Custom styles for this template -->
    <link href="css/Customize.css" rel="stylesheet">
	  <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！评论文本框-->
	  <script type="text/javascript" src="js/wangEditor.min.js"></script>
	
  </head>
  
  <body>
    <nav class = "navbar navbar-inverse navbar-fixed-top mybar">
    	<div class ="container">
    		<div class="navbar-header">
				<a class="navbar-brand" href="MainView.jsp">Name</a>
			</div>
			<%--<div id="navbar" class="collapse navbar-collapse">--%>
				<ul class="nav navbar-nav navbar-right">
					<li><a href = "#">Login</a></li>
					<li class="home"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			<%--</div>--%>
    	</div>
    </nav>
    <div class = "container">
    	<div class="starter-template">
			<div class="title">
				<h3>20岁女留学生在加拿大多伦多失联，当地警方启动寻人</h3>
			</div>
			<hr>
			<div class="date-time">
				2017年11月10日 22:45   来源：法制晚报<br><br><br>
			</div>
			<div class="content">
				<p>
					原题为《20岁美女留学生在加失联超2天 望其家人速与联合会联系》<br>
					法制晚报·看法新闻消息<br>
					11月10日，法制晚报·看法新闻记者从清华大学海外安全研究中心、海外青少年权益保护与发展联合会了解到，20岁的女留学生章镌文(Angel)于加拿大多伦多当地时间11月8日下午1时45分失联，该联合会负责人表示，希望章镌文的家人看到消息后与他们取得联系，他们会联系当地华人协助搜索工作。<br>
					法制晚报·看法新闻记者了解到，章镌文今年20岁，身高约 163厘米，体重约100斤。失联前身着灰色运动裤。章镌文失去联系前最后一次被发现是在11月8日周三下午1时45分，地点位于Yonge Street &Grenville Street。<br>
					<img src="images/Zhang.jpg" ><br>
					章镌文近照<br>
					看法新闻 图当地警方很关心她的安全情况，如果发现她的位置或情况请立即联系多伦多警方。如果能提供任何有用信息，请立即拨打416-808-5200联系多伦多警方，或匿名拨打416-222-TIPS (8477)，或者发送信息TOR+您的信息至247637。<br>
					海外青少年权益保护与发展联合会秘书长刘嘉宏告诉法制晚报·看法新闻记者，他们会根据加拿大方面的情况联系当地华人协助搜索工作，并且向家长推荐相关国际救援组织进行具体工作。“若有实际需要我们会安排当地律师跟进，其家人到京后我们协助办理签证等手续。”刘嘉宏说。<br>
					【责任编辑:梁异】
				</p>
			</div>
    	</div>
		<%--<form class="related-news">--%>
			<%--<table>--%>

			<%--</table>--%>
		<%--</form>--%>
    </div>
	<div class="container">
			<div id="editor"></div>
			<script type="text/javascript">
                var E = window.wangEditor
                var editor = new E('#editor')
                // 或者 var editor = new E( document.getElementById('#editor') )
                editor.create()
			</script>
			<input type="submit" class="btn btn-default" id = "submit" value="评论">
		</div>
	</div>
	<div class="container">
		<form>
			<table class="comment-show">
				<tr class="comment-show-info">
					<td>Name &#12288  &#12288 Time</td>
				</tr>
				<tr class="comment-show-info">
					<td>&#12288&#12288 commentcommentcommentcommentcommentcommentcommentcommentcommentcommentcommentcommentcommentcommentcommentcommentcommentcommentcommentcomment</td>
				</tr>
			</table>
			<table class="comment-show">
				<tr class="comment-show-info">
					<td>Name &#12288  &#12288 Time</td>
				</tr>
				<tr class="comment-show-info">
					<td>&#12288&#12288 commentcommentcommentcommentcommentcommentcommentcommentcommentcommentcommentcommentcommentcommentcommentcommentcommentcommentcommentcomment</td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<a href="javascript:window.scrollTo(0,0)"class = "BackToTop">
		<span class="glyphicon glyphicon-menu-up" aria-hidden="true">
			<br>Back<br>to<br>top
		</span>
		</a>
	</div>
  	<div class="modal" id="loginModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<button type="button" class="close" data-dismiss="modal">×</button><%--如果你的modal弹窗里面加上这个按钮，那么点击则会关闭当前弹窗，关键在于data-dismiss="modal"，它让按钮有了这个功能。--%>
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
</html>
