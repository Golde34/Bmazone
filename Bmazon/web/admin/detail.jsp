
<%@page import="java.util.ArrayList"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User curUser = (User) request.getSession().getAttribute("currUser");
    ArrayList<User> listUser = (ArrayList<User>) request.getAttribute("listUser");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">

        <link rel="stylesheet" href="../css/admin.css">
        <link rel="stylesheet" href="../css/usermanagement.css">
    </head>
    <body>
        <input type="checkbox" id="nav-toggle">
        <div class="sidebar">
            <div class="sidebar-brand">
                <h1><span class="lab la-amazon"></span><span>Bmazon</span></h1>
            </div>

            <div class="sidebar-menu">
                <ul>
                    <li>
                        <a href="AdminControllerMap"><span class="las la-igloo"></span>
                            <span>Dashboard</span></a>
                    </li>
                    <li>
                        <a href="AdminControllerMap?service=usermanagement" class="active">
                            <span class="las la-igloo"></span>
                            <span>User Management</span></a>
                    </li>
                    <li>
                        <a href=""><span class="las la-igloo"></span>
                            <span>Dashboard</span></a>
                    </li>
                    <li>
                        <a href=""><span class="las la-igloo"></span>
                            <span>Dashboard</span></a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="main-content">
            <jsp:include page="admin_header.jsp"></jsp:include>
                <main>
                    <div class="recent-grids">
                        <div class="customers">
                            <div class="card">
                                <div class="card-header">
                                    <h3>User</h3>

                                </div>
                                <div class="card-body">
                                    <form action="/Bmazon/AdminControllerMap" method="POST">
                                        <div class="group">
                                            <label for="user" class="label">Username</label>
                                            <input id="user" type="text" name="signupusername" placeholder="Username" class="input" required autofocus="" >
                                        </div>
                                        <div class="group">
                                            <label for="pass" class="label">Password</label>
                                            <input id="pass" type="password" name="signuppass" class="input" placeholder="Password" data-type="password" required autofocus="" >
                                        </div>
                                        <div class="group">
                                            <label for="pass" class="label">Email</label>
                                            <input id="pass" type="text" name="email" class="input" placeholder="abc@xyz.com" required autofocus="" >
                                        </div>
                                        <div class="group">
                                            <label for="pass" class="label">Phone</label>
                                            <input id="pass" type="text" name="phone" class="input" placeholder="0987654321 required autofocus="" >
                                        </div>
                                    <div class="group">
                                        <input type="submit" class="button" value="Add User">
                                        <input type="hidden" name="service" value="register">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </body>
</html>
