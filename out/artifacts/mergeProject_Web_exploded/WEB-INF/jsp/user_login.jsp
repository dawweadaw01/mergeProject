<%--
  Created by IntelliJ IDEA.
  User: 20698
  Date: 2022/12/12
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <title>用户登录</title>
    <link rel="stylesheet" href="static/css/user_login.css">
    <link rel="stylesheet" href="static/verify-master/css/verify.css">
    <link rel="stylesheet" href="static/bootstrap-3.4.1-dist/css/bootstrap.css">
</head>
<body>
<!-- 最外层的大盒子 -->
<div class="box">
    <!-- 滑动盒子 -->
    <div class="pre-box">
        <h1>WELCOME</h1>
        <p>JOIN US!</p>
        <div class="img-box">
            <img src="static/img/waoku.jpg" alt="">
        </div>
    </div>
    <!-- 注册盒子 -->
    <div class="register-form">
        <!-- 标题盒子 -->
        <div class="title-box">
            <h1>注册</h1>
        </div>
        <!-- 输入框盒子 -->
        <form id="registerForm">
            <div class="input-box">
                <input type="text" placeholder="用户名" name="username" id="username1" required><span id="msgName"></span>
                <input type="password" placeholder="密码" name="password" id="password1" required><span id="msgPwd"></span>
                <input type="text" placeholder="邮箱" name="email" id="email" required><span id="msgEmail"></span>
                <input type="text" placeholder="手机号" name="phone" id="phone" required><span id="msgPhone"></span>
                <input type="file" placeholder="头像" name="photo" id="photo">
            </div>
            <!-- 按钮盒子 -->
            <div class="btn-box">
                <button id="register" type="button">注册</button>
                <!-- 绑定点击事件 -->
                <p onclick="mySwitch()">已有账号?去登录</p>
            </div>
        </form>

    </div>
    <!-- 登录盒子 -->
    <div class="login-form">
        <!-- 标题盒子 -->
        <div class="title-box">
            <h1>登录</h1>
        </div>
        <!-- 输入框盒子 -->
        <form id="loginForm">
            <div class="input-box">
                <input type="text" placeholder="用户名" name="username" id="username">
                <input type="password" placeholder="密码" name="password" id="password">
            </div>
            <!-- 按钮盒子 -->
            <div class="btn-box">
                <button type="button" id="login">登录</button>
                <!-- 绑定点击事件 -->
                <p onclick="mySwitch()">没有账号?去注册</p>
            </div>
        </form>
    </div>
</div>

<!-- 滑块验证码 -->
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">验证码</h4>
            </div>
            <div class="modal-body">
                <div id="mpanel4" style="margin-top:50px;">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取 消</button>
                <button id="btnSave" type="button" class="btn btn-primary">确认</button>
            </div>
        </div>
    </div>
</div>

<!-- 添加滑动验证码的模块 -->
<script src="static/jquery-3.5.1/jquery-3.5.1.js"></script>
<script src="static/bootstrap-3.4.1-dist/js/bootstrap.js"></script>
<script src="static/verify-master/js/verify.js"></script>
<script>

    // 书写函数封装
    $(function () {
        // 点击登录出现验证码框
        btnSlide();
        // 注册函数
        registerFunc();
    });

    // 点击登录出现验证码框
    function btnSlide() {
        $("#login").click(function () {
            $('#myModal').modal('show');
        });
        slideFunc();
    }

    // 滑块验证码的函数
    function slideFunc() {
        $('#mpanel4').slideVerify({
            type: 2,		//类型
            vOffset: 5,	//误差量，根据需求自行调整
            vSpace: 5,	//间隔
            imgUrl: "static/img/",
            imgName: ['slide1.webp', 'slide2.webp',],
            imgSize: {
                width: '568px',
                height: '305px',
            },
            blockSize: {
                width: '50px',
                height: '50px',
            },
            barSize: {
                width: '568px',
                height: '40px',
            },
            ready: function () {
            },
            success: function () {
                // alert('验证成功，添加你自己的代码！');
                //......后续操作
                loginFunc();
            },
            error: function () {
                alert('验证失败！');
            }

        });
    }

    //登录函数
    function loginFunc() {
        $("#btnSave").click(function () {
            let username = $("#loginForm #username").val();
            let password = $("#loginForm #password").val();
            // console.log(username + " " + password);
            $.ajax({
                url: "login",
                type: "post",
                //接收的数据
                data: {
                    'username': username,
                    'password': password,
                },
                success: function (res) {
                    if (res !== "false") {
                        window.location.href = "index.do";
                    } else {
                        alert("登录失败！");
                        // console.log(res);
                        // 刷新页面
                        location.reload();
                    }
                }
            });
        });
    }

    // 注册函数
    function registerFunc() {
        $('#register').click(function () {
            // 注册之前需要校验
            if(checkInput()){
                // 得到form表单的数据
                let formData = new FormData($('#registerForm')[0]);
                $.ajax({
                    url: 'register',
                    type: 'post',
                    data: formData,
                    contentType: false, // 提交给服务端的数据类型，不要当成字符串处理
                    processData:false, // 通过请求发送的数据是否转换为查询字符串
                    success: function (res) {
                        if (res === "true") {
                            window.location.href = "user_login.do";
                        } else {
                            alert("出现问题！请重新来过！");
                            location.reload();
                        }
                    }
                });
            }
        });
    }

    // 校验注册
    function checkInput(){
        let username1 = $('#username1').val()
        let password1 = $('#password1').val();
        let email = $('#email').val();
        let phone = $('#phone').val();
        let a, b, c, d = 0;

        // 用户名最长为3-12位字符串
        let reg_username = /^\w{3,6}$/;
        if(! reg_username.test(username1)){
            $('#msgName').text('用户名需要3-6位字符！');
        }else{
            a = 1;
            $('#msgName').text('');
        }

        // 密码最长为6-12位字符串
        let reg_password = /^\w{6,12}$/;
        if(! reg_password.test(password1)){
            $('#msgPwd').text('密码需要6-12位字符！');
        }else{
            b = 1;
            $('#msgPwd').text('');
        }

        // 邮箱的验证
        let reg_email = /^[a-zA-Z0-9]+([-_.][A-Za-zd]+)*@([a-zA-Z0-9]+[-.])+[A-Za-zd]{2,5}$/;
        if(! reg_email.test(email)){
            $('#msgEmail').text('邮箱格式错误！')
        }else{
            c = 1;
            $('#msgEmail').text('');
        }

        // 手机号验证
        let reg_phone =  /^1[3456789]{1}\d{9}$/;
        if(! reg_phone.test(phone)){
            $('#msgPhone').text('手机号格式错误!');
        }else{
            d = 1;
            $('#msgPhone').text('');
        }
        if (a === 1 && b === 1 && c === 1 && d === 1){
            console.log(a,b,c,d);
            return 1;
        }else{
            return 0;
        }
    }
</script>
<script>
    // 滑动的状态
    let flag = true;
    let box = $(".pre-box");
    const mySwitch = () => {
        if (flag) {
            // 获取到滑动盒子的dom元素并修改它移动的位置
            box.css("transform", "translateX(100%)");
            // 获取到滑动盒子的dom元素并修改它的背景颜色
            box.css("background-color", "#c9e0ed");
            //修改图片的路径
            $("img").attr("src", "static/img/wuwu.jpeg");

        } else {
            box.css("transform", "translateX(0%)");
            box.css("background-color", "#edd4dc");
            $("img").attr("src", "static/img/waoku.jpg");
        }
        flag = !flag;
    };
</script>
</body>
</html>
