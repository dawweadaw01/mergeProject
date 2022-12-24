<%--
  Created by IntelliJ IDEA.
  User: 20698
  Date: 2022/12/23
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%--                <li>--%>
<%--                    <!-- 资讯体的左侧内容 -->--%>
<%--                    <div class="left-info">--%>
<%--                        <!-- 标题 -->--%>
<%--                        <h4 class="info-title"><a href="javascript:;">我是标题</a></h4>--%>
<%--                        <!-- 简介 -->--%>
<%--                        <p class="info-desc">我是简介</p>--%>
<%--                        <!-- 其他信息 -->--%>
<%--                        <p class="info-etc">动漫资讯 | 2022-12-31</p>--%>
<%--                    </div>--%>
<%--                    <!-- 资讯体的右侧图片 -->--%>
<%--                    <div class="right-info">--%>
<%--                        <a href="javascript:;">我是右侧图片</a>--%>
<%--                    </div>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <!-- 资讯体的左侧内容 -->--%>
<%--                    <div class="left-info">--%>
<%--                        <!-- 标题 -->--%>
<%--                        <h4 class="info-title"><a href="javascript:;">我是标题</a></h4>--%>
<%--                        <!-- 简介 -->--%>
<%--                        <p class="info-desc">我是简介</p>--%>
<%--                        <!-- 其他信息 -->--%>
<%--                        <p class="info-etc">动漫资讯 | 2022-12-31</p>--%>
<%--                    </div>--%>
<%--                    <!-- 资讯体的右侧图片 -->--%>
<%--                    <div class="right-info">--%>
<%--                        <a href="javascript:;">我是右侧图片</a>--%>
<%--                    </div>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <!-- 资讯体的左侧内容 -->--%>
<%--                    <div class="left-info">--%>
<%--                        <!-- 标题 -->--%>
<%--                        <h4 class="info-title"><a href="javascript:;">我是标题</a></h4>--%>
<%--                        <!-- 简介 -->--%>
<%--                        <p class="info-desc">我是简介</p>--%>
<%--                        <!-- 其他信息 -->--%>
<%--                        <p class="info-etc">动漫资讯 | 2022-12-31</p>--%>
<%--                    </div>--%>
<%--                    <!-- 资讯体的右侧图片 -->--%>
<%--                    <div class="right-info">--%>
<%--                        <a href="javascript:;">--%>
<%--                            <img src="" alt="">--%>
<%--                        </a>--%>
<%--                    </div>--%>
<%--                </li>--%>
            </ul>
        </div>
    </div>
<%--    设置一个写资讯的地方--%>
    <div class="zixun">
        <form action="" id="form">
            写下文章标题：<input type="text" name="title" placeholder="请输入标题"><br>
            <input type="text" name="author" value="${user.userName}" style="display: none;"><br>
            注明来源：
            <select name="source">
                <option value="动漫">动漫</option>
                <option value="电影">电影</option>
                <option value="漫画">漫画</option>
                <option value="网络">网络</option>
            </select><br>
            写上文章内容：<textarea name="textContent" id="" cols="30" rows="10"></textarea><br>
            上传封面：<input type="file" name="imgCover"><br>
            <button type="button" id="release">发布（您需要登录之后才可以发布哦！）</button>
        </form>
    </div>
</div>

<!-- 以下是写swiper轮播图 -->
<script src="static/swiper/swiper-bundle.min.js"></script>
<script src="static/jquery-3.5.1/jquery-3.5.1.js"></script>
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
<script>
    // 渲染页面
    $.ajax({
        url: '/news/latest',
        type: 'get',
        data: {},
        dataType: 'json',
        success: function (res){
            console.log(res);
            // 渲染数据
            $.each(res.newsList, function (index, value){
                let li = $('<li></li>');
                let div1 = $('<div class="left-info"></div>');
                let h4 = $('<h4 class="info-title"></h4>');
                let a1 = $('<a href="javascript:;">' + value.title + '</a>');
                let p1 = $('<p class="info-desc">' + value.textContent + '</p>');
                let p2 = $('<p class="info-etc">' + value.source + ' | ' +  value.creatTime + '</p>');
                let div2 = $('<div class="right-info"></div>');
                let a2 = $('<a href="javascript:;"></a>');
                let img = $('<img src=' + value.imgCover + ' alt="">')
                h4.append(a1);
                a2.append(img);
                div2.append(a2);
                div1.append(h4);
                div1.append(p1);
                div1.append(p2);
                li.append(div1);
                li.append(div2);
                $('.info-list').append(li);
            });
        }
    });

    // 发布资讯
    $('#release').click(function (){
       <c:if test="${empty user}">
           alert("您还未登录请您先登录！");
       </c:if>
        <c:if test="${not empty user}">
            let formData = new FormData($('#form')[0]);
            $.ajax({
                url: '/news/add',
                type: 'post',
                data: formData,
                contentType: false, // 提交给服务端的数据类型，不要当成字符串处理
                processData: false, // 通过请求发送的数据是否转换为查询字符串
                success: function (res){
                    if(res === "true"){
                        alert("发布成功，请刷新查看！");
                    }else{
                        alert("发布失败！");
                        location.reload();
                    }
                }
            });
        </c:if>
    });
</script>
</body>
</html>
