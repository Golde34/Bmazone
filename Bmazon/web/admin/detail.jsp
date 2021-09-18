
<%@page import="model.DBConnection"%>
<%@page import="model.DAOUser"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User user = (User) request.getAttribute("user");
    String mess = (String) request.getAttribute("mess");
    String serivce = (String) request.getAttribute("service");
    User curUser = (User) request.getSession().getAttribute("currUser");
    ArrayList<User> listUser = (ArrayList<User>) request.getAttribute("listUser");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
        <link rel="stylesheet" href="../css/detail.css">

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
                                    <h6 style="color: yellow;" style="font-size: small" >${mess}</h6>
                                <div class="wrapper">
                                    <form class="form" action="/Bmazon/AdminControllerMap" method="POST">
                                        <%if (serivce.equalsIgnoreCase("adddetail")) {%>
                                        <table class="table table-striped">
                                            <tr>
                                                <td>Name</td>
                                                <td><input type="text" name="username" class="input"><br></td>
                                            </tr>
                                            <tr>
                                                <td>Password</td>
                                                <td><input type="text" name="password" class="input"><br></td>
                                            </tr>    
                                            <tr>
                                                <td>Full Name<p></td>
                                                <td><input type="text" name="fullname" class="input"><br></td>
                                            </tr>
                                            <tr>
                                                <td>Phone<p></td>
                                                <td><input type="text" name="phone" class="input"><br></td>
                                            </tr>
                                            <tr>
                                                <td>Email<p></td>
                                                <td><input type="text" name="email" class="input"> <br></td>
                                            <tr>
                                            <tr>
                                                <td>Address<p></td>
                                                <td><input type="text" name="address" class="input"><br></td>
                                            <tr>
                                            <tr>
                                                <td><label>Gender</label></td>
                                                <td>
                                                    <div class="custom-select">
                                                        <select name="gender">
                                                            <option value="1">Male</option>
                                                            <option value="0">Female</option>
                                                        </select>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>  
                                                <td><label>System Role</label></td>
                                                <td>
                                                    <div class="custom-select">
                                                        <select name="role">
                                                            <option value="0">Customer</option>
                                                            <option value="1">Admin</option>
                                                        </select>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="submit" value="Add User" class="btn">
                                                    <input type="hidden" value="adduser" name="service">
                                                </td>
                                            </tr>
                                        </table>
                                        <%}%>
                                        <%if (serivce.equalsIgnoreCase("updatedetail")) {%>
                                        <table class="table table-striped">
                                            <tr>
                                                <td>Name</td>
                                                <td><input value="<%=user.getUsername()%>" type="text" name="username" class="input"><br></td>
                                            </tr>
                                            <tr>
                                                <td>Password</td>
                                                <td><input value="<%=user.getPassword()%>" type="text" name="password" class="input"><br></td>
                                            </tr>    
                                            <tr>
                                                <td>Full Name<p></td>
                                                <td><input value="<%=user.getFullname()%>" type="text" name="fullname" class="input"><br></td>
                                            </tr>
                                            <tr>
                                                <td>Phone<p></td>
                                                <td><input value="<%=user.getPhoneNumber()%>" type="text" name="phone" class="input"><br></td>
                                            </tr>
                                            <tr>
                                                <td>Email<p></td>
                                                <td><input value="<%=user.getEmail()%>" type="text" name="email" class="input"> <br></td>
                                            <tr>
                                            <tr>
                                                <td>Address<p></td>
                                                <td><input value="<%=user.getAddress()%>" type="text" name="address" class="input"><br></td>
                                            <tr>
                                            <tr>
                                                <td><label>Gender</label></td>
                                                <td>
                                                    <div class="custom-select">
                                                        <select name="gender">
                                                            <option <%if (user.getGender() == 1) {%> selected<%}%> value="1">Male</option>
                                                            <option <%if (user.getGender() == 0) {%> selected<%}%> value="0">Female</option>
                                                        </select>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>  
                                                <td><label>System Role</label></td>
                                                <td>
                                                    <div class="custom-select">
                                                        <select name="role">
                                                            <option <%if (user.getSystemRole() == 0) {%> selected<%}%> value="0">Customer</option>
                                                            <option <%if (user.getSystemRole() == 1) {%> selected<%}%> value="1">Admin</option>
                                                        </select>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="submit" value="Update User" class="btn">
                                                    <input type="hidden" value="updateuser" name="service">
                                                    <input type="hidden" value="<%=user.getUserId()%>" name="id">
                                                </td>
                                            </tr>
                                        </table>
                                        <%}%>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </body>
</html>
