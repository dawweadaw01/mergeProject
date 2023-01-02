<%--
  Created by IntelliJ IDEA.
  User: 20698
  Date: 2022/12/13
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8"/>
    <title>详情</title>
    <link rel="stylesheet" href="static/css/comic_info.css">
    <link rel="stylesheet" href="static/bootstrap-3.4.1-dist/css/bootstrap.css">
</head>
<body>
<!-- 设置一个大的容器 -->
<div class="container">
    <!-- 上半部分详情 -->
    <div class="top-bar">
        <!-- 图片部分 -->
        <div class="cover">
            <img src="${comic.cover}" alt="封面">
            <div class="remark">
                <span>${comic.remark}</span>
            </div>
        </div>
        <!-- 详情部分 -->
        <div class="info">
            <!-- 标题 -->
            <div class="comicName">
                <span>${comic.comicName}</span>
            </div>
            <!-- 人气 -->
            <div class="score">
                <span>评分：</span>
                <span>${comic.popularity}</span>
            </div>
            <!-- 别名 -->
            <div class="nickname">
                <span>别名：</span>
                <span>${comic.nickname}</span>
            </div>
            <!-- 标签 -->
            <div class="label1">
                <span>标签：</span>
                <span>${comic.label}</span>
            </div>
            <!-- 地区 -->
            <div class="region">
                <span>地区：</span>
                <span>${comic.region}</span>
            </div>
            <!-- 年份 -->
            <div class="year">
                <span>年份：</span>
                <span>${comic.year}</span>
            </div>
            <!-- 更新 -->
            <div class="updateTime">
                <span>更新：</span>
                <span>${comic.updateTime}</span>
            </div>
            <!-- 简介 -->
            <div class="description">
                <span>简介：</span>
                <span>${comic.description}</span>
            </div>
            <!-- 立即播放 -->
            <div class="start">
                <button type="button" class="btn btn-success">立即播放</button>
            </div>
            <!-- 下载APP -->
            <div class="download">
                <button type="button" class="btn btn-success">下载APP</button>
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
            <textarea name="comment" id="comment" cols="30" rows="10"></textarea>
            <!-- 功能框 -->
            <div class="tool">
                <button id="send" type="button" class="btn btn-info">发送评论</button>
            </div>
            <!-- 用户评论列表 -->
            <div class="user">
                <div class="userTitle">
                    <span>用户评论</span>
                </div>
                <div class="userComment">
                    <c:forEach items="${commentList}" var="comment">
                        <c:if test="${not empty comment.reviewerTo}">
                            <div class="comment2">
                                <!-- 头像 -->
                                <div class="avatar">
                                    <img src="${comment.reviewer.avatar}" alt="头像">
                                </div>
                                <!-- 名字 -->
                                <div class="userName">
                                    <span>${comment.reviewer.userName}</span>
                                </div>
                                <!-- 评论时间 -->
                                <div class="Ctime">
                                    <span>${comment.time}</span>
                                </div>
                                <!-- 评论内容 -->
                                <div class="Ctxt">
                                    <span>${comment.comment}</span>
                                </div>
                                <!-- 设置回复人 -->
                                <div class="replyTo">
                                    <span>回复：${comment.reviewerTo.userName}</span>
                                </div>
                                <!-- 是否回复 -->
                                <div class="reply">
                                    <span>
                                        <button type="button" class="btn btn-info btn-sm back"
                                                id="${comment.reviewer.id}">
                                            回复
                                        </button>
                                    </span>
                                </div>
                                <!-- 是否删除  -->
                                <c:if test="${user.userName == comment.reviewer.userName}">
                                    <div class="del">
                                        <button type="button" class="btn btn-danger btn-sm delete"
                                                id="${comment.id}">
                                            删除
                                        </button>
                                    </div>
                                </c:if>
                            </div>
                        </c:if>
                        <c:if test="${empty comment.reviewerTo}">
                            <div class="comment">
                                <!-- 头像 -->
                                <div class="avatar">
                                    <img src="${comment.reviewer.avatar}" alt="头像">
                                </div>
                                <!-- 名字 -->
                                <div class="userName">
                                    <span>${comment.reviewer.userName}</span>
                                </div>
                                <!-- 评论时间 -->
                                <div class="Ctime">
                                    <span>${comment.time}</span>
                                </div>
                                <!-- 评论内容 -->
                                <div class="Ctxt">
                                    <span>${comment.comment}</span>
                                </div>
                                <!-- 是否回复 -->
                                <div class="reply">
                                    <button type="button" class="btn btn-info btn-sm back" id="${comment.reviewer.id}">
                                        回复
                                    </button>
                                </div>
                                <!-- 是否删除  -->
                                <c:if test="${user.userName == comment.reviewer.userName}">
                                    <div class="del">
                                        <button type="button" class="btn btn-danger btn-sm delete"
                                                id="${comment.id}">
                                            删除
                                        </button>
                                    </div>
                                </c:if>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!-- 右边榜单 -->
        <div class="right">
            <!-- 大标题 -->
            <div class="bTitle">
                <span>热播动漫</span>
            </div>
            <!-- 排名 -->
            <ul class="sort">
                <c:forEach items="${comicList}" var="comic">
                    <li>
                        <a href="#">${comic.comicName}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>

