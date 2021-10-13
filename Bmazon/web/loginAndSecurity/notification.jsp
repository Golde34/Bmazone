<%-- 
    Document   : notification
    Created on : Oct 11, 2021, 10:44:25 AM
    Author     : AD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .notification{
                margin-top: 80px;
                margin-bottom: 80px;
            }
            .notification h1{
                font-size: 50px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <div class="notification"><h1 style="text-align: center">Welcome to Bmazon</h1>
            <h2 style="text-align: center"> 
                <font color="red">An email has been sent. Please check your inbox!</font>
            </h2>
        </div>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
