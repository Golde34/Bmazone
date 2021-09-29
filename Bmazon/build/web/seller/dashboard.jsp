<%-- 
    Document   : dashboard
    Created on : Sep 26, 2021, 12:09:49 PM
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
        <!-- font Awesome -->
        <link href="${contextPath}/css/seller/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="${contextPath}/css/seller/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- Morris chart -->
        <link href="${contextPath}/css/seller/morris/morris.css" rel="stylesheet" type="text/css" />
        <!-- jvectormap -->
        <link href="${contextPath}/css/seller/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        <!-- Date Picker -->
        <link href="${contextPath}/css/seller/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
        <!-- fullCalendar -->
        <!-- <link href="${contextPath}/css/seller/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css" /> -->
        <!-- Daterange picker -->
        <link href="${contextPath}/css/seller/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        <!-- iCheck for checkboxes and radio inputs -->
        <link href="${contextPath}/css/seller/iCheck/all.css" rel="stylesheet" type="text/css" />
        <!-- bootstrap wysihtml5 - text editor -->
        <!-- <link href="${contextPath}/css/seller/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" /> -->
        <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
        <!-- Theme style -->
        <link href="${contextPath}/css/seller/style.css" rel="stylesheet" type="text/css" />


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
    ProductTypeDAO producttypedao = new ProductTypeDAO();
    User curUser = (User) request.getSession().getAttribute("currUser");
    ArrayList<Product> listP = (ArrayList<Product>) request.getAttribute("listP");
%>

    <body class="skin-black">
        <!-- header logo: style can be found in header.less -->
        <header class="header">
            <a href="#" class="logo">
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
                                                    <img src="${contextPath}/images/seller/26115.jpg" class="img-circle" alt="User Image"/>
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
                                <span><%= curUser.getFullname() %>  <i class="caret"></i></span>
                            </a>
                            <ul class="dropdown-menu dropdown-custom dropdown-menu-right">
                                <li class="dropdown-header text-center">Account</li>

                                <li>
                                    <a href="#">
                                        <i class="fa fa-clock-o fa-fw pull-right"></i>
                                        <span class="badge badge-success pull-right">10</span> Updates</a>
                                    <a href="#">
                                        <i class="fa fa-envelope-o fa-fw pull-right"></i>
                                        <span class="badge badge-danger pull-right">5</span> Messages</a>
                                    <a href="#"><i class="fa fa-magnet fa-fw pull-right"></i>
                                        <span class="badge badge-info pull-right">3</span> Subscriptions</a>
                                    <a href="#"><i class="fa fa-question fa-fw pull-right"></i> <span class=
                                                                                                      "badge pull-right">11</span> FAQ</a>
                                </li>

                                <li class="divider"></li>

                                <li>
                                    <a href="#">
                                        <i class="fa fa-user fa-fw pull-right"></i>
                                        Profile
                                    </a>
                                    <a data-toggle="modal" href="#modal-user-settings">
                                        <i class="fa fa-cog fa-fw pull-right"></i>
                                        Settings
                                    </a>
                                </li>

                                <li class="divider"></li>

                                <li>
                                    <a href="#"><i class="fa fa-ban fa-fw pull-right"></i> Logout</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
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
                        <li class="tablinks">
                            <a href="" onclick="openObject(event, 'Dashboard')">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                            </a>
                        </li>
                        <li class="tablinks">
                            <a href="" onclick="openObject(event, 'Product')">
                                <i class="fa fa-gavel"></i> <span>Product Management</span>
                            </a>
                        </li>

                        <li class="tablinks">
                            <a href="" onclick="openObject(event, 'Order')">
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
                    <div class="row" id="Dashboard" name="tabcontent" style="display: block;">

                        <div class="col-md-8">
                            <section class="panel">
                                <header class="panel-heading">
                                    Order in Progress
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
                                                <td><span class="label label-danger">in progress</span></td>
                                                <td><span class="badge badge-info">50%</span></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </section>


                        </div><!--end col-6 -->
                        <div class="col-md-4">
                            <section class="panel">
                                <header class="panel-heading">
                                    Most spent customers
                                </header>
                                <div class="panel-body">
                                </div>
                            </section>
                        </div>

                    </div>
                    
                    
                    
                    <!-- Product management -->
                    <div class="row" id="Product" name="tabcontent" style="display: none;">

                        <div class="col-md-8">
                            <section class="panel">
                                <header class="panel-heading">
                                    Product in shop
                                </header>
                                <div class="panel-body table-responsive">
                                    <table class="table table-hover">
                                        <thead>
                                                <tr>
                                                    <th>Product Name</th>
                                                    <th>Color</th>
                                                    <th>Size</th>
                                                    <th>Price</th>
                                                    <th>ProductTypeID</th>
                                                    <th></th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% for (Product product : listP) {
                                                        List<ProductType> listProductType = producttypedao.getProductByProductID(product.getProductID());
                                                        for (ProductType producttype : listProductType) {
                                                %>
                                                <tr>
                                                    <td><div><%=product.getProductName()%></div></td>
                                                    <td><div><%=producttype.getColor()%></div></td>
                                                    <td><div><%=producttype.getSize()%></div></td>
                                                    <td><div><%=producttype.getPrice()%></div></td>
                                                    <td><div><%=producttype.getProductTypeId()%></div></td>
                                                    <td><div>
                                                            <a href="AdminControllerMap?service=updatedetail&userid=<%=producttype.getProductTypeId()%>"><span class="fas fa-edit"></span></a>
                                                        </div></td>
                                                    <td><div><a href="AdminControllerMap?service=deleteuser&userid=<%=producttype.getProductTypeId()%>" onclick="return confirm('Are you sure you want to Remove?');"><span class="fas fa-trash-alt"></span></a></div></td>
                                                </tr>
                                                <%}%>
                                                <%}%>
                                            </tbody>
                                    </table>
                                </div>
                            </section>


                        </div><!--end col-6 -->
                        <div class="col-md-4">
                            <section class="panel">
                                <header class="panel-heading">
                                    Hot products
                                </header>
                                <div class="panel-body">
                                </div>
                            </section>
                        </div>

                    </div>
                    
                    
                    <!-- Order management -->
                    <div class="row" id="Order" name="tabcontent" style="display: none;">
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

        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="${contextPath}/js/seller/jquery.min.js" type="text/javascript"></script>

        <!-- jQuery UI 1.10.3 -->
        <script src="${contextPath}/js/seller/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
        <!-- Bootstrap -->
        <script src="${contextPath}/js/seller/bootstrap.min.js" type="text/javascript"></script>
        <!-- daterangepicker -->
        <script src="${contextPath}/js/seller/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>

        <script src="${contextPath}/js/seller/plugins/chart.js" type="text/javascript"></script>

        <script src="${contextPath}/js/seller/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
        <!-- calendar -->
        <script src="${contextPath}/js/seller/plugins/fullcalendar/fullcalendar.js" type="text/javascript"></script>

        <!-- Director App -->
        <script src="${contextPath}/js/seller/Director/app.js" type="text/javascript"></script>

        <!-- Director dashboard demo (This is only for demo purposes) -->
        <script src="${contextPath}/js/seller/Director/dashboard.js" type="text/javascript"></script>
    </body>
    <!--% }%-->

    <script>
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
    </script>
</html>