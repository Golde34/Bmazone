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
    String state = (String) request.getAttribute("state");
    if (state == null) {
        state = "";
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
        <!-- Font Awesome Icons -->
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
        <!-- CSS Files -->
        <link id="pagestyle" href="${contextPath}/css/soft-ui-dashboard.css" rel="stylesheet" />
    </head>

    <body class="g-sidenav-show  bg-gray-100">
        <aside class="sidenav navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-3 " id="sidenav-main">
            <jsp:include page="adminsidebar.jsp"></jsp:include>
            </aside>
            <main class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
                <!-- Navbar -->
            <jsp:include page="adminheader.jsp"></jsp:include>
                <!-- End Navbar -->
                <div class="container-fluid py-4">
                    <div class="row my-4">
                        <div class="col-lg-12 col-md-12 mb-md-0 mb-4">
                            <div class="card">
                                <div class="card-body px-0 pb-2" >    
                                    <div class="card-header py-3 d-flex justify-content-between">
                                        <h3 class="m-0 font-weight-bold text-primary">User Detail</h3>
                                        <a href="AdminControllerMap?service=usermanagement"><btn class="btn btn-primary">User Management</btn></a>
                                    </div>
                                <% if (state.equals("success")) {%>
                                <h6 class="text-success mt-3 px-4">${mess}</h6>
                                <%}%>
                                <% if (state.equals("fail")) {%>
                                <h6 class="text-danger mt-3 px-4">${mess}</h6>
                                <%}%>
                                <div class="card-body">
                                    <form class="needs-validation" novalidate action="/Bmazon/AdminControllerMap" method="POST">
                                        <%if (service.equalsIgnoreCase("adduserdetail")) {%>
                                        <table class="table table-striped">
                                            <tr>
                                                <td style="width: 30%;">User Name</td>
                                                <td style="width: 70%;">
                                                    <input pattern="[^' ']+" class="form-control" type="text" value="${username}" name="username" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space at beginning or ending
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Password</td>
                                                <td>
                                                    <input pattern="[^' ']+" class="form-control" type="text" value="${password}" name="password" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Full Name</td>
                                                <td>
                                                    <input pattern="^[^\s]+(\s+[^\s]+)*$" class="form-control" type="text" value="${fullname}" name="fullname" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Email</td>
                                                <td>
                                                    <input pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{1,4}$" class="form-control" type="text" value="${email}" name="email" required>
                                                    <div class="invalid-feedback">
                                                        Input correct email patter : abc@xyz.com
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Phone</td>
                                                <td>
                                                    <input pattern="(09|03|07|08|05)+([0-9]{8})" class="form-control" type="text" value="${phone}" name="phone" required>
                                                    <div class="invalid-feedback">
                                                        Input correct phone number in Viet Nam
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Address</td>
                                                <td>
                                                    <input pattern="^[^\s]+(\s+[^\s]+)*$" class="form-control" type="text" value="${address}" name="address" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space at beginning or ending
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Gender</td>
                                                <td>
                                                    <div class="form-check form-check-inline">
                                                        <input value="1" class="form-check-input" type="radio" name="gender" id="male">
                                                        <label class="form-check-label" for="male">
                                                            Male
                                                        </label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input value="0" class="form-check-input" type="radio" name="gender" id="female">
                                                        <label class="form-check-label" for="female">
                                                            Female
                                                        </label>
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
                                            <tr>
                                                <td style="width: 30%;">User Name</td>
                                                <td style="width: 70%;">
                                                    <input pattern="[^' ']+" class="form-control" value="<%=user.getUsername()%>" type="text" name="username" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space at beginning or ending
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Full Name</td>
                                                <td>
                                                    <input pattern="^[^\s]+(\s+[^\s]+)*$" class="form-control" value="<%=user.getFullname()%>" type="text" name="fullname" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Email</td>
                                                <td>
                                                    <input pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" class="form-control" value="<%=user.getEmail()%>" type="text" name="email" required>
                                                    <div class="invalid-feedback">
                                                        Input correct email patter : abc@xyz.com
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Phone</td>
                                                <td>
                                                    <input pattern="(09|03|07|08|05)+([0-9]{8})" class="form-control" value="<%=user.getPhoneNumber()%>" type="text" name="phone" required>
                                                    <div class="invalid-feedback">
                                                        Input correct phone number in Viet Nam
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Address</td>
                                                <td>
                                                    <input pattern="^[^\s]+(\s+[^\s]+)*$" class="form-control" value="<%=user.getAddress()%>" type="text" name="address" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space at beginning or ending
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Gender</td>
                                                <td>
                                                    <div class="form-check form-check-inline">
                                                        <input <%if (user.getGender() == 1) {%> checked <%}%> value="1" class="form-check-input" type="radio" name="gender" id="male">
                                                        <label class="form-check-label" for="male">
                                                            Male
                                                        </label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input <%if (user.getGender() == 0) {%> checked<%}%> value="0" class="form-check-input" type="radio" name="gender" id="female">
                                                        <label class="form-check-label" for="female">
                                                            Female
                                                        </label>
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
        <script>
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
        </script>
        <!-- Github buttons -->
        <script async defer src="https://buttons.github.io/buttons.js"></script>
        <!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<!--        <script src="${contextPath}/js/soft-ui-dashboard.min.js?v=1.0.3"></script>-->

    </body>

</html>