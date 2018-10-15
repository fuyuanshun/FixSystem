<%@page isELIgnored="false"%>
<%@ page import="com.fys.fixsystem.util.Page" %>
<%@ page import="java.util.regex.Pattern" %>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%request.setCharacterEncoding("utf-8");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    int currentPage = 1;
    String strCurrentPage = request.getParameter("currentPage");
    if (null == strCurrentPage || "".equals(strCurrentPage)) {
        currentPage = 1;
    } else {
        if (Pattern.matches("^\\d+$", strCurrentPage)) {
            currentPage = Integer.parseInt(strCurrentPage);
        }
    }

    Page page1 = (Page)request.getSession().getAttribute("page");

    int totalPage = page1.getTotalPage();
    if (currentPage >= totalPage) {
        currentPage = totalPage;
    }
    if (currentPage <= 1) {
        currentPage = 1;
    }
%>

<html>
<head>
    <title>故障反馈管理员界面</title>
    <%--Jquery--%>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.3.1.min.js"></script>
    <%--BootStrap--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
</head>
<body>
<nav class="nav">
    <span>尊贵的</span>
    <p class="text-danger" style="margin-left: 10px">${name}</p>
    <span class="text-muted" style="margin-left: 10px">欢迎登陆高端大气上档次，低调奢华有内涵的故障反馈后台管理页面！</span>
    <p style="margin-left: 10px"><a href="/fixSystem/admin/logout" onclick='return confirm("确定退出吗?");'>退出</a></p>
</nav>
<div class="container">
    <table class="table table-hover table-bordered">
        <tr>
            <td class="badge-success">序号</td>
            <td class="badge-success">姓名</td>
            <td class="badge-success">楼层</td>
            <td class="badge-success">宿舍号</td>
            <td class="badge-success">联系电话</td>
            <td class="badge-danger">故障信息</td>
            <td class="badge-danger">提交时间</td>
            <td class="badge-danger">操作</td>
        </tr>
    <c:forEach items="${infos}" var="info">
        <tr>
            <td>${info.id}</td>
            <td>${info.name}</td>
            <td>${info.floor}</td>
            <td>${info.room}</td>
            <td>${info.phone}</td>
            <td>${info.info}</td>
            <td>${info.createDate}</td>
            <td><a href="${pageContext.request.contextPath}/delete?id=${info.id}" onclick='return confirm("处理完成后会删除此记录，确定吗?");'>处理完成</a></td>
        </tr>
    </c:forEach>
        <tr>
            <td colspan="8">
                <ul class="pagination">
                    <li class="page-item disabled"><a class="page-link" href="">共<%=totalPage%>页</a></li>
                    <li class="page-item disabled"><a class="page-link" href="">当前第<%=currentPage%>页</a></li>
                    <li class="page-item "><a class="page-link" href="/fixSystem/admin/Manager?currentPage=1">首页</a></li>
                    <li class="page-item "><a class="page-link" href="/fixSystem/admin/Manager?currentPage=<%=currentPage-1%>">上一页</a></li>
                    <li class="page-item "><a class="page-link" href="/fixSystem/admin/Manager?currentPage=<%=currentPage+1%>">下一页</a></li>
                    <li class="page-item "><a class="page-link" href="/fixSystem/admin/Manager?currentPage=${page.getTotalPage()}">尾页</a></li>
                </ul>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
