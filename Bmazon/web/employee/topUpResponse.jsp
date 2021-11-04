<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    DecimalFormat nf = new DecimalFormat("###,###,###");
    UserDAO daouser = new UserDAO();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    int index = (Integer) request.getAttribute("index");
    int totalPage = (Integer) request.getAttribute("totalPage");
    int prev = index == 1 ? 1 : index - 1;
    int next = index == totalPage ? totalPage : index + 1;
    User curUser = (User) request.getSession().getAttribute("currUser");
    List<Transaction> listTransaction = (List<Transaction>) request.getAttribute("listTransaction");
%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Admin Dashboard </title>
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
            <jsp:include page="employeesidebar.jsp"></jsp:include>
            </aside>
            <main class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
                <!-- Navbar -->
            <jsp:include page="employeeheader.jsp"></jsp:include>
                <!-- End Navbar -->
                <div class="container-fluid py-4">
                    <div class="row my-4">
                        <div class="col-lg-12 col-md-12 mb-md-0 mb-4">
                            <div class="card">
                                <div class="card-body px-0 pb-2">
                                    <div class="card-header py-3 d-flex justify-content-between">
                                        <h3 class="m-0 font-weight-bold text-primary">Top Up Response</h3>
                                    </div>
                                    <div class="card-body">
                                        <div class="table_head py-3 d-flex justify-content-between">
                                            <div class="rowNum">
                                                <h6 class="d-inline">Select number of Rows</h6>
                                                <div class="form-group d-inline">
                                                    <select onchange="pagination()" name="state" id="maxRows" class="form-control d-inline" style="width:80px;">
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
                                            <table class="text-center" style="width: 100%;">
                                                <thead class="text-uppercase bg-gray-200">
                                                    <tr>
                                                        <th style="width: 15%;padding: 20px;">Customer</th>
                                                        <th style="width: 20%">Time</th>
                                                        <th style="width: 15%">Phone</th>
                                                        <th style="width: 20%">Money</th>
                                                        <th style="width: 15%">Action</th>
                                                        <th style="width: 15%"></th>
                                                    </tr>
                                                </thead>
                                                <tbody id="topup">
                                                <%for (Transaction transaction : listTransaction) {%>
                                                <tr>
                                                    <td><%=daouser.getUserById(transaction.getUserID()).getFullname()%></td>
                                                    <td><%=transaction.getHistory()%></td>
                                                    <td><%=daouser.getUserById(transaction.getUserID()).getPhoneNumber()%></td>
                                                    <td><%=nf.format(transaction.getMoney())%></td>
                                                    <%if (transaction.getState() == 1) {%>
                                                    <td>Deposit</td>
                                                    <%} else {%>
                                                    <td>Withdrawal</td>
                                                    <%}%>
                                                    <td style='white-space: nowrap'>
                                                        <a href="EmployeeControllerMap?service=accepttopup&transactionID=<%=transaction.getTransactionID()%>" onclick="return confirm('Are you sure?');"><button class="btn btn-primary">Accept</button></a>
                                                        <a href="EmployeeControllerMap?service=denytopup&transactionID=<%=transaction.getTransactionID()%>" onclick="return confirm('Are you sure?');"><button class="btn btn-primary">Refuse</button></a>
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
        <script src="${contextPath}/js/plugins/perfect-scrollbar.min.js"></script>
        <script src="${contextPath}/js/plugins/smooth-scrollbar.min.js"></script>
        <script src="${contextPath}/js/plugins/chartjs.min.js"></script>
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
                                                                    url: "/Bmazon/EmployeeControllerMap",
                                                                    type: "get",
                                                                    data: {
                                                                        search: search,
                                                                        row: row,
                                                                        index: pageNum,
                                                                        service: "pagingtopupresponse"
                                                                    },
                                                                    success: function (respone) {
                                                                        var text = document.getElementById("topup");
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
                                                                    url: "/Bmazon/EmployeeControllerMap",
                                                                    type: "get",
                                                                    data: {
                                                                        search: search,
                                                                        row: row,
                                                                        index: pageNum,
                                                                        service: "showpagetopupresponse"
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
    </body>

</html>