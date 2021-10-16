<%-- 
    Document   : productdetail
    Created on : Oct 16, 2021, 4:45:55 PM
    Author     : DELL
--%>

<%@page import="entity.Category"%>
<%@page import="model.GenreDAO"%>
<%@page import="model.ProductGenreDAO"%>
<%@page import="entity.Genre"%>
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
        <style type="text/css">

        </style>
    </head>

    <%
        ProductTypeDAO daopt = new ProductTypeDAO();
    CategoryDAO daocat = new CategoryDAO();
    GenreDAO genredao = new GenreDAO();
    String mess = (String) request.getAttribute("mess");
    if (mess == null) {
        mess = "";
    }
    String state = (String) request.getAttribute("state");
    if (state == null) {
        state = "";
    }
    Category category = (Category) request.getAttribute("category");
    Genre genre = (Genre) request.getAttribute("genre");
    String date = (String) request.getAttribute("date");
    String service = (String) request.getAttribute("service");
    User curUser = (User) request.getSession().getAttribute("currUser");
    ArrayList<Category> listCategory = daocat.getAllCategories();
    ArrayList<Genre> listGenre = (ArrayList<Genre>) request.getAttribute("listGenre");
    Product product = (Product) request.getAttribute("product");
    List<ProductType> listType = daopt.getProductByProductID(product.getProductID());
    DecimalFormat nf = new DecimalFormat("###,###,###");
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
                            <a href="SellerControllerMap?service=SellerDashboard">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                            </a>
                        </li>
                        <li class="active">
                            <a href="SellerControllerMap?service=productmanagement">
                                <i class="fa fa-gavel"></i> <span>Product Management</span>
                            </a>
                        </li>

                        <li>
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
                    <!-- Product management -->
                    <div class="container-fluid py-4">
                        <div class="row my-4">
                            <div class="col-lg-12 col-md-12 mb-md-0 mb-4">
                                <form id="form" class="needs-validation" novalidate="" action="/Bmazon/SellerControllerMap" method="POST">
                                    <div class="card">
                                        <div class="card-header pt-5 d-flex justify-content-between">
                                            <h3 class="m-0 font-weight-bold text-primary">General Information</h3>
                                        </div>
                                        <% if (state.equals("success")) {%>
                                        <h6 class="text-success mt-3 px-4">${mess}</h6>
                                        <%}%>
                                        <% if (state.equals("fail")) {%>
                                        <h6 class="text-danger mt-3 px-4">${mess}</h6>
                                        <%}%>
                                        <div class="card-body">
                                            <table class="table table-striped">
                                                <tr>
                                                    <td style="width: 30%;">Product Name</td>
                                                    <td style="width: 70%;"><textarea required class="form-control" name="productname"><%=product.getProductName()%></textarea></td>
                                                </tr>
                                                <tr>
                                                    <td>Category</td>
                                                    <td>
                                                        <select required name="category" style="width: 50%;" class="form-select" id="category">
                                                            <%for (Category cate : listCategory) {
                                                            %>
                                                            <option
                                                                <%if (cate.getCategoryName().equals(category.getCategoryName())) {%> selected <%}%> value="<%=cate.getCategoryID()%>"> <%=cate.getCategoryName()%>
                                                            </option>
                                                            <%}%>
                                                        </select>
                                                    </td>
                                                </tr>    
                                                <tr>
                                                    <td>Genre</td>
                                                    <td>
                                                        <select required name="genre" style="width: 50%;" class="form-select" id="genre">
                                                            <%for (Genre gen : listGenre) {
                                                            %>
                                                            <option
                                                                <%if (gen.getGenreName().equals(genre.getGenreName())) {%> selected <%}%> value="<%=gen.getGenreID()%>"> <%=gen.getGenreName()%>
                                                            </option>
                                                            <%}%>
                                                        </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Release Date</td>
                                                    <td><input required class="form-control" value="<%=product.getReleaseDate()%>" type="date" name="date" class="input"></td>
                                                </tr>
                                                <input type="hidden" value="updateproduct" name="service">
                                                <input type="hidden" value="<%=product.getProductID()%>" name="pid">
                                            </table>
                                        </div>
                                    </div>
                                    <div class="card mt-3">
                                        <div class="card-header pt-5 d-flex justify-content-between">
                                            <h3 class="m-0 font-weight-bold text-primary">Detail Information</h3>
                                        </div>
                                        <div class="card-body">
                                            <table id="productType" class="table table-borderless">
                                                <thead>
                                                    <tr>
                                                        <th style="width: 35%;">Color</th>
                                                        <th style="width: 40%;">Size</th>
                                                        <th style="width: 15%;">Price</th>
                                                        <th style="width: 5%;">Quantity</th>
                                                        <th style="width: 5%;"></th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <% for (ProductType pt : listType) {%>
                                                    <tr>
                                                        <td>
                                                            <input required style="width: 100%;" type="text" name="color" class="form-control" value="<%=pt.getColor()%>">
                                                            <input type="hidden" name="ptid" value="<%=pt.getProductTypeId()%>">
                                                        </td>
                                                        <td><input required style="width: 100%;" type="text" name="size" class="form-control" value="<%=pt.getSize()%>"></td>
                                                            <%Double price = Double.parseDouble(pt.getPrice());%>
                                                        <td><input required style="width: 100%;" type="text" name="price" class="form-control price" value="<%=nf.format(price)%>"></td>
                                                        <td><input required style="width: 100%;"  type="text" name="quantity" class="form-control" value="<%=pt.getQuantity()%>"></td>
                                                        <td>
                                                            <%if (pt.getStatus() == 1) {%>
                                                            <a class="btn btn-primary" href="AdminControllerMap?service=deleteproducttype&producttypeid=<%=pt.getProductTypeId()%>" onclick="return confirm('Are you sure you want to Remove?');">Deactive
                                                                <!--<span class="fas fa-trash-alt mt-3 ml-3 delete"></span>-->
                                                            </a>
                                                            <%} else {%>
                                                            <a class="btn btn-primary" href="AdminControllerMap?service=activeproducttype&producttypeid=<%=pt.getProductTypeId()%>" onclick="return confirm('Are you sure you want to Remove?');">Active
                                                                <!--<span class="fas fa-link mt-3 ml-3 delete"></span>-->
                                                            </a><%}%>
                                                        </td>
                                                    </tr>
                                                    <%}%>
                                                </tbody>
                                            </table>
                                            <div class="d-flex justify-content-center">
                                                
                                            <a href="SellerControllerMap?service=productmanagement"><btn class="btn btn-primary">Back</btn></a>
                                                <input type="submit" value="Update Product" class="btn btn-primary mt-3">
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
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
                                                                            service: "pagingproduct"
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
                                                                            service: "showpageproduct"
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