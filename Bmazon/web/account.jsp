<%-- 
    Document   : account
    Created on : Sep 23, 2021, 9:53:59 AM
    Author     : Admin
--%>

<%@page import="model.UserDAO"%>
<%@page import="model.DBConnection"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Account</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!--Body resources-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <%
            User x = (User) request.getSession().getAttribute("currUser");

            DBConnection dbCon = new DBConnection();
            UserDAO daoUser = new UserDAO();
//            DAOGalery daoGalery = new DAOGalery(dbCon);

        %>
        <br>
        <style>
            .container{
                width: 80rem;
            }

            .card-title {
                font-size: 1.3rem;
            }

            .card-body img {
                width: 4em;
            }
        </style>

        <div class="container">
            <h1>Your Account</h1>
            <br>
            <div class="row" style="padding: 15px;">
                <!--Order-->
                <div class="col-lg-4 col-md-5">
                    <a href="#">
                        <div class=" card shadow p-3 mb-5 bg-white rounded" style="width: 20rem; height: 9rem;"> 
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-4">
                                        <img alt="Your Order" src="https://images-na.ssl-images-amazon.com/images/G/01/x-locale/cs/help/images/gateway/self-service/order._CB660668735_.png">
                                    </div>
                                    <div class="col-md-8">
                                        <h5 class="card-title">Your Order</h5>
                                        <h6 class="card-subtitle mb-2 text-muted">Track, return, or buy things again </h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>

                <!--Security-->
                <div class="col-lg-4 col-md-5">
                    <a href="UserControllerMap?service=editPrivateProfile">
                        <div class=" card shadow p-3 mb-5 bg-white rounded" style="width: 20rem; height: 9rem;"> 
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-4">
                                        <img alt="Security" src="https://images-na.ssl-images-amazon.com/images/G/01/x-locale/cs/help/images/gateway/self-service/security._CB659600413_.png">
                                    </div>
                                    <div class="col-md-8">
                                        <h5 class="card-title">Login & Security</h5>
                                        <h6 class="card-subtitle mb-2 text-muted">Edit login, name, and mobile number</h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>

                <!--Profile-->
                <div class="col-lg-4 col-md-5">
                    <a href="UserControllerMap?service=info">
                        <div class=" card shadow p-3 mb-5 bg-white rounded" style="width: 20rem; height: 9rem;"> 
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-4">
                                        <img alt="Your Profile" src="https://images-na.ssl-images-amazon.com/images/G/01/x-locale/cs/help/images/gateway/self-service/account._CB660668669_.png">
                                    </div>
                                    <div class="col-md-8">
                                        <h5 class="card-title">Your Profile</h5>
                                        <h6 class="card-subtitle mb-2 text-muted">Manage user profiles </h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>

                <!--Top Up-->
                <div class="col-lg-4 col-md-5">
                    <a href="UserControllerMap?service=editWallet">
                        <div class=" card shadow p-3 mb-5 bg-white rounded" style="width: 20rem;"> 
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-4">
                                        <img alt="Top Up" src="https://images-na.ssl-images-amazon.com/images/G/01/x-locale/cs/help/images/gateway/self-service/payment._CB660668735_.png">
                                    </div>
                                    <div class="col-md-8">
                                        <h5 class="card-title">Wallet</h5>
                                        <h6 class="card-subtitle mb-2 text-muted">Manage your balance </h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                
                <!--Sales Feature-->
                <% if (x.getSystemRole() != 2) { %>
                <div class="col-lg-4 col-md-5">
                    <a href="UserControllerMap?service=turnOnSalesFeature">
                        <div class=" card shadow p-3 mb-5 bg-white rounded" style="width: 20rem; height: 9rem;"> 
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-4">
                                        <img alt="Sales Feature" src="https://images-na.ssl-images-amazon.com/images/G/01/x-locale/cs/contact-us/GiftCard_icon_01._CB660349069_.png">                                    </div>
                                    <div class="col-md-8">
                                        <h5 class="card-title">Turn on Sales Feature </h5>
                                        <h6 class="card-subtitle mb-2 text-muted">Register to seller</h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <%} else { %>
                <div class="col-lg-4 col-md-5">
                    <a href="SellerControllerMap?service=editSellerInformation">
                        <div class=" card shadow p-3 mb-5 bg-white rounded" style="width: 20rem;"> 
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-4">
                                        <img alt="Sales Feature" src="https://images-na.ssl-images-amazon.com/images/G/01/x-locale/cs/contact-us/GiftCard_icon_01._CB660349069_.png">                                    </div>
                                    <div class="col-md-8">
                                        <h5 class="card-title">Seller information</h5>
                                        <h6 class="card-subtitle mb-2 text-muted">Edit seller information </h6>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <%}%>
            </div>
        </div>
        <br><br><br><br><br><br><br>
        <br><br><br><br><br><br><br>

        <jsp:include page="footer.jsp"/>
    </body>
</html>
