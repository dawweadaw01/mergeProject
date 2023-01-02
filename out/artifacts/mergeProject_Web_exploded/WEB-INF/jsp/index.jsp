<%@ page import="cdu.zch.service.ComicService" %>
<%@ page import="cdu.zch.service.impl.ComicServiceImpl" %>
<%@ page import="cdu.zch.model.Comic" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 20698
  Date: 2022/12/13
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8"/>
    <title>首页</title>
    <!-- 引入CSS样式 -->
    <%--    <link rel="stylesheet" href="static/css/reset.css">--%>
    <link rel="stylesheet" href="static/css/index.css">
    <!-- 引入图标iconfont -->
    <link rel="stylesheet" href="static/font/iconfont.css">
    <!-- 引入swiper插件 -->
    <link rel="stylesheet" href="static/swiper/swiper-bundle.min.css">
</head>
<body>
<!-- 创建最外层容器，表示总页面 -->
<div class="all-wrapper">
    <!-- 创建外层容器 -->
    <div class="out-wrapper">
        <!-- 创建导航栏容器 -->
        <div class="header-wrapper">
            <!-- 创建logo -->
            <div class="logo">
                <a href="javascript:;">
                    <i class="iconfont icon-icon-test"></i>
                    <span>纯路人动漫</span>
                    <!-- <img src="./img/logo.png" alt="纯路人动漫"> -->
                </a>
            </div>
            <!-- 创建导航栏 -->
            <div class="nav-bar">
                <ul class="navBar">
                    <li>
                        <a href="index.do">首页</a>
                    </li>
                    <li id="riben">
                        <a href="javascript:void(0);">日本动漫</a>
                    </li>
                    <li id="guo">
                        <a href="javascript:void(0);">国产动漫</a>
                    </li>
                    <li>
                        <a href="javascript:void(0);">动漫电影</a>
                    </li>
                    <li>
                        <a href="news/news.do">动漫资讯</a>
                    </li>
                    <li>
                        <a href="javascript:void(0);">欧美动漫</a>
                    </li>
                    <li>
                        <a href="javascript:void(0);">专题</a>
                    </li>
                </ul>
            </div>
            <!-- 创建右侧工具栏 -->
            <div class="tool-bar">
                <div class="feed">
                    <a href="javascript:;">
                        <i class="iconfont icon-feed"></i>
                    </a>
                </div>
                <div class="admin">
                    <c:if test="${empty user}">
                        <a href="login_choice.do">
                            <i class="iconfont icon-my-admin"></i>
                        </a>
                    </c:if>
                    <c:if test="${not empty user}">
                        <a href="user/user_self.do">
                            <i class="iconfont icon-my-admin"></i>
                        </a>
                    </c:if>
                </div>
            </div>
        </div>
        <!-- 创建搜索容器 -->
        <div class="search-wrapper">
            <!-- 创建搜索框 -->
            <div class="search-in">
                <i class="iconfont icon-search"></i>
                <input type="text" id="input" name="keywords" placeholder="请输入关键词">
            </div>
        </div>

        <!-- 创建轮播图容器 -->
        <%
            // 创建脚本获取动漫
            ComicService comicService = new ComicServiceImpl();
            List<Comic> comicList = comicService.getIndexComic();
            request.setAttribute("comicList", comicList);
        %>
        <div class="swiper">
            <div class="swiper-wrapper">
                <c:forEach items="${comicList}" var="comic">
                    <div class="swiper-slide">
                        <a href="comic/detail?id=${comic.id}">
                            <img src="${comic.cover}" alt="">
                        </a>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            ${comic.remark}
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            ${comic.comicName}
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            ${comic.description}
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!-- 创建主容器 -->
        <div class="main-wrapper">
            <!-- 最新更新 -->
            <div class="latest">
                <div class="title">
                    <i class="iconfont icon-video"></i>
                    <span>最新更新</span>
                </div>
                <!-- 图片 -->
                <ul class="list">
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/1.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/2.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/3.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/4.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/5.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                </ul>
            </div>
            <!-- 最新日本动漫 -->
            <div class="latestriben" id="latestriben">
                <div class="title">
                    <i class="iconfont icon-video"></i>
                    <span>最新日本动漫</span>
                </div>
                <!-- 图片 -->
                <ul class="list">
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/1.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/2.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/3.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/4.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/5.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                </ul>
            </div>
            <!-- 最新国产动漫 -->
            <div class="latestguo" id="latestguo">
                <div class="title">
                    <i class="iconfont icon-video"></i>
                    <span>最新国产动漫</span>
                </div>
                <!-- 图片 -->
                <ul class="list">
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/1.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/2.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/3.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/4.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/5.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                </ul>
            </div>
            <!-- 最新动漫电影 -->
            <div class="latestdian" id="latestdian">
                <div class="title">
                    <i class="iconfont icon-video"></i>
                    <span>最新动漫电影</span>
                </div>
                <!-- 图片 -->
                <ul class="list">
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/1.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/2.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/3.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/4.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/5.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                </ul>
            </div>
            <!-- 欧美动漫 -->
            <div class="oumeicomic" id="oumeicomic">
                <div class="title">
                    <i class="iconfont icon-video"></i>
                    <span>欧美动漫</span>
                </div>
                <!-- 图片 -->
                <ul class="list">
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/1.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/2.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/3.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/4.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                    <li>
                        <!-- 封面列表 -->
                        <div class="imgList">
                            <a href="javascript:;">
                                <img src="static/swiper_img/5.jpg" alt="">
                            </a>
                        </div>
                        <!-- 设置图片下方内容 -->
                        <!-- 备注（更新至第几集) -->
                        <div class="remark">
                            更新至1065话
                        </div>
                        <!-- 动漫名字 -->
                        <div class="comicName">
                            海贼王
                        </div>
                        <!-- 动漫简介 -->
                        <div class="description">
                            这是一部很好看的动漫
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>

