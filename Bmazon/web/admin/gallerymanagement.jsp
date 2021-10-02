<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    ProductDAO productdao = new ProductDAO();
    ProductTypeDAO producttypedao = new ProductTypeDAO();
    User curUser = (User) request.getSession().getAttribute("currUser");
    List<Gallery> listGallery = (List<Gallery>) request.getAttribute("listGallery");
%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="../assets/img/favicon.png">
        <title>
            Admin Dashboard
        </title>
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
        <!-- Font Awesome Icons -->
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
        <!-- CSS Files -->
        <link id="pagestyle" href="${contextPath}/css/soft-ui-dashboard.css?v=1.0.3" rel="stylesheet" />
    </head>

    <body class="g-sidenav-show  bg-gray-100">
        <aside class="sidenav navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-3 " id="sidenav-main">
            <div class="sidenav-header">
                <i class="fas fa-times p-3 cursor-pointer text-secondary opacity-5 position-absolute end-0 top-0 d-none d-xl-none" aria-hidden="true" id="iconSidenav"></i>
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${contextPath}/HomePageControllerMap">
                    <div class="sidebar-brand-icon">
                        <img  width="124" height="75" src="${contextPath}/images/fpt.png" class="header-logo-dark" />
                    </div>
<!--                    <div class="sidebar-brand-text mx-3 my-3">Bmazon</div>-->
                </a>
            </div>
            <hr class="horizontal dark mt-0">
            <!--            collapse navbar-collapse w-auto max-height-vh-100 h-100-->
            <div class="" id="sidenav-collapse-main">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="AdminControllerMap">
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="fas fa-fw fa-tachometer-alt" style="color: black"></i>
                            </div>
                            <span class="nav-link-text ms-1">Dashboard</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="AdminControllerMap?service=usermanagement">
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="fas fa-users" style="color: black"></i>
                            </div>
                            <span class="nav-link-text ms-1">User Management</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link  " href="AdminControllerMap?service=productmanagement">
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="fas fa-layer-group" style="color: black"></i>
                            </div>
                            <span class="nav-link-text ms-1 ">Product Management</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link  " href="AdminControllerMap?service=companymanagement">
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="far fa-building" style="color: black"></i>
                            </div>
                            <span class="nav-link-text ms-1">Company Management</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active " href="AdminControllerMap?service=gallerymanagement">
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="far fa-images"></i>
                            </div>
                            <span class="nav-link-text ms-1">Gallery Management</span>
                        </a>
                    </li>
                </ul>
            </div>
        </aside>
        <main class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
            <!-- Navbar -->
            <jsp:include page="adminheader.jsp"></jsp:include>
            <!-- End Navbar -->
            <div class="container-fluid py-4">
                <div class="row my-4">
                    <div class="col-lg-12 col-md-12 mb-md-0 mb-4">
                        <div class="card">
                            <div class="card-body px-0 pb-2">
                                <div class="card-header py-3" 
                                     style="display: flex;
                                     justify-content: space-between;">
                                    <h6 class="m-0 font-weight-bold text-primary">Gallery Management</h6>
                                    <a href="AdminControllerMap?service=addgallerydetail">
                                        <button class="btn btn-primary">Add new gallery</button></a>
                                </div>
                                <div class="card-body">
                                    <div class="table_head py-3" style="display: flex;
                                         justify-content: space-between;">
                                        <div class="rowNum">
                                            <h6 style="display: inline">Select number of Rows</h6>
                                            <div class="form-group" style="display: inline;">
                                                <select name="state" id="maxRows" class="form-control" style="width:80px;display:inline;">
                                                    <option value="5">5</option>
                                                    <option value="10">10</option>
                                                    <option value="20">20</option>
                                                    <option value="5000">Show All</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="tb_search">
                                            <input style="width: 100%;" type="text" oninput="searchByName(this)" placeholder="Search.." class="form-control">
                                        </div>
                                    </div>
                                    <table id="dataTable" style="table-layout: fixed;width: 100%;text-align: center;">
                                        <thead>
                                            <tr>
                                                <th style="width: 30%">Product Name</th>
                                                <th style="width: 15%">Color</th>
                                                <th style="width: 15%">Size</th>
                                                <th style="width: 30%">Image</th>
                                                <th style="width: 5%"></th>
                                                <th style="width: 5%"></th>
                                            </tr>
                                        </thead>
                                        <tbody id="gallery">
                                            <%for (Gallery gallery : listGallery) {
                                            Product product = productdao.getProductByID(gallery.getProductID());
                                            ProductType producttype = producttypedao.getProductTypeByPTypeID(gallery.getProductTypeID());
                                            %>
                                            <tr>
                                                <td><%=product.getProductName() %></td>
                                                <td><%=producttype.getColor() %></td>
                                                <td><%=producttype.getSize() %></td>
                                                <%String str = "images/"+gallery.getLink();%>
                                                <td><img src="<%=str%>" width="100px" height="100px"></td>
                                                <td>
                                                    <a href="AdminControllerMap?service=updategallerydetail&galleryid=<%=gallery.getGalleryID()%>"><span class="fas fa-edit"></span></a>
                                                </td>
                                                <td><a href="AdminControllerMap?service=deletegallery&galleryid=<%=gallery.getGalleryID()%>" onclick="return confirm('Are you sure you want to Remove?');"><span class="fas fa-trash-alt"></span></a></td>
                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                    <div class="pagination-container mt-4" style="display: flex;
                                         justify-content: space-around;cursor: pointer;">
                                        <nav>
                                            <ul class="pagination">
<!--                                                <li data-page="first" class="page-item">
                                                    <a class="page-link" aria-label="Previous">
                                                        <span aria-hidden="true"><i class="fas fa-backward"></i>
                                                            <span class="sr-only">(current)</span> 
                                                        </span>
                                                    </a>
                                                </li>-->
                                                <li data-page="prev" class="page-item">
                                                    <a class="page-link" aria-label="Previous">
                                                        <span aria-hidden="true"><i class="fas fa-arrow-left"></i>
                                                            <span class="sr-only">(current)</span> 
                                                        </span>
                                                    </a>
                                                </li>
                                                <li data-page="next" class="page-item" id="next">
                                                    <a class="page-link" aria-label="Next">
                                                        <span aria-hidden="true"><i class="fas fa-arrow-right"></i>
                                                            <span class="sr-only">(current)</span> 
                                                        </span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </nav>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!--   Core JS Files   -->
        <script src="${contextPath}/js/core/popper.min.js"></script>
        <script src="${contextPath}/js/core/bootstrap.min.js"></script>
        <script src="${contextPath}/js/plugins/perfect-scrollbar.min.js"></script>
        <script src="${contextPath}/js/plugins/smooth-scrollbar.min.js"></script>
        <script src="${contextPath}/js/plugins/chartjs.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="${contextPath}/js/tablepagination.js"></script>
        <script>
            function searchByName(param) {
                var txtSearch = param.value;
                $.ajax({
                    url: "/Bmazon/AdminControllerMap",
                    type: "get",
                    data: {
                        search: txtSearch,
                        service: "searchgallery"
                    },
                    success: function (respone) {
                        var text = document.getElementById("gallery");
                        text.innerHTML = respone;
                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                });
            }
        </script>
        <!-- Github buttons -->
        <script async defer src="https://buttons.github.io/buttons.js"></script>
        <!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<!--        <script src="${contextPath}/js/soft-ui-dashboard.min.js?v=1.0.3"></script>-->
    </body>

</html>