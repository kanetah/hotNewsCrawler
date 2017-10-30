<%--
  Created by IntelliJ IDEA.
  User: kane
  Date: 2017/10/30
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
    <script>
        function a() {
            alert('poi');
            $.ajax({
                url: "/out",
                success: function (result) {
                    $('.p1').remove();
                    $.each(result, function (index, elem) {
                        $('.d1').append('<p>' + elem + '</p>');
                    })
                }
            })
        }
    </script>
</head>
<body onload="a()">
pooi
<input type="button" onclick="a()"/>
<div class="d1">
    <p class="p1">12356789</p>
    <p class="p1">12356789</p>
    <p class="p1">12356789</p>
    <p class="p1">12356789</p>
    <p class="p1">12356789</p>
</div>
</body>
</html>
