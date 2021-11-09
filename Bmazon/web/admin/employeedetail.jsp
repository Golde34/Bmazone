<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    DecimalFormat nf = new DecimalFormat("###,###,###");
    Employee employee=(Employee) request.getAttribute("employee");
    User user =(User) request.getAttribute("user");
    String mess = (String) request.getAttribute("mess");
    String state = (String) request.getAttribute("state");
    if (state == null) {
        state = "";
    }
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
                                        <h3 class="m-0 font-weight-bold text-primary">Employee Detail</h3>
                                        <a href="AdminControllerMap?service=employeemanagement"><btn class="btn btn-primary">Employee Management</btn></a>
                                    </div>
                                <% if (state.equals("success")) {%>
                                <h6 class="text-success mt-3 px-4">${mess}</h6>
                                <%}%>
                                <% if (state.equals("fail")) {%>
                                <h6 class="text-danger mt-3 px-4">${mess}</h6>
                                <%}%>
                                <div class="card-body">
                                    <form class="needs-validation" novalidate action="/Bmazon/AdminControllerMap" method="POST">
                                        <%if (service.equalsIgnoreCase("addemployeedetail")) {%>
                                        <table class="table table-striped">
                                            <tr>
                                                <tr>
                                                <td>Username</td>
                                                <td>
                                                    <input pattern="[^' ']+" class="form-control" value="${username}" type="text" name="username" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space at beginning or ending
                                                    </div>
                                                </td>
                                            </tr>
                                             <tr>
                                                <td>Password</td>
                                                <td>
                                                    <input pattern="[^' ']+" class="form-control" value="${password}" type="text" name="password" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space at beginning or ending
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
                                                    <select class="form-control" name="gender">
                                                        <option value="1">Male</option>
                                                        <option value="0">Female</option>
                                                    </select>
                                                </td>
                                            </tr>
                                                <td style="width: 30%;">Employee Name</td>
                                                <td style="width: 70%;">
                                                    <input pattern="^[^\s]+(\s+[^\s]+)*$" class="form-control" type="text" value="" name="employeename" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space at beginning or ending
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Salary</td>
                                                <td>
                                                    <input class="form-control number" type="text" value="" name="salary" required>
                                                    <div class="invalid-feedback">
                                                        Only number
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Start Date</td>
                                                <td>
                                                    <input class="form-control number" type="date" value="" name="startdate" required>
                                                    <div class="invalid-feedback">
                                                        Only number
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="submit" value="Add Employee" class="btn btn-primary">
                                                    <input type="hidden" value="addemployee" name="service">
                                                </td>
                                            </tr>
                                        </table>
                                        <%}%>
                                        <%if (service.equalsIgnoreCase("updateemployeedetail")) {%>
                                        <table class="table table-striped">
                                             <tr>
                                                <td>Username</td>
                                                <td>
                                                    <input pattern="[^' ']+" class="form-control" value="<%=user.getUsername()%>" type="text" name="username" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space at beginning or ending
                                                    </div>
                                                </td>
                                            </tr>
                                             <tr>
                                                <td>Password</td>
                                                <td>
                                                    <input pattern="^[^\s]+(\s+[^\s]+)*$" class="form-control" value="<%=user.getPassword()%>" type="text" name="password" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space at beginning or ending
                                                    </div>
                                                </td>
                                            </tr>
                                          
                                             <tr>
                                                <td>Email</td>
                                                <td>
                                                    <input pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{1,4}$" class="form-control" type="text" value="<%=user.getEmail() %>" name="email" required>
                                                    <div class="invalid-feedback">
                                                        Input correct email patter : abc@xyz.com
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Phone</td>
                                                <td>
                                                    <input pattern="(09|03|07|08|05)+([0-9]{8})" class="form-control" type="text" value="<%=user.getPhoneNumber() %>" name="phone" required>
                                                    <div class="invalid-feedback">
                                                        Input correct phone number in Viet Nam
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Address</td>
                                                <td>
                                                    <input pattern="^[^\s]+(\s+[^\s]+)*$" class="form-control" type="text" value="<%=user.getAddress() %>" name="address" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space at beginning or ending
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                               <td>Gender</td>
                                                <td>
                                                     <select class="form-control" name="gender">
                                                        <option <%if (user.getGender() == 1) {%> selected<%}%> value="1">Male</option>
                                                        <option <%if (user.getGender() == 0) {%> selected<%}%> value="0">Female</option>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Employee Name</td>
                                                <td>
                                                    <input pattern="^[^\s]+(\s+[^\s]+)*$" class="form-control" value="<%=employee.getName() %>" type="text" name="employeename" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space at beginning or ending
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Salary</td>
                                                <td>
                                                    <input class="form-control number" value="<%=nf.format(employee.getSalary())%>" type="text" name="salary" required>
                                                    <div class="invalid-feedback">
                                                        Only Number
                                                    </div>
                                                </td>
                                            </tr> 
                                            <tr>
                                                <td>Start Date</td>
                                                <td>
                                                    <input class="form-control number" value="<%=employee.getStartDate()%>" type="text" name="startdate" required>
                                                    <div class="invalid-feedback">
                                                        Only Number
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="submit" value="Update Employee" class="btn btn-primary">
                                                    <input type="hidden" value="updateemployee" name="service">
                                                    <input type="hidden" value="<%=employee.getEmployeeId()%>" name="id">
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script>
            $(".number").on('keyup', function () {
                var n = parseInt($(this).val().replace(/\D/g, ''), 10);
                $(this).val(n.toLocaleString());
            });
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