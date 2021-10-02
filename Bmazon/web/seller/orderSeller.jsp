<%-- 
    Document   : orderSeller
    Created on : Sep 30, 2021, 2:15:00 PM
    Author     : DELL
--%>

<%@page import="java.util.List"%>
<%@page import="entity.ProductType"%>
<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.User"%>
<%@page import="model.ProductTypeDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Seller | Dashboard</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <meta name="description" content="Developed By M Abdur Rokib Promy">
        <meta name="keywords" content="Admin, Bootstrap 3, Template, Theme, Responsive">
        <!-- bootstrap 3.0.2 -->
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

        <style type="text/css">

        </style>
    </head>

    <!--%
        Account account = (Account) session.getAttribute("account");
        if (account == null || account.isIsAdmin() == false) {
    %-->
    <!--    <h2>You must be seller to access this</h2>-->
    <!--% } else { %-->
    
<%
    User curUser = (User) request.getSession().getAttribute("currUser");
    ArrayList<Product> listP = (ArrayList<Product>) request.getAttribute("listP");
%>

    <body class="skin-black">
            <jsp:include page="headerSeller.jsp"/>
        <!-- header logo: style can be found in header.less -->
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="${contextPath}/images/seller/26115.jpg" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p>Hello, <%= curUser.getUsername() %></p>

                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    <!--                             search form 
                                                <form action="#" method="get" class="sidebar-form">
                                                    <div class="input-group">
                                                        <input type="text" name="q" class="form-control" placeholder="Search..."/>
                                                        <span class="input-group-btn">
                                                            <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                                                        </span>
                                                    </div>
                                                </form>-->
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li><!-- class="tablinks" -->
                            <!--<a href="" onclick="openObject(event, 'Dashboard')">-->
                                
                            <a href="SellerControllerMap">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                            </a>
                        </li>
                        <li>
                            <a href="SellerControllerMap?service=productmanagement">
                                <i class="fa fa-gavel"></i> <span>Product Management</span>
                            </a>
                        </li>

                        <li class="active">
                            <a href="SellerControllerMap?service=ordermanagement">
                                <i class="fa fa-globe"></i> <span>Order Management</span>
                            </a>
                        </li>


                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <aside class="right-side">

                <!-- Main content -->
                <section class="content">

                    <div class="row" style="margin-bottom:5px;">


                        <div class="col-md-4">
                            <div class="sm-st clearfix">
                                <span class="sm-st-icon st-red"><i class="fa fa-check-square-o"></i></span>
                                <div class="sm-st-info">
                                    <span> <%= listP.size() %> </span>
                                    Total Product
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="sm-st clearfix">
                                <span class="sm-st-icon st-violet"><i class="fa fa-envelope-o"></i></span>
                                <div class="sm-st-info">
                                    <span>2200</span>
                                    Total Order
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="sm-st clearfix">
                                <span class="sm-st-icon st-blue"><i class="fa fa-dollar"></i></span>
                                <div class="sm-st-info">
                                    <span>100,320</span>
                                    Total Profit
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Main row -->
                    <!-- Dashboard -->
                    <div class="row" id="Order" name="tabcontent" style="display: block;">
                        <div class="col-md-8">
                            <section class="panel">
                                <header class="panel-heading">
                                    Order completed
                                </header>
                                <div class="panel-body table-responsive">
                                    <table class="table table-hover">
                                        <thead>
                                            <tr>
                                                <th>Order ID</th>
                                                <th>Customer</th>
                                                <th>Required date</th>
                                                <th>Total cost</th>
                                                <th>Status</th>
                                                <th>Progress</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Nam</td>
                                                <td>13/11/2001</td>
                                                <td>300$</td>
                                                <td><span class="label label-success">success</span></td>
                                                <td><span class="badge badge-success">100%</span></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </section>


                        </div><!--end col-6 -->
                        <div class="col-md-4">
                            <section class="panel">
                                <header class="panel-heading">
                                    Biggest orders
                                </header>
                                <div class="panel-body">
                                </div>
                            </section>
                        </div>

                    </div>
                    <!-- row end -->
                </section><!-- /.content -->
                <div class="footer-main">
                    &copy Bmazon, 2021
                </div>
            </aside><!-- /.right-side -->

        </div><!-- ./wrapper -->

    </body>
    <!--% }%-->

<!--    <script>
                                function openObject(evt, Object) {
                                    // Declare all variables
                                    var i, tabcontent, tablinks;

                                    // Get all elements with class="tabcontent" and hide them
                                    tabcontent = document.getElementsByName("tabcontent");
                                    for (i = 0; i < tabcontent.length; i++) {
                                        tabcontent[i].style.display = "none";
                                    }

                                    // Get all elements with class="tablinks" and remove the class "active"
                                    tablinks = document.getElementsByClassName("tablinks");
                                    for (i = 0; i < tablinks.length; i++) {
                                        tablinks[i].className = tablinks[i].className.replace(" active", "");
                                    }

                                    // Show the current tab, and add an "active" class to the link that opened the tab
                                    document.getElementById(Object).style.display = "block";
                                    evt.currentTarget.className += " active";
                                }
    </script>-->
</html>