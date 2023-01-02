<%--
  Created by IntelliJ IDEA.
  User: 20698
  Date: 2022/12/23
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="myfn" uri="http://cdu/functions" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <title>个人信息页面</title>
    <link rel="stylesheet" href="static/css/user_self.css">
    <link rel="stylesheet" href="static/bootstrap-3.4.1-dist/css/bootstrap.css">
</head>
<body>
<!-- 创建一个大容器 -->
<div class="all-wrapper">
    <!-- 左侧导航栏 -->
    <div class="left-nav">
        <!-- 头像 -->
        <div class="avatar">
            <img src="${user.avatar}" alt="头像" id="" class="avatar_img">
        </div>
        <!-- 头像下的文字 -->
        <div class="user_name">
            <span>${user.userName}</span>
        </div>
        <!-- 下方导航栏 -->
        <ul class="list-nav">
            <li class="" id="sc">
                <a href="javascript:;">收藏动漫</a>
            </li>
            <li class="" id="ls">
                <a href="javascript:;">历史观看</a>
            </li>
            <li class="">
                <a href="javascript:;">个人资料</a>
            </li>
            <li class="">
                <a href="user/logout">退出登录</a>
            </li>
        </ul>
    </div>
    <!-- 右侧内容区 -->
    <div class="right-nav">
        <div class="big" style="display: none;">
            <!-- 内容区 -->
            <div class="content">
                <!-- 图片 -->
                <ul class="list" id="shoucang">
<%--                    <li>--%>
<%--                        <!-- 封面列表 -->--%>
<%--                        <div class="imgList">--%>
<%--                            <a href="javascript:;">--%>
<%--                                <img src="static/swiper_img/1.jpg" alt="">--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                        <!-- 设置图片下方内容 -->--%>
<%--                        <!-- 备注（更新至第几集) -->--%>
<%--                        <div class="remark">--%>
<%--                            更新至1065话--%>
<%--                        </div>--%>
<%--                        <!-- 动漫名字 -->--%>
<%--                        <div class="comicName">--%>
<%--                            海贼王--%>
<%--                        </div>--%>
<%--                        <!-- 动漫简介 -->--%>
<%--                        <div class="description">--%>
<%--                            这是一部很好看的动漫--%>
<%--                        </div>--%>
<%--                    </li>--%>
<%--                    <li>--%>
<%--                        <!-- 封面列表 -->--%>
<%--                        <div class="imgList">--%>
<%--                            <a href="javascript:;">--%>
<%--                                <img src="static/swiper_img/2.jpg" alt="">--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                        <!-- 设置图片下方内容 -->--%>
<%--                        <!-- 备注（更新至第几集) -->--%>
<%--                        <div class="remark">--%>
<%--                            更新至1065话--%>
<%--                        </div>--%>
<%--                        <!-- 动漫名字 -->--%>
<%--                        <div class="comicName">--%>
<%--                            海贼王--%>
<%--                        </div>--%>
<%--                        <!-- 动漫简介 -->--%>
<%--                        <div class="description">--%>
<%--                            这是一部很好看的动漫--%>
<%--                        </div>--%>
<%--                    </li>--%>
<%--                    <li>--%>
<%--                        <!-- 封面列表 -->--%>
<%--                        <div class="imgList">--%>
<%--                            <a href="javascript:;">--%>
<%--                                <img src="static/swiper_img/3.jpg" alt="">--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                        <!-- 设置图片下方内容 -->--%>
<%--                        <!-- 备注（更新至第几集) -->--%>
<%--                        <div class="remark">--%>
<%--                            更新至1065话--%>
<%--                        </div>--%>
<%--                        <!-- 动漫名字 -->--%>
<%--                        <div class="comicName">--%>
<%--                            海贼王--%>
<%--                        </div>--%>
<%--                        <!-- 动漫简介 -->--%>
<%--                        <div class="description">--%>
<%--                            这是一部很好看的动漫--%>
<%--                        </div>--%>
<%--                    </li>--%>
<%--                    <li>--%>
<%--                        <!-- 封面列表 -->--%>
<%--                        <div class="imgList">--%>
<%--                            <a href="javascript:;">--%>
<%--                                <img src="static/swiper_img/4.jpg" alt="">--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                        <!-- 设置图片下方内容 -->--%>
<%--                        <!-- 备注（更新至第几集) -->--%>
<%--                        <div class="remark">--%>
<%--                            更新至1065话--%>
<%--                        </div>--%>
<%--                        <!-- 动漫名字 -->--%>
<%--                        <div class="comicName">--%>
<%--                            海贼王--%>
<%--                        </div>--%>
<%--                        <!-- 动漫简介 -->--%>
<%--                        <div class="description">--%>
<%--                            这是一部很好看的动漫--%>
<%--                        </div>--%>
<%--                    </li>--%>
                </ul>
            </div>
        </div>
        <div class="big" style="display: none;">
            <div class="content">
                <!-- 图片 -->
                <ul class="list" id="lishi">
