<%-- 
    Document   : shop_cart
    Created on : Mar 5, 2022, 11:10:36 AM
    Author     : TungNT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>CART</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link rel="stylesheet" href="./css/style_shoppingcart.css">
        <link href="css/styles_index.css" rel="stylesheet" />
    </head>

    <body>
        <%@include file="./components/navbar.jsp" %>
        
        <!-- CLOSE HEADER -->
        <c:set var="cart" value="${sessionScope.CART}"/>
        <c:set var="product" value="${cart.getCart().values()}"/>
        <div style="margin-top: 50px">
            <h1 style="text-align: center; color: green">SHOPPING CART</h1>
        </div>
        <div style="margin-top: 50px" class="container padding-bottom-3x padding-top-3x mb-1">
            <!-- Shopping Cart-->
            <div class="table-responsive shopping-cart">
                <table class="table">
                    <thead>
                        <tr>
                            <th class="text-center">Product Name</th>
                            <th class="text-center">Quantity</th>
                            <th class="text-center">Price</th>
                            <th class="text-center">Total</th>
                            <th class="text-center">Action</th>
                                <c:if test="${not empty cart}">
                                <th class="text-center"><a class="btn btn-sm btn-outline-danger" href="MainController?action=Cancel cart&position=in_cart">Clear All Product</a></th>
                                </c:if>
                        </tr>
                    </thead>
                    <c:set var="total" value="0"/>

                    <c:set var="error" value="${requestScope.PRODUCT_ERROR}"/>
                    <c:set var="error_checkout" value="${requestScope.PRODUCT_ERROR_CHECKOUT}"/>
                    <tbody>
                        <c:if test="${empty cart}">
                        <p style="color: red">Shopping cart is empty!</p>
                    </c:if>
                    <c:forEach var="p" items="${product}" varStatus="status">
                        <c:set var="showTotalPrice" value="${p.showPriceTotal(p.price, p.quantity)}"/>
                        <form action="MainController">
                            <tr>
                                <td>
                                    <div class="product-item">
                                        <img style="width: 144px; height: 93px; margin-right: 20px;" src="${p.image}" alt="Product" />
                                        <input type="hidden" name="image" value="${p.image}">
                                        <div class="product-info">
                                            <h4 class="product-title">${p.productName}</h4>
                                            <input type="hidden" name="productName" value="${p.productName}">
                                        </div>
                                    </div>
                                </td>
                                <td class="text-center">
                                    <input class="form-control" style="border-radius: 10px" type="number" name="quantity" min="1" value="${p.quantity}"/>
                                    <c:if test="${error.productID eq p.productID}">
                                        <p style="text-align: left; color: red; font-size: 12px;">${requestScope.ERROR_SHOPPING_MESSAGE}</p>
                                    </c:if>
                                    <c:if test="${not empty error_checkout}">
                                        <c:forEach var="check" items="${product}" varStatus="status">
                                            <c:if test="${check.productID eq p.productID}">
                                                <p style="text-align: left; color: red; font-size: 12px;">${requestScope.ERROR_SHOPPING_MESSAGE}</p>
                                            </c:if>
                                        </c:forEach>   
                                    </c:if>
                                </td>
                                <td class="text-center text-lg text-medium">
                                    <c:set var="price" value="${p.price}"/>
                                    ${p.showPrice(price)} VNĐ
                                    <input type="hidden" name="price" value="${p.price}">
                                </td>
                                <td class="text-center text-lg text-medium">${showTotalPrice} VNĐ</td>
                                <td class="text-center">
                                    <button type="submit" name="action" value="Update Quantity" class="btn btn-success">Update Quantity</button>
                                    <input type="hidden" name="productID" value="${p.productID}">
                                </td>
                                <td class="text-center">
                                    <a class="remove-from-cart" href="MainController?action=Remove&productID=${p.productID}&productName=${p.productName}" 
                                       data-toggle="tooltip" title=""
                                       data-original-title="Remove item">
                                        <i class="fa fa-trash"></i>
                                    </a>
                                </td>
                            </tr>
                        </form>
                        <c:set var="total" value="${total + (p.quantity * p.price)}"/>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="shopping-cart-footer">
                <!-- <div class="column">
                    <form class="coupon-form" method="post">
                        <input class="form-control form-control-sm" type="text" placeholder="Coupon code" required="">
                        <button class="btn btn-outline-primary btn-sm" type="submit">Apply Coupon</button>
                    </form>
                </div> -->
                <div class="column text-lg">Subtotal: <span class="text-medium">${total} VNĐ</span></div>
            </div>
            <div class="shopping-cart-footer">
                <div class="column"><a class="btn btn-outline-secondary" href="OnlineShoppingController"><i class="icon-arrow-left"></i>&nbsp;Back to Shopping</a>
                </div>
                <c:if test="${cart != null}">
                    <div class="column"><a class="btn btn-success"href="checkout.jsp">Checkout</a></div>
                </c:if>
            </div>
            <c:if test="${requestScope.SHOPPING_MESSAGE != null}">
                <div class="message">
                    <p style="color: green; text-align: center">${requestScope.SHOPPING_MESSAGE}</p>
                </div>
            </c:if>
        </div>

        <script>
            window.setTimeout(function () {
                $(".message").fadeTo(500, 0).slideUp(500, function () {
                    $(this).remove();
                });
            }, 2000);
        </script>  
    </body>
</html>