<%-- 
    Document   : uploadImage
    Created on : Jul 5, 2021, 4:15:24 PM
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
        <title>Upload Image</title>
        <link rel="shortcut icon" type="image/png" href="../images/80jslogo.png">
        <%--JS,Css--%>
        <link href="${contextPath}/css/upload.css" rel="stylesheet">
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    </head>
    <body>
        <%
            User x = (User) request.getAttribute("currUser");
        %>

        <form method="post" action="/Bmazon/UserControllerMap?service=updateBackgroundImage" enctype="multipart/form-data">
            <div class="container">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <div class="wrapper">
                        <div class="image">
                            <img src="" alt="">
                        </div>
                        <div class="content">
                            <div class="icon">
                                <i class="fas fa-cloud-upload-alt"></i>
                            </div>
                            <div class="text">
                                No file chosen, yet!
                            </div>
                        </div>
                        <div id="cancel-btn">
                            <i class="fas fa-times"></i>
                        </div>
                        <div class="file-name">
                            File name here
                        </div>
                    </div>
                    <input id="default-btn" type="file" hidden class="form-control" name="photo" placeholder="Enter photo">
                    <button type="submit" class="btn btn-primary">Save</button>
                    <button type="reset" class="btn btn-primary">Reset</button>
                </div>
                <div class="col-md-4"></div>
            </div>
        </form>
        <a href="HomePageCOntrollerMap">Go to home</a>
        <a href="UserControllerMap?service=info">Go to profile</a>
        <script>
            const wrapper = document.querySelector(".wrapper");
            const fileName = document.querySelector(".file-name");
            const defaultBtn = document.querySelector("#default-btn");
            const customBtn = document.querySelector("#custom-btn");
            const cancelBtn = document.querySelector("#cancel-btn i");
            const img = document.querySelector("img");
            let regExp = /[0-9a-zA-Z\^\&\'\@\{\}\[\]\,\$\=\!\-\#\(\)\.\%\+\~\_ ]+$/;
            function defaultBtnActive() {
                defaultBtn.click();
            }
            defaultBtn.addEventListener("change", function () {
                const file = this.files[0];
                if (file) {
                    const reader = new FileReader();
                    reader.onload = function () {
                        const result = reader.result;
                        img.src = result;
                        wrapper.classList.add("active");
                    }
                    cancelBtn.addEventListener("click", function () {
                        img.src = "";
                        wrapper.classList.remove("active");
                    })
                    reader.readAsDataURL(file);
                }
                if (this.value) {
                    let valueStore = this.value.match(regExp);
                    fileName.textContent = valueStore;
                }
            });
        </script>


    </body>
</html>
