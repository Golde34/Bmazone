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
        List<Order> listO = (ArrayList<Order>) request.getAttribute("listOrder");

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
                        <li class="active">
                            <a href="SellerControllerMap?service=ordermanagement">
                                <i class="fa fa-globe"></i> <span>Order Management</span>
                            </a>
                        </li>
                        <li>
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
                                <div class="table_head py-3" style="display: flex;
                                 justify-content: space-between;">
                                <div class="rowNum">
                                    <h6 style="display: inline">Select number of Rows</h6>
                                    <div class="form-group" style="display: inline;">
                                        <select onchange="pagination()" name="state" id="maxRows" class="form-control" style="width:80px;display:inline;">
                                            <option value="5">5</option>
                                            <option value="10">10</option>
                                            <option value="20">20</option>
                                            <option value="5000">Show All</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="tb_search">
                                    <input id="search" style="width: 100%;" type="text" oninput="pagination()" placeholder="Search.." class="form-control">
                                </div>
                            </div>
                                <div class="panel-body table-responsive">
                                    <table class="table table-hover" id="dataTable">
                                        <thead>
                                            <tr>
                                                <th>Customer</th>
                                                <th>Order date</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody id="order">
                                            <%
                                                for (Order o : listO) {
                                                    User u = uDAO.getUserById(o.getUserID());
                                            %>
                                            <tr>
                                                <td><%= u.getUsername()%> </td>
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
                                                <td><a href="SellerControllerMap?service=orderdetail&orderid=<%= o.getOrderID()%>"><button class="btn btn-primary">Detail</button></a>
                                                </td>
                                            </tr>
                                            <% } %>
                                        </tbody>
                                    </table>
                                </div>

                                <div class="pagination-container mt-4" style="display: flex;
                                     justify-content: space-around;cursor: pointer;">
                                    <nav>
                                        <%if (totalPage > 1) {%>
                                        <ul class="pagination" id="showpage">
                                            <li data-repair="1" class="page-item">
                                                <a class="page-link" aria-label="First">
                                                    <span aria-hidden="true"><i class="fas fa-backward"></i>
                                                        <span class="sr-only">(current)</span> 
                                                    </span>
                                                </a>
                                            </li>
                                            <li data-repair="<%=prev%>" class="page-item">
                                                <a class="page-link" aria-label="Previous">
                                                    <span aria-hidden="true"><i class="fas fa-arrow-left"></i>
                                                        <span class="sr-only">(current)</span> 
                                                    </span>
                                                </a>
                                            </li>
                                            <%int limit = totalPage > 5 ? 5 : totalPage;%>
                                            <%for (int i = 1; i <= limit; i++) {%>
                                            <%if (index == i) {%>
                                            <li  class="page-item active" data-repair="<%=i%>">
                                            <%} else {%><li  class="page-item" data-repair="<%=i%>"> <%}%>
                                                <a class="page-link">
                                                    <div class="index"><%=i%></div>
                                                    <span class="sr-only">(current)</span>
                                                </a>
                                            </li>
                                            <%}%>
                                            <li data-repair="<%=next%>" class="page-item">
                                                <a class="page-link" aria-label="Next">
                                                    <span aria-hidden="true"><i class="fas fa-arrow-right"></i>
                                                        <span class="sr-only">(current)</span> 
                                                    </span>
                                                </a>
                                            </li>
                                            <li data-repair="<%=totalPage%>" class="page-item">
                                                <a class="page-link" aria-label="Last">
                                                    <span aria-hidden="true"><i class="fas fa-forward"></i>
                                                        <span class="sr-only">(current)</span> 
                                                    </span>
                                                </a>
                                            </li>
                                        </ul>
                                        <%}%>
                                    </nav>
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
                                                List<Order> listObig = odDAO.most5BigOrder();
                                                for (Order obig : listObig) {

                                            %>
                                            <tr>
                                                <td><a href="SellerControllerMap?service=orderdetail&orderid=<%= obig.getOrderID()%>"><%= obig.getOrderID()%></a></td>
                                                <td><%= nf.format(obig.getTotal())%> VND</td>
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