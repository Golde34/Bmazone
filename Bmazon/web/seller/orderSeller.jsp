<%-- 
    Document   : orderSeller
    Created on : Sep 30, 2021, 2:15:00 PM
    Author     : DELL
--%>

<%@page import="model.UserDAO"%>
<%@page import="model.SellerDAO"%>
<%@page import="entity.Seller"%>
<%@page import="entity.Order"%>
<%@page import="model.OrderDAO"%>
<%@page import="model.OrderDetailDAO"%>
<%@page import="model.ProductDAO"%>
<%@page import="entity.Genre"%>
<%@page import="entity.Category"%>
<%@page import="model.GenreDAO"%>
<%@page import="model.ProductGenreDAO"%>
<%@page import="model.CategoryDAO"%>
<%@page import="model.ProductCategoryDAO"%>
<%@page import="java.text.DecimalFormat"%>
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
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>

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

        DecimalFormat nf = new DecimalFormat("###,###,###");
        ProductTypeDAO ptDAO = new ProductTypeDAO();
        ProductCategoryDAO pcDAO = new ProductCategoryDAO();
        CategoryDAO cateDAO = new CategoryDAO();
        ProductGenreDAO pgdao = new ProductGenreDAO();
        GenreDAO genreDAO = new GenreDAO();
        ProductDAO pDAO = new ProductDAO();
        OrderDetailDAO odDAO = new OrderDetailDAO();
        OrderDAO oDAO = new OrderDAO();
        SellerDAO sDAO = new SellerDAO();
        UserDAO uDAO = new UserDAO();

        ArrayList<Category> listCategory = cateDAO.getAllCategories();
        ArrayList<Genre> listGenre = genreDAO.getAllGenres();
        int index = (Integer) request.getAttribute("index");
        int totalPage = (Integer) request.getAttribute("totalPage");
        int prev = index == 1 ? 1 : index - 1;
        int next = index == totalPage ? totalPage : index + 1;
        User curUser = (User) request.getSession().getAttribute("currUser");
        ArrayList<Product> listP = (ArrayList<Product>) request.getAttribute("listProduct");

        String userID = curUser.getUserId();
        Seller seller = sDAO.getSellerByUserID(Integer.parseInt(userID));
        int sellerID = seller.getSellerID();
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

                        <li class="active">
                            <a href="SellerControllerMap?service=ordermanagement">
                                <i class="fa fa-globe"></i> <span>Order Management</span>
                            </a>
                        </li>
                        
                       <li class="active">
                            <a href="SellerControllerMap?service=feedback">
                                <i class="fa fa-empire"></i> <span>Feed Back</span>
                            </a>
                        </li>



                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <aside class="right-side">

                <!-- Main content -->
                <section class="content">


                    <jsp:include page="generalBoard.jsp"/>

                    <!-- Main row -->
                    <!-- Dashboard -->
                    <div class="row" id="Order" name="tabcontent" style="display: block;">
                        <div class="col-md-8">
                            <section class="panel">
                                <header class="panel-heading">
                                    Orders
                                </header>
                                <div class="panel-body table-responsive">
                                    <table class="table table-hover">
                                        <thead>
                                            <tr>
                                                <th>Customer</th>
                                                <th>Order date</th>
                                                <th>Status</th>
                                                <th>Progress</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                List<Order> listOrder = oDAO.getOrderBySellerID(sellerID);
                                                for (Order o : listOrder) {
                                                  User u = uDAO.getUserById(o.getUserID());
                                                    
                                            %>
                                            <tr>
                                                <td><%= u.getUsername() %> </td>
                                                <td><%= o.getOrderDate() %></td>
                                                
                                                <% if (o.getState() == 0) {%>
                                                <td><span class="label label-danger">Wait for accept</span></td>
                                                <td><span class="badge badge-danger">0%</span></td>
                                                <% } else if (o.getState() == 1) {%>
                                                <td><span class="label label-primary">Order confirmed</span></td>
                                                <td><span class="badge badge-primary">25%</span></td>
                                                <% } else if (o.getState() == 2) {%>
                                                <td><span class="label label-warning">On The Way</span></td>
                                                <td><span class="badge badge-warning">50%</span></td>
                                                <% } else { %>
                                                <td><span class="label label-success">Success</span></td>
                                                <td><span class="badge badge-success">100%</span></td>
                                                <% } %>
                                                <td><a href="SellerControllerMap?service=orderdetail&orderid=<%= o.getOrderID() %>"><button class="btn btn-primary">Detail</button></a>
                                                </td>
                                            </tr>
                                            <% } %>
                                        </tbody>
                                    </table>
                                </div>
                            </section>


                        </div><!--end col-6 -->
                        <div class="col-md-4">
                            <section class="panel">
                                <header class="panel-heading">
                                    Big Order
                                </header>
                                    
                                <div class="panel-body table-responsive">
                                    <table class="table table-hover">
                                        <thead>
                                            <tr>
                                                <th>Order</th>
                                                <th>Total spent</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                <% 
                                   List<Order> listO = odDAO.most5BigOrder();
                                   for (Order obig : listO) {
                                           
                                %>
                                            <tr>
                                                <td><a href="SellerControllerMap?service=orderdetail&orderid=<%= obig.getOrderID() %>"><%= obig.getOrderID() %></a></td>
                                                <td><%= nf.format(obig.getTotal()) %> VND</td>
                                            </tr>
                                            <% } %>
                                        </tbody>
                                    </table>
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
    <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
    <script src="${contextPath}/js/core/popper.min.js"></script>
    <script src="${contextPath}/js/core/bootstrap.min.js"></script>
    <script src="${contextPath}/js/plugins/perfect-scrollbar.min.js"></script>
    <script src="${contextPath}/js/plugins/smooth-scrollbar.min.js"></script>
    <script src="${contextPath}/js/plugins/chartjs.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        $("textarea").on('keyup', function () {
            $(".noti").hide();
        });
        $(document).ready(function () {
        $("#category").change(function () {
        var val = $(this).val();
                $(".noti").hide();
        <% for (Category cate : listCategory) {%>
        if (val == "<%=cate.getCategoryID()%>"){
        console.log("<%=cate.getCategoryName()%>");
                $("#genre").html(
        <% ArrayList<Genre> list = genreDAO.getGenresByCategoryId(cate.getCategoryID());
            for (int i = 0; i < list.size(); i++) {
                if (list.size() == 1 || i == list.size() - 1) {%>"<option value='<%=list.get(i).getGenreID()%>'><%=list.get(i).getGenreName()%></option>"
        <%} else {%>"<option value='<%=list.get(i).getGenreID()%>'><%=list.get(i).getGenreName()%></option>" +
        <%}
            }%>);
        }
        <%}%>
        });
        });
                $(".number").on('keyup', function () {
        var n = parseInt($(this).val().replace(/\D/g, ''), 10);
                $(this).val(n.toLocaleString());
                $(".noti").hide();
        });
                (function () {
                'use strict'
                        var forms = document.querySelectorAll('.needs-validation')
                        Array.prototype.slice.call(forms)
                        .forEach(function (form) {
                        form.addEventListener('submit', function (event) {
                        if (!form.checkValidity()) {
                        event.preventDefault()
                                event.stopPropagation()
                        }
                        form.classList.add('was-validated')
                        }, false)
                        })
                })()

                var today = new Date();
                var dd = today.getDate();
                var mm = today.getMonth() + 1; //January is 0!
                var yyyy = today.getFullYear();
                if (dd < 10){
        dd = '0' + dd
        }
        if (mm < 10){
        mm = '0' + mm
        }
        today = yyyy + '-' + mm + '-' + dd;
                document.getElementById("inputDate").setAttribute("max", today);
    </script>
    <script>
                var pageNum;
                $(document).on('click', '.pagination li', function () {
        pageNum = $(this).data('repair');
                pagination();
        });
                function pagination() {
                var row = document.getElementById("maxRows").value;
                        var search = document.getElementById("search").value;
                        console.log(row);
                        console.log(search);
                        console.log(pageNum);
                        $.ajax({
                        url: "/Bmazon/SellerControllerMap",
                                type: "get",
                                data: {
                                search: search,
                                        row: row,
                                        index: pageNum,
                                        service: "pagingorder"
                                },
                                success: function (respone) {
                                var text = document.getElementById("product");
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
                var search = document.getElementById("search").value;
                $.ajax({
                url: "/Bmazon/SellerControllerMap",
                        type: "get",
                        data: {
                        search: search,
                                row: row,
                                index: pageNum,
                                service: "showpageorder"
                        },
                        success: function (respone) {
                        var text = document.getElementById("showpage");
                                text.innerHTML = respone;
                        },
                        error: function (xhr) {
                        //Do Something to handle error
                        } });
        }
    </script>
</html>