<%-- 
    Document   : checkout
    Created on : Mar 10, 2022, 12:21:22 PM
    Author     : TungNT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="css/style_checkout.css">
        <link href="css/styles_index.css" rel="stylesheet" />
        <title>Checkout</title>
    </head>

    <body>
        <div class="row">

            <div class="col-75">
                <div class="container">
                    <form action="MainController">
                        <div class="row">
                            <div class="col-50">
                                <h3>Billing Address</h3>
                                <c:set var="user" value="${sessionScope.LOGIN_USER}"/>
                                <c:choose>
                                    <c:when test="${user != null}">
                                        <label for="fname"><i class="fa fa-user"></i> Full Name</label>
                                        <input type="text" id="fname" name="fullName" placeholder="Full Name" value="${user.fullName}" pattern=".{4,50}" title="Fullname length must be [4, 50]">

                                        <label for="email"><i class="fa fa-envelope"></i> Email</label>
                                        <input type="text" id="email" name="email" placeholder="Email" value="${user.email}"
                                               pattern="[a-z0-9._%+-]+@(gmail.com|fpt.edu.vn)" title="Email addresses must start with a lowercase letter and end with domains '@gmail.com' or '@fpt.edu.vn'">

                                        <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
                                        <input type="text" id="adr" name="address" placeholder="Address" value="${user.address}" required="">

                                        <label for="city"><i class="bi bi-telephone-forward-fill"></i> Phone</label>
                                        <input type="text" id="city" name="phone" placeholder="Phone" value="${user.phone.trim()}" required="" pattern="[0][0-9]{9}" title="Phone number contains 10 numbers and start with '0'">
                                    </c:when>
                                    <c:otherwise>
                                        <label for="fname"><i class="fa fa-user"></i> Full Name</label>
                                        <input type="text" id="fname" name="fullName" placeholder="Full Name" required="" pattern=".{4,50}" title="Fullname length must be [4, 50]"/>

                                               <label for="email"><i class="fa fa-envelope"></i> Email</label>
                                        <input type="text" id="email" name="email" placeholder="Email" required=""
                                               pattern="[a-z0-9._%+-]+@(gmail.com|fpt.edu.vn)" title="Email addresses must start with a lowercase letter and end with domains '@gmail.com' or '@fpt.edu.vn'">

                                        <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
                                        <input type="text" id="adr" name="address" placeholder="Address" required="">

                                        <label for="city"><i class="bi bi-telephone-forward-fill"></i> Phone</label>
                                        <input type="text" id="city" name="phone" placeholder="Phone" required="" pattern="[0][0-9]{9}" title="Phone number contains 10 numbers and start with '0'">
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                        <input type="submit" name="action" value="Checkout" class="btn btn-success">
                        <a href="cart.jsp">
                            <button type="button" class="btn btn-success">Back to cart</button>
                        </a>
                        <a href="OnlineShoppingController">
                            <button type="button" class="btn btn-success">HomePage</button>
                        </a>
                    </form>
                </div>
            </div>
            <div class="col-25">
                <div class="container">
                    <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i><b>${sessionScope.CART.getCart().size()}</b></span>
                    </h4>
                    <c:set var="cart" value="${sessionScope.CART}"/>
                    <c:set var="product" value="${cart.getCart().values()}"/>
                    <c:set var="total" value="0"/>
                    <c:forEach items="${product}" var="p" varStatus="status">
                        <c:set var="price" value="${p.price}"/>
                        <c:set var="quantity" value="${p.quantity}"/>
                        <c:set var="total" value="${total + (price * p.quantity)}"/>
                        <p>${p.productName}<span class="price">${p.showPriceTotal(price, quantity)} VNĐ</span></p>
                    </c:forEach>
                    <hr>
                    <p>Total <span class="price" style="color:black"><b>${total} VNĐ</b></span></p>
                </div>
            </div>
        </div>
    </body>
</html>
