<%-- 
    Document   : resetSuccessjsp
    Created on : Oct 8, 2021, 8:58:27 AM
    Author     : AD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .resetsuccess{
                margin-top: 80px;
                margin-bottom: 80px;
            }
            .resetsuccess h1{
                font-size: 50px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <div class="resetsuccess"><h1 style="text-align: center">Welcome to Bmazon</h1>
            <h2 style="text-align: center"> 
                <font color="red">Your password has been successfully reset!
                <br/> An email has been sent. Please check your inbox!
                </font>
            </h2></div>
            <jsp:include page="../footer.jsp"/>
    </body>
</html>
