<%-- 
    Document   : orderdetail
    Created on : Oct 28, 2021, 11:33:08 PM
    Author     : Admin
--%>

<%@page import="model.OrderDetailDAO"%>
<%@page import="entity.Gallery"%>
<%@page import="model.GalleryDAO"%>
<%@page import="model.WareHouseDAO"%>
<%@page import="model.GenreDAO"%>
<%@page import="model.CategoryDAO"%>
<%@page import="model.ProductTypeDAO"%>
<%@page import="entity.User"%>
<%@page import="entity.Category"%>
<%@page import="entity.Genre"%>
<%@page import="entity.ProductType"%>
<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seller | Order Detail</title>
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
    </head>
    <body class="skin-black">
        <%
            ProductTypeDAO daopt = new ProductTypeDAO();
            CategoryDAO daocat = new CategoryDAO();
            GenreDAO genredao = new GenreDAO();
            WareHouseDAO whdao = new WareHouseDAO();
            GalleryDAO gallerydao = new GalleryDAO();
            OrderDetailDAO oddao = new OrderDetailDAO();

            Category category = (Category) request.getAttribute("category");
            Genre genre = (Genre) request.getAttribute("genre");
            User curUser = (User) request.getSession().getAttribute("currUser");

            ArrayList<Category> listCategory = daocat.getAllCategories();
            Product product = (Product) request.getAttribute("product");
            DecimalFormat nf = new DecimalFormat("###,###,###");
            ArrayList<ProductType> listPT = (ArrayList<ProductType>) request.getAttribute("listProductType");
        %>
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
                        <li class="active"><!-- class="tablinks" -->
                            <!--<a href="" onclick="openObject(event, 'Dashboard')">-->
                            <a href="SellerControllerMap?service=SellerDashboard">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                            </a>
                        </li>
                        <li>
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
                <section class="content">
                    <!-- Main row -->
                    <!-- Product management -->
                    <div class="container-fluid py-4">
                        <div class="row my-4">
                            <div class="col-lg-12 col-md-12 mb-md-0 mb-4">
                                <div class="card">
                                    <div class="card-header pt-5 d-flex justify-content-between">
                                        <h3 class="m-0 font-weight-bold text-primary">Product Information</h3>
                                    </div>
                                    <div class="card-body">
                                        <table class="table table-striped">
                                            <tr>
                                                <td style="width: 200px;">Product Name</td>
                                                <td><input readonly="" value="<%=product.getProductName()%>"></td>
                                            </tr>
                                            <tr>
                                                <td>Category</td>
                                                <td><input readonly="" value="<%=category.getCategoryName()%>">
                                                </td>
                                            </tr>    
                                            <tr>
                                                <td>Genre</td>
                                                <td><input readonly="" value="<%=genre.getGenreName()%>">
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Release Date</td>
                                                <td><input readonly="" value="<%=product.getReleaseDate()%>"></td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                                <div class="card mt-3">
                                    <div class="card-header pt-5 d-flex justify-content-between">
                                        <h3 class="m-0 font-weight-bold text-primary">Detail Information</h3>
                                    </div>
                                    <div class="card-body">
                                        <table id="dataTable" class="table table-borderless">
                                            <thead>
                                                <tr>
                                                    <th style="width: 50px;"></th>
                                                    <th style="width: 50px;"></th>
                                                    <th style="width: 30px;"></th>
                                                    <th style="width: 100px;"></th>
                                                    <th style="width: 30px;"></th>
                                                    <th style="width: 100px;"></th>
                                                    <th style="width: 30px;"></th>
                                                    <th style="width: 100px;"></th>
                                                </tr>
                                            </thead>
                                            <tbody id="producttype">
                                                <% for (ProductType ptype : listPT) {%>
                                                <tr>
                                                    <td style="width: 90px;"><label>Color</label></td>
                                                    <td><%=ptype.getColor()%></td>

                                                    <td><label>Size</label></td>
                                                    <td><%=ptype.getSize()%></td>
                                                    <%
                                                        Double price = Double.parseDouble(ptype.getPrice());
                                                        int sold = oddao.sumSoldProductTypeByPtypeID(ptype.getProductTypeId());

                                                    %>

                                                    <td><label>Price</label></td>
                                                    <td><%=nf.format(price)%></td>

                                                    <td><label>Sold</label></td>
                                                    <td><%= sold%></td>
                                                    <td>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><label>Image</label></td>
                                                    <td>
                                                        <%
                                                            List<Gallery> listGallery = gallerydao.getAllImageByProductTypeID(ptype.getProductTypeId());
                                                            for (Gallery gallery : listGallery) {
                                                        %>

                                                        <label style="width: 250px;height: 150px;" for="file">
                                                            <img id="img" src="images/<%=gallery.getLink()%>">
                                                        </label>
                                                    </td>
                                                    <% } %>
                                                </tr>
                                                <% }%>
                                            </tbody>
                                        </table>

                                        <a href="SellerControllerMap"><btn class="btn btn-default">Back</btn></a>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </section>
                </body>

                <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
                </html>
