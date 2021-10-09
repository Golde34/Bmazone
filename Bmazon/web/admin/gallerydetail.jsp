<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    ShipCompany company = (ShipCompany) request.getAttribute("company");
    Gallery gallery = (Gallery) request.getAttribute("gallery");
    Product product = (Product) request.getAttribute(("product"));
    ProductType producttype = (ProductType) request.getAttribute("producttype");
    String mess = (String) request.getAttribute("mess");
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
                            <div class="card-body px-0 pb-2">
                                <div class="card-header py-3" 
                                     style="display: flex;
                                     justify-content: space-between;">
                                    <h6 class="m-0 font-weight-bold text-primary">Gallery Detail</h6>
                                </div>
                                <div class="card-body">
                                    <form class="form" action="/Bmazon/AdminControllerMap" method="POST">
                                        <%if (service.equalsIgnoreCase("addgallerydetail")) {%>
                                        <table class="table table-striped">
                                            <tr>
                                                <td>Product Name</td>
                                                <td>
                                                    <textarea name="productname" rows="3"></textarea><br>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Color</td>
                                                <td><input type="text" name="color" class="input"><br></td>
                                            </tr>    
                                            <tr>
                                                <td>Size<p></td>
                                                <td><input type="text" name="size" class="input"><br></td>
                                            </tr>
                                            <tr>
                                                <td>Link<p></td>
                                                <td>
                                                    <input type="file" name="link" class="input"><br>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="submit" value="Update Gallery" class="btn btn-primary">
                                                    <input type="hidden" value="updategallery" name="service">
                                                </td>
                                            </tr>
                                        </table>
                                        <%}%>
                                        <%if (service.equalsIgnoreCase("updategallerydetail")) {%>
                                        <table class="table table-striped">
                                            <tr>
                                                <td>Product Name</td>
                                                <td>
                                                    <textarea name="productname" rows="3"><%=product.getProductName()%> </textarea><br>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Color</td>
                                                <td><input value="<%=producttype.getColor()%>" type="text" name="unitcost" class="input"><br></td>
                                            </tr>    
                                            <tr>
                                                <td>Size<p></td>
                                                <td><input value="<%=producttype.getSize()%>" type="text" name="commitdate" class="input"><br></td>
                                            </tr>
                                            <tr>
                                                <td>Link<p></td>
                                                <td>
                                                    <%String str = "images/" + gallery.getLink();%>
                                                    <img src="<%=str%>" width="150px" height="150px"><br>
                                                    <input type="file" name="commitdate" class="input"><br>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="submit" value="Update Gallery" class="btn btn-primary">
                                                    <input type="hidden" value="updategallery" name="service">
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
        <!-- Github buttons -->
        <script async defer src="https://buttons.github.io/buttons.js"></script>
        <!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<!--        <script src="${contextPath}/js/soft-ui-dashboard.min.js?v=1.0.3"></script>-->

    </body>

</html>