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
                                    <a href="AdminControllerMap?service=adddetail">
                                        <button>Add new user</button></a>
                                </div>
                                <div class="card-body">
                                    <table width="100%">
                                        <thead>
                                            <tr>
                                                <td>User name</td>
                                                <td>Password</td>
                                                <td>Email</td>
                                                <td>Phone</td>
                                                <td>Address</td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <%for (User user : listUser) {%>
                                        <tr>
                                            <td><%=user.getUsername()%></td>
                                            <td><%=user.getPassword()%></td>
                                            <td><%=user.getEmail()%></td>
                                            <td><%=user.getPhoneNumber()%></td>
                                            <td><%=user.getAddress()%></td>
                                            <td>
                                                <a href="AdminControllerMap?service=updatedetail&userid=<%=user.getUserId()%>"><span class="las la-edit"></span></a>
                                            </td>
                                            <td><a href="AdminControllerMap?service=deleteuser&userid=<%=user.getUserId()%>" onclick="return confirm('Are you sure you want to Remove?');"><span class="las la-trash"></span></a></td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </body>
</html>