</div>
<!--回复框-->
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">回复评论</h4>
            </div>
            <div class="modal-body">
                回复的人的编号：<input type="text" name="otherId" readonly id="reId"><br>
                回复的内容：<br>
                <textarea name="comment" id="reCom" cols="30" rows="10"></textarea>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="re">回复</button>
            </div>
        </div>
    </div>
</div>

<!-- 删除对话框-->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="alert alert-danger alert-dismissible fade in" role="alert">
            <h4>是否确定删除？</h4>
            <p style="margin-bottom: 10px">你确定删除吗？</p>
            <p style="text-align: right">
                <button id="btnConfirmDelete" type="button" class="btn btn-danger">确 定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取 消</button>
            </p>
        </div>
    </div>
</div>

<!--
发送评论
-->
<script src="static/jquery-3.5.1/jquery-3.5.1.js"></script>
<script src="static/bootstrap-3.4.1-dist/js/bootstrap.js"></script>
<script>
    // 发送评论
    $('#send').click(function () {
        <c:if test="${not empty user}">
        $.ajax({
            url: '/comic/addComment',
            type: 'post',
            data: {
                'userId': ${user.id},
                'comment': $('#comment').val(),
                'comicId': ${comic.id},
            },
            success: function (res) {
                if (res === "true") {
                    alert("评论成功！");
                    location.reload();
                } else {
                    alert("评论失败！");
                }
            }
        });
        </c:if>
        <c:if test="${empty user}">
        alert("您未登录不能评论！请您先登录")
        </c:if>
    });

    // 回复评论
    $('.back').click(function () {
        <c:if test="${not empty user}">
        $("#myModal").modal("show");

        // 得到评论人的id
        let id = $(this).attr('id');
        $('#reId').val(id);

        if ($('#reCom').val() != null) {
            // 点击回复
            $('#re').click(function () {
                $.ajax({
                    url: '/comic/addComment',
                    type: 'post',
                    data: {
                        'comicId': ${comic.id},
                        'userId': ${user.id},
                        'otherId': id,
                        'comment': $('#reCom').val(),
                    },
                    success: function (res) {
                        if (res === "true") {
                            alert("回复成功！");
                            location.reload();
                        } else {
                            alert("回复失败！请刷新重试！");
                        }
                    }
                });
            });
        }
        </c:if>
        <c:if test="${empty user}">
        alert("您未登录，请尽快去登录！");
        </c:if>
    });

    // 删除评论
    $('.delete').click(function () {
        $("#deleteModal").modal('show');
        // 得到评论人的id
        let id = $(this).attr('id');

        $('#btnConfirmDelete').click(function () {
            $.ajax({
                url: '/comic/delComment',
                type: 'get',
                data: {
                  'id': id
                },
                success: function (res) {
                    if (res === 'true') {
                        alert("删除评论成功！");
                        location.reload();
                    } else {
                        alert("删除失败！");
                    }
                }
            });
        });
    });

</script>
</body>
</html>
