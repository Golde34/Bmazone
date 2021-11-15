<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    String[] temp={""};
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    DecimalFormat nf = new DecimalFormat("###,###,###");
    ProductDAO daoProduct = new ProductDAO();
    ShipCompanyDAO daoCompany = new ShipCompanyDAO();
    OrderDAO daoOrder = new OrderDAO();
    ArrayList<Product> top6Product = daoProduct.getAllPagingProduct(1, 6, "",temp);
    List<ShipCompany> top5Company = daoCompany.getAllPagingShipCompany(1, 5, "");
    User curUser = (User) request.getSession().getAttribute("currUser");
    Double profit = (Double) request.getAttribute("profit");
    ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("listProduct");
    ArrayList<User> listUser = (ArrayList<User>) request.getAttribute("listUser");
    ArrayList<Order> listOrder = (ArrayList<Order>) request.getAttribute("listOrder");
    List<ShipCompany> listCompany = (List<ShipCompany>) request.getAttribute("listCompany");
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title> Admin Dashboard</title>
        <!--Fonts and icons -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
        <!--Font Awesome Icons-->
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
        <!--CSS Files-->
        <link id="pagestyle" href="${contextPath}/css/soft-ui-dashboard.css" rel="stylesheet" />
    </head>

    <body class="g-sidenav-show  bg-gray-100">
        <!--Sidebar-->
        <aside class="sidenav navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-3 " id="sidenav-main">
            <jsp:include page="adminsidebar.jsp"></jsp:include>
            </aside>
            <!--End Sidebar-->
            <main class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
                <!-- Header -->
            <jsp:include page="adminheader.jsp"></jsp:include>
                <!-- End header -->
                <div class="container-fluid py-4">
                    <div class="row">
                        <div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
                            <div class="card">
                                <div class="card-body p-3">
                                    <div class="row">
                                        <div class="col-8">
                                            <div class="numbers">
                                                <p class="text-sm mb-0 text-capitalize font-weight-bold">All User</p>
                                                <h5 class="font-weight-bolder mb-0">
                                                <%=listUser.size()%>
                                            </h5>
                                        </div>
                                    </div>
                                    <div class="col-4 text-end">
                                        <div class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                                            <i class="fas fa-user text-lg opacity-10" aria-hidden="true"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
                        <div class="card">
                            <div class="card-body p-3">
                                <div class="row">
                                    <div class="col-8">
                                        <div class="numbers">
                                            <p class="text-sm mb-0 text-capitalize font-weight-bold">All Product</p>
                                            <h5 class="font-weight-bolder mb-0">
                                                <%=listProduct.size()%>
                                            </h5>
                                        </div>
                                    </div>
                                    <div class="col-4 text-end">
                                        <div class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                                            <i class="fas fa-database text-lg opacity-10" aria-hidden="true"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
                        <div class="card">
                            <div class="card-body p-3">
                                <div class="row">
                                    <div class="col-8">
                                        <div class="numbers">
                                            <p class="text-sm mb-0 text-capitalize font-weight-bold">All Order</p>
                                            <h5 class="font-weight-bolder mb-0">
                                                <%=listOrder.size()%>
                                            </h5>
                                        </div>
                                    </div>
                                    <div class="col-4 text-end">
                                        <div class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                                            <i class="fas fa-clipboard text-lg opacity-10" aria-hidden="true"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-sm-6">
                        <div class="card">
                            <div class="card-body p-3">
                                <div class="row">
                                    <div class="col-8">
                                        <div class="numbers">
                                            <p class="text-sm mb-0 text-capitalize font-weight-bold">Profit</p>
                                            <h5 class="font-weight-bolder mb-0">
                                                <%=nf.format(profit)%>
                                            </h5>
                                        </div>
                                    </div>
                                    <div class="col-4 text-end">
                                        <div class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                                            <i class="fas fa-money-bill-wave text-lg opacity-10" aria-hidden="true"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row mt-4">
                    <div class="col-lg-5 mb-lg-0 mb-4">
                        <div class="card z-index-2">
                            <div class="card-body p-3">
                                <div class="bg-gradient-dark border-radius-lg py-3 pe-1 mb-3">
                                    <div class="chart">
                                        <canvas id="chart-bars" class="chart-canvas" height="170"></canvas>
                                    </div>
                                </div>
                                <h6 class="ms-2 mt-4 mb-0"> Orders Overview </h6>
                                <div class="container border-radius-lg">
                                    <div class="row">
                                        <div class="col-4 py-3 ps-0">
                                            <div class="d-flex mb-2">
                                                <div class="icon icon-shape icon-xxs shadow border-radius-sm bg-gradient-primary text-center me-2 d-flex align-items-center justify-content-center">

                                                </div>
                                                <p class="text-xs mt-1 mb-0 font-weight-bold">Orders</p>
                                            </div>
                                            <h4 class="font-weight-bolder"><%=listOrder.size()%></h4>
                                            
                                        </div>
                                        <div class="col-4 py-3 ps-0">
                                            <div class="d-flex mb-2">
                                                <div class="icon icon-shape icon-xxs shadow border-radius-sm bg-gradient-info text-center me-2 d-flex align-items-center justify-content-center">

                                                </div>
                                                <p class="text-xs mt-1 mb-0 font-weight-bold">Users</p>
                                            </div>
                                            <h4 class="font-weight-bolder"><%=daoOrder.countUserOnOrder()%></h4>
                                            
                                        </div>
                                        <div class="col-4 py-3 ps-0">
                                            <div class="d-flex mb-2">
                                                <div class="icon icon-shape icon-xxs shadow border-radius-sm bg-gradient-warning text-center me-2 d-flex align-items-center justify-content-center">
                                                    
                                                </div>
                                                <p class="text-xs mt-1 mb-0 font-weight-bold">Products</p>
                                            </div>
                                            <h4 class="font-weight-bolder"><%=daoOrder.countProductOnOrder()%></h4>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-7">
                        <div class="card z-index-2">
                            <div class="card-header pb-0">
                                <h6>Sales overview</h6>
                            </div>
                            <div class="card-body p-3">
                                <div class="chart">
                                    <canvas id="chart-line" class="chart-canvas" height="300"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row my-4">
                    <div class="col-lg-8 col-md-6 mb-md-0 mb-4">
                        <div class="card">
                            <div class="card-header pb-0">
                                <div class="row">
                                    <div class="col-lg-6 col-7">
                                        <h6 class="text-primary">Products</h6>
                                    </div>
                                    <div class="col-lg-6 col-5 my-auto text-end">
                                        <div class="dropdown float-lg-end pe-4">
                                            <a class="cursor-pointer" id="dropdownTable" data-bs-toggle="dropdown" aria-expanded="false">
                                                <i class="fa fa-ellipsis-v text-secondary"></i>
                                            </a>
                                            <ul class="dropdown-menu px-2 py-3 ms-sm-n4 ms-n5" aria-labelledby="dropdownTable">
                                                <li><a class="dropdown-item border-radius-md" href="AdminControllerMap?service=productmanagement">See more</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card-body px-0 pb-2">
                                <div class="table-responsive">
                                    <table class="table text-center align-items-center mb-0">
                                        <thead>
                                            <tr>
                                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Product Name</th>
                                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Rating</th>
                                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Release Date</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% for (Product product : top6Product) {%>
                                            <tr>
                                                <td>
                                                    <div class="d-flex flex-column justify-content-center">
                                                        <h6 class="text-sm"><%=product.getProductName()%></h6>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="d-flex flex-column justify-content-center">
                                                        <h6 class="text-sm"><%=product.getRating()%></h6>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="d-flex flex-column justify-content-center">
                                                        <h6 class="text-sm"><%=sdf.format(product.getReleaseDate())%></h6>
                                                    </div>
                                                </td>
                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="card h-100">
                            <div class="card-header pb-0">
                                <div class="row">
                                    <div class="col-lg-6 col-7">
                                        <h6 class="text-primary">Ship Company</h6>
                                    </div>
                                    <div class="col-lg-6 col-5 my-auto text-end">
                                        <div class="dropdown float-lg-end pe-4">
                                            <a class="cursor-pointer" id="dropdownTable" data-bs-toggle="dropdown" aria-expanded="false">
                                                <i class="fa fa-ellipsis-v text-secondary"></i>
                                            </a>
                                            <ul class="dropdown-menu px-2 py-3 ms-sm-n4 ms-n5" aria-labelledby="dropdownTable">
                                                <li><a class="dropdown-item border-radius-md" href="AdminControllerMap?service=companymanagement">See more</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card-body p-3">
                                <div class="timeline timeline-one-side">
                                    <% for (ShipCompany company : top5Company) {%>
                                    <div class="timeline-block mb-3">
                                        <span class="timeline-step">
                                            <i class="fas fa-truck text-success text-gradient"></i>
                                        </span>
                                        <div class="timeline-content">
                                            <h6 class="text-dark text-sm font-weight-bold mb-0"><%=company.getCompanyName()%></h6>
                                            <p class="text-secondary font-weight-bold text-xs mt-1 mb-0">Unit Cost: <%=nf.format(company.getUnitCost())%></p>
                                        </div>
                                    </div>
                                    <%}%>
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
    </body>
    <script>
        var ctx = document.getElementById("chart-bars").getContext("2d");

        new Chart(ctx, {
            type: "bar",
            data: {
                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                datasets: [{
                        label: "Orders",
                        tension: 0.5,
                        borderWidth: 0,
                        borderRadius: 4,
                        borderSkipped: false,
                        backgroundColor: "#fff",
                        data: [
        <%=daoOrder.getOrderByMonth(1).size()%>,
        <%=daoOrder.getOrderByMonth(2).size()%>,
        <%=daoOrder.getOrderByMonth(3).size()%>,
        <%=daoOrder.getOrderByMonth(4).size()%>,
        <%=daoOrder.getOrderByMonth(5).size()%>,
        <%=daoOrder.getOrderByMonth(6).size()%>,
        <%=daoOrder.getOrderByMonth(7).size()%>,
        <%=daoOrder.getOrderByMonth(8).size()%>,
        <%=daoOrder.getOrderByMonth(9).size()%>,
        <%=daoOrder.getOrderByMonth(10).size()%>,
        <%=daoOrder.getOrderByMonth(11).size()%>,
        <%=daoOrder.getOrderByMonth(12).size()%>],
                        maxBarThickness: 6
                    }, ],
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        display: false,
                    }
                },
                interaction: {
                    intersect: false,
                    mode: 'index',
                },
                scales: {
                    y: {
                        grid: {
                            drawBorder: false,
                            display: false,
                            drawOnChartArea: false,
                            drawTicks: false,
                        },
                        ticks: {
                            suggestedMin: 0,
                            suggestedMax: 500,
                            beginAtZero: true,
                            padding: 15,
                            font: {
                                size: 14,
                                family: "Open Sans",
                                style: 'normal',
                                lineHeight: 2
                            },
                            color: "#fff"
                        },
                    },
                    x: {
                        grid: {
                            drawBorder: false,
                            display: false,
                            drawOnChartArea: false,
                            drawTicks: false
                        },
                        ticks: {
                            display: false
                        },
                    },
                },
            },
        });


        var ctx2 = document.getElementById("chart-line").getContext("2d");

        var gradientStroke1 = ctx2.createLinearGradient(0, 230, 0, 50);

        gradientStroke1.addColorStop(1, 'rgba(203,12,159,0.2)');
        gradientStroke1.addColorStop(0.2, 'rgba(72,72,176,0.0)');
        gradientStroke1.addColorStop(0, 'rgba(203,12,159,0)'); //purple colors

        var gradientStroke2 = ctx2.createLinearGradient(0, 230, 0, 50);

        gradientStroke2.addColorStop(1, 'rgba(20,23,39,0.2)');
        gradientStroke2.addColorStop(0.2, 'rgba(72,72,176,0.0)');
        gradientStroke2.addColorStop(0, 'rgba(20,23,39,0)'); //purple colors

        new Chart(ctx2, {
            type: "line",
            data: {
                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                datasets: [{
                        label: "Profit",
                        tension: 0.4,
                        borderWidth: 0,
                        pointRadius: 0,
                        borderColor: "#cb0c9f",
                        borderWidth: 3,
                        backgroundColor: gradientStroke1,
                        fill: true,
                        data: [
        <%=daoOrder.getProfitOfMonth(1)%>,
        <%=daoOrder.getProfitOfMonth(2)%>,
        <%=daoOrder.getProfitOfMonth(3)%>,
        <%=daoOrder.getProfitOfMonth(4)%>,
        <%=daoOrder.getProfitOfMonth(5)%>,
        <%=daoOrder.getProfitOfMonth(6)%>,
        <%=daoOrder.getProfitOfMonth(7)%>,
        <%=daoOrder.getProfitOfMonth(8)%>,
        <%=daoOrder.getProfitOfMonth(9)%>,
        <%=daoOrder.getProfitOfMonth(10)%>,
        <%=daoOrder.getProfitOfMonth(11)%>,
        <%=daoOrder.getProfitOfMonth(12)%>],
                        maxBarThickness: 6
                    },
                ],
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        display: false,
                    }
                },
                interaction: {
                    intersect: false,
                    mode: 'index',
                },
                scales: {
                    y: {
                        grid: {
                            drawBorder: false,
                            display: true,
                            drawOnChartArea: true,
                            drawTicks: false,
                            borderDash: [5, 5]
                        },
                        ticks: {
                            display: true,
                            padding: 10,
                            color: '#b2b9bf',
                            font: {
                                size: 11,
                                family: "Open Sans",
                                style: 'normal',
                                lineHeight: 2
                            },
                        }
                    },
                    x: {
                        grid: {
                            drawBorder: false,
                            display: false,
                            drawOnChartArea: false,
                            drawTicks: false,
                            borderDash: [5, 5]
                        },
                        ticks: {
                            display: true,
                            color: '#b2b9bf',
                            padding: 20,
                            font: {
                                size: 11,
                                family: "Open Sans",
                                style: 'normal',
                                lineHeight: 2
                            },
                        }
                    },
                },
            },
        });
    </script>
</html>