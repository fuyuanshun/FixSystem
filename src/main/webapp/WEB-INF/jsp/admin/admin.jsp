<%@page isELIgnored="false" %>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%request.setCharacterEncoding("utf-8");%>
<html>
<head>
    <title>管理员登陆</title>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.3.1.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/admin/admin.js"></script>
</head>
<style>
    .login-center {
        height: 100vh;
    }
</style>
<body>
<div class="container">
    <div class="row align-items-center justify-content-center login-center">
        <form action="/adeal" method="POST" id="loginForm">
            <h4 class="text-center">管理员登陆(默认账号密码root)</h4>
            <input type="text" class="form-control" placeholder="管理员账号" id="name" name="name"/><br>
            <input type="text" class="form-control" placeholder="管理员密码" id="password" name="password"/><br>
            <button type="button" id="button" class="btn-success btn-block">登陆</button>
        </form>
    </div>
</div>
</body>
</html>
