<%-- 
    Document   : orderSeller
    Created on : Sep 30, 2021, 2:15:00 PM
    Author     : DELL
--%>

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

        ArrayList<Category> listCategory = cateDAO.getAllCategories();
        ArrayList<Genre> listGenre = genreDAO.getAllGenres();
        int index = (Integer) request.getAttribute("index");
        int totalPage = (Integer) request.getAttribute("totalPage");
        int prev = index == 1 ? 1 : index - 1;
        int next = index == totalPage ? totalPage : index + 1;
        User curUser = (User) request.getSession().getAttribute("currUser");
        ArrayList<Product> listP = (ArrayList<Product>) request.getAttribute("listProduct");
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
                                <!--                            <header class="panel-heading">
                                                                Product in shop
                                                            </header>-->
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
                                                <th style="width: 30%;height: 50px;">Product Name</th>
                                                <th style="width: 10%;height: 50px;">Rating</th>
                                                <th style="width: 10%;height: 50px;">Type</th>
                                                <th style="width: 10%;height: 50px;">Genre</th>
                                                <th style="width: 10%;height: 50px;">Action</th>
                                                <th style="width: 10%;height: 50px;">Sold</th>
                                            </tr>
                                        </thead>
                                        <tbody id="product">
                                            <% for (Product product : listP) {
                                                    int proID = product.getProductID();
                                                    String genreid = pgdao.getGenreIdByProductId(product.getProductID());
                                                    Genre genre = genreDAO.getGenreById(Integer.parseInt(genreid));
                                            %>
                                            <tr>
                                                <td><div><%= product.getProductName()%></div></td>
                                                <td><div><%= product.getRating() %>/10</div></td>
                                                <td><div><%= cateDAO.getCategoryById(pcDAO.getProductCateByProductID(proID).getCategoryID())%></div></td>
                                                <td><div><%= genre.getGenreName()%></div></td>
                                                <td><div><a href="SellerControllerMap?service=orderdetail&productid=<%= product.getProductID()%>"><button class="btn btn-primary">Detail</button></a>
                                                    </div></td>
                                                <td>
                                                    <div>10 sold</div>
                                                </td></tr>
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
                for (int i = 0; i < list    .size(); i++) {
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