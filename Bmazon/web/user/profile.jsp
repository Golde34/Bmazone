<%-- 
    Document   : profile
    Created on : Sep 17, 2021, 3:33:54 PM
    Author     : Admin
--%>

<%@page import="model.GalleryDAO"%>
<%@page import="entity.Gallery"%>
<%@page import="entity.ProductType"%>
<%@page import="entity.Product"%>
<%@page import="model.ProductDAO"%>
<%@page import="model.ProductTypeDAO"%>
<%@page import="entity.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.CommentDAO"%>
<%@page import="model.UserDAO"%>
<%@page import="model.DBConnection"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <%
            User x = (User) request.getSession().getAttribute("currUser");
            UserDAO daoUser = new UserDAO();
            CommentDAO daoComment = new CommentDAO();
            ProductTypeDAO daoPrType = new ProductTypeDAO();
            ProductDAO daoProduct = new ProductDAO();
            GalleryDAO daoGallery = new GalleryDAO();
            ArrayList<Comment> comments = daoComment.getCommentsByUserId(Integer.parseInt(x.getUserId()));
        %>       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your public Profile</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
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
            .cover {
                background-color: black;
                background-image: url(${contextPath}/upload/<%= x.getBackgroundImage()%>);
                background-size: cover;
                background-repeat: no-repeat;
                background-position:center; 
                height: 230px;
                position: relative;
                width: 100%;
                margin-left: auto;
                margin-right: auto;
            } 
            .row .first-right-comment{
                height: 25px;
            }   
        </style>
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <div class="row py-5 px-4">
            <div class="col-md-10 mx-auto">
                <!-- Profile widget -->
                <div class="bg-white shadow rounded overflow-hidden">
                    <!--Avatar-->
                    <div class="px-4 pt-0 pb-4 cover">
                        <div class="media align-items-end profile-head">
                            <div class="profile mr-3">
                                <div class="profilepic" style="background-color: #e2c147;width: 190px;height: 190px;">
                                    <div class=" profilepic__image rounded mb-2 img-thumbnail" >
                                        <object data="upload/<%= x.getProfileImage()%>" width="180" height="180"></object>
                                    </div>
                                    <a href="${contextPath}/UserControllerMap?service=uploadProfileImage">
                                        <div class="profilepic__content">
                                            <span class="profilepic__icon"><i class="fas fa-camera"></i></span>
                                            <span class="profilepic__text">Upload Image</span>
                                        </div> 
                                    </a>
                                </div>
                                <a href="${contextPath}/UserControllerMap?service=editProfile" class="btn btn-outline-dark btn-sm btn-block">Edit profile</a>

                            </div>
                            <div class="media-body mb-5 text-white">
                                <h4 class="mt-0 mb-0" style="color: #ffffff; font-size:30px;"><%=x.getPublicName()%>
                                    <a href="${contextPath}/UserControllerMap?service=editProfile">   
                                        <i class="fas fa-pencil-alt" style="color: #96a2b8;"></i></a>
                                </h4>
                                <p class="mb-4" style="color: #ffffff;"> <i class="fas fa-map-marker-alt mr-2"></i><%= x.getAddress()%></p>
                            </div>
                        </div>
                        <div class="icon-background">
                            <a href="${contextPath}/UserControllerMap?service=uploadBackgroundImage">
                                <i class="fas fa-camera" style="font-size:2.5em; color: #96a2b8;"></i>
                            </a>
                        </div>
                    </div>

                    <!--Information-->    
                    <div class="bg-light p-4 d-flex justify-content-end text-center">
                        <ul class="list-inline mb-0">
                            <li class="list-inline-item">
                                <h5 class="font-weight-bold mb-0 d-block">215</h5><small class="text-muted"> <i class="fas fa-image mr-1"></i>Photos</small>
                            </li>
                            <li class="list-inline-item">
                                <h5 class="font-weight-bold mb-0 d-block">745</h5><small class="text-muted"> <i class="fas fa-user mr-1"></i>Followers</small>
                            </li>
                            <li class="list-inline-item">
                                <h5 class="font-weight-bold mb-0 d-block">340</h5><small class="text-muted"> <i class="fas fa-user mr-1"></i>Following</small>
                            </li>
                        </ul>
                    </div>
                    <br>
                    <div class="row">
                        <div class="py-4 px-4">
                            <div class="row">
                                <div class="pr-lg-1 mb-2 col-md-4">
                                    <div class="left-component p-4 rounded shadow-sm">
                                        <h4 class="mb-0"><strong>About</strong></h4>
                                        <a style="color: #00669c;" href="${contextPath}/UserControllerMap?service=editProfile">
                                            <p>Add more info about who you are</p></a>
                                        <div style="font-size: 25px;" class="row col-md-12">
                                            <a href="<%= x.getFacebook()%>" target="_blank" class="col-md-3">
                                                <i class="fab fa-facebook-f"></i></a> 
                                            <a href="<%= x.getInstagram()%>" target="_blank" class="col-md-3">
                                                <i class="fab fa-instagram"></i></a>
                                            <a href="<%= x.getTwitter()%>" target="_blank" class="col-md-3">
                                                <i class="fab fa-twitter"></i></a>
                                            <a href="<%= x.getYoutube()%>" target="_blank" class="col-md-3">
                                                <i class="fab fa-youtube"></i></a>
                                            <i class=""></i>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="left-component p-4 rounded shadow-sm">
                                        <h4 class="mb-0"><strong>Account</strong></h4>
                                        <p style="color: #333">Check your orders, add payment options, manage your password and more.</p>
                                        <a style="color: #00669c;" href="${contextPath}/UserControllerMap?service=account"> Go to your account</a>
                                    </div>
                                    <br>
                                    <div class="left-component p-4 rounded shadow-sm">
                                        <a href="CartControllerMap?service=MyOrder">
                                            <h4 class="mb-0"><strong>Views your orders</strong></h4>
                                        </a>
                                    </div>
                                    <br>
                                    <div class="left-component p-4 rounded shadow-sm">
                                        <%if (x.getSystemRole() == 0) {%>
                                        <a href="${contextPath}/UserControllerMap?service=turnOnSalesFeature">
                                            <h4 class="mb-0"><strong>Wanna create an online shop? Click here</strong></h4>
                                        </a>
                                        <% } else {%> 
                                        <a href="${contextPath}/UserControllerMap?service=editProfile">
                                            <h4 class="mb-0"><strong>Edit Seller Information</strong></h4>
                                        </a>
                                        <%}%>
                                    </div>
                                </div>

                                <div class="mb-2 pl-lg-1 col-md-8">
                                    <%if (comments.isEmpty()) {%>
                                    <div class="right-component p-4 rounded shadow-sm bg-light">
                                        <div class="py-3 d-flex justify-content-between">
                                            <h3 class="mb-0"><strong>Activities</strong></h3>
                                            <a href="UserControllerMap?service=listAllComments" class="btn btn-link text-muted">Show all</a>
                                        </div>
                                        <hr>
                                        <p class="font-italic mb-0"><%=x.getPublicName()%> has no activities to share.</p>
                                    </div>
                                    <%} else {%> 
                                    <%
                                        for (int i = 0; i < comments.size(); i++) {
                                    %>      
                                    <div class="right-component p-4 rounded shadow-sm bg-light">
                                        <%if (i == 0) {%>
                                        <div class="py-3 d-flex justify-content-between">
                                            <h3 class="mb-0"><strong>Activities</strong></h3>
                                            <a href="UserControllerMap?service=listAllComments" class="btn btn-link text-muted">Show all</a>
                                        </div><hr>
                                        <% } else { %>
                                        <p></p>
                                        <%}%>
                                        <div class="row first-right-comment" style="padding-left: 15px;">
                                            <object style="border-radius: 50%;" data="upload/<%= x.getProfileImage()%>" width="30" height="30"></object>
                                            <p style="padding: 7px; color: black; "><%=x.getFullname()%></p> 
                                            <p style="padding: 7px;">reviewed a product </p>    
                                        </div>
                                        <div class="row" style="padding-left: 15px;">
                                            <div class="reviews-counter" style="padding: 10px;">
                                                <div class="rate">
                                                    <% for (int star = 5; star > 0; star--) {%>
                                                    <%if (star <= comments.get(i).getRating()) {%>
                                                    <label for="star<%=star%>" title="text" style="color: #ffe793;"><%=star%> stars</label>
                                                    <%} else {%>
                                                    <label for="star<%=star%>" title="text"><%=star%> stars</label>
                                                    <%}
                                                        }%>
                                                </div>
                                            </div>
                                            <p class="comment_content " style="padding-left: 15px;"> <%=comments.get(i).getContent()%></p> 
                                        </div>  
                                        <div class="col-md-12"> 
                                            <%Product p = daoProduct.getProductByID(comments.get(i).getProductID());
                                                ProductType pt = daoPrType.getDefaultProductTypeByProductId(p.getProductID());
                                                Gallery g = daoGallery.getDefaultGalleryByProductTypeId(pt.getProductTypeId());
                                            %>
                                            <a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=p.getProductID()%>">
                                                <div class="row" style="border: 1px solid black; border-radius: 5px;padding: 10px;">
                                                    <div class="col-md-3">
                                                        <object style="margin-right: 20px;" data="images/<%=g.getLink()%>"></object>
                                                    </div>
                                                    <div class="col-md-9">
                                                        <p style="padding: 0;"><strong>Product:</strong> <%=p.getProductName()%></p> 
                                                        <div class="reviews-counter">
                                                            <div class="rate">
                                                                <% for (int star = 5; star > 0; star--) {%>
                                                                <%if (star <= p.getRating()) {%>
                                                                <label for="star<%=star%>" title="text" style="color: #ffe793;"><%=star%> stars</label>
                                                                <%} else {%>
                                                                <label for="star<%=star%>" title="text"><%=star%> stars</label>
                                                                <%}
                                                                    }%>
                                                            </div>
                                                        </div>
                                                        <p style="padding-left: 12rem; "><strong>Price:</strong> <%=pt.getPrice()%></p>
                                                    </div>
                                                </div> 
                                            </a>
                                        </div>
                                        <hr style="color: black;">
                                    </div><br>
                                    <%}
                                        }%>

                                </div>
                            </div>
                        </div>
                        <div class="py-4 px-4">
                            <div class="d-flex align-items-center justify-content-between mb-3">
                                <h3 class="mb-0">Recent product reviews</h3>
                            </div>
                            <div class="row">
                                <% for (int i = 0; i < comments.size(); i++) { %>
                                <%Product p = daoProduct.getProductByID(comments.get(i).getProductID());
                                    ProductType pt = daoPrType.getDefaultProductTypeByProductId(p.getProductID());
                                    Gallery g = daoGallery.getRevertGalleryByProductTypeId(pt.getProductTypeId());%>
                                <div class="col-lg-6 "> 
                                    <div class="box">
                                        <a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=p.getProductID()%>">
                                            <object style="height: 300px;" data="images/<%=g.getLink()%>"></object></a>
                                        <div class="overlay">
                                            <div class="content">
                                                <a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=p.getProductID()%>">Read More</a>
                                            </div>
                                        </div>
                                    </div>  

                                </div>
                                <%    }
                                %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
