<%-- 
    Document   : editProfile
    Created on : Sep 19, 2021, 10:51:53 AM
    Author     : Admin
--%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Information</title>
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
            User x = (User) request.getAttribute("currUser");
        %>

        <jsp:include page="../header.jsp"/>

        <div class="container">
            <br>
            <h1 >Public Profile page settings</h1>
            <br>
            <ul class="nav nav-tabs">
                <li class="active" style="font-size: 18px;"><a data-toggle="tab" href="#public-name">Edit public profile</a></li>
                <li style="font-size: 18px;"><a data-toggle="tab" href="#sales-feature">Turn on the sales feature</a></li>
            </ul>
            <br><br>
            <div class="tab-content">
                <div class="tab-pane fade in active" id="public-name">
                    <form action="UserControllerMap" method="POST">
                        <input type="hidden" name ="service" value="changeinfo">
                        <div class="card">
                            <div class="box">
                                <h2><strong>Your public name</strong></h2>
                                <div class="col-md-12 ">
                                    <input name="username" type="text" value="<%=x.getPublicName()%>" style="width: 25rem;">
                                    <p>This will not change the name associated with your account (<%=x.getFullname()%>)
                                        <span><a style="color: red;" href="${contextPath}/UserControllerMap?service=editPrivateProfile">   Edit</a></span>
                                    </p>
                                    <p>Your public name will be visible on your public profile page and elsewhere on Bmazon.</p>
                                    <br>
                                </div>

                                <h2><strong>Your public information (optional)</strong></h2>
                                <div class="col-md-12 ">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <p>Bio</p>
                                            <textarea name="bio" placeholder="Share a little about you"></textarea>
                                            <p>Date of birth</p>
                                            <input type="date" name="dob" value="<%=x.getDOB()%>">
                                        </div>
                                        <div class="col-md-6">
                                            <p>Location</p>
                                            <input name="address" type="text" value="<%= x.getAddress()%>" placeholder="Enter your location">
                                            <p>Occupation</p>
                                            <input name="occupation" type="text" value="<%= x.getOccupation()%>" placeholder="Enter your occupation">
                                            <p>Gender</p>
                                            <% if (x.getGender() == 0) {%>
                                            <select name="gender">
                                                <option value="0">Female</option>
                                                <option value="1">Male</option>
                                            </select>
                                            <%} else {%>
                                            <select name="gender">
                                                <option value="1">Male</option>
                                                <option value="0">Female</option>
                                            </select>
                                            <%}%>
                                        </div>
                                        <br>
                                    </div>
                                </div>

                                <h2><strong>Add social links to your public profile (optional)</strong></h2>
                                <div class="col-md-12 ">

                                    <div class="row">
                                        <div class="col-md-6">
                                            <p>Facebook</p>
                                            <input name="Facebook" type="text" value="<%= x.getFacebook()%>" placeholder="http://www.facebook.com/...">
                                            <p>Instagram</p>
                                            <input name="Instagram" type="text" value="<%= x.getInstagram()%>" placeholder="http://www.instagram.com/...">
                                        </div>
                                        <div class="col-md-6">
                                            <p>Twitter</p>
                                            <input name="Twitter" type="text" value="<%= x.getTwitter()%>" placeholder="http://www.twitter.com/...">
                                            <p>Youtube</p>
                                            <input name="Youtube" type="text" value="<%= x.getYoutube()%>" placeholder="http://www.youtube.com/...">
                                        </div>
                                        <br><br><br><br>
                                        <p>Your public information will be visible on your public profile page.
                                            We will never share what you browse or purchase on Bmazon. Bmazon will never ask for your account login or password, billing information, or any other account details via your Public Profile page.</p>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <br><br>
                                <div class="col-md-4"></div>
                                <div class="col-md-4">
                                    <a style="right: 50%;" href="UserControllerMap?service=info" >        
                                        <button style="text-align:center; color:white;border-radius: 15px;height: 2em; width: 15em;" class="btn-danger" > Back to public profile
                                        </button> 
                                    </a> 
                                    <a style="right: 50%;" href="UserControllerMap?service=info" >        
                                        <button type="submit" style="text-align:center; color:white;border-radius: 15px;height: 2em; width: 8em;" class="btn-warning" > Save
                                        </button> 
                                    </a> 
                                </div>
                            </div> 
                        </div>
                    </form>
                </div>



                <div id="sales-feature" class="tab-pane fade">
                    <h3>Menu 1</h3>
                    <p>Some content in menu 1.</p>
                    <div class="col-md-7">
                        <%--change--%>
                        <div class="card1">
                            <div class="box1">
                                <div class="content1">
                                    <form action="UserControllerMap" method="POST" >
                                        <input type="hidden" name ="service" value="changeInfo">
                                        <h1 class="text-center">Edit Profile</h1>

                                        <label class="label control-label">Display Name</label>
                                        <div class="input-group" >
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-user"></span></span>
                                            <input type="text" class="form-control" name="name" 
                                                   placeholder="Your Name" required>
                                        </div>

                                        <label class="label control-label">E-mail</label>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-envelope"></span></span>
                                            <input type="email" class="form-control" name="mail" 
                                                   placeholder="Your E-mail" required>
                                        </div>

                                        <label class="label control-label">Phone</label>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-phone"></span></span>
                                            <input id="mobile" type="text" class="form-control" name="phone" 
                                                   placeholder="Your Phone" required>
                                            <span id='message1'></span>
                                        </div>

                                        <label class="label control-label">Address</label>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-user"></span></span>
                                            <input type="text" class="form-control" name="address" 
                                                   placeholder="Your address" required>
                                        </div>

                                        <label class="label control-label">Password</label>
                                        <div class="input-group">
                                            <input id="password" type="password" class="form-control" name="pass" 
                                                   placeholder="Password" required>
                                        </div>
                                        <button type="reset" class="btn btn-info">Reset</button>
                                        <button type="submit" class="btn btn-success">Change</button>
                                        <br><br>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br><br><br>
        <jsp:include page="../footer.jsp"/>
        <%--JS--%>
        <script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
        <script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <script src="https://kit.fontawesome.com/9650a62e47.js" crossorigin="anonymous"></script>
    </body>
</html>