<%--                    <li>--%>
<%--                        <!-- 封面列表 -->--%>
<%--                        <div class="imgList">--%>
<%--                            <a href="javascript:;">--%>
<%--                                <img src="static/swiper_img/1.jpg" alt="">--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                        <!-- 设置图片下方内容 -->--%>
<%--                        <!-- 备注（更新至第几集) -->--%>
<%--                        <div class="remark">--%>
<%--                            更新至1065话--%>
<%--                        </div>--%>
<%--                        <!-- 动漫名字 -->--%>
<%--                        <div class="comicName">--%>
<%--                            海贼王--%>
<%--                        </div>--%>
<%--                        <!-- 动漫简介 -->--%>
<%--                        <div class="description">--%>
<%--                            这是一部很好看的动漫--%>
<%--                        </div>--%>
<%--                    </li>--%>
<%--                    <li>--%>
<%--                        <!-- 封面列表 -->--%>
<%--                        <div class="imgList">--%>
<%--                            <a href="javascript:;">--%>
<%--                                <img src="static/swiper_img/2.jpg" alt="">--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                        <!-- 设置图片下方内容 -->--%>
<%--                        <!-- 备注（更新至第几集) -->--%>
<%--                        <div class="remark">--%>
<%--                            更新至1065话--%>
<%--                        </div>--%>
<%--                        <!-- 动漫名字 -->--%>
<%--                        <div class="comicName">--%>
<%--                            海贼王--%>
<%--                        </div>--%>
<%--                        <!-- 动漫简介 -->--%>
<%--                        <div class="description">--%>
<%--                            这是一部很好看的动漫--%>
<%--                        </div>--%>
<%--                    </li>--%>
<%--                    <li>--%>
<%--                        <!-- 封面列表 -->--%>
<%--                        <div class="imgList">--%>
<%--                            <a href="javascript:;">--%>
<%--                                <img src="static/swiper_img/3.jpg" alt="">--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                        <!-- 设置图片下方内容 -->--%>
<%--                        <!-- 备注（更新至第几集) -->--%>
<%--                        <div class="remark">--%>
<%--                            更新至1065话--%>
<%--                        </div>--%>
<%--                        <!-- 动漫名字 -->--%>
<%--                        <div class="comicName">--%>
<%--                            海贼王--%>
<%--                        </div>--%>
<%--                        <!-- 动漫简介 -->--%>
<%--                        <div class="description">--%>
<%--                            这是一部很好看的动漫--%>
<%--                        </div>--%>
<%--                    </li>--%>
<%--                    <li>--%>
<%--                        <!-- 封面列表 -->--%>
<%--                        <div class="imgList">--%>
<%--                            <a href="javascript:;">--%>
<%--                                <img src="static/swiper_img/4.jpg" alt="">--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                        <!-- 设置图片下方内容 -->--%>
<%--                        <!-- 备注（更新至第几集) -->--%>
<%--                        <div class="remark">--%>
<%--                            更新至1065话--%>
<%--                        </div>--%>
<%--                        <!-- 动漫名字 -->--%>
<%--                        <div class="comicName">--%>
<%--                            海贼王--%>
<%--                        </div>--%>
<%--                        <!-- 动漫简介 -->--%>
<%--                        <div class="description">--%>
<%--                            这是一部很好看的动漫--%>
<%--                        </div>--%>
<%--                    </li>--%>
                </ul>
            </div>
        </div>
        <div class="big" style="display: none;">
            <div class="content">
                <form action="" id="form">
                    <div class="form-group" style="visibility: hidden;">
                        <label for="id">编号</label>
                        <input type="text" class="form-control" id="id" placeholder=""
                               name="id" value="${user.id}">
                    </div>
                    <div class="form-group">
                        <label for="username">用户名</label>
                        <input type="text" class="form-control" id="username" placeholder=""
                               name="username" value="${user.userName}">
                    </div>
                    <div class="form-group">
                        <label for="password">密码</label>
                        <input type="password" class="form-control" id="password" placeholder=""
                               name="password" value="${user.password}">
                    </div>
                    <div class="form-group">
                        <label for="avatar">头像</label>
                        <input type="file" id="avatar" name="avatar">
                    </div>
                    <div class="form-group">
                        <label for="email">邮箱</label>
                        <input type="email" class="form-control" id="email" placeholder=""
                               name="email" value="${user.email}">
                    </div>
                    <br/>
                    <div class="form-group">
                        <label for="phone">手机号</label>
                        <input type="text" class="form-control" id="phone" placeholder=""
                               name="phone" value="${user.phone}">
                    </div>
                    <div class="form-group">
                        <label for="createTime">创建时间</label>
                        <input type="text" class="form-control" id="createTime" placeholder=""
                               name="createTime" value="${myfn:formatDate(user.createTime)}">
                    </div>
                    <button type="button" class="btn btn-success" id="edit">修改</button>
                </form>

            </div>
        </div>
    </div>
