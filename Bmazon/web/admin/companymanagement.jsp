<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
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
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${contextPath}/UserControllerMap">
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
                        <a class="nav-link" href="AdminControllerMap?service=usermanagement">
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="fas fa-fw fa-tachometer-alt"  style="color: black"></i>
                            </div>
                            <span class="nav-link-text ms-1">User Management</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link  " href="AdminControllerMap?service=productmanagement">
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="fas fa-fw fa-tachometer-alt " style="color: black"></i>
                            </div>
                            <span class="nav-link-text ms-1 ">Product Management</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active " href="AdminControllerMap?service=companymanagement">
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="fas fa-fw fa-tachometer-alt"></i>
                            </div>
                            <span class="nav-link-text ms-1">Company Management</span>
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
            <nav class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl" id="navbarBlur" navbar-scroll="true">
                <div class="container-fluid py-1 px-3">
                    <nav aria-label="breadcrumb">
                        <li class="nav-item d-xl-none ps-3 d-flex align-items-center">
                            <a href="javascript:;" class="nav-link text-body p-0" id="iconNavbarSidenav">
                                <div class="sidenav-toggler-inner">
                                    <i class="sidenav-toggler-line"></i>
                                    <i class="sidenav-toggler-line"></i>
                                    <i class="sidenav-toggler-line"></i>
                                </div>
                            </a>
                        </li>
                        <h6 class="font-weight-bolder mb-0">Dashboard</h6>
                    </nav>
                    <div class="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4" id="navbar">
                        <div class="ms-md-auto pe-md-3 d-flex align-items-center">
                            <div class="input-group">
                            </div>
                        </div>
                        <ul class="navbar-nav  justify-content-end">
                            <li class="nav-item dropdown pe-2 d-flex align-items-center">
                                <a href="javascript:;" class="nav-link text-body p-0" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=curUser.getFullname()%></span>
                                    <img class="img-profile rounded-circle"
                                         src="${contextPath}/images/defaultPicture.jpg" width="30px" height="30px">
                                </a>
                                <ul class="dropdown-menu  dropdown-menu-end  px-2 py-3 me-sm-n4" aria-labelledby="dropdownMenuButton">
                                    <li class="mb-2">
                                        <a class="dropdown-item border-radius-md" href="${contextPath}/UserControllerMap?service=info">
                                            <div class="d-flex py-1">
                                                <div class="d-flex flex-column justify-content-center">
                                                    <h6 class="text-sm font-weight-normal mb-1">
                                                        Profile
                                                    </h6>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="mb-2">
                                        <a class="dropdown-item border-radius-md" href="">
                                            <div class="d-flex py-1">
                                                <div class="d-flex flex-column justify-content-center">
                                                    <h6 class="text-sm font-weight-normal mb-1">
                                                        Shopping
                                                    </h6>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item border-radius-md" href="${contextPath}/UserControllerMap?service=logout">
                                            <div class="d-flex py-1">
                                                <div class="d-flex flex-column justify-content-center">
                                                    <h6 class="text-sm font-weight-normal mb-1">
                                                        Log out
                                                    </h6>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- End Navbar -->
            <div class="container-fluid py-4">
                <div class="row mt-4">

                </div>
                <div class="row my-4">
                    <div class="col-lg-12 col-md-12 mb-md-0 mb-4">
                        <div class="card">
                            <div class="card-body px-0 pb-2">
                                <div class="card-header py-3" 
                                     style="display: flex;
                                     justify-content: space-between;">
                                    <h6 class="m-0 font-weight-bold text-primary">Ship Company</h6>
                                    <a href="AdminControllerMap?service=addcompanydetail">
                                        <button>Add new company</button></a>
                                </div>
                                <div class="card-body">
                                    <div class="table_head py-3" style="display: flex;
                                         justify-content: space-between;">
                                        <div class="rowNum">
                                            <h6 style="display: inline">Select number of Rows</h6>
                                            <div class="form-group" style="display: inline;">
                                                <select name="state" id="maxRows" class="form-control" style="width:80px;display:inline;">
                                                    <option value="5">5</option>
                                                    <option value="10">10</option>
                                                    <option value="20">20</option>
                                                    <option value="5000">Show All</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="ms-md-auto pe-md-3 d-flex align-items-center">
                                            <div class="input-group">
                                                <span class="input-group-text text-body"><i class="fas fa-search" aria-hidden="true"></i></span>
                                                <input type="text" class="form-control" placeholder="Type here...">
                                            </div>
                                        </div>
                                    </div>
                                    <table class="table table-bordered table-striped" id="dataTable" style="text-align: center;">
                                        <thead>
                                            <tr>
                                                <th>Username</th>
                                                <th>Password</th>
                                                <th>Email</th>
                                                <th>Phone</th>
                                                <th>Address</th>
                                                <th></th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for (ShipCompany company : listCompany) {%>
                                            <tr>
                                                <td><%=company.getCompanyName()%></td>
                                                <td><%=company.getCommitDate()%></td>
                                                <td><%=company.getUnitCost()%></td>
                                                <td><%=company.getCompanyID()%></td>
                                                <td><%=company.getStatus()%></td>
                                                <td>
                                                    <a href="AdminControllerMap?service=updatecompanydetail&companyid=<%=company.getCompanyID()%>"><span class="fas fa-edit"></span></a>
                                                </td>
                                                <td><a href="AdminControllerMap?service=deletecompany&companyid=<%=company.getCompanyID()%>" onclick="return confirm('Are you sure you want to Remove?');"><span class="fas fa-trash-alt"></span></a></td>
                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                    <div class="pagination-container" style="display: flex;
                                         justify-content: flex-end;cursor: pointer;">
                                        <nav>
                                            <ul class="pagination">
                                                <li class="page-item disabled">
                                                    <a class="page-link" href="#" tabindex="-1">Previous</a>
                                                </li>
                                                <li class="page-item">
                                                    <a class="page-link" href="#">Next</a>
                                                </li>
                                            </ul>
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
        <!-- Github buttons -->
        <script async defer src="https://buttons.github.io/buttons.js"></script>
        <!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<!--        <script src="${contextPath}/js/soft-ui-dashboard.min.js?v=1.0.3"></script>-->
        <script>
                                                    getPagination('#dataTable');
                                                    $('#maxRows').trigger('change');
                                                    function getPagination(table) {

                                                        $('#maxRows').on('change', function () {
                                                            $('.pagination').html('');
                                                            var trnum = 0;
                                                            var maxRows = parseInt($(this).val());

                                                            var totalRows = $(table + ' tbody tr').length;
                                                            $(table + ' tr:gt(0)').each(function () {
                                                                trnum++;
                                                                if (trnum > maxRows) {

                                                                    $(this).hide();
                                                                }
                                                                if (trnum <= maxRows) {
                                                                    $(this).show();
                                                                }// else fade in Important in case if it ..
                                                            });
                                                            if (totalRows > maxRows) {
                                                                var pagenum = Math.ceil(totalRows / maxRows);
                                                                //	numbers of pages 
                                                                for (var i = 1; i <= pagenum; ) {
                                                                    $('.pagination').append('<li class="page-item" data-page="' + i + '">\
<a class="page-link">' + i++ + '<span class="sr-only">(current)</span></a>\
</li>').show();
                                                                }
                                                                i
                                                            }
                                                            $('.pagination li:first-child').addClass('active');

                                                            $('.pagination li').on('click', function (e) {
                                                                e.preventDefault();
                                                                var pageNum = $(this).attr('data-page');
                                                                var trIndex = 0;
                                                                $('.pagination li').removeClass('active');
                                                                $(this).addClass('active');


                                                                $(table + ' tr:gt(0)').each(function () {
                                                                    trIndex++;
                                                                    if (trIndex > (maxRows * pageNum) || trIndex <= ((maxRows * pageNum) - maxRows)) {
                                                                        $(this).hide();
                                                                    } else {
                                                                        $(this).show();
                                                                    }
                                                                });
                                                            });
                                                        });
                                                    }

                                                    function FilterkeyWord_all_table() {

// Count td if you want to search on all table instead of specific column

                                                        var count = $('.table').children('tbody').children('tr:first-child').children('td').length;

                                                        // Declare variables
                                                        var input, filter, table, tr, td, i;
                                                        input = document.getElementById("search_input_all");
                                                        var input_value = document.getElementById("search_input_all").value;
                                                        filter = input.value.toLowerCase();
                                                        if (input_value != '') {
                                                            table = document.getElementById("table-id");
                                                            tr = table.getElementsByTagName("tr");

                                                            // Loop through all table rows, and hide those who don't match the search query
                                                            for (i = 1; i < tr.length; i++) {

                                                                var flag = 0;

                                                                for (j = 0; j < count; j++) {
                                                                    td = tr[i].getElementsByTagName("td")[j];
                                                                    if (td) {

                                                                        var td_text = td.innerHTML;
                                                                        if (td.innerHTML.toLowerCase().indexOf(filter) > -1) {
                                                                            //var td_text = td.innerHTML;  
                                                                            //td.innerHTML = 'shaban';
                                                                            flag = 1;
                                                                        } else {
                                                                            //DO NOTHING
                                                                        }
                                                                    }
                                                                }
                                                                if (flag == 1) {
                                                                    tr[i].style.display = "";
                                                                } else {
                                                                    tr[i].style.display = "none";
                                                                }
                                                            }
                                                        } else {
                                                            //RESET TABLE
                                                            $('#maxRows').trigger('change');
                                                        }
                                                    }
        </script>
    </body>

</html>