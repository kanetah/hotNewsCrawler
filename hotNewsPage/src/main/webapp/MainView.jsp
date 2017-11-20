<%--
  Created by IntelliJ IDEA.
  User: 老幺
  Date: 2017/10/24
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- JQuery -->
<script src="https://cdn.bootcss.com/jquery/3.2.1/core.js"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel = "stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<!-- Custom styles for this template -->
<link href="css/Customize.css" rel="stylesheet">
<link href="css/MainView.css" rel="stylesheet">
<html>
<head>
    <title>MainView</title>
</head>
<body>
    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="MainView.jsp">Name</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="btn btn-block" >
                        <a data-toggle="modal" data-target="#loginModal" class="account-setting-seperator polyglot" >Login</a>
                    </li>
                    <%--<li><a href="#">Login</a></li>--%>
                    <li><a href="/about">About</a></li>
                    <li><a href="/contact">Contact</a></li>
                </ul>
            </div>
        </div>
    </nav>
   <nav class="navbar">
        <div class="container1">
            <div class="navbar-header">
                <ul class="nav navbar-nav">
                    <li class="home" onfocus=""><a href="#">Home</a></li>
                    <li><a href = "#">Type</a></li>
                    <li><a href = "#">Type</a></li>
                    <li><a href = "#">类型</a></li>
                    <li><a href = "#">Type</a></li>
                    <li><a href = "#">Type</a></li>
                    <li><a href = "#">Type</a></li>
                    <li><a href = "#">Type</a></li>
                    <li><a href = "#">Type</a></li>
                    <li><a href = "#">Type</a></li>
                </ul>
            </div>

            <div class="nav navbar-nav">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">搜索</button>
                     </span>
                </div>
            </div>
        </div>
    </nav>
    <%-- <div class="starter-template">
        <div class="page-header">
            <h2>习近平强调，坚持“一国两制”，推进祖国统一<br></h2>
            <small>新华社北京10月18日电</small>
        </div>
        <p>

            习近平同志在十九大报告中强调，坚持“一国两制”，推进祖国统一。<br>

            习近平指出，事实证明，“一国两制”是解决历史遗留的香港、澳门问题的最佳方案，也是香港、澳门回归后保持长期繁荣稳定的最佳制度。<br>

            习近平强调，保持香港、澳门长期繁荣稳定，必须全面准确贯彻“一国两制”、“港人治港”、“澳人治澳”、高度自治的方针，严格依照宪法和基本法办事，完善与基本法实施相关的制度和机制。要支持特别行政区政府和行政长官依法施政、积极作为，团结带领香港、澳门各界人士齐心协力谋发展、促和谐，保障和改善民生，有序推进民主，维护社会稳定，履行维护国家主权、安全、发展利益的宪制责任。<br>

            要支持香港、澳门融入国家发展大局，以粤港澳大湾区建设、粤港澳合作、泛珠三角区域合作等为重点，全面推进内地同香港、澳门互利合作，制定完善便利香港、澳门居民在内地发展的政策措施。<br>

            习近平说，我们坚持爱国者为主体的“港人治港”、“澳人治澳”，发展壮大爱国爱港爱澳力量，增强香港、澳门同胞的国家意识和爱国精神，让香港、澳门同胞同祖国人民共担民族复兴的历史责任、共享祖国繁荣富强的伟大荣光。<br>

            关于台湾问题，习近平说，解决台湾问题、实现祖国完全统一，是全体中华儿女共同愿望，是中华民族根本利益所在。必须继续坚持“和平统一、一国两制”方针，推动两岸关系和平发展，推进祖国和平统一进程。<br>

            他强调，体现一个中国原则的“九二共识”明确界定了两岸关系的根本性质，是确保两岸关系和平发展的关键。承认“九二共识”的历史事实，认同两岸同属一个中国，两岸双方就能开展对话，协商解决两岸同胞关心的问题，台湾任何政党和团体同大陆交往也不会存在障碍。<br>

            习近平说，我们秉持“两岸一家亲”理念，尊重台湾现有的社会制度和台湾同胞生活方式，愿意率先同台湾同胞分享大陆发展的机遇。将扩大两岸经济文化交流合作，实现互利互惠，逐步为台湾同胞在大陆学习、创业、就业、生活提供与大陆同胞同等的待遇，增进台湾同胞福祉。将推动两岸同胞共同弘扬中华文化，促进心灵契合。<br>

            习近平强调，坚决维护国家主权和领土完整，绝不容忍国家分裂的历史悲剧重演。一切分裂祖国的活动都必将遭到全体中国人坚决反对。我们有坚定的意志、充分的信心、足够的能力挫败任何形式的“台独”分裂图谋。绝不允许任何人、任何组织、任何政党、在任何时候、以任何形式、把任何一块中国领土从中国分裂出去。<br>

            习近平表示，实现中华民族伟大复兴，是全体中国人共同的梦想。我们坚信，只要包括港澳台同胞在内的全体中华儿女顺应历史大势、共担民族大义，把民族命运牢牢掌握在自己手中，就一定能够共创中华民族伟大复兴的美好未来。<br>
            新华社北京10月18日电 习近平同志在十九大报告中强调，坚持“一国两制”，推进祖国统一。<br>

            习近平指出，事实证明，“一国两制”是解决历史遗留的香港、澳门问题的最佳方案，也是香港、澳门回归后保持长期繁荣稳定的最佳制度。<br>

            习近平强调，保持香港、澳门长期繁荣稳定，必须全面准确贯彻“一国两制”、“港人治港”、“澳人治澳”、高度自治的方针，严格依照宪法和基本法办事，完善与基本法实施相关的制度和机制。要支持特别行政区政府和行政长官依法施政、积极作为，团结带领香港、澳门各界人士齐心协力谋发展、促和谐，保障和改善民生，有序推进民主，维护社会稳定，履行维护国家主权、安全、发展利益的宪制责任。

            要支持香港、澳门融入国家发展大局，以粤港澳大湾区建设、粤港澳合作、泛珠三角区域合作等为重点，全面推进内地同香港、澳门互利合作，制定完善便利香港、澳门居民在内地发展的政策措施。

            习近平说，我们坚持爱国者为主体的“港人治港”、“澳人治澳”，发展壮大爱国爱港爱澳力量，增强香港、澳门同胞的国家意识和爱国精神，让香港、澳门同胞同祖国人民共担民族复兴的历史责任、共享祖国繁荣富强的伟大荣光。

            关于台湾问题，习近平说，解决台湾问题、实现祖国完全统一，是全体中华儿女共同愿望，是中华民族根本利益所在。必须继续坚持“和平统一、一国两制”方针，推动两岸关系和平发展，推进祖国和平统一进程。

            他强调，体现一个中国原则的“九二共识”明确界定了两岸关系的根本性质，是确保两岸关系和平发展的关键。承认“九二共识”的历史事实，认同两岸同属一个中国，两岸双方就能开展对话，协商解决两岸同胞关心的问题，台湾任何政党和团体同大陆交往也不会存在障碍。

            习近平说，我们秉持“两岸一家亲”理念，尊重台湾现有的社会制度和台湾同胞生活方式，愿意率先同台湾同胞分享大陆发展的机遇。将扩大两岸经济文化交流合作，实现互利互惠，逐步为台湾同胞在大陆学习、创业、就业、生活提供与大陆同胞同等的待遇，增进台湾同胞福祉。将推动两岸同胞共同弘扬中华文化，促进心灵契合。

            习近平强调，坚决维护国家主权和领土完整，绝不容忍国家分裂的历史悲剧重演。一切分裂祖国的活动都必将遭到全体中国人坚决反对。我们有坚定的意志、充分的信心、足够的能力挫败任何形式的“台独”分裂图谋。绝不允许任何人、任何组织、任何政党、在任何时候、以任何形式、把任何一块中国领土从中国分裂出去。

            习近平表示，实现中华民族伟大复兴，是全体中国人共同的梦想。我们坚信，只要包括港澳台同胞在内的全体中华儿女顺应历史大势、共担民族大义，把民族命运牢牢掌握在自己手中，就一定能够共创中华民族伟大复兴的美好未来。新华社北京10月18日电 习近平同志在十九大报告中强调，坚持“一国两制”，推进祖国统一。

            习近平指出，事实证明，“一国两制”是解决历史遗留的香港、澳门问题的最佳方案，也是香港、澳门回归后保持长期繁荣稳定的最佳制度。

            习近平强调，保持香港、澳门长期繁荣稳定，必须全面准确贯彻“一国两制”、“港人治港”、“澳人治澳”、高度自治的方针，严格依照宪法和基本法办事，完善与基本法实施相关的制度和机制。要支持特别行政区政府和行政长官依法施政、积极作为，团结带领香港、澳门各界人士齐心协力谋发展、促和谐，保障和改善民生，有序推进民主，维护社会稳定，履行维护国家主权、安全、发展利益的宪制责任。

            要支持香港、澳门融入国家发展大局，以粤港澳大湾区建设、粤港澳合作、泛珠三角区域合作等为重点，全面推进内地同香港、澳门互利合作，制定完善便利香港、澳门居民在内地发展的政策措施。

            习近平说，我们坚持爱国者为主体的“港人治港”、“澳人治澳”，发展壮大爱国爱港爱澳力量，增强香港、澳门同胞的国家意识和爱国精神，让香港、澳门同胞同祖国人民共担民族复兴的历史责任、共享祖国繁荣富强的伟大荣光。

            关于台湾问题，习近平说，解决台湾问题、实现祖国完全统一，是全体中华儿女共同愿望，是中华民族根本利益所在。必须继续坚持“和平统一、一国两制”方针，推动两岸关系和平发展，推进祖国和平统一进程。

            他强调，体现一个中国原则的“九二共识”明确界定了两岸关系的根本性质，是确保两岸关系和平发展的关键。承认“九二共识”的历史事实，认同两岸同属一个中国，两岸双方就能开展对话，协商解决两岸同胞关心的问题，台湾任何政党和团体同大陆交往也不会存在障碍。

            习近平说，我们秉持“两岸一家亲”理念，尊重台湾现有的社会制度和台湾同胞生活方式，愿意率先同台湾同胞分享大陆发展的机遇。将扩大两岸经济文化交流合作，实现互利互惠，逐步为台湾同胞在大陆学习、创业、就业、生活提供与大陆同胞同等的待遇，增进台湾同胞福祉。将推动两岸同胞共同弘扬中华文化，促进心灵契合。

            习近平强调，坚决维护国家主权和领土完整，绝不容忍国家分裂的历史悲剧重演。一切分裂祖国的活动都必将遭到全体中国人坚决反对。我们有坚定的意志、充分的信心、足够的能力挫败任何形式的“台独”分裂图谋。绝不允许任何人、任何组织、任何政党、在任何时候、以任何形式、把任何一块中国领土从中国分裂出去。

            习近平表示，实现中华民族伟大复兴，是全体中国人共同的梦想。我们坚信，只要包括港澳台同胞在内的全体中华儿女顺应历史大势、共担民族大义，把民族命运牢牢掌握在自己手中，就一定能够共创中华民族伟大复兴的美好未来。新华社北京10月18日电 习近平同志在十九大报告中强调，坚持“一国两制”，推进祖国统一。

            习近平指出，事实证明，“一国两制”是解决历史遗留的香港、澳门问题的最佳方案，也是香港、澳门回归后保持长期繁荣稳定的最佳制度。

            习近平强调，保持香港、澳门长期繁荣稳定，必须全面准确贯彻“一国两制”、“港人治港”、“澳人治澳”、高度自治的方针，严格依照宪法和基本法办事，完善与基本法实施相关的制度和机制。要支持特别行政区政府和行政长官依法施政、积极作为，团结带领香港、澳门各界人士齐心协力谋发展、促和谐，保障和改善民生，有序推进民主，维护社会稳定，履行维护国家主权、安全、发展利益的宪制责任。

            要支持香港、澳门融入国家发展大局，以粤港澳大湾区建设、粤港澳合作、泛珠三角区域合作等为重点，全面推进内地同香港、澳门互利合作，制定完善便利香港、澳门居民在内地发展的政策措施。

            习近平说，我们坚持爱国者为主体的“港人治港”、“澳人治澳”，发展壮大爱国爱港爱澳力量，增强香港、澳门同胞的国家意识和爱国精神，让香港、澳门同胞同祖国人民共担民族复兴的历史责任、共享祖国繁荣富强的伟大荣光。

            关于台湾问题，习近平说，解决台湾问题、实现祖国完全统一，是全体中华儿女共同愿望，是中华民族根本利益所在。必须继续坚持“和平统一、一国两制”方针，推动两岸关系和平发展，推进祖国和平统一进程。

            他强调，体现一个中国原则的“九二共识”明确界定了两岸关系的根本性质，是确保两岸关系和平发展的关键。承认“九二共识”的历史事实，认同两岸同属一个中国，两岸双方就能开展对话，协商解决两岸同胞关心的问题，台湾任何政党和团体同大陆交往也不会存在障碍。

            习近平说，我们秉持“两岸一家亲”理念，尊重台湾现有的社会制度和台湾同胞生活方式，愿意率先同台湾同胞分享大陆发展的机遇。将扩大两岸经济文化交流合作，实现互利互惠，逐步为台湾同胞在大陆学习、创业、就业、生活提供与大陆同胞同等的待遇，增进台湾同胞福祉。将推动两岸同胞共同弘扬中华文化，促进心灵契合。

            习近平强调，坚决维护国家主权和领土完整，绝不容忍国家分裂的历史悲剧重演。一切分裂祖国的活动都必将遭到全体中国人坚决反对。我们有坚定的意志、充分的信心、足够的能力挫败任何形式的“台独”分裂图谋。绝不允许任何人、任何组织、任何政党、在任何时候、以任何形式、把任何一块中国领土从中国分裂出去。

            习近平表示，实现中华民族伟大复兴，是全体中国人共同的梦想。我们坚信，只要包括港澳台同胞在内的全体中华儿女顺应历史大势、共担民族大义，把民族命运牢牢掌握在自己手中，就一定能够共创中华民族伟大复兴的美好未来。

        </p>
    </div>--%>

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
                            <form role="form" novalidate="" ng-model="signInForm" name="signInForm">
                                <div class="form-group form-group-lg label-floating is-empty">
                                    <%--<label class="control-label">Username</label>--%>
                                    <input class="form-control" name="loginId" type="text" id="loginId" placeholder="Username" required/>
                                    <%--<p ng-cloak class="help-text text-danger" ng-show="signInForm.$submitted && !signInForm.loginId.$error.required && signInForm.loginId.$invalid"><span class="text-red">* </span>Enter a valid username.</p>--%>
                                    <%--<p ng-cloak class="help-text text-danger" ng-show="signInForm.$submitted && signInForm.loginId.$error.required"> <span class="text-red">* </span>Username is required.</p>--%>
                                    <%--<p ng-cloak class="help-text text-danger" id="signInIncorrectEmail"><span class="text-red">* </span>The username you entered is incorrect.</p>--%>
                                </div>
                                <div class="form-group form-group-lg label-floating is-empty">
                                    <%--<label for="signInPassword" class="control-label">Password</label>--%>
                                    <input name="password" type="password" id="signInPassword" required class="form-control" placeholder="Password"/>
                                    <%--<p ng-cloak class="help-text text-danger" ng-show="signInForm.$submitted && signInForm.password.$error.required"> <span class="text-red">* </span>Password is required</p>--%>
                                    <%--<p ng-cloak class="help-text text-danger" ng-show="signInForm.$submitted && signInForm.password.$error.minlength"> <span class="text-red">* </span>Password is too short</p>--%>
                                    <%--<p ng-cloak class="help-text text-danger" ng-show="signInForm.$submitted && signInForm.password.$error.maxlength"> <span class="text-red">* </span>Password is too long</p>--%>
                                    <%--<p ng-cloak class="help-text text-danger" id="signInIncorrectPassword" ng-cloak><span class="text-red">* </span>Your password is incorrect.</p>--%>
                                </div>
                                <div class="forgotten-text">
                                    <p class="text-right"><a href="#" >Sign Up</a>|<a href="#" >Forgotten Password</a></p>
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

<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
