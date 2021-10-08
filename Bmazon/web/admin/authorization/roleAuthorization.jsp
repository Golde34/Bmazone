<%@page import="model.UserDAO"%>
<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    List<Role> listRole = (List<Role>) request.getAttribute("role");
    String mess = (String) request.getAttribute("mess");
    if (mess == null) {
        mess = "";
    }
    String service = (String) request.getAttribute("service");
    User curUser = (User) request.getSession().getAttribute("currUser");
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
                        <a class="nav-link" href="AdminControllerMap?service=usermanagement">
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="fas fa-users"  style="color: black"></i>
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
                        <a class="nav-link" href="AdminControllerMap?service=companymanagement">
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="far fa-building"></i>
                            </div>
                            <span class="nav-link-text ms-1">Company Management</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link  " href="AdminControllerMap?service=gallerymanagement">
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="far fa-images" style="color: black"></i>
                            </div>
                            <span class="nav-link-text ms-1">Gallery Management</span>
                        </a>
                    </li>
                </ul>
                <hr>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" href="AdminControllerMap?service=userAuthorization">
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="fas fa-building"></i>
                            </div>
                            <span class="nav-link-text ms-1">User Authorization</span>
                        </a>
                    </li>
                </ul>
            </div>
        </aside>
        <main class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
            <!-- Navbar -->
            <jsp:include page="../adminheader.jsp"></jsp:include>
                <!-- End Navbar -->
                <div class="container-fluid py-4">
                    <div class="row my-4">
                        <div class="col-lg-12 col-md-12 mb-md-0 mb-4">
                            <div class="card">
                                <div class="card-body px-0 pb-2">
                                    <div class="card-header py-3" 
                                         style="display: flex;
                                         justify-content: space-between;">
                                        <h3 class="m-0 font-weight-bold text-primary">Authorization Role </h3>
                                        <a href="AdminControllerMap?service=addRoleDetail">
                                            <button class="btn-primary btn">Add Role</button></a>
                                    </div>
                                    <div class="card-body">
                                        <div class="table_head py-3" style="display: flex;
                                             justify-content: space-between;">
                                            <div class="tb_search">
                                                <input style="width: 100%;" type="text" oninput="searchByName(this)" placeholder="Search.." class="form-control">
                                            </div>
                                        </div>
                                        <div class="table-responsive">
                                            <table class="table table-bordered table-striped" id="dataTable" style="text-align: center;">
                                                <thead>
                                                    <tr>
                                                        <th>Role ID</th>
                                                        <th>Role Name</th>
                                                        <th>Admin Permission</th>
                                                        <th>Seller Permission</th>
                                                        <th>Customer Permission</th>
                                                        <th></th>
                                                        <th></th>
                                                    </tr>
                                                </thead>
                                                <tbody id="user">
                                                <%for (Role role : listRole) {%>
                                                <tr>
                                                    <td><%=role.getRoleID()%></td>
                                                    <td><%=role.getRoleName()%></td>
                                                    <td><%=role.getAdminPermission()%></td>
                                                    <td><%=role.getSellerPermission()%></td>
                                                    <td><%=role.getCustomerPermission()%></td>
                                                    <td>
                                                        <a href="AdminControllerMap?service=updateuserdetail&userid=<%=role.getRoleID()%>"><span class="fas fa-edit"></span></a>
                                                    </td>
                                                    <td><a href="AdminControllerMap?service=deleteuser&userid=<%=role.getRoleName()%>" onclick="return confirm('Are you sure you want to Remove?');"><span class="fas fa-trash-alt"></span></a></td>
                                                </tr>
                                                <%}%>
                                            </tbody>
                                        </table>
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
                                                                    service: "searchcompany"
                                                                },
                                                                success: function (respone) {
                                                                    var text = document.getElementById("company");
                                                                    text.innerHTML = respone;
                                                                    getPagination('#dataTable');
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