</div>

<!-- 创建侧边悬浮栏 -->
<div class="flyBar">
    <a href="#">
        <i class="iconfont icon-huojian"></i>
    </a>
</div>

<!-- 创建页脚 -->
<div class="footer">
    <!-- 友情链接 -->
    <ul class="furl">
        <li><a href="https://www.bilibili.com">B站</a></li>
        <li><a href="https://www.baidu.com">百度</a></li>
        <li><a href="http://www.google.cn/">谷歌</a></li>
        <li><a href="https://twitter.com">推特</a></li>
        <li><a href="https://www.youtube.com">Youtube</a></li>
    </ul>
    <!-- 额外信息 -->
    <div class="extrInfo">
            <span>本站所有视频和图片均来自互联网收集而来，本网站只提供web页面服务，并不提供资源存储，也不参与录制、上传<br/>
                若本站收录的节目无意侵犯了贵司版权，请发邮件至chunluren@qq.com （我们会在3个工作日内删除侵权内容，谢谢。）</span>
    </div>
    <!-- 收尾 -->
    <div class="end">
        <span>Copyright © 2022 纯路人动漫</span>
    </div>
</div>

<!-- 以下是写swiper轮播图 -->
<script src="static/swiper/swiper-bundle.min.js"></script>
<script src="static/jquery-3.5.1/jquery-3.5.1.js"></script>
<%--这个是轮播图的js--%>
<script>
    var mySwiper = new Swiper('.swiper', {
        loop: true, // 循环模式选项

        // 设置播放间隔时间
        autoplay: {
            delay: 2000,//1秒切换一次
        },
        // 设置轮换样式，grid布局
        slidesPerView: 6,
        grid: {
            fill: 'column',
            rows: 1,
        },
    });

    $(document).ready(function () {
        //首先将#back-to-top隐藏
        $(".flyBar").hide();
        //当滚动条的位置处于距顶部400像素以下时，跳转链接出现，否则消失
        $(function () {
            $(window).scroll(function () {
                if ($(window).scrollTop() > 400) {
                    $(".flyBar").fadeIn(500);
                } else {
                    $(".flyBar").fadeOut(500);
                }
            });
            //当点击跳转链接后，回到页面顶部位置
            $(".flyBar").click(function () {
                $('body,html').animate({ scrollTop: 0 }, 500);
                return false;
            });
        });
    });

    // 搜索框
    $('.icon-search').click(function (){
        $.ajax({
            url: '/comic/search',
            type: 'post',
            data: {
                'keywords': $('#input').val(),
            },
            dataType: 'json',
            success: function (res){
                if(res !== null){
                    // location.href = 'comic/comic_search.do';
                    // console.log(res);
                    $('.swiper').hide();
                    $('.main-wrapper').hide();

                    // 渲染搜索结果
                    let all = $('<div class="all"><div>');
                    $.each(res, function (index, value){
                        let div1 = $('<div class="slide"></div>');
                        let a = $('<a href="comic/detail?id=' + value.id + '"></a>');
                        let img = $('<img src=' + value.cover + ' alt="">');
                        let div2 = $('<div class="remark">' + value.remark + '</div>');
                        let div3 = $('<div class="comicName">' + value.comicName + '</div>');
                        let div4 = $('<div class="description">' + value.description + '</div>');
                        a.append(img);
                        div1.append(a);
                        div1.append(div2);
                        div1.append(div3);
                        div1.append(div4);
                        all.append(div1);
                    });
                    $('.out-wrapper').append(all);
                }
            }
        });
    });

    // 点击国产动漫
    $('#guo').click(function (){
        $.ajax({
            url: '/list',
            type: 'get',
            data: {
                'region': '大陆',
            },
            dataType: 'json',
            success: function (res){
                // console.log(res);

                $('.swiper').hide();
                $('.main-wrapper').hide();

                // 渲染搜索结果
                let all = $('<div class="all"><div>');
                $.each(res, function (index, value){
                    let div1 = $('<div class="slide"></div>');
                    let a = $('<a href="comic/detail?id=' + value.id + '"></a>');
                    let img = $('<img src=' + value.cover + ' alt="">');
                    let div2 = $('<div class="remark">' + value.remark + '</div>');
                    let div3 = $('<div class="comicName">' + value.comicName + '</div>');
                    let div4 = $('<div class="description">' + value.description + '</div>');
                    a.append(img);
                    div1.append(a);
                    div1.append(div2);
                    div1.append(div3);
                    div1.append(div4);
                    all.append(div1);
                });
                $('.out-wrapper').append(all);
            }
        });
    });
    // 点击日本动漫
    $('#riben').click(function (){
        $.ajax({
            url: '/list',
            type: 'get',
            data: {
                'region': '日本',
            },
            dataType: 'json',
            success: function (res){
                // console.log(res);

                $('.swiper').hide();
                $('.main-wrapper').hide();

                // 渲染搜索结果
                let all = $('<div class="all"><div>');
                $.each(res, function (index, value){
                    let div1 = $('<div class="slide"></div>');
                    let a = $('<a href="comic/detail?id=' + value.id + '"></a>');
                    let img = $('<img src=' + value.cover + ' alt="">');
                    let div2 = $('<div class="remark">' + value.remark + '</div>');
                    let div3 = $('<div class="comicName">' + value.comicName + '</div>');
                    let div4 = $('<div class="description">' + value.description + '</div>');
                    a.append(img);
                    div1.append(a);
                    div1.append(div2);
                    div1.append(div3);
                    div1.append(div4);
                    all.append(div1);
                });
                $('.out-wrapper').append(all);
            }
        });
    });
</script>

</body>
</html>
