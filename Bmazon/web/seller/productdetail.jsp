<%-- 
    Document   : productdetail
    Created on : Oct 16, 2021, 4:45:55 PM
    Author     : DELL
--%>

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
        ProductTypeDAO daopt = new ProductTypeDAO();
        CategoryDAO daocat = new CategoryDAO();
        GenreDAO genredao = new GenreDAO();
        WareHouseDAO whdao = new WareHouseDAO();
        GalleryDAO gallerydao = new GalleryDAO();
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
        int index = (Integer) request.getAttribute("index");
        int totalPage = (Integer) request.getAttribute("totalPage");
        int prev = index == 1 ? 1 : index - 1;
        int next = index == totalPage ? totalPage : index + 1;

        List<WareHouse> listWh = whdao.getAllWareHouse();
        ArrayList<Category> listCategory = daocat.getAllCategories();
        ArrayList<Genre> listGenre = (ArrayList<Genre>) request.getAttribute("listGenre");
        Product product = (Product) request.getAttribute("product");
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
                        <li class="active">
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

                <!-- Main content -->
                <section class="content">
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
                                        <h6 class="text-success px-4 noti">${mess}</h6>
                                        <%}%>
                                        <% if (state.equals("fail")) {%>
                                        <h6 class="text-danger px-4 noti">${mess}</h6>
                                        <%}%>
                                        <div class="card-body">
                                            <table class="table table-striped">
                                                <tr>
                                                    <td style="width: 200px;">Product Name</td>
                                                    <td><textarea style="width: 500px;" required class="form-control" name="productname"><%=product.getProductName()%></textarea></td>
                                                </tr>
                                                <tr>
                                                    <td>Category</td>
                                                    <td>
                                                        <select required name="category" style="width: 150px;" class="form-select" id="category">
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
                                                        <select required name="genre" style="width: 150px;" class="form-select" id="genre">
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
                                                    <td><input style="width: 200px;" max="2000-01-01" id="inputDate" required class="form-control" value="<%=product.getReleaseDate()%>" type="date" name="date"></td>
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
                                                        <th style="width: 150px;"></th>
                                                        <th style="width: 150px;"></th>
                                                        <th style="width: 150px;"></th>
                                                        <th style="width: 150px;"></th>
                                                        <th style="width: 150px;"></th>
                                                        <th style="width: 150px;"></th>
                                                        <th style="width: 150px;"></th>
                                                        <th style="width: 150px;"></th>
                                                    </tr>
                                                </thead>
                                                <tbody id="producttype">
                                                    <% for (ProductType ptype : listPT) {%>
                                                    <tr>
                                                        <td><label>Color</label></td>
                                                        <td>
                                                            <input required style="width: 100px;" type="text" name="color" class="form-control" value="<%=ptype.getColor()%>">
                                                            <input type="hidden" name="ptid" value="<%=ptype.getProductTypeId()%>">
                                                        </td>
                                                        <td><label>Size</label></td>
                                                        <td><input required style="width: 100px;" type="text" name="size" class="form-control" value="<%=ptype.getSize()%>"></td>
                                                            <%Double price = Double.parseDouble(ptype.getPrice());%>

                                                        <td><label>Price</label></td>
                                                        <td><input required style="width: 100px;" type="text" name="price" pattern="[0-9]+" title="please enter number only" class="form-control number" value="<%=nf.format(price)%>"></td>

                                                        <td><label>Quantity</label></td>
                                                        <td><input required style="width: 100px;"  type="text" name="quantity" pattern="[0-9]+" title="please enter number only" class="form-control number" value="<%=ptype.getQuantity()%>"></td>
                                                        <td>
                                                            <%if (ptype.getStatus() == 1) {%>
                                                            <a class="btn btn-danger" href="SellerControllerMap?service=deactiveproducttype&producttypeid=<%=ptype.getProductTypeId()%>&productid=<%= product.getProductID()%>" onclick="return confirm('Are you sure?');">Deactive
                                                                <!--<span class="fas fa-trash-alt mt-3 ml-3 delete"></span>-->
                                                            </a>
                                                            <%} else {%>
                                                            <a class="btn btn-success" href="SellerControllerMap?service=activeproducttype&producttypeid=<%=ptype.getProductTypeId()%>&productid=<%= product.getProductID()%>" onclick="return confirm('Are you sure?');">Active
                                                                <!--<span class="fas fa-link mt-3 ml-3 delete"></span>-->
                                                            </a><%}%>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><label>Image</label></td>
                                                        <%
                                                            List<Gallery> listGallery = gallerydao.getAllImageByProductTypeID(ptype.getProductTypeId());
                                                            for (Gallery gallery : listGallery) {
                                                        %>
                                                        <td>
                                                            <img src="images/<%=gallery.getLink()%>" width="150px" height="120px">
                                                        </td>
                                                        <% } %>
                                                    </tr>
                                                    <% } %>
                                                </tbody>
                                            </table>
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
                                            <a href="#addEmployeeModal" data-toggle="modal"><btn class="btn btn-success">Add</btn></a>
                                            <div class="d-flex justify-content-center">
                                                <input type="hidden" value="updateproductdetail" name="service">
                                                <input type="hidden" value="<%=product.getProductID()%>" name="pid">
                                                <input type="submit" value="Save" class="btn btn-primary mt-3" style="margin-left: 45%"> <br>
                                                <a href="SellerControllerMap?service=productmanagement"><btn class="btn btn-default">Back</btn></a>
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
    <div id="addEmployeeModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="/Bmazon/SellerControllerMap" method="post">
                    <div class="modal-header">						
                        <h4 class="modal-title">Add Product Type</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">					
                        <div class="form-group">
                            <label>Color</label>
                            <input name="color" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Size</label>
                            <input name="size" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Price</label>
                            <input name="price" type="text" pattern="[0-9]+" title="please enter number only" class="form-control number" required>
                        </div>
                        <div class="form-group">
                            <label>Quantity</label>
                            <input name="quantity" type="text" pattern="[0-9]+" title="please enter number only" class="form-control number" required>
                        </div>
                        <div class="form-group">
                            <label>Warehouse</label> <br>
                            <select required name="warehouse" style="width: 50%;" class="form-select" id="warehouse">
                                <%for (WareHouse wh : listWh) {
                                %>
                                <option value="<%= wh.getWareHouseID()%>"><%= wh.getWareHouseAddress()%>
                                </option>
                                <% }%>
                            </select>
                        </div>

<!--                        <div class="form-group">
                            <div class="wrapper">
                                <div class="image">
                                    <img src="">
                                </div>
                                <div class="file-name">
                                    File name here
                                </div>
                            </div>
                            <input id="default-btn" type="file" hidden class="form-control" name="photo" placeholder="Enter photo">
                        </div>-->


                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                        <input type="hidden" value="addproducttype" name="service">
                        <input type="hidden" value="<%= product.getProductID()%>" name="proID">
                        <input type="submit" class="btn btn-success" value="Add">
                    </div>
                </form>
            </div>
        </div>
    </div>
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
                    service: "pagingproducttype",
                    productid: "<%= product.getProductID()%>"
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
                    service: "showpageproducttype",
                    productid: "<%= product.getProductID()%>"
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
        <% for (Category cate : listCategory) {%>
        if (val == "<%=cate.getCategoryID()%>"){
        console.log("<%=cate.getCategoryName()%>");
                $("#genre").html(
        <% ArrayList<Genre> list = genredao.getGenresByCategoryId(cate.getCategoryID());
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
</html>