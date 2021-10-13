<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    ShipCompany company = (ShipCompany) request.getAttribute("company");
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
    List<ShipCompany> listCompany = (ArrayList<ShipCompany>) request.getAttribute("listCompany");
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
                                    <div class="card-header py-3" style="display: flex;
                                     justify-content: space-between;">
                                        <h3 class="m-0 font-weight-bold text-primary">Company Detail</h3>
                                        <a href="AdminControllerMap?service=companymanagement"><btn class="btn btn-primary">Company Management</btn></a>
                                    </div>
                                <% if (state.equals("success")) {%>
                                <h6 class="text-success mt-3 px-4">${mess}</h6>
                                <%}%>
                                <% if (state.equals("fail")) {%>
                                <h6 class="text-danger mt-3 px-4">${mess}</h6>
                                <%}%>
                                <div class="card-body">
                                    <form class="needs-validation" novalidate action="/Bmazon/AdminControllerMap" method="POST">
                                        <%if (service.equalsIgnoreCase("addcompanydetail")) {%>
                                        <table class="table table-striped">
                                            <tr>
                                                <td style="width: 30%;">Company Name</td>
                                                <td style="width: 70%;">
                                                    <input pattern="^[^\s]+(\s+[^\s]+)*$" class="form-control" type="text" value="${companyname}" name="companyname" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space at beginning or ending
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Unit Cost</td>
                                                <td>
                                                    <input pattern="^[0-9]*$" class="form-control" type="text" value="${unitcost}" name="unitcost" required>
                                                    <div class="invalid-feedback">
                                                        Only number
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Commit Date</td>
                                                <td>
                                                    <input pattern="^[0-9]*$" class="form-control" type="text" value="${commitdate}" name="commitdate" required>
                                                    <div class="invalid-feedback">
                                                        Only number
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="submit" value="Add Company" class="btn btn-primary">
                                                    <input type="hidden" value="addcompany" name="service">
                                                </td>
                                            </tr>
                                        </table>
                                        <%}%>
                                        <%if (service.equalsIgnoreCase("updatecompanydetail")) {%>
                                        <table class="table table-striped">
                                            <tr>
                                                <td>Company Name</td>
                                                <td>
                                                    <input pattern="^[^\s]+(\s+[^\s]+)*$" class="form-control" value="<%=company.getCompanyName()%>" type="text" name="companyname" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space at beginning or ending
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Unit Cost</td>
                                                <td>
                                                    <% int unit= (int) company.getUnitCost();%>
                                                    <input pattern="^[0-9]*$" class="form-control" value="<%=unit%>" type="text" name="unitcost" required>
                                                    <div class="invalid-feedback">
                                                        Only Number
                                                    </div>
                                                </td>
                                            </tr> 
                                            <tr>
                                                <td>Commit Date</td>
                                                <td>
                                                    <input pattern="^[0-9]*$" class="form-control" value="<%=company.getCommitDate()%>" type="text" name="commitdate" required>
                                                    <div class="invalid-feedback">
                                                        Only Number
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="submit" value="Update Company" class="btn btn-primary">
                                                    <input type="hidden" value="updatecompany" name="service">
                                                    <input type="hidden" value="<%=company.getCompanyID()%>" name="id">
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