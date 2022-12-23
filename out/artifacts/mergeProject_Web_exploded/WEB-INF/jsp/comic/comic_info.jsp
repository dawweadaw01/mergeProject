<%--
  Created by IntelliJ IDEA.
  User: 20698
  Date: 2022/12/13
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8"/>
    <title>资讯</title>
    <link rel="stylesheet" href="static/css/comic_info.css">
</head>
<body>
<!-- 设置一个大的容器 -->
<div class="container">
    <!-- 上半部分详情 -->
    <div class="top-bar">
        <!-- 图片部分 -->
        <div class="cover">
            <img src="./swiper_img/1.jpg" alt="封面">
            <div class="remark">
                <span>更新至1045话</span>
            </div>
        </div>
        <!-- 详情部分 -->
        <div class="info">
            <!-- 标题 -->
            <div class="comicName">
                <span>海贼王</span>
            </div>
            <!-- 人气 -->
            <div class="score">
                <span>评分：</span>
                <span>五星好评</span>
            </div>
            <!-- 别名 -->
            <div class="nickname">
                <span>别名：</span>
                <span>One Piece</span>
            </div>
            <!-- 标签 -->
            <div class="label">
                <span>标签：</span>
                <span>热血；搞笑；励志</span>
            </div>
            <!-- 地区 -->
            <div class="region">
                <span>地区：</span>
                <span>日本</span>
            </div>
            <!-- 年份 -->
            <div class="year">
                <span>年份：</span>
                <span>1999</span>
            </div>
            <!-- 更新 -->
            <div class="updateTime">
                <span>更新：</span>
                <span>2022-12-18</span>
            </div>
            <!-- 简介 -->
            <div class="description">
                <span>简介：</span>
                <span>这是一部很好看的动漫</span>
            </div>
            <!-- 立即播放 -->
            <div class="start">
                <button>立即播放</button>
            </div>
            <!-- 下载APP -->
            <div class="download">
                <button>下载APP</button>
            </div>
        </div>
    </div>
    <!-- 下方容器 -->
    <div class="footer-bar">
        <!-- 左边评论 -->
        <div class="left">
            <!-- 大标题 -->
            <div class="title">
                <span>最新评论</span>
            </div>
            <!-- 文本框 -->
            <textarea name="comment" id="comment" cols="30" rows="10">请输入评论内容</textarea>
            <!-- 功能框 -->
            <div class="tool">
                <button id="send" type="button">发送评论</button>
            </div>
            <!-- 用户评论列表 -->
            <div class="user">
                <div class="userTitle">
                    <span>用户评论</span>
                </div>
                <div class="total">
                    <span>共66条评论</span>
                </div>
                <div class="userComment">
                    <div class="comment">
                        <!-- 头像 -->
                        <div class="avatar">
                            <img src="img/logo.png" alt="头像">
                        </div>
                        <!-- 名字 -->
                        <div class="userName">
                            <span>迷失的🐏</span>
                        </div>
                        <!-- 评论时间 -->
                        <div class="Ctime">
                            <span>2022-12-18 10:12:30</span>
                        </div>
                        <!-- 评论内容 -->
                        <div class="Ctxt">
                            <span>这也太好看了吧！</span>
                        </div>
                        <!-- 是否回复 -->
                        <div class="reply">
                            <span><a href="#">回复</a></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 右边榜单 -->
        <div class="right">
            <!-- 大标题 -->
            <div class="bTitle">
                <span>日本热播动漫</span>
            </div>
            <!-- 排名 -->
            <ul class="sort">
                <li>
                    <a href="#">海贼王</a>
                </li>
                <li>
                    <a href="#">海贼王</a>
                </li>
                <li>
                    <a href="#">海贼王</a>
                </li>
                <li>
                    <a href="#">海贼王</a>
                </li>
                <li>
                    <a href="#">海贼王</a>
                </li>
                <li>
                    <a href="#">海贼王</a>
                </li>
                <li>
                    <a href="#">海贼王</a>
                </li>
                <li>
                    <a href="#">海贼王</a>
                </li>
                <li>
                    <a href="#">海贼王</a>
                </li>
                <li>
                    <a href="#">海贼王</a>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
