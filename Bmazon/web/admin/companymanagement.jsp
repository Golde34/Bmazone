<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    DecimalFormat nf = new DecimalFormat("###,###,###");
    int index = (Integer) request.getAttribute("index");
    int totalPage = (Integer) request.getAttribute("totalPage");
    int prev = index == 1 ? 1 : index - 1;
    int next = index == totalPage ? totalPage : index + 1;
    User curUser = (User) request.getSession().getAttribute("currUser");
    List<ShipCompany> listCompany = (List<ShipCompany>) request.getAttribute("listCompany");
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
    <style>
        th,td{
            padding: 12px 15px;
        }
        tbody tr:nth-child(even){
            background-color: #f2f2f2;
        }
    </style>
    <body class="g-sidenav-show  bg-gray-100">
        <aside class="sidenav navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-3 " id="sidenav-main">
            <jsp:include page="adminsidebar.jsp"></jsp:include>
            </aside>
            <main class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
                <!-- Navbar -->
            <jsp:include page="adminheader.jsp"></jsp:include>
                <!-- End Navbar -->
                <div class="container-fluid py-4">
                    <div class="row mt-4">

                    </div>
                    <div class="row my-4">
                        <div class="col-lg-12 col-md-12 mb-md-0 mb-4">
                            <div class="card">
                                <div class="card-body px-0 pb-2">
                                    <div class="card-header py-3 d-flex justify-content-between">
                                        <h3 class="m-0 font-weight-bold text-primary">Ship Company Management</h3>
                                        <a href="AdminControllerMap?service=addcompanydetail">
                                            <button class="btn-primary btn">Add new company</button></a>
                                    </div>
                                    <div class="card-body">
                                        <div class="table_head py-3 d-flex justify-content-between">
                                            <div class="rowNum">
                                                <h6 class="d-inline">Select number of Rows</h6>
                                                <div class="form-group d-inline">
                                                    <select onchange="pagination()" name="state" id="maxRows" class="form-control" style="width:80px;display:inline;">
                                                        <option value="5">5</option>
                                                        <option value="10">10</option>
                                                        <option value="20">20</option>
                                                        <option value="5000">Show All</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div>
                                                <input id="search" style="width: 100%;" type="text" oninput="pagination()" placeholder="Search.." class="form-control">
                                            </div>
                                        </div>
                                        <table style="width: 100%;" class="text-center ">
                                            <thead class="text-uppercase bg-gray-200">
                                                <tr>
                                                    <th style="width: 30%">Company Name</th>
                                                    <th style="width: 25%">Commit Date</th>
                                                    <th style="width: 25%">Unit Cost</th>
                                                    <th style="width: 20%">Action</th>
                                                </tr>
                                            </thead>
                                            <tbody id="company">
                                            <%for (ShipCompany company : listCompany) {%>
                                            <tr>
                                                <td><%=company.getCompanyName()%></td>
                                                <td><%=company.getCommitDate()%></td>
                                                <td><%=nf.format(company.getUnitCost())%></td>
                                                <td style='white-space: nowrap'>
                                                    <a href="AdminControllerMap?service=updatecompanydetail&companyid=<%=company.getCompanyID()%>"><button class="btn btn-primary">Edit</button></a>
                                                    <% if(company.getStatus()==1){%>
                                                    <a href="AdminControllerMap?service=deletecompany&companyid=<%=company.getCompanyID()%>" onclick="return confirm('Are you sure?');"><button class="btn btn-primary">Deactive</button></a>
                                                    <%}else{%>
                                                    <a href="AdminControllerMap?service=activecompany&companyid=<%=company.getCompanyID()%>" onclick="return confirm('Are you sure?');"><button class="btn btn-primary">Active</button></a>
                                                    <%}%>
                                                </td>
                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                    <div class="pagination-container mt-4 d-flex justify-content-around" style="cursor: pointer;">
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
                                                <%int limit = totalPage>5 ? 5 : totalPage;%>
                                                <%for (int i = index; i <= limit; i++) {%>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script>
            var pageNum;
            $(document).on('click', '.pagination li', function () {
                pageNum = $(this).data('repair');
                pagination();
            });
            function pagination() {
                var row = document.getElementById("maxRows").value;
                var search = document.getElementById("search").value;
                $(document).on('change','#maxRows',function(){
                    pageNum=1;
                });
                $(document).on('input','#search',function(){
                    pageNum=1;
                });
                $.ajax({
                    url: "/Bmazon/AdminControllerMap",
                    type: "get",
                    data: {
                        search: search,
                        row: row,
                        index: pageNum,
                        service: "pagingcompany"
                    },
                    success: function (respone) {
                        var text = document.getElementById("company");
                        text.innerHTML = respone;
                        showpage();
                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                });
            }
            function showpage() {
                var row = document.getElementById("maxRows").value;
                var search = document.getElementById("search").value;
                $(document).on('change','#maxRows',function(){
                    pageNum=1;
                });
                $(document).on('input','#search',function(){
                    pageNum=1;
                });
                $.ajax({
                    url: "/Bmazon/AdminControllerMap",
                    type: "get",
                    data: {
                        search: search,
                        row: row,
                        index: pageNum,
                        service: "showpagecompany"
                    },
                    success: function (respone) {
                        var text = document.getElementById("showpage");
                        text.innerHTML = respone;
                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                });
            }
        </script>
        <!-- Github buttons -->
        <!--        <script async defer src="https://buttons.github.io/buttons.js"></script>-->
        <!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<!--        <script src="${contextPath}/js/soft-ui-dashboard.min.js?v=1.0.3"></script>-->
    </body>

</html>