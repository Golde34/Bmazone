<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.*"%>
<%@page import="entity.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Seller | Dashboard</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
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
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
    </head>
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        DecimalFormat nf = new DecimalFormat("###,###,###,###");
        SellerDAO sDAO = new SellerDAO();
        UserDAO uDAO = new UserDAO();
        OrderDetailDAO odDAO = new OrderDetailDAO();
        
        User curUser = (User) request.getSession().getAttribute("currUser");
        List<Customer> listCustomer = (ArrayList<Customer>) request.getAttribute("listCustomer");
        String mess = (String) request.getAttribute("messThanks");

        String userID = curUser.getUserId();
        Seller seller = sDAO.getSellerByUserID(Integer.parseInt(userID));
        int sellerID = seller.getSellerID();
    %>

    <body class="skin-black">
        <jsp:include page="headerSeller.jsp"/>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <aside class="left-side sidebar-offcanvas">
                <section class="sidebar">
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="upload/<%= curUser.getProfileImage()%>" class="img-circle"/>
                        </div>
                        <div class="pull-left info">
                            <p>Hello, <%= curUser.getUsername()%></p>
                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
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
            </aside>
            <aside class="right-side">
                <section class="content">
                    <div class="row d-block" id="Order" name="tabcontent">
                        <div class="col-md-12">
                            <section class="panel">
                                <p style="color: green;">${messThanks}</p>
                                <header class="panel-heading">
                                    Familiar Customer
                                </header>
                                <div class="panel-body table-responsive">
                                    <table class="text-center" style="width: 100%;">
                                        <thead class="text-uppercase bg-gray-200">
                                            <tr>
                                                <th style="width: 15%;padding: 20px;">Customer</th>
                                                <th style="width: 20%">Total order</th>
                                                <th style="width: 15%">Total cost</th>
                                                <th style="width: 15%">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody id="order">
                                            <%
                                                for (Customer cus : listCustomer) {
                                                    User u = uDAO.getUserById(Integer.toString(cus.getUserID()));
                                            %>
                                            <tr>
                                                <td><%= u.getFullname() %></td>
                                                <td><%= cus.getOrder() %> orders</td>
                                                <td><%= nf.format(cus.getSpent()) %> VND</td>
                                                <td style='white-space: nowrap'>
                                                    <a href="SellerControllerMap?service=sendthanks&userID=<%= cus.getUserID() %>&ordered=<%= cus.getOrder() %>"><button class="btn btn-primary">Send Thanks</button></a>
                                                </td>
                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
                            </section>
                        </div>
                    </div>
                </section>
<!--                <div class="footer-main">
                    &copy Bmazon, 2021
                </div>-->
            </aside>
        </div>
    </body>
    <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
    <script src="${contextPath}/js/core/popper.min.js"></script>
    <script src="${contextPath}/js/core/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        var pageNum;
        $(document).on('click', '.pagination li', function () {
            pageNum = $(this).data('repair');
            pagination();
        });
        function pagination() {
            var row = document.getElementById("maxRows").value;
//                var search = document.getElementById("search").value;
            $(document).on('change', '#maxRows', function () {
                pageNum = 1;
            });
            $(document).on('input', '#search', function () {
                pageNum = 1;
            });
            $.ajax({
                url: "/Bmazon/AdminControllerMap",
                type: "get",
                data: {
//                        search: search,
                    row: row,
                    index: pageNum,
                    service: "pagingOrderResponse"
                },
                success: function (respone) {
                    var text = document.getElementById("order");
                    text.innerHTML = respone;
                    showpage();
                },
                error: function (xhr) {
                    //Do Something to handle error
                }
            });
        }
        function showpage() {
            var row = document.getElementById("maxRows").value;
//                var search = document.getElementById("search").value;
            $(document).on('change', '#maxRows', function () {
                pageNum = 1;
            });
            $(document).on('input', '#search', function () {
                pageNum = 1;
            });
            $.ajax({
                url: "/Bmazon/AdminControllerMap",
                type: "get",
                data: {
//                        search: search,
                    row: row,
                    index: pageNum,
                    service: "showPageOrderResponse"
                },
                success: function (respone) {
                    var text = document.getElementById("showpage");
                    text.innerHTML = respone;
                },
                error: function (xhr) {
                    //Do Something to handle error
                }
            });
        }
    </script>
</html>