<%--
  Created by IntelliJ IDEA.
  User: 20698
  Date: 2022/12/13
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8"/>
    <title>首页</title>
    <!-- 引入CSS样式 -->
    <link rel="stylesheet" href="static/css/reset.css">
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
                    纯路人动漫
                    <!-- <img src="./img/logo.png" alt="纯路人动漫"> -->
                </a>
            </div>
            <!-- 创建导航栏 -->
            <div class="nav-bar">
                <ul class="navBar">
                    <li>
                        <a href="javascript:;">首页</a>
                    </li>
                    <li>
                        <a href="javascript:;">日本动漫</a>
                    </li>
                    <li>
                        <a href="javascript:;">国产动漫</a>
                    </li>
                    <li>
                        <a href="javascript:;">动漫电影</a>
                    </li>
                    <li>
                        <a href="./comic_info.html">动漫资讯</a>
                    </li>
                    <li>
                        <a href="javascript:;">欧美动漫</a>
                    </li>
                    <li>
                        <a href="javascript:;">专题</a>
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
                    <a href="login_choice.do">
                        <i class="iconfont icon-my-admin"></i>
                    </a>
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
        <div class="swiper">
            <div class="swiper-wrapper">
                <div class="swiper-slide">
                    <a href="javascript:;">
                        <img src="static/swiper_img/1.jpg" alt="">
                    </a>
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
                </div>
                <div class="swiper-slide">
                    <a href="javascript:;">
                        <img src="static/swiper_img/2.jpg" alt="">
                    </a>
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
                </div>
                <div class="swiper-slide">
                    <a href="javascript:;">
                        <img src="static/swiper_img/3.jpg" alt="">
                    </a>
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
                </div>
                <div class="swiper-slide">
                    <a href="javascript:;">
                        <img src="static/swiper_img/4.jpg" alt="">
                    </a>
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
                </div>
                <div class="swiper-slide">
                    <a href="javascript:;">
                        <img src="static/swiper_img/5.jpg" alt="">
                    </a>
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
                </div>
                <div class="swiper-slide">
                    <a href="javascript:;">
                        <img src="static/swiper_img/6.jpeg" alt="">
                    </a>
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
                </div>
                <div class="swiper-slide">
                    <a href="javascript:;">
                        <img src="static/swiper_img/7.jpg" alt="">
                    </a>
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
                </div>
                <div class="swiper-slide">
                    <a href="javascript:;">
                        <img src="static/swiper_img/8.jpg" alt="">
                    </a>
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
                </div>
                <div class="swiper-slide">
                    <a href="javascript:;">
                        <img src="static/swiper_img/9.jpg" alt="">
                    </a>
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
                </div>
                <div class="swiper-slide">
                    <a href="javascript:;">
                        <img src="static/swiper_img/10.jpg" alt="">
                    </a>
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
                </div>
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
            <div class="latestriben"></div>
            <!-- 最新国产动漫 -->
            <div class="latestguo"></div>
            <!-- 最新动漫电影 -->
            <div class="latestdian"></div>
            <!-- 榜单 -->
            <div class="rankList"></div>
            <!-- 最新动漫资讯 -->
            <div class="latestzi"></div>
        </div>
    </div>

</div>

<!-- 以下是写swiper轮播图 -->
<script src="./static/swiper/swiper-bundle.min.js"></script>
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
    })
</script>
</body>
</html>
