<%-- 
    Document   : galleryDetail
    Created on : Nov 16, 2021, 10:53:08 AM
    Author     : Admin
--%>

<%@page import="model.SellerDAO"%>
<%@page import="entity.Seller"%>
<%@page import="model.ProductDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Gallery"%>
<%@page import="model.GalleryDAO"%>
<%@page import="entity.WareHouse"%>
<%@page import="model.WareHouseDAO"%>
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
            .modal .modal-dialog {
                max-width: 400px;
            }
            .modal .modal-header, .modal .modal-body, .modal .modal-footer {
                padding: 20px 30px;
            }
            .modal .modal-content {
                border-radius: 3px;
            }
            .modal .modal-footer {
                background: #ecf0f1;
                border-radius: 0 0 3px 3px;
            }
            .modal .modal-title {
                display: inline-block;
            }
            .modal .form-control {
                border-radius: 2px;
                box-shadow: none;
                border-color: #dddddd;
            }
            .modal textarea.form-control {
                resize: vertical;
            }
            .modal .btn {
                border-radius: 2px;
                min-width: 100px;
            }	
            .modal form label {
                font-weight: normal;
            }
            .imgho{
                width: 250px; 
                height: 150px; 
            }
            .imgho:hover{
                opacity: 0.7;
                cursor: pointer;
            }
        </style>
    </head>

    <%
        ProductTypeDAO ptDAO = new ProductTypeDAO();
        CategoryDAO cateDAO = new CategoryDAO();
        GenreDAO genreDAO = new GenreDAO();
        WareHouseDAO whDAO = new WareHouseDAO();
        GalleryDAO galleryDAO = new GalleryDAO();
        ProductDAO pDAO = new ProductDAO();
        SellerDAO sellerDAO = new SellerDAO();
        String mess = (String) request.getAttribute("mess");
        if (mess == null) {
            mess = "";
        }
        String state = (String) request.getAttribute("state");
        if (state == null) {
            state = "";
        }
        User curUser = (User) request.getSession().getAttribute("currUser");
        String userID = curUser.getUserId();
        Seller seller = sellerDAO.getSellerByUserID(Integer.parseInt(userID));
        int sellerID = seller.getSellerID();

        int index = (Integer) request.getAttribute("index");
        int totalPage = (Integer) request.getAttribute("totalPage");
        int prev = index == 1 ? 1 : index - 1;
        int next = index == totalPage ? totalPage : index + 1;

        DecimalFormat nf = new DecimalFormat("###,###,###");
        ProductType pt = (ProductType) request.getAttribute("producttype");
        String ptypeID = pt.getProductTypeId();
        Product product = pDAO.getProductByPtypeID(ptypeID);
        List<Gallery> listGallery = (List<Gallery>) request.getAttribute("listGallery");
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
                        <li class="active">
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
                        <li>
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
                    <div>
                        <section class="panel">
                            <div class="card">
                                <div class="card-header pt-5 d-flex justify-content-between">
                                    <h3 class="m-0 font-weight-bold text-primary">General Information</h3>
                                </div>
                                <div class="card-body">
                                    <table class="table table-striped">
                                        <tr>
                                            <td style="width: 200px;">Product Name</td>
                                            <td><textarea readonly="" style="width: 500px;" required class="form-control" name="productname"><%=product.getProductName()%></textarea></td>
                                        </tr>
                                        <tr>
                                            <td>Color</td>
                                            <td><input readonly="" value="<%= pt.getColor()%>">
                                        </tr>    
                                        <tr>
                                            <td>Size</td>
                                            <td><input readonly="" value="<%= pt.getSize()%>">
                                        </tr>
                                        <tr>
                                            <td>Price</td>
                                            <td><input readonly="" value="<%= pt.getPrice()%>">
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <!--                            <header class="panel-heading">
                                                            Product in shop
                                                        </header>-->
                            <div class="panel-body table-responsive">
                                <%
                                    for (Gallery g : listGallery) {
                                %>
                                <form enctype="multipart/form-data" class="form" action="/Bmazon/SellerControllerMap?service=updategallery&galleryid=<%=g.getGalleryID()%>" method="POST">
                                    <table class="table table-hover" id="dataTable">
                                        <thead>
                                            <tr>
                                                <th style="width: 200px;"></th>
                                                <th style="width: 50px;"></th>
                                            </tr>
                                        </thead>
                                        <tr>                                        
                                            <td>
                                                <label class="imgho" for="file">
                                                    <img id="img" src="images/<%=g.getLink()%>" width="150px" height="120px"> 
                                                    <input required accept="image/*" onchange="loadFile(event)" id="file" type="file" name="photo" style="display: none;">
                                                </label>
                                            </td>
                                            <td><div>
                                                    <!--<input type="hidden" value="updategallery" name="service">-->
                                                    <input type="submit" value="Update Gallery" class="btn btn-primary">
                                                    <% if (g.getStatus() == 1) {%>
                                                    <a href="SellerControllerMap?service=deactivegallery&galleryid=<%=g.getGalleryID()%>" onclick="return confirm('Are you sure?');" class="btn btn-danger">Deactive</a>
                                                    <%} else {%>
                                                    <a href="SellerControllerMap?service=activegallery&galleryid=<%=g.getGalleryID()%>" onclick="return confirm('Are you sure?');" class="btn btn-success">Active</a>
                                                    <%}%>
                                                </div></td>
                                        </tr>
                                    </table>
                                </form>
                                <% } %>
                            </div>
                            <!--                            <div class="pagination-container mt-4" style="display: flex;
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
                            <% }%>
                        </nav>
                    </div>-->
                        </section>


                    </div><!--end col-6 -->
                    <!--                    <div class="col-md-3">
                                            <section class="panel">
                                                <header class="panel-heading">
                                                    Hot products
                                                </header>
                                                <div class="panel-body">
                                                </div>
                                            </section>
                                        </div>-->

                    <!-- row end -->
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
                                                        var loadFile = function (event) {
                                                            var output = document.getElementById('img');
                                                            img.src = URL.createObjectURL(event.target.files[0]);
                                                            img.onload = function () {
                                                                URL.revokeObjectURL(img.src)
                                                            }
                                                        };
    </script>
    <script>


        var pageNum;
        $(document).on('click', '.pagination li', function () {
            pageNum = $(this).data('repair');
            pagination();
        });
        function pagination() {
            console.log(pageNum);
            $.ajax({
                url: "/Bmazon/SellerControllerMap",
                type: "get",
                data: {
                    index: pageNum,
                    service: "paginggallery"
                },
                success: function (respone) {
                    var text = document.getElementById("producttype");
                    text.innerHTML = respone;
                    showpage();
                },
                error: function (xhr) {
                    //Do Something to handle error
                }
            });
        }
        function showpage() {
            $.ajax({
                url: "/Bmazon/SellerControllerMap",
                type: "get",
                data: {
                    index: pageNum,
                    service: "showpagegallery"
                },
                success: function (respone) {
                    var text = document.getElementById("showpage");
                    text.innerHTML = respone;
                },
                error: function (xhr) {
                    //Do Something to handle error
                }});
        }
    </script>
</html>
