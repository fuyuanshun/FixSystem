$(function () {
   /* $.validator.addMethod("isPhone", function (value, element, param) {
        alert(value);
        if(/^1[3578][9]{11}$/.test(value)){
            return true;
        } else {
            return false;
        }
    }, "请正确的输入11位手机号")

    $.validator.setDefaults({
        submitHandler : function () {
            var json = $("#sendInfo2").serialize();

            $.ajax({
                url : "/deal",
                data : json,
                method : "POST",
                async : true,
                success : function (data) {
                    alert("success!");
                }
            })
        }
    })

    $("#sendInfo2").validate({
        errorPlacement: function(error, element) {
            alert(error.val());
            alert(element.val());
            $(element)
                .closest( "form" )
                .find( "label[for='" + element.attr( "id" ) + "']" )
                .append( error );
        },
        errorElement: "span",
        rules : {
            name2 : {
              required : true,
              minLength : 3
            },
            floor : {
                required : true,
            },
            room : {
                required : true,
                minLength : 3
            },
            phone : {
                required : true,
                isPhone : true
            },
            info : {
                required : true
            }
        },
        message : {
            name2 : {
              required : "请填写你的名字",
              minLength : "3"
            },
            floor : {
                required : "请填写你的宿舍楼"
            },
            room : {
                required : "请填写你的地址"
            },
            info : {
                required : "请填写故障信息"
            },
        }
    })*/


    $("#button").click(function () {
        var json = $("#sendInfo").serializeArray();
        var name = json[1].value;
        $("#name").attr("value", name);
        var floor = json[2].value;
        $("#floor").attr("value", floor);
        var room = json[3].value;
        $("#room").attr("value", room);
        var phone = json[4].value;
        $("#phone").attr("value", phone);
        var info = json[5].value;
        $("#info").attr("value", info);
    })

    $("#button2").click(function () {
        var json = $("#sendInfo").serializeArray();
        $.ajax({
            url : "/fixSystem/deal",
            data : json,
            method : "POST",
            async : true,
            success : function (data) {
                alert(data);
            }
        })
    })
})