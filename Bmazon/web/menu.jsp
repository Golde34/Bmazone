

<%@page import="entity.Gallery"%>
<%@page import="model.DBConnection"%>
<%@page import="model.DAOGallery"%>
<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <title>Menu</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <div class="w3-content" style="max-width:2000px;margin-top:46px">

            <!-- Automatic Slideshow Images -->
            <div class="mySlides w3-display-container w3-center">
                <img src="images/gigabyte.jpg" style="width:100%">
                <div class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">
                    <h3>GIGABYTE</h3>

                </div>
            </div>
            <div class="mySlides w3-display-container w3-center">
                <img src="images/rog.jpg" style="width:100%">
                <div class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">
                    <h3>ROG</h3>

                </div>
            </div>
            <div class="mySlides w3-display-container w3-center">
                <img src="images/msi.jpg" style="width:100%">
                <div class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">
                    <h3>MSI</h3>
                    <p><b>Good design should be honest </b>
                        <br>
                        <b>Ferdinand Porsche</b></p>    
                </div>
            </div>

            <!-- The Band Section -->


            <!-- The Tour Section -->
            <div class="w3-black" id="tour">
                <div class="w3-container w3-content w3-padding-64" style="max-width:800px">
                    <h2 class="w3-wide w3-center">HYPER CAR LIST</h2>
                    <p class="w3-opacity w3-center"><i>Remember to buy Car</i></p><br>
                    <div class="w3-bar w3-black w3-card">
                        <form class="example" action="search" method="post">
                            <input type="text" placeholder="Search.." name="search" value="" >
                            <button type="submit"><i class="fa fa-search"></i></button>
                        </form>
                        <div class="w3-dropdown-hover w3-hide-small">
                            <button class="w3-padding-large w3-button" title="More">CATEGORY <i class="fa fa-caret-down"></i></button>     
                            <div class="w3-dropdown-content w3-bar-block w3-card-4">
                                <ul class="w3-ul w3-border w3-white w3-text-grey">
                                    <c:forEach items="${listC}" var="o">
                                        <li class="w3-padding" ><a href="category?cid=${o.cid}"> ${o.cname} </a></li>
                                        </c:forEach>
                                </ul>
                            </div>


                        </div>

                    </div>
                    <div class="w3-row-padding w3-padding-32" style="margin:0 -16px">
                        <c:forEach items="${listP}" var="o">

                            <div class="w3-third w3-margin-bottom">
                                <form method="POST" action="CartController">
                                    <img src="${o.image}"  style="width:100%"  class="w3-hover-opacity"><input type="hidden" name="image" value="${o.image}"><br/>
                                    <div class="w3-container w3-white">
                                        ${o.name}<input type="hidden" name="description" value="${o.name}"><br/>

                                        Quantity:<input type="number" name="quantity" value="1"><br/> 
                                        Price: ${o.price}<input type="hidden" name="price" value="${o.price}"><br/>

                                        <input class="w3-button w3-black w3-margin-bottom"type="submit" name="action" value="Add To Cart">
                                    </div>
                                </form>

                            </div>
                        </c:forEach>

                    </div>


                </div>
            </div>
        </div>
        <script>
            // Automatic Slideshow - change image every 4 seconds
            var myIndex = 0;
            carousel();

            function carousel() {
                var i;
                var x = document.getElementsByClassName("mySlides");
                for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";
                }
                myIndex++;
                if (myIndex > x.length) {
                    myIndex = 1
                }
                x[myIndex - 1].style.display = "block";
                setTimeout(carousel, 4000);
            }

            // Used to toggle the menu on small screens when clicking on the menu button
            function myFunction() {
                var x = document.getElementById("navDemo");
                if (x.className.indexOf("w3-show") == -1) {
                    x.className += " w3-show";
                } else {
                    x.className = x.className.replace(" w3-show", "");
                }
            }

            // When the user clicks anywhere outside of the modal, close it

        </script>
    </body>
</html>
