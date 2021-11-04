<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    DecimalFormat nf = new DecimalFormat("###,###,###");
    ProductDAO daoProduct = new ProductDAO();
    ShipCompanyDAO daoCompany = new ShipCompanyDAO();
    OrderDAO daoOrder = new OrderDAO();
    ArrayList<Product> top6Product = daoProduct.getAllPagingProduct(1, 6, "");
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
            <jsp:include page="employeesidebar.jsp"></jsp:include>
            </aside>
            <!--End Sidebar-->
            <main class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
                <!-- Header -->
            <jsp:include page="employeeheader.jsp"></jsp:include>
                <!-- End header -->
                <h1>Hello</h1>
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