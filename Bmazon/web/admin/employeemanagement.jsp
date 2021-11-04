<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    int index = (Integer) request.getAttribute("index");
    int totalPage = (Integer) request.getAttribute("totalPage");
    int prev = index == 1 ? 1 : index - 1;
    int next = index == totalPage ? totalPage : index + 1;
    User curUser = (User) request.getSession().getAttribute("currUser");
    ArrayList<Employee> listEmp = (ArrayList<Employee>) request.getAttribute("ListEmployee");
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Admin Dashboard</title>
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
                    <div class="row my-4">
                        <div class="col-lg-12 col-md-12 mb-md-0 mb-4">
                            <div class="card">
                                <div class="card-body px-0 pb-2">
                                    <div class="card-header py-3 d-flex justify-content-between">
                                        <h3 class="m-0 font-weight-bold text-primary">User Management</h3>
                                        <a href="AdminControllerMap?service=addemployee">
                                            <button class="btn-primary btn">Add New Employee</button></a>
                                    </div>
                                    <div class="card-body">
                                        <div class="table_head py-3 d-flex justify-content-between">
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
                                            <div>
                                                <input id="search" style="width: 100%;" type="text" oninput="pagination()" placeholder="Search.." class="form-control">
                                            </div>
                                        </div>
                                        <div class="table-responsive">
                                            <table style="width: 100%;" class="text-center">
                                                <thead class="text-uppercase bg-gray-200">
                                                    <tr>
                                                        <th style="width: 25%">Employee ID</th>
                                                        <th style="width: 10%">Name</th>
                                                        <th style="width: 20%">Start Date</th>
                                                        <th style="width: 10%">Salary</th>
                                                      
                                                        <th style="width: 15%"></th>
                                                    </tr>
                                                </thead>
                                                <tbody id="user">
                                                <%for (Employee emp : listEmp) {
                                               
                                                %>
                                                <tr>
                                                    <td><%=emp.getEmployeeId()%></td>
                                                    <td><%=emp.getName() %></td>
                                                    <td><%=emp.getStartDate() %></td>
                                                    <td><%=emp.getSalary() %></td>
                                                    
                                                    <td style='white-space: nowrap'>
                                                        <a href="AdminControllerMap?service=updateemployeedetail&empid=<%=emp.getEmployeeId()%>"><button class="btn btn-primary">Edit</button></a>
                                                        <% if (emp.getStatus() == 1) {%>
                                                        <a href="AdminControllerMap?service=deleteemployee&empid=<%=emp.getEmployeeId()%>" onclick="return confirm('Are you sure?');"><button class="btn btn-primary">Deactive</button></a>
                                                        <%} else {%>
                                                        <a href="AdminControllerMap?service=activeemployee&empid=<%=emp.getEmployeeId()%>" onclick="return confirm('Are you sure?');"><button class="btn btn-primary">Active</button></a>
                                                        <%}%>
                                                    </td>
                                                </tr>
                                                <%}%>
                                            </tbody>
                                        </table>
                                    </div>
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
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
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
                console.log(row);
                console.log(search);
                console.log(pageNum);
                $.ajax({
                    url: "/Bmazon/AdminControllerMap",
                    type: "get",
                    data: {
                        search: search,
                        row: row,
                        index: pageNum,
                        service: "pagingemployee"
                    },
                    success: function (respone) {
                        var text = document.getElementById("user");
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
                $.ajax({
                    url: "/Bmazon/AdminControllerMap",
                    type: "get",
                    data: {
                        search: search,
                        row: row,
                        index: pageNum,
                        service: "showpageemployee"
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
        <!--   Core JS Files   -->
        <script src="${contextPath}/js/core/popper.min.js"></script>
        <script src="${contextPath}/js/core/bootstrap.min.js"></script>

    </body>

</html>>