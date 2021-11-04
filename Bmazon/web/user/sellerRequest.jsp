<%-- 
    Document   : editProfile
    Created on : Sep 19, 2021, 10:51:53 AM
    Author     : Admin
--%>
<%@page import="entity.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.CategoryDAO"%>
<%@page import="entity.Seller"%>
<%@page import="model.SellerDAO"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Turn On Sales Feature</title>
        <!--        <link rel="shortcut icon" type="image/png" href="images/80jslogo.png">-->
        <%--js,css--%>   
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <style>
            body {
                background-color: #FAFAFA;
                font-family: "Amazon Ember",Arial,sans-serif;
            }

            .container .form-edit{
                background-color: #ffffff;
                padding-left: 25px;
            }

            .nav nav-tabs {
                font-family: "Amazon Ember",Arial,sans-serif;
            }

            p {
                font-size: 15px;
            }

            .card {
                padding: 15px;
            }
        </style>
    </head>
    <body>
        <%
            String service = request.getParameter("service");
            User x = (User) request.getAttribute("currUser");
            SellerDAO daoSeller = new SellerDAO();
            CategoryDAO daoCate = new CategoryDAO();
            int userID = Integer.parseInt(x.getUserId());
            Seller sel = daoSeller.getSellerByUserID(userID);
            ArrayList<Category> list = daoCate.getAllCategories();
        %>

        <jsp:include page="../header.jsp"/>

        <div class="container">
            <%if (sel.getSellerID() == 0) {%>
            <br>
            <h1>Turn on Sales Feature</h1>
            <br>
            <form action="UserControllerMap" method="POST">
                <input type="hidden" name ="service" value="requestSeller">
                <div class="card">
                    <div class="box">
                        <h2><strong>Your Shop name</strong></h2>
                        <div class="col-md-12 ">
                            <input name="shopName" type="text" value="" style="width: 25rem;">
                            <p>Your public shop name will be visible on your public shop page on Bmazon.</p>
                            <br>
                        </div>

                        <h2><strong>Register As A Seller</strong></h2>
                        <div class="col-md-12 ">
                            <div class="row">
                                <div class="col-md-6">
                                    <p>Seller Phone</p>
                                    <input id="phone" type="text" pattern="(0[3|5|7|8|9])+([0-9]{8})\b" name="sellerPhone" class="form-control" placeholder="Your phone" required autofocus="" >
                                    <p>Seller Email</p>
                                    <input id="email" type="text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" value="<%=x.getEmail()%>" class="form-control" placeholder="Your email" readonly required >
                                    <p>The email you use is registered as the user's email. If you want to change the email for your sales page, you will also change the email on your user page. Please change here.
                                        <span><a style="color: red;" href="${contextPath}/UserControllerMap?service=editPrivateProfile">   Edit</a></span>
                                    </p>
                                </div>
                                <div class="col-md-6">
                                    <p>Evidence</p>
                                    <textarea name="evidence" placeholder="The evidence, reason, or your linked photo to prove you're selling outside." required></textarea>
                                    <p>Main Product</p>
                                    <select name="sellerMainProduct">
                                        <%for (Category cate : list) {%>
                                        <option value="<%=cate.getCategoryID()%>"><%=cate.getCategoryName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <br>
                            </div>
                        </div>
                    </div>
                    <div style="text-align: center;">
                        <p style="color: red; font-size: 18px;">${mess}</p>
                        <a style="right: 50%;">        
                            <button type="submit" style="text-align:center; color:white;border-radius: 15px;height: 2em; width: 8em;" class="btn-warning"  > Save
                            </button> 
                        </a> 
                    </div> 
                    <div style="text-align: center; ">
                        <a style="right: 50%; color: red; font-size: 18px" href="UserControllerMap?service=account" >Back to account</a> 
                    </div> 
                </div>
            </form>
            <%} else if (sel.getSellerID() != 0 && sel.getSellerVerification() == 0) {%>
            <div style="height: 25rem;">
                <p style="color: red; font-size: 18px;">Waiting for administrator to verify your registration certificate...</p>
            </div>
            <%} else if (sel.getSellerID() != 0 && sel.getSellerVerification() == 2) {%>
            <br>
            <h1>Turn on Sales Feature</h1>
            <br>
            <p style="color: red; font-size: 18px;">You have been refused to become a seller on our Website.</p>
            <p style="color: red; font-size: 18px;">We hope you will register as a seller with more authentic commitments to be able to operate on our site.</p>
            <form action="UserControllerMap" method="POST">
                <input type="hidden" name ="service" value="editDeniedSellerInformation">
                <div class="card">
                    <div class="box">
                        <h2><strong>Your Shop name</strong></h2>
                        <div class="col-md-12 ">
                            <input name="shopName" type="text" value="" style="width: 25rem;">
                            <p>Your public shop name will be visible on your public shop page on Bmazon.</p>
                            <br>
                        </div>

                        <h2><strong>Register As A Seller</strong></h2>
                        <div class="col-md-12 ">
                            <div class="row">
                                <div class="col-md-6">
                                    <p>Seller Phone</p>
                                    <input id="phone" type="text" pattern="(0[3|5|7|8|9])+([0-9]{8})\b" name="sellerPhone" class="form-control" placeholder="Your phone" required autofocus="" >
                                    <p>Seller Email</p>
                                    <input id="email" type="text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" value="<%=x.getEmail()%>" class="form-control" placeholder="Your email" readonly required >
                                    <p>The email you use is registered as the user's email. If you want to change the email for your sales page, you will also change the email on your user page. Please change here.
                                        <span><a style="color: red;" href="${contextPath}/UserControllerMap?service=editPrivateProfile">   Edit</a></span>
                                    </p>
                                </div>
                                <div class="col-md-6">
                                    <p>Evidence</p>
                                    <textarea name="evidence" placeholder="The evidence, reason, or your linked photo to prove you're selling outside." required></textarea>
                                    <p>Main Product</p>
                                    <select name="sellerMainProduct">
                                        <%for (Category cate : list) {%>
                                        <option value="<%=cate.getCategoryID()%>"><%=cate.getCategoryName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <br>
                            </div>
                        </div>
                    </div>
                    <div style="text-align: center;">
                        <p style="color: red; font-size: 18px;">${mess}</p>
                        <a style="right: 50%;">        
                            <button type="submit" style="text-align:center; color:white;border-radius: 15px;height: 2em; width: 8em;" class="btn-warning"  > Save
                            </button> 
                        </a> 
                    </div> 
                    <div style="text-align: center; ">
                        <a style="right: 50%; color: red; font-size: 18px" href="UserControllerMap?service=account" >Back to account</a> 
                    </div>
                </div>
            </form>

            <%} else if (sel.getSellerID() != 0 && sel.getSellerVerification() == 1) {%>
            <br>
            <h1>Turn on Sales Feature</h1>
            <br>
            <form action="SellerControllerMap" method="POST">
                <input type="hidden" name ="service" value="editSellerInformation">
                <div class="card">
                    <div class="box">
                        <h2><strong>Your Shop name</strong></h2>
                        <div class="col-md-12 ">
                            <input name="shopName" type="text" value="<%=sel.getSellerShopName()%>" style="width: 25rem;">
                            <p>Your public shop name will be visible on your public shop page on Bmazon.</p>
                            <br>
                        </div>

                        <h2><strong>Register As A Seller</strong></h2>
                        <div class="col-md-12 ">
                            <div class="row">
                                <div class="col-md-6">
                                    <p>Seller Phone</p>
                                    <input id="phone" type="text" pattern="(0[3|5|7|8|9])+([0-9]{8})\b" value="<%=sel.getSellerPhone()%>" name="sellerPhone" class="form-control" placeholder="Your phone" required autofocus="" >
                                    <p>Seller Email</p>
                                    <input id="email" type="text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" value="<%=x.getEmail()%>" class="form-control" placeholder="Your email" readonly required >
                                    <p>The email you use is registered as the user's email. If you want to change the email for your sales page, you will also change the email on your user page. Please change here.
                                        <span><a style="color: red;" href="${contextPath}/UserControllerMap?service=editPrivateProfile">   Edit</a></span>
                                    </p>
                                </div>
                                <div class="col-md-6">
                                    <p>Main Product</p>
                                    <select name="sellerMainProduct">
                                        <%for (Category cate : list) {
                                                if (cate.getCategoryID() == sel.getSellerMainProduct()) {
                                        %>
                                        <option value="<%=cate.getCategoryID()%>" selected><%=cate.getCategoryName()%></option>
                                        <%} else {%>
                                        <option value="<%=cate.getCategoryID()%>"><%=cate.getCategoryName()%></option>
                                        <%}
                                            }%>
                                    </select>
                                    <p>Shop Description</p>
                                    <input type="text" class="form-control" placeholder="You are now authorized to sell on the Bmazon website" name="description">
                                </div>
                                <br>
                            </div>
                        </div>
                    </div>
                    <div style="text-align: center;">
                        <p style="color: red; font-size: 18px;">${mess}</p>
                        <a style="right: 50%;">        
                            <button type="submit" style="text-align:center; color:white;border-radius: 15px;height: 2em; width: 8em;" class="btn-warning"  > Save
                            </button> 
                        </a> 
                    </div> 
                    <div style="text-align: center; ">
                        <a style="right: 50%; color: red; font-size: 18px" href="UserControllerMap?service=account" >Back to account</a> 
                    </div>
                </div>
            </form>
            <%}%>
        </div>
        <br><br><br>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
