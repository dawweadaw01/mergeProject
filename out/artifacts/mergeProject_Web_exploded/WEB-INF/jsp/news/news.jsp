<%--
  Created by IntelliJ IDEA.
  User: 20698
  Date: 2022/12/23
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <title>资讯</title>
    <link rel="stylesheet" href="static/css/news.css">
    <!-- 引入swiper插件 -->
    <link rel="stylesheet" href="static/swiper/swiper-bundle.min.css">
</head>
<body>
<!-- 创建一个大容器 -->
<div class="all-wrapper">
    <!-- 创建一个轮播图 -->
    <div class="swiper">
        <div class="swiper-wrapper">
            <div class="swiper-slide">
                <a href="javascript:;">
                    <img src="static/swiper_img/1.jpg" alt="">
                </a>
            </div>
            <div class="swiper-slide">
                <a href="javascript:;">
                    <img src="static/swiper_img/2.jpg" alt="">
                </a>
            </div>
            <div class="swiper-slide">
                <a href="javascript:;">
                    <img src="static/swiper_img/3.jpg" alt="">
                </a>
            </div>
            <div class="swiper-slide">
                <a href="javascript:;">
                    <img src="static/swiper_img/4.jpg" alt="">
                </a>
            </div>
            <div class="swiper-slide">
                <a href="javascript:;">
                    <img src="static/swiper_img/5.jpg" alt="">
                </a>
            </div>
        </div>
    </div>
    <!-- 创建一个资讯内容容器 -->
    <div class="info-wrapper">
        <div class="header">
            <span>最新动漫资讯</span>
        </div>
        <!-- 创建资讯容器 -->
        <div class="info">
            <!-- 创建资讯列表 -->
            <ul class="info-list">
                <!-- 创建各个资讯体 -->
                <li>
                    <!-- 资讯体的左侧内容 -->
                    <div class="left-info">
                        <!-- 标题 -->
                        <h4 class="info-title"><a href="javascript:;">我是标题</a></h4>
                        <!-- 简介 -->
                        <p class="info-desc">我是简介</p>
                        <!-- 其他信息 -->
                        <p class="info-etc">动漫资讯 | 2022-12-31</p>
                    </div>
                    <!-- 资讯体的右侧图片 -->
                    <div class="right-info">
                        <a href="javascript:;">我是右侧图片</a>
                    </div>
                </li>
                <li>
                    <!-- 资讯体的左侧内容 -->
                    <div class="left-info">
                        <!-- 标题 -->
                        <h4 class="info-title"><a href="javascript:;">我是标题</a></h4>
                        <!-- 简介 -->
                        <p class="info-desc">我是简介</p>
                        <!-- 其他信息 -->
                        <p class="info-etc">动漫资讯 | 2022-12-31</p>
                    </div>
                    <!-- 资讯体的右侧图片 -->
                    <div class="right-info">
                        <a href="javascript:;">我是右侧图片</a>
                    </div>
                </li>
                <li>
                    <!-- 资讯体的左侧内容 -->
                    <div class="left-info">
                        <!-- 标题 -->
                        <h4 class="info-title"><a href="javascript:;">我是标题</a></h4>
                        <!-- 简介 -->
                        <p class="info-desc">我是简介</p>
                        <!-- 其他信息 -->
                        <p class="info-etc">动漫资讯 | 2022-12-31</p>
                    </div>
                    <!-- 资讯体的右侧图片 -->
                    <div class="right-info">
                        <a href="javascript:;">我是右侧图片</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>

<!-- 以下是写swiper轮播图 -->
<script src="static/swiper/swiper-bundle.min.js"></script>
<script>
    var mySwiper = new Swiper('.swiper', {
        loop: true, // 循环模式选项

        // 设置播放间隔时间
        autoplay: {
            delay: 2000,//1秒切换一次
        },
        // 设置轮换样式，grid布局
        slidesPerView: 4,
        grid: {
            fill: 'column',
            rows: 1,
        },
    })
</script>
</body>
</html>
