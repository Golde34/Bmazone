<%-- 
    Document   : gallerySeller
    Created on : Nov 9, 2021, 2:47:05 PM
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
        ArrayList<ProductType> listPT = (ArrayList<ProductType>) request.getAttribute("listProductType");
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
                                            <th style="width: 50px;">Product Name</th>
                                            <th style="width: 50px;">Color</th>
                                            <th style="width: 50px;">Size</th>
                                            <th style="width: 50px;">Price</th>
                                            <th style="width: 50px;">Quantity</th>
                                            <th style="width: 50px;"></th>
                                        </tr>
                                    </thead>
                                    <tbody id="product">
                                        <%
                                            for (ProductType ptype : listPT) {
                                                String ptypeID = ptype.getProductTypeId();
                                                Product product = pDAO.getProductByPtypeID(sellerID, ptypeID);
                                        %>
                                        <tr>
                                            <td><div><%= product.getProductName()%></div></td>
                                            <td><div><%= ptype.getColor()%></div></td>
                                            <td><div><%= ptype.getSize()%></div></td>
                                            <%Double price = Double.parseDouble(ptype.getPrice());%>
                                            <td><div><%=nf.format(price)%></div></td>
                                            <td><div><%= ptype.getQuantity()%></div></td>
                                            <td><div><a href="SellerControllerMap?service=gallerydetail&ptypeid=<%=ptypeID%>"><button class="btn btn-primary">Edit</button></a>
                                                </div></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <%
                                                    List<Gallery> listGallery = galleryDAO.getAllImageByProductTypeID(ptype.getProductTypeId());
                                                    for (Gallery gallery : listGallery) {
                                                %>
                                                    <img id="img" src="images/<%=gallery.getLink()%>" width="125px" height="100px">
                                            </td>
                                            <% } %>
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
                                    <% }%>
                                </nav>
                            </div>
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
    <script>
        $("textarea").on('keyup', function () {
            $(".noti").hide();
        });
        $(document).ready(function () {
            $("#category").change(function () {
                var val = $(this).val();
                $(".noti").hide();

            });
        });
        $(".number").on('keyup', function () {
            var n = parseInt($(this).val().replace(/\D/g, ''), 10);
            $(this).val(n.toLocaleString());
            $(".noti").hide();
        });
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; //January is 0!
        var yyyy = today.getFullYear();
        if (dd < 10) {
            dd = '0' + dd
        }
        if (mm < 10) {
            mm = '0' + mm
        }
        today = yyyy + '-' + mm + '-' + dd;
        document.getElementById("inputDate").setAttribute("max", today);

    </script>
</html>
