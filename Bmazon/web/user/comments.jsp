<%-- 
    Document   : editProfile
    Created on : Sep 19, 2021, 10:51:53 AM
    Author     : Admin
--%>
<%@page import="model.CommentDAO"%>
<%@page import="entity.Seller"%>
<%@page import="model.SellerDAO"%>
<%@page import="model.GalleryDAO"%>
<%@page import="model.ProductDAO"%>
<%@page import="model.ProductTypeDAO"%>
<%@page import="entity.Gallery"%>
<%@page import="entity.ProductType"%>
<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Comment"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comments</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--        <link rel="shortcut icon" type="image/png" href="images/80jslogo.png">-->
        <%--js,css--%>   
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!--Body resources-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css">     
        <link rel="stylesheet" href="${contextPath}/css/profile.css"> 
        <style>
            body {
                background-color: #FAFAFA;
                font-family: "Amazon Ember",Arial,sans-serif;
            }
            .row .first-right-comment{
                height: 15px;
            } 
        </style>
    </head>
    <body>
        <%
            User x = (User) request.getSession().getAttribute("currUser");
            ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("listComment");
            ProductTypeDAO daoPrType = new ProductTypeDAO();
            ProductDAO daoProduct = new ProductDAO();
            GalleryDAO daoGallery = new GalleryDAO();
            SellerDAO daoSeller = new SellerDAO();
            CommentDAO daoComment = new CommentDAO();
        %>

        <jsp:include page="../header.jsp"/>
        <div class="container">
            <%
                for (int i = 0; i < comments.size(); i++) {
            %>      
            <div class="right-component rounded shadow-sm bg-light">
                <div class="row">
                    <div class="col-md-5">
                        <div class="row" style="padding:15px 0 0 15px; margin:0;">
                            <object style="border-radius: 50%;" data="upload/<%= x.getProfileImage()%>" width="40" height="40"></object>
                            <p style="padding: 5px; color: black; font-size: 18px; "><%=x.getFullname()%></p>
                        </div>
                        <div class="reviews-counter" style="padding: 0 10px 10px 15px;">
                            <div class="rate">
                                <% for (int star = 5; star > 0; star--) {%>
                                <%if (star <= comments.get(i).getRating()) {%>
                                <label for="star<%=star%>" title="text" style="color: #ffe793;"><%=star%> stars</label>
                                <%} else {%>
                                <label for="star<%=star%>" title="text"><%=star%> stars</label>
                                <%}
                                    }%>
                            </div>
                        </div> <br>
                        <p class="comment_content " style="padding-left: 18px;">Reviewed in the <%=x.getAddress()%></p>
                        <p class="comment_content " style="padding-left: 18px;"> <%=comments.get(i).getContent()%></p> 
                    </div>
                    <div class="col-md-7" style="padding:15px; margin:0;"> 
                        <%Product p = daoProduct.getProductByID(comments.get(i).getProductID());
                            ProductType pt = daoPrType.getDefaultProductTypeByProductId(p.getProductID());
                            Gallery g = daoGallery.getDefaultGalleryByProductTypeId(pt.getProductTypeId());
                            Seller s = daoSeller.getSellerByProductId(p.getProductID());
                            ArrayList<Comment> c = daoComment.getCommentsByProductId(p.getProductID());
                        %>
                        <h1>Product Details</h1>
                        <div class="row" style="border: 1px solid black; border-radius: 5px;padding: 10px;">
                            <div class="col-md-3">
                                <a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=p.getProductID()%>">
                                    <object style="margin-right: 20px;" data="images/<%=g.getLink()%>"></object>
                                </a>
                            </div>
                            <div class="col-md-9" style="padding: 0;">
                                <p style="padding: 0; margin:0; color: #001f3f; font-size: 18px;"><%=p.getProductName()%></p> 
                                <div class="row" style="padding: 3px 15px 0px 15px;">
                                    <p style="padding:0; margin: 0;">by <span style="color: #0089db;"><%=s.getSellerShopName()%></span</p>
                                </div>
                                <div class="reviews-counter">
                                    <div class="rate">
                                        <% for (int star = 5; star > 0; star--) {%>
                                        <%if (star <= p.getRating()) {%>
                                        <label for="star<%=star%>" title="text" style="color: #ffa41c; font-size: 1.5rem;"><%=star%> stars</label>
                                        <%} else {%>
                                        <label for="star<%=star%>" title="text" style="font-size: 1.5rem;"><%=star%> stars</label>
                                        <%}
                                            }%>
                                    </div>
                                </div>
                                <p style="padding-left: 9rem; font-size: 1.2rem; margin:0;"> <%=p.getRating()%> out of 5.</p>
                                <p style="margin:3px 0 5px 0;"><%=c.size()%> ratings</p>
                                <%for (int rate = 5; rate > 0; rate--) {%>
                                <%ArrayList<Comment> numberRating = daoComment.getCommensByProductIdAndRating(p.getProductID(), rate);%>
                                <div class="row" style="height: 30px;">
                                    <div class="col-md-2">
                                        <p><%=rate%> star</p>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="w3-light-grey w3-round">
                                            <div class="w3-container w3-round w3-blue" style="width:<%=(numberRating.size()/c.size())*100%>%; height: 1.5rem;"></div>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <p><%=(numberRating.size()/c.size())*100%>%</p>
                                    </div>
                                </div>
                                <%}%>

                            </div>
                        </div>
                    </div>
                </div>
                <hr style="color: black;">
            </div><br>
            <%}%>
        </div>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
