<%@page import="model.UserDAO"%>
<%@page import="model.ProductTypeDAO"%>
<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    UserDAO userdao = new UserDAO();
    ProductTypeDAO producttypedao = new ProductTypeDAO();
    User curUser = (User) request.getSession().getAttribute("currUser");
    ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("listProduct");
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
        <!-- Nucleo Icons -->
        <link href="${contextPath}/css/nucleo-icons.css" rel="stylesheet" />
        <link href="${contextPath}/css/nucleo-svg.css" rel="stylesheet" />
        <!-- Font Awesome Icons -->
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
        <link href="${contextPath}/css/nucleo-svg.css" rel="stylesheet" />
        <!-- CSS Files -->
        <link id="pagestyle" href="${contextPath}/css/soft-ui-dashboard.css?v=1.0.3" rel="stylesheet" />
    </head>
    <style>
        th,td{
            padding: 12px 15px;
        }
        tbody tr:nth-of-type(even){
            background-color: #f2f2f2;
        }
    </style>
    <body class="g-sidenav-show  bg-gray-100">
        <aside class="sidenav navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-3 " id="sidenav-main">
            <div class="sidenav-header">
                <i class="fas fa-times p-3 cursor-pointer text-secondary opacity-5 position-absolute end-0 top-0 d-none d-xl-none" aria-hidden="true" id="iconSidenav"></i>
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${contextPath}/HomePageControllerMap">
                    <div class="sidebar-brand-icon">
                        <i class="fab fa-blogger"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3 my-3">Bmazon</div>
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
                                <i class="fas fa-fw fa-tachometer-alt" style="color: black"></i>
                            </div>
                            <span class="nav-link-text ms-1">User Management</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active " href="AdminControllerMap?service=productmanagement">
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="fas fa-fw fa-tachometer-alt " ></i>
                            </div>
                            <span class="nav-link-text ms-1 ">Product Management</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link  " href="AdminControllerMap?service=companymanagement">
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="fas fa-fw fa-tachometer-alt" style="color: black"></i>
                            </div>
                            <span class="nav-link-text ms-1">Company Management</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link  " href="AdminControllerMap?service=gallerymanagement">
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="fas fa-fw fa-tachometer-alt" style="color: black"></i>
                            </div>
                            <span class="nav-link-text ms-1">Gallery Management</span>
                        </a>
                    </li>
                </ul>
            </div>
        </aside>
        <main class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
            <!-- Navbar -->
            <nav class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl" id="navbarBlur" navbar-scroll="true">
                <div class="container-fluid py-1 px-3">
                    <nav aria-label="breadcrumb">
                        <li class="nav-item d-xl-none ps-3 d-flex align-items-center">
                            <a href="javascript:;" class="nav-link text-body p-0" id="iconNavbarSidenav">
                                <div class="sidenav-toggler-inner">
                                    <i class="sidenav-toggler-line"></i>
                                    <i class="sidenav-toggler-line"></i>
                                    <i class="sidenav-toggler-line"></i>
                                </div>
                            </a>
                        </li>
                        <h6 class="font-weight-bolder mb-0">Product Management</h6>
                    </nav>
                    <div class="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4" id="navbar">
                        <div class="ms-md-auto pe-md-3 d-flex align-items-center">
                            <div class="input-group">
                            </div>
                        </div>
                        <ul class="navbar-nav  justify-content-end">
                            <li class="nav-item dropdown pe-2 d-flex align-items-center">
                                <a href="javascript:;" class="nav-link text-body p-0" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=curUser.getFullname()%></span>
                                    <img class="img-profile rounded-circle"
                                         src="${contextPath}/upload/<%=curUser.getProfileImage()%>" width="30px" height="30px">
                                </a>
                                <ul class="dropdown-menu  dropdown-menu-end  px-2 py-3 me-sm-n4" aria-labelledby="dropdownMenuButton">
                                    <li class="mb-2">
                                        <a class="dropdown-item border-radius-md" href="${contextPath}/UserControllerMap?service=info">
                                            <div class="d-flex py-1">
                                                <div class="d-flex flex-column justify-content-center">
                                                    <h6 class="text-sm font-weight-normal mb-1">
                                                        Profile
                                                    </h6>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="mb-2">
                                        <a class="dropdown-item border-radius-md" href="${contextPath}/UserControllerMap">
                                            <div class="d-flex py-1">
                                                <div class="d-flex flex-column justify-content-center">
                                                    <h6 class="text-sm font-weight-normal mb-1">
                                                        Shopping
                                                    </h6>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item border-radius-md" href="${contextPath}/UserControllerMap?service=logout">
                                            <div class="d-flex py-1">
                                                <div class="d-flex flex-column justify-content-center">
                                                    <h6 class="text-sm font-weight-normal mb-1">
                                                        Log out
                                                    </h6>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- End Navbar -->
            <div class="container-fluid py-4">
                <div class="row my-4">
                    <div class="col-lg-12 col-md-12 mb-md-0 mb-4">
                        <div class="card">
                            <div class="card-body px-0 pb-2">
                                <div class="card-header py-3" 
                                     style="display: flex;
                                     justify-content: space-between;">
                                    <h6 class="m-0 font-weight-bold text-primary">Product Management</h6>
                                    <a href="AdminControllerMap?service=addproductdetail">
                                        <button>Add new product</button></a>
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
                                            <input type="text" oninput="searchByName(this)" placeholder="Search.." class="form-control">
                                        </div>
                                    </div>
                                    <div class="table-responsive-md">
                                        <table class="table-bordered" style="table-layout: fixed;width: 100%;text-align: center;" id="dataTable">
                                            <thead>
                                                <tr>
                                                    <th style="width: 30%;">Product Name</th>
                                                    <th style="width: 30%;">Description</th>
                                                    <th style="width: 10%;">Rating</th>
                                                    <th style="width: 10%;">Seller</th>
                                                    <th style="width: 10%;">Release Date</th>
                                                    <th style="width: 5%;"></th>
                                                    <th style="width: 5%;"></th>
                                                </tr>
                                            </thead>
                                            <tbody id="product">
                                                <%for (Product product : listProduct) {
                                                        User user = userdao.getUserByProductId(product.getProductID());
                                                %>
                                                <tr>
                                                    <td><%=product.getProductName()%></td>
                                                    <td><%=product.getDescription()%></td>
                                                    <td><%=product.getRating()%></td>
                                                    <td><%=user.getFullname()%></td>
                                                    <td><%=product.getReleaseDate()%></td>
                                                    <td><div><a href="AdminControllerMap?service=updateproductdetail&producttypeid=<%=product.getProductID()%>"><span class="fas fa-edit"></span></a>
                                                        </div></td>
                                                    <td><div><a href="AdminControllerMap?service=deleteproduct&producttypeid=<%=product.getProductID()%>" onclick="return confirm('Are you sure you want to Remove?');"><span class="fas fa-trash-alt"></span></a></div></td>
                                                </tr>

                                                <%}%>
                                            </tbody>
                                        </table>
                                    </div>
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
                                                <li data-page="next" class="page-item" id="prev">
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
                        service: "searchproduct"
                    },
                    success: function (respone) {
                        var text = document.getElementById("product");
                        text.innerHTML = respone;
                        getPagination('#dataTable');
                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                });
            }
        </script>
    </body>

</html>
<!-- Github buttons -->
<!--        <script async defer src="https://buttons.github.io/buttons.js"></script>-->
<!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<!--        <script src="${contextPath}/js/soft-ui-dashboard.min.js?v=1.0.3"></script>-->