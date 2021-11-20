<%-- 
    Document   : customerDetail
    Created on : Nov 20, 2021, 7:34:01 PM
    Author     : Admin
--%>

<%@page import="entity.Order"%>
<%@page import="model.OrderDAO"%>
<%@page import="model.UserDAO"%>
<%@page import="entity.Customer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Seller | Product Detail</title>
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
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <style type="text/css">
            
        </style>
    </head>

    <%
        UserDAO uDAO = new UserDAO();
        OrderDAO oDAO = new OrderDAO();
        DecimalFormat nf = new DecimalFormat("###,###,###,###");
        
        User curUser = (User) request.getSession().getAttribute("currUser");
        Customer cus = (Customer) request.getAttribute("cus");
    %>

    <body class="skin-black">
        <!-- header logo: style can be found in header.less -->
        <jsp:include page="headerSeller.jsp"/>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="upload/<%= curUser.getProfileImage()%>" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p>Hello, <%= curUser.getUsername()%></p>

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
                        <li>
                            <a href="SellerControllerMap?service=gallerymanagement">
                                <i class="fa fa-image"></i> <span>Gallery Management</span>
                            </a>
                        </li>
                        <li>
                            <a href="SellerControllerMap?service=orderResponse">
                                <i class="fa fa-globe"></i> <span>Order Response</span>
                            </a>
                        </li>
                        <li>
                            <a href="SellerControllerMap?service=ordermanagement">
                                <i class="fa fa-globe"></i> <span>Order Management</span>
                            </a>
                        </li>
                        <li>
                            <a href="SellerControllerMap?service=feedback">
                                <i class="fa fa-empire"></i> <span>Feed Back</span>
                            </a>
                        </li>
                        <li class="active">
                            <a href="SellerControllerMap?service=customermanagement">
                                <i class="fa fa-empire"></i> <span>Customer Management</span>
                            </a>
                        </li>

                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <aside class="right-side">
                <section class="content">
                    <!-- Main row -->
                    <!-- Product management -->
                        <section class="panel">
                            <div class="card">
                                <div class="card-header pt-5 d-flex justify-content-between">
                                    <h3 class="m-0 font-weight-bold text-primary">Customer Information</h3>
                                </div>
                                <div class="card-body">
                                    <table class="table table-striped">
                                        <tr>
                                            <td style="width: 200px;">Customer Name</td>
                                            <td><textarea readonly="" style="width: 500px;" required class="form-control" name="productname"><%= uDAO.getUserById(Integer.toString(cus.getUserID())).getFullname() %></textarea></td>
                                        </tr>
                                        <tr>
                                            <td>Total order success</td>
                                            <td><input readonly="" value="<%= cus.getOrder() %>">
                                        </tr>
                                        <tr>
                                            <td>Total spent</td>
                                            <td><input readonly="" value="<%= nf.format(cus.getSpent()) %>">
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <!--                            <header class="panel-heading">
                                                            Product in shop
                                                        </header>-->
                            <div class="panel-body table-responsive">
                                <%
                                    List<Order> listO = oDAO.getOrderByUser(cus.getUserID());
                                %>
                                    <table class="table table-hover">
                                        <thead>
                                            <tr>
                                                <th>Receiver Name</th>
                                                <th>Order date</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody id="order">
                                            <%
                                                for (Order o : listO) {
                                            %>
                                            <tr>
                                                <td><%= o.getShipName() %> </td>
                                                <td><%= o.getOrderDate()%></td>

                                                <% if (o.getState() == 0) {%>
                                                <td><span class="label label-danger">Wait for accept</span></td>
                                                <% } else if (o.getState() == 1) {%>
                                                <td><span class="label label-primary">Order confirmed</span></td>
                                                <% } else if (o.getState() == 2) {%>
                                                <td><span class="label label-warning">On The Way</span></td>
                                                <% } else { %>
                                                <td><span class="label label-success">Success</span></td>
                                                <% }%>
                                                <td><a href="SellerControllerMap?service=orderdetail&orderid=<%= o.getOrderID() %>"><button class="btn btn-primary">Detail</button></a>
                                                </td>
                                            </tr>
                                            <% } %>
                                        </tbody>
                                    </table>
                            </div>
                        </section>

                </section><!-- /.content -->


        </div><!-- ./wrapper -->

    </body>
    <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
    <script src="${contextPath}/js/core/popper.min.js"></script>
    <script src="${contextPath}/js/core/bootstrap.min.js"></script>
    <script src="${contextPath}/js/plugins/perfect-scrollbar.min.js"></script>
    <script src="${contextPath}/js/plugins/smooth-scrollbar.min.js"></script>
    <script src="${contextPath}/js/plugins/chartjs.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</html>
