<%@page import="java.util.ArrayList"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    User user = new User();
    if (request.getAttribute("user") != null) {
        user = (User) request.getAttribute("user");
    }
    String mess = (String) request.getAttribute("mess");
    if (mess == null) {
        mess = "";
    }
    String service = (String) request.getAttribute("service");
    User curUser = (User) request.getSession().getAttribute("currUser");
    ArrayList<User> listUser = (ArrayList<User>) request.getAttribute("listUser");
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
                        <a class="nav-link active" href="AdminControllerMap?service=usermanagement">
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="fas fa-fw fa-tachometer-alt"></i>
                            </div>
                            <span class="nav-link-text ms-1">User Management</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminControllerMap?service=productmanagement">
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="fas fa-fw fa-tachometer-alt " style="color: black"></i>
                            </div>
                            <span class="nav-link-text ms-1 ">Product Management</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link  " href="AdminControllerMap?service=companymanagement">
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="fas fa-fw fa-tachometer-alt" style="color: black"></i>
                            </div>
                            <span class="nav-link-text ms-1">Ship Company Management</span>
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
            <jsp:include page="adminheader.jsp"></jsp:include>
            <!-- End Navbar -->
            <div class="container-fluid py-4">
                <div class="row my-4">
                    <div class="col-lg-12 col-md-12 mb-md-0 mb-4">
                        <div class="card">
                            <div class="card-body px-0 pb-2">
                                <div class="card-header py-3" >
                                    <h3 class="m-0 font-weight-bold text-primary">User Management</h3>
                                    <h6 class="text-success mt-3"><%=mess%></h6>
                                </div>
                                <div class="card-body">
                                    <form class="form" action="/Bmazon/AdminControllerMap" method="POST">
                                        <%if (service.equalsIgnoreCase("adduserdetail")) {%>
                                        <table class="table">
                                            <div class="form-group">
                                                <tr>
                                                    <td>User Name</td>
                                                    <td>
                                                        <input type="text" name="username"><br>
                                                        <span clas="form-message"></span>
                                                    </td>
                                                </tr>
                                            </div> 
                                            <div class="form-group">
                                                <tr>
                                                    <td>Password</td>
                                                    <td>
                                                        <input type="text" name="password"><br>
                                                        <span clas="form-message"></span>
                                                    </td>
                                                </tr>
                                            </div>  
                                            <div class="form-group">
                                                <tr>
                                                    <td>Full Name</td>
                                                    <td>
                                                        <input type="text" name="fullname"><br>
                                                        <span clas="form-message"></span>
                                                    </td>
                                                </tr>
                                            </div>
                                            <div class="form-group">
                                                <tr>
                                                    <td>Phone</td>
                                                    <td>
                                                        <input type="text" name="phone"><br>
                                                        <span clas="form-message"></span>
                                                    </td>
                                                </tr>
                                            </div>
                                            <div class="form-group">
                                                <tr>
                                                    <td>Email</td>
                                                    <td>
                                                        <input type="text" name="email"><br>
                                                        <span clas="form-message"></span>
                                                    </td>
                                                </tr>
                                            </div>
                                            <div class="form-group">
                                                <tr>
                                                    <td>Address</td>
                                                    <td>
                                                        <input type="text" name="address"><br>
                                                        <span clas="form-message"></span>
                                                    </td>
                                                </tr>
                                            </div>
                                            <tr>
                                                <td>Gender</td>
                                                <td>
                                                    <div class="custom-select">
                                                        <select name="gender">
                                                            <option value="1">Male</option>
                                                            <option value="0">Female</option>
                                                        </select>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>  
                                                <td>System Role</td>
                                                <td>
                                                    <div class="custom-select">
                                                        <select name="role">
                                                            <option value="0">Customer</option>
                                                            <option value="1">Admin</option>
                                                        </select>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="submit" value="Add User" class="btn btn-primary">
                                                    <input type="hidden" value="adduser" name="service">
                                                </td>
                                            </tr>
                                        </table>
                                        <%}%>
                                        <%if (service.equalsIgnoreCase("updateuserdetail")) {%>
                                        <table class="table table-striped">
                                            <div class="form-group">
                                                <tr>
                                                    <td>User Name</td>
                                                    <td>
                                                        <input value="<%=user.getUsername()%>" type="text" name="username"><br>
                                                        <span clas="form-message"></span>
                                                    </td>
                                                </tr>
                                            </div>
                                            <div class="form-group">
                                                <tr>
                                                    <td>Password</td>
                                                    <td>
                                                        <input value="<%=user.getPassword()%>" type="text" name="username"><br>
                                                        <span clas="form-message"></span>
                                                    </td>
                                                </tr>
                                            </div>  
                                            <div class="form-group">
                                                <tr>
                                                    <td>Full Name</td>
                                                    <td>
                                                        <input value="<%=user.getFullname()%>" type="text" name="fullname"><br>
                                                        <span clas="form-message"></span>
                                                    </td>
                                                </tr>
                                            </div>
                                            <div class="form-group">
                                                <tr>
                                                    <td>Phone</td>
                                                    <td>
                                                        <input value="<%=user.getPhoneNumber()%>" type="text" name="phone"><br>
                                                        <span clas="form-message"></span>
                                                    </td>
                                                </tr>
                                            </div>
                                            <div class="form-group">
                                                <tr>
                                                    <td>Email</td>
                                                    <td>
                                                        <input value="<%=user.getEmail()%>" type="text" name="email"><br>
                                                        <span clas="form-message"></span>
                                                    </td>
                                                </tr>
                                            </div>
                                            <div class="form-group">
                                                <tr>
                                                    <td>Address</td>
                                                    <td>
                                                        <input value="<%=user.getAddress()%>" type="text" name="address"><br>
                                                        <span clas="form-message"></span>
                                                    </td>
                                                </tr>
                                            </div>
                                            <tr>
                                                <td>Gender</td>
                                                <td>
                                                    <div class="custom-select">
                                                        <select name="gender">
                                                            <option <%if (user.getGender() == 1) {%> selected<%}%> value="1">Male</option>
                                                            <option <%if (user.getGender() == 0) {%> selected<%}%> value="0">Female</option>
                                                        </select>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>  
                                                <td>System Role</td>
                                                <td>
                                                    <div class="custom-select">
                                                        <select name="role">
                                                            <option <%if (user.getSystemRole() == 0) {%> selected<%}%> value="0">Customer</option>
                                                            <option <%if (user.getSystemRole() == 1) {%> selected<%}%> value="1">Admin</option>
                                                        </select>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="submit" value="Update User" class="btn btn-primary">
                                                    <input type="hidden" value="updateuser" name="service">
                                                    <input type="hidden" value="<%=user.getUserId()%>" name="id">
                                                </td>
                                            </tr>
                                        </table>
                                        <%}%>
                                    </form>
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
        <!-- Github buttons -->
        <script async defer src="https://buttons.github.io/buttons.js"></script>
        <!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<!--        <script src="${contextPath}/js/soft-ui-dashboard.min.js?v=1.0.3"></script>-->

    </body>

</html>