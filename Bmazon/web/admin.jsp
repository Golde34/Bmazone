<%@page import="java.util.ArrayList"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User curUser = (User) request.getSession().getAttribute("currUser");
    ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("listProduct");
    ArrayList<User> listUser = (ArrayList<User>) request.getAttribute("listUser");
    ArrayList<Category> listCategory = (ArrayList<Category>) request.getAttribute("listCategory");
    ArrayList<Genre> listGenre = (ArrayList<Genre>) request.getAttribute("listGenre");
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
        <input type="checkbox" id="nav-toggle">
        <div class="sidebar">
            <div class="sidebar-brand">
                <h1><span class="lab la-amazon"></span><span>Bmazon</span></h1>
            </div>

            <div class="sidebar-menu">
                <ul>
                    <li>
                        <a href="" class="active"><span class="las la-igloo"></span>
                            <span>Dashboard</span></a>
                    </li>
                    <li>
                        <a href=""><span class="las la-igloo"></span>
                            <span>Dashboard</span></a>
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
                    <img src="images/FPT.jpg" width="30px" height="30px">
                    <div>
                        <h4>Hello,%</h4>
                    </div>
                </div>
            </header>
            <main>
                <div class="cards">
                    <div class="card-single">
                        <div>
                            <h1>1000</h1>
                            <span>Products</span>
                        </div>
                        <div><span class="las la-archive"></span></div>
                    </div>
                    <div class="card-single">
                        <div>
                            <h1>1000</h1>
                            <span>Customer</span>
                        </div>
                        <div><span class="las la-users"></span></div>
                    </div>
                    <div class="card-single">
                        <div>
                            <h1>1000</h1>
                            <span>Orders</span>
                        </div>
                        <div><span class="las la-shopping-bag"></span></div>
                    </div>
                    <div class="card-single">
                        <div>
                            <h1>1000</h1>
                            <span>Warehouse</span>
                        </div>
                        <div><span class="las la-warehouse"></span></div>
                    </div>
                </div>
                <div class="recent-grid">
                    <div class="product">
                        <div class="card">
                            <div class="card-header">
                                <h3>Some Product</h3>
                                <button>See all<span class="las la-arrow-right"></span></button>
                            </div>
                            <div class="card-body">
                                <table width="100%">
                                    <thead>
                                        <tr>
                                            <td>Product name</td>
                                            <td>Description</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%for (Product product : listProduct) {%>
                                        <tr>
                                            <td><%=product.getProductName()%></td>
                                            <td><%=product.getDescription()%></td>
                                            <td><span class="las la-edit"></span></td>
                                            <td><span class="las la-trash"></span></td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="customers">
                        <div class="card">
                            <div class="card-header">
                                <h3>Some Customer</h3>
                                <button>See all<span class="las la-arrow-right"></span></button>
                            </div>
                            <div class="card-body">
                                <%for (User user : listUser) {%>
                                <div class="customer">
                                    <div class="info">
                                        <img src="<%=user.getProfileImage()%>" width="40px" height="40px">
                                        <div>
                                            <h2><%=user.getUsername()%></h2>
                                        </div>
                                    </div>
                                    <div class="edit-delete">
                                        <span class="las la-edit"></span>
                                        <span class="las la-trash"></span>
                                    </div>
                                </div>
                                <%}%>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </body>
</html>
