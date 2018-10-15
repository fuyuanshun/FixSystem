<%@page isELIgnored="false"%>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<html>
<head>
    <title>报修系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.3.1.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/infoForm.js"></script>
</head>

<body>
<h2 class="text-center">报修系统表</h2>

<div class="container center-block">
    <table class="table table-hover">
        <form action="" method="post" id="sendInfo">
            <input type="hidden" name="id" value="${id}">
            <tr>
                <td class="col-sm-1 text-center">您的姓名</td>
                <td class="col-sm-5"><input class="form-control" type="text" name="name" value="${name}" readonly></td>
            </tr>
            <tr>
                <td class="text-center">宿舍楼</td>
                <td><input class="form-control" type="text" name="floor" value="${floor}" readonly></td>
            </tr>
            <tr>
                <td class="text-center">寝室号</td>
                <td><input class="form-control" type="text" name="room" value="${room}" readonly></td>
            </tr>
            <tr>
                <td class="text-center">联系电话</td>
                <td><input class="form-control" type="text"  name="phone" value="${phone}" readonly></td>
            </tr>
            <tr>
                <td class="text-center">故障信息</td>
                <td><textarea name="info" cols="30" rows="10" placeholder="请填写故障信息"></textarea></td>
            </tr>
            <tr>
                <td colspan="5"><button type="button" class="float-right btn-primary btn btn-lg" data-toggle="modal" data-target="#myModal" id="button">提交信息</button></td>
            </tr>
        </form>
    </table>
</div>

<!-- 模态框 -->
<div class="modal fade" id="myModal" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">确认信息</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
                <div>
                    <label class="text-muted">名称:</label>
                    <input type="text" id="name" class="form-control" readonly>
                    <label class="col-form-label">宿舍楼:</label>
                    <input type="text" id="floor" class="form-control" readonly>
                    <label class="col-form-label">寝室号:</label>
                    <input type="text" id="room" class="form-control" readonly>
                    <label class="col-form-label">联系电话:</label>
                    <input type="text" id="phone" class="form-control" readonly>
                    <label class="col-form-label">故障信息:</label>
                    <input <%--cols="30" rows="10"--%> type="text" id="info" class="form-control" readonly />
                    <span class="text-danger">注: 如想修改信息，请返回上个页面修改</span>
                </div>
            </div>
            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-secondary" id="button2">提交</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>