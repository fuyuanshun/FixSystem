<%@page isELIgnored="false"%>
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
<body>
    <div class="container center-block">
        <div>
            <table  class="table table-hover">
                <form action="/adeal" method="POST" id="loginForm">
                <tr>
                    <td>
                        <span>管理员账号</span>
                    </td>
                    <td>
                        <input type="text" name="name" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>管理员密码</span>
                    </td>
                    <td>
                        <input type="text" name="password" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="button" id="button" class="btn btn-lg float-right btn-primary">登陆</button>
                           <%--<input type="submit" id="button" class="btn btn-lg float-right btn-primary" value="登陆"/>--%>
                    </td>
                </tr>
                </form>
            </table>
            <p class="text-danger">管理员账号：root 管理员密码：root</p>
        </div>
    </div>
</body>
</html>
