<%-- 
    Document   : admin_header
    Created on : Sep 16, 2021, 10:49:59 PM
    Author     : Admin
--%>

<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User currUser = (User) request.getSession().getAttribute("currUser");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
        <link rel="stylesheet" href="css/admin.css">
    </head>
    <body>
        <header>
            <h2>
                <label for="nav-toggle">
                    <span class="las la-bars"></span>
                </label>
                Dashboard
            </h2>
            <div class="search-wrapper">
                <span class="las la-search"></span>
                <input type="search" placeholder="Search here">
            </div>
            <div class="user-wrapper">
                <div class="dropdown">
                    <ul>
                        <li>
                            <div>
                                <h4>Hello,<%=currUser.getFullname()%></h4>
                            </div>
                            <ul>
                                <li><a href="">Profile</a></li>
                                <li><a href="index.jsp">Shopping</a></li>
                                <li><a href="UserControllerMap?service=logout">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </header>
    </body>
</html>
