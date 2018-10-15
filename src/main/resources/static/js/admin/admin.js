$(function () {
    $("#button").click(function () {
        var json = $("#loginForm").serialize();
        $.ajax({
            async : true,
            data : json,
            url : "/fixSystem/adeal",
            type : "POST",
            success : function(data){
                if (data == "success") {
                    $(window).attr("location", "/fixSystem/admin/Manager");
                } else {
                    alert("用户名或密码错误!");
                }
            },
            error : function () {
                alert("可能服务器内部出了点小问题哦~请稍后再来~")
            }
        })
    })
});