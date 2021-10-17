<%-- 
    Document   : headerSeller
    Created on : Sep 30, 2021, 3:37:37 PM
    Author     : DELL
--%>

<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="${contextPath}/css/seller/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/ionicons.min.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/morris/morris.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/iCheck/all.css" rel="stylesheet" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
        <link href="${contextPath}/css/seller/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css"> 
    </head>
    <body>
        <%
            User curUser = (User) request.getSession().getAttribute("currUser");
        %>
        <header class="header">
            <a href="HomePageControllerMap?service=Homepage" class="logo">
                Bmazon
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="navbar-right">
                    <ul class="nav navbar-nav">
                        <!--                         Messages: style can be found in dropdown.less
                        -->                        <li class="dropdown messages-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-envelope"></i>
                                <span class="label label-success">1</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="header">You have 1 messages</li>
                                <li>
                                    <ul class="menu">
                                        <li>
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="upload/<%= curUser.getProfileImage()%>" class="img-circle" alt="User Image"/>
                                                </div>
                                                <h4>
                                                    Customer 1
                                                </h4>
                                                <p>Comment product</p>
                                                <small class="pull-right"><i class="fa fa-clock-o"></i> 5 mins</small>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="footer"><a href="#">See All Messages</a></li>
                            </ul>
                        </li>
                        <!-- User Account: style can be found in dropdown.less -->
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-user"></i>
                                <span><%= curUser.getFullname()%>  <i class="caret"></i></span>
                            </a>
                            <ul class="dropdown-menu dropdown-custom dropdown-menu-right">
                                <li class="dropdown-header text-center">Account</li>

                                <% if (curUser.getSystemRole() == 1) {%>
                                <li>
                                    <a href="${contextPath}/AdminControllerMap">
                                        <i class="fa fa-user fa-fw pull-right"></i>
                                        Admin Dashboard
                                    </a>
                                    <ul class='nav-dropdown nav-dropdown-simple'>
                                        <li  ><a href="${contextPath}/AdminControllerMap?service=usermanagement" class="menu-image-title-after"><span >User Management</span></a></li>
                                        <li  ><a href="${contextPath}/AdminControllerMap?service=productmanagement" class="menu-image-title-after"><span >Product Management</span></a></li>
                                    </ul>
                                </li>
                                <%}%>
                                <% if (curUser.getSell() == 1) { %>

                                <li class="divider"></li>

                                <li>
                                    <a href="${contextPath}/SellerControllerMap">
                                        <i class="fa fa-user fa-fw pull-right"></i>
                                        Seller Dashboard
                                    </a>
                                    <ul class='nav-dropdown nav-dropdown-simple'>
                                        <li  ><a href="${contextPath}/SellerControllerMap?service=productmanagement" class="menu-image-title-after"><span >Product Management</span></a></li>
                                        <li  ><a href="#" class="menu-image-title-after"><span >Order Management</span></a></li>
                                    </ul>
                                </li>
                                <%}%>

                                <li class="divider"></li>

                                <li>
                                    <a href="${contextPath}/UserControllerMap?service=account">
                                        <i class="fa fa-user fa-fw pull-right"></i>
                                        Account
                                    </a>
                                    <ul class='nav-dropdown nav-dropdown-simple'>
                                        <li  ><a href="${contextPath}/UserControllerMap?service=info" class="menu-image-title-after"><span >My Profile</span></a></li>
                                    </ul>
                                </li>

                                <li class="divider"></li>

                                <li>
                                    <a href="${contextPath}/UserControllerMap?service=changepass"><i></i> Change Password</a>
                                    <a href="${contextPath}/UserControllerMap?service=logout"><i class="fa fa-ban fa-fw pull-right"></i> Logout</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
    </body>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
    <script src="${contextPath}/js/seller/jquery.min.js" type="text/javascript"></script>
    <script src="${contextPath}/js/seller/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
    <script src="${contextPath}/js/seller/bootstrap.min.js" type="text/javascript"></script>
    <script src="${contextPath}/js/seller/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>
    <script src="${contextPath}/js/seller/plugins/chart.js" type="text/javascript"></script>
    <script src="${contextPath}/js/seller/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    <script src="${contextPath}/js/seller/plugins/fullcalendar/fullcalendar.js" type="text/javascript"></script>
    <script src="${contextPath}/js/seller/Director/app.js" type="text/javascript"></script>
    <script src="${contextPath}/js/seller/Director/dashboard.js" type="text/javascript"></script>
</html>
