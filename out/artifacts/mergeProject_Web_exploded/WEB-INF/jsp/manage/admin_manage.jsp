<%--
  Created by IntelliJ IDEA.
  User: 20698
  Date: 2022/12/13
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8"/>
    <title>管理员管理页面</title>
    <link rel="stylesheet" href="static/bootstrap-3.4.1-dist/css/bootstrap.css">
    <!-- 引入图标字体 -->
    <link rel="stylesheet" href="static/font/iconfont.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="manage/manage.do">动漫管理系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="manage/user">用户管理</a></li>
                <li><a href="manage/comic">动漫管理</a></li>
                <li><a href="manage/news">资讯管理</a></li>
                <li><a href="manage/admin">管理员管理</a></li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">${sessionScope.admin.adminName} <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">个人信息</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="admin/AdminLogout">注销</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<!-- 面板 -->
<div class="panel panel-default">
    <div class="panel-heading">
        <span class="iconfont icon-liebiao"></span>
        管理员列表&nbsp;&nbsp;&nbsp;
        <button id="btnAdd" class="btn btn-success"><span class="iconfont icon-xinjian"></span>新建</button>
    </div>

    <div class="panel-body">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>编号</th>
                <th>用户名</th>
                <th>密码</th>
                <th>头像</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.adminList}" var="admin">
                <tr>
                    <th scope="row">${admin.id}</th>
                    <td>${admin.adminName}</td>
                    <td>${admin.password}</td>
                    <td>
                        <img src="${admin.default_avatar}" alt="图片" style="width: 45px; height: 45px;">
                    </td>
                    <td>
                        <button id="btnEdit" class="btn btn-warning"><span
                                class="iconfont icon-xiugai"></span>修改
                        </button>
                        <button id="btnDelete" class="btn btn-danger"><span
                                class="iconfont icon-shanchu"></span>删除
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- 模态框，可弹出新建或者编辑 -->
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel"></h4>
            </div>
            <div class="modal-body">
                <div class="panel-body">
                    <div class="form-group">
                        <label for="uid">编号</label>
                        <input type="text" class="form-control" id="uid" name="id">
                    </div>
                    <div class="form-group">
                        <label for="adminName">用户名</label>
                        <input type="text" class="form-control" id="adminName" placeholder="请输入用户名" name="adminName">
                    </div>
                    <div class="form-group">
                        <label for="password">密码</label>
                        <input type="password" class="form-control" id="password" placeholder="请输入密码" name="password">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取 消</button>
                <button id="btnSave" type="button" class="btn btn-primary">确认</button>
            </div>
        </div>
    </div>
</div>

<!-- 删除对话框-->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="alert alert-danger alert-dismissible fade in" role="alert">
            <h4>是否确定删除？</h4>
            <p style="margin-bottom: 10px">删除后，所有相关东西都会被删除</p>
            <p style="text-align: right">
                <button id="btnConfirmDelete" type="button" class="btn btn-danger">确 定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取 消</button>
            </p>
        </div>
    </div>
</div>

<!--分页-->
<nav aria-label="Page navigation" style="text-align: center">
    <ul class="pagination pagination-lg">
        <li><a href="manage/admin?currentPage=1">首页</a></li>
        <c:if test="${requestScope.pageInfo.currentPage > 1}">
            <li>
                <a href="manage/admin?currentPage=${requestScope.pageInfo.currentPage - 1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>
        <c:forEach items="${requestScope.arr}" var="num">
            <li><a href="manage/admin?currentPage=${num}">${num}</a></li>
        </c:forEach>
        <c:if test="${requestScope.pageInfo.currentPage < requestScope.pageInfo.pageNum}">
            <li>
                <a href="manage/admin?currentPage=${requestScope.pageInfo.currentPage + 1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
        <li><a href="manage/admin?currentPage=${requestScope.pageInfo.pageNum}">末页</a></li>
    </ul>
</nav>

<script src="static/jquery-3.5.1/jquery-3.5.1.js"></script>
<script src="static/bootstrap-3.4.1-dist/js/bootstrap.js"></script>

<script>
    $(function () {

        window.onload = function (){
            addFunc();
            editFunc();
            deleteFunc();
        }

    })

    // 点击新建
    function addFunc() {
        $("#btnAdd").click(function () {
            // 将模态框显示出来
            $("#myModal").modal("show");
            // 更改标题
            $("#myModalLabel").text("新建管理员");

        });
    }

    // 点击修改
    function editFunc() {
        $("#btnEdit").click(function () {
            // 将模态框显示出来
            $("#myModal").modal("show");
            // 更改标题,先清空内容再更改
            $("#myModalLabel").text("");
            $("#myModalLabel").text("修改管理员");
        });
    }

    // 点击删除
    function deleteFunc() {
        $("#btnDelete").click(function () {
            //显示删除对话框
            $("#deleteModal").modal('show');
            var id = $(this).attr('id');
            doDel(id);
        })
    }
    // 做删除方法
    function doDel(id) {
        $('#btnConfirmDelete').click(function () {
            // console.log(id);
            $.ajax({
                url: 'admin/delete',
                type: 'get',
                data: {
                    id,
                },
                success: function (res) {
                    console.log(res);
                    if (res === "true") {
                        alert("删除成功！");
                        location.reload();
                    } else {
                        alert("好像出问题了，不能删除！");
                    }
                }
            });
        });
    }

</script>
</body>
</html>
