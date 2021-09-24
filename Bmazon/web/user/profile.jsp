<%-- 
    Document   : profile
    Created on : Sep 17, 2021, 3:33:54 PM
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
        <%
            User x = (User) request.getSession().getAttribute("currUser");

            DBConnection dbCon = new DBConnection();
            UserDAO daoUser = new UserDAO();
//            DAOGalery daoGalery = new DAOGalery(dbCon);

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
        <style>
            .profile-head {
                transform: translateY(5rem)
            }

            .cover {
                background-image: url(${contextPath}/images/<%= x.getBackgroundImage()%>);
                background-size: cover;
                background-repeat: no-repeat;
                height: 230px;
            }

            body {
                background: #654ea3;
                background: linear-gradient(to right, #e96443, #904e95);
                min-height: 100vh;
                overflow-x: hidden
            }
        </style>
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        
        <div class="row py-5 px-4">
            <div class="col-md-10 mx-auto">
                <!-- Profile widget -->
                <div class="bg-white shadow rounded overflow-hidden">
                    <div class="px-4 pt-0 pb-4 cover">
                        <!--                        <div class="a-row desktop cover-photo-edit-icon">
                                                    <img alt="" src="//d1k8kvpjaf8geh.cloudfront.net/gp/profile/assets/camera-desktop-4aba2c5ff428bad7bee93a2e61a2ad5128cbdd58b770618a1fd108abca1e2f31.png">
                                                    <span class="a-declarative" data-action="a-popover" data-a-popover="{&quot;name&quot;:&quot;cover-photo-edit-image-popover&quot;,&quot;dataStrategy&quot;:&quot;preload&quot;,&quot;position&quot;:&quot;triggerBottom&quot;,&quot;activate&quot;:&quot;onclick&quot;,&quot;closeButton&quot;:&quot;false&quot;,&quot;closeButtonLabel&quot;:&quot;cover-photo-upload-popover-close&quot;}">
                                                        <div id="cover-photo-edit-popover-trigger" class="a-section edit-popover-trigger">
                                                        </div>
                                                    </span>
                                                </div>-->
                        <div class="media align-items-end profile-head">
                            <div class="profile mr-3">
                                <img src="${contextPath}/images/<%= x.getProfileImage()%>"
                                                           alt="..." width="180" class="rounded mb-2 img-thumbnail">
                                <a href="${contextPath}/UserControllerMap?service=editProfile" class="btn btn-outline-dark btn-sm btn-block">Edit profile</a>
                            </div>
                            <div class="media-body mb-5 text-white">
                                <h4 class="mt-0 mb-0" style="color: white; font-size:30px;"><%=x.getFullname()%></h4>
                                <p class="small mb-4"> <i class="fas fa-map-marker-alt mr-2"></i><%= x.getAddress()%></p>
                            </div>
                        </div>
                    </div>
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
                        <div class="px-4 py-3 col-md-4">
                            <ul> 
                                <li >
                                    <h5 class="mb-0"><strong>About</strong></h5>
                                    <div class="p-4 rounded shadow-sm bg-light" style="background-color: #F5F7F5">
                                        <p class="font-italic mb-0">Web Developer</p>
                                        <p class="font-italic mb-0">Lives in New York</p>
                                        <p class="font-italic mb-0">Photographer</p>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="px-4 py-3 col-md-8">

                            <h5 class="mb-0"><strong>Your list and your wishlist</strong></h5>
                            <div class="p-4 rounded shadow-sm bg-light" style="background-color: #F5F7F5">
                                <p class="font-italic mb-0">Web Developer</p>
                                <p class="font-italic mb-0">Lives in New York</p>
                                <p class="font-italic mb-0">Photographer</p>
                            </div>

                            <!--                            <h5 class="mb-0"><strong>Insights</strong></h5>
                                                        <div class="p-4 rounded bg-light" style="background-color: #F5F7F5">
                                                            <p class="font-italic mb-0">Web Developer</p>
                                                            <p class="font-italic mb-0">Lives in New York</p>
                                                            <p class="font-italic mb-0">Photographer</p>
                                                        </div>-->
                        </div>
                    </div>
                    <div class="py-4 px-4">
                        <div class="d-flex align-items-center justify-content-between mb-3">
                            <h5 class="mb-0">Recent photos</h5><a href="#" class="btn btn-link text-muted">Show all</a>
                        </div>
                        <div class="row">
                            <div class="col-lg-6 mb-2 pr-lg-1"><img src="https://images.unsplash.com/photo-1469594292607-7bd90f8d3ba4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80" alt="" class="img-fluid rounded shadow-sm"></div>
                            <div class="col-lg-6 mb-2 pl-lg-1"><img src="https://images.unsplash.com/photo-1493571716545-b559a19edd14?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80" alt="" class="img-fluid rounded shadow-sm"></div>
                            <div class="col-lg-6 pr-lg-1 mb-2"><img src="https://images.unsplash.com/photo-1453791052107-5c843da62d97?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80" alt="" class="img-fluid rounded shadow-sm"></div>
                            <div class="col-lg-6 pl-lg-1"><img src="https://images.unsplash.com/photo-1475724017904-b712052c192a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80" alt="" class="img-fluid rounded shadow-sm"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../footer.jsp"/>
</body>
</html>