</div>

<script src="static/jquery-3.5.1/jquery-3.5.1.js"></script>
<!-- 设置点击事件，点击哪个div就出现相应的页面 -->
<script>
    $('.list-nav li:nth-child(1)').click(function (){
        $('.right-nav .big:nth-child(3)').hide();
        $('.right-nav .big:nth-child(2)').hide();
        $('.right-nav .big:nth-child(1)').show();
    });
    $('.list-nav li:nth-child(2)').click(function (){
        $('.right-nav .big:nth-child(3)').hide();
        $('.right-nav .big:nth-child(1)').hide();
        $('.right-nav .big:nth-child(2)').show();
    });
    $('.list-nav li:nth-child(3)').click(function (){
        $('.right-nav .big:nth-child(2)').hide();
        $('.right-nav .big:nth-child(1)').hide();
        $('.right-nav .big:nth-child(3)').show();
    });

    // 循环渲染 “收藏”
    $('#sc').click(function (){
        $('#lishi').empty();
        <c:if test="${not empty user.collection}">
        <c:forEach items="${user.collection}" var="collection">
        $.ajax({
            url: '/comic/findById',
            type: 'get',
            data: {
                'id': ${collection},
            },
            dataType: 'json', // 当作json而不是字符串处理
            success: function (res) {
                // console.log(res);
                // console.log(typeof res);
                // 下面的操作是为了生成相应的html渲染进页面
                let li = $('<li></li>');
                let div1 = $('<div class="imgList"></div>');
                let a = $('<a href="javascript:;"></a>');
                let img = $('<img src=' + res.cover + ' alt="">');
                let div2 = $('<div class="remark">' + res.remark + '</div>');
                let div3 = $('<div class="comicName">' + res.comicName + '</div>');
                let div4 = $('<div class="description">' + res.description + '</div>');
                a.append(img);
                div1.append(a);
                li.append(div1);
                li.append(div2);
                li.append(div3);
                li.append(div4);
                $('ul#shoucang').append(li);
            }
        });
        </c:forEach>
        </c:if>
    });

    // 循环渲染 “历史”
    $('#ls').click(function (){
        $('#shoucang').empty();
        <c:if test="${not empty user.history}">
        <c:forEach items="${user.history}" var="history">
        $.ajax({
            url: '/comic/findById',
            type: 'get',
            data: {
                'id': ${history},
            },
            dataType: 'json', // 当作json而不是字符串处理
            success: function (res) {
                // console.log(res);
                // console.log(typeof res);
                // 下面的操作是为了生成相应的html渲染进页面
                let li = $('<li></li>');
                let div1 = $('<div class="imgList"></div>');
                let a = $('<a href="javascript:;"></a>');
                let img = $('<img src=' + res.cover + ' alt="">');
                let div2 = $('<div class="remark">' + res.remark + '</div>');
                let div3 = $('<div class="comicName">' + res.comicName + '</div>');
                let div4 = $('<div class="description">' + res.description + '</div>');
                a.append(img);
                div1.append(a);
                li.append(div1);
                li.append(div2);
                li.append(div3);
                li.append(div4);
                $('ul#lishi').append(li);
            }
        });
        </c:forEach>
        </c:if>
    });

    // 当点击修改时触发
    $('#edit').click(function (){
        let formData = new FormData($('#form')[0]);
        console.log(formData);
        $.ajax({
            url: 'update',
            type: 'post',
            data: formData,
            contentType: false, // 提交给服务端的数据类型，不要当成字符串处理
            processData: false, // 通过请求发送的数据是否转换为查询字符串
            success: function (res) {
                // console.log(res);
                if (res === 'true') {
                    alert("您修改了账户信息，请重新登录！");
                    location.href = 'user_login.do';
                } else {
                    alert('修改失败！请刷新来过');
                }
            }
        });
    });
</script>
</body>
</html>
