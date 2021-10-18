<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    Gallery gallery = (Gallery) request.getAttribute("gallery");
    Seller seller = (Seller) request.getAttribute("seller");
    Product product = (Product) request.getAttribute(("product"));
    ProductType producttype = (ProductType) request.getAttribute("producttype");
    String mess = (String) request.getAttribute("mess");
    if (mess == null) {
        mess = "";
    }
    String service = (String) request.getAttribute("service");
    String f = (String) request.getAttribute("filen");
    User curUser = (User) request.getSession().getAttribute("currUser");
    List<ShipCompany> listCompany = (ArrayList<ShipCompany>) request.getAttribute("listCompany");
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
                                    <div class="card-header py-3 d-flex justify-content-between">
                                        <h6 class="m-0 font-weight-bold text-primary">Gallery Detail</h6>
                                    </div>
                                    <div class="card-body">
                                        <form enctype="multipart/form-data" class="form" action="/Bmazon/AdminControllerMap?service=updategallery&galleryid=<%=gallery.getGalleryID()%>" method="POST">
                                            <table style="width: 100%;" class="table table-striped">
                                                <tr>
                                                    <td style="width: 30%;">Product Name</td>
                                                    <td style="width: 70%;">
                                                        <textarea readonly class="form-control" name="productname" rows="3"><%=product.getProductName()%> </textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Color</td>
                                                <td><input readonly class="form-control" value="<%=producttype.getColor()%>" type="text" name="color"></td>
                                            </tr>    
                                            <tr>
                                                <td>Size<p></td>
                                                <td><input readonly class="form-control" value="<%=producttype.getSize()%>" type="text" name="size"></td>
                                            </tr>
                                            <tr>
                                                <td>Seller<p></td>
                                                <td><input readonly class="form-control" value="<%=seller.getSellerShopName()%>" type="text" name="seller"></td>
                                            </tr>
                                            <tr>
                                                <td>Link<p></td>
                                                <td>
                                                    <img id="img" src="images/<%=gallery.getLink()%>" width="150px" height="150px"><br>                    
                                                    <input required accept="image/*" onchange="loadFile(event)" id="file" type="file" name="photo">
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="hidden" value="<%=gallery.getGalleryID()%>" name="galleryid">
                                                    <input type="submit" value="Update Gallery" class="btn btn-primary">
                                                </td>
                                            </tr>
                                        </table>
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
    <script>
        var loadFile = function (event) {
            var output = document.getElementById('img');
            img.src = URL.createObjectURL(event.target.files[0]);
            img.onload = function () {
                URL.revokeObjectURL(img.src)
            }
        };
    </script>
</html>