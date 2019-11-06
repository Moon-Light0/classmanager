<%--
  Created by IntelliJ IDEA.
  User: MrXu
  Date: 2019/11/4
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- 导航侧栏 -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p class="stuName"><sec:authentication property="principal.username"></sec:authentication></p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
            <span id="username-span"><sec:authentication property="name"></sec:authentication></span>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <li id="admin-index"><a href="${pageContext.request.contextPath}/pages/main.jsp"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-laptop"></i> <span>个人管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <li id="elements-general">
                        <span hidden><sec:authentication property="name" var="username"></sec:authentication></span>
                        <sec:authorize access="hasRole('USER')">
                            <a href="${pageContext.request.contextPath}/student/findByStuNo?stuNo=${username}">
                                <i class="fa fa-circle-o"></i> 个人信息管理
                            </a>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN')">
                            <a href="${pageContext.request.contextPath}/headmaster/findByHNo?hNo=${username}">
                                <i class="fa fa-circle-o"></i> 个人信息管理
                            </a>
                        </sec:authorize>
                    </li>

                    <li id="elements-buttons">
                        <a href="${pageContext.request.contextPath}/pages/studentmsg.jsp">
                            <i class="fa fa-circle-o"></i> 课程管理
                        </a>
                    </li>


                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i> <span>班级管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li id="elements-icons">
                        <a href="${pageContext.request.contextPath}/pages/studentmanage.jsp">
                            <i class="fa fa-circle-o"></i> 学生管理
                        </a>
                    </li>
                    <li id="charts-chartjs">
                        <a href="${pageContext.request.contextPath}/pages/eveningstudy.jsp">
                            <i class="fa fa-circle-o"></i> 晚自习管理
                        </a>
                    </li>

                    <li id="charts-morri">
                        <a href="all-charts-morris.html">
                            <i class="fa fa-circle-o"></i> 请假管理
                        </a>
                    </li>
                    <li id="charts-morris">
                        <a href="${pageContext.request.contextPath}/pages/reward.jsp">
                            <i class="fa fa-circle-o"></i> 奖惩管理
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
<!-- 导航侧栏 /-->

