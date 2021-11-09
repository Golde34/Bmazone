<%@page import="java.text.DecimalFormat"%>
<%@page import="model.CategoryDAO"%>
<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    DecimalFormat nf = new DecimalFormat("###,###,###");
    CategoryDAO daocate = new CategoryDAO();
    int index = (Integer) request.getAttribute("index");
    int totalPage = (Integer) request.getAttribute("totalPage");
    int prev = index == 1 ? 1 : index - 1;
    int next = index == totalPage ? totalPage : index + 1;
    User curUser = (User) request.getSession().getAttribute("currUser");
    ArrayList<Transaction> listHistoryTransaction = (ArrayList<Transaction>) request.getAttribute("listHistoryTransaction");
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
        body{
            background-color: #e5e5e5;
        }
        th{
            padding: 12px 15px;
        }
        td{
            padding: 12px 15px;
        }
        tbody tr:nth-child(even){
            background-color: #f2f2f2;
        }
        th,td{
            font-weight: bold;
        }
    </style>
    <body>
        <main>
            <jsp:include page="../header.jsp"/>
            <div class="container-fluid py-4">
                <div class="row my-4">
                    <div class="col-lg-12 col-md-12 mb-md-0 mb-4">
                        <div class="card">
                            <div class="card-body px-0 pb-2">
                                <div class="card-header py-3 d-flex justify-content-between">
                                    <h3 class="m-0 font-weight-bold text-primary" style="font-size: 35px;">History Transaction</h3>
                                    <a href="UserControllerMap?service=editWallet"><btn class="btn btn-primary">Wallet</btn></a>
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
                                                    <th style="width: 25%; text-align: center; font-size: 18px;">Time</th>
                                                    <th style="width: 25%; text-align: center; font-size: 18px;">Money</th>
                                                    <th style="width: 25%; text-align: center; font-size: 18px;">Action</th>
                                                    <th style="width: 25%; text-align: center; font-size: 18px;">Status</th>
                                                </tr>
                                            </thead>
                                            <tbody id="history">
                                                <%for (Transaction transaction : listHistoryTransaction) {%>
                                                <tr>
                                                    <td style="width: 25%; text-align: center;"><%=transaction.getHistory()%></td>
                                                    <td style="width: 25%; text-align: center;"><%=nf.format(transaction.getMoney())%></td>
                                                    <%if (transaction.getState() == 1) {%>
                                                    <td style="width: 25%; text-align: center;">Deposit</td>
                                                    <%} else {%>
                                                    <td style="width: 25%; text-align: center;">Withdrawal</td>
                                                    <%}%>
                                                    <%if (transaction.getStatus() == 0) {%>
                                                    <td style="width: 25%; text-align: center;"><span style="color: red; font-weight: bold;">Failed</span></td>
                                                    <%} else if (transaction.getStatus() == 1) {%>
                                                    <td style="width: 25%; text-align: center;"><span style="color: green; font-weight: bold;">Successfully</span></td>
                                                    <%} else {%>
                                                    <td style="width: 25%; text-align: center;"><span style="color: blueviolet; font-weight: bold;">Pending</span></td>
                                                    <%}%>
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
            <jsp:include page="../footer.jsp"/>
        </main>
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
                                                            url: "/Bmazon/UserControllerMap",
                                                            type: "get",
                                                            data: {
                                                                search: search,
                                                                row: row,
                                                                index: pageNum,
                                                                service: "pagingtransaction"
                                                            },
                                                            success: function (respone) {
                                                                var text = document.getElementById("history");
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
                                                            url: "/Bmazon/UserControllerMap",
                                                            type: "get",
                                                            data: {
                                                                search: search,
                                                                row: row,
                                                                index: pageNum,
                                                                service: "showpagetransaction"
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

</html>>