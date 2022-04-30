<%-- 
    Document   : navbar
    Created on : Mar 9, 2022, 7:52:45 PM
    Author     : TungNT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="OnlineShoppingController">VEGETABLE STORE</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="OnlineShoppingController">Home</a></li>
                <c:choose>
                    <c:when test="${empty sessionScope.LOGIN_USER}">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="login.jsp">Login</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="signup.jsp">Sign Up</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
                               data-bs-toggle="dropdown">${sessionScope.LOGIN_USER.fullName}</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="LogoutController">Log Out</a></li>
                            </ul>
                        <c:choose>
                            <c:when test="${empty requestScope.ERROR}">
                                <c:set var="error" value=""/>
                                <li class="nav-item"><a style="color: red" class="nav-link active" aria-current="page">${error}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="nav-item"><a style="color: red" class="nav-link active" aria-current="page">${requestScope.ERROR}</a></li>
                            </c:otherwise>
                        </c:choose>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
            <div class="d-flex my-2">
                <a href="cart.jsp">
                    <button class="btn bg-success text-white" type="button">
                        <i class="bi-cart-fill me-1"></i>
                        Cart
                        <span class="badge bg-dark text-white ms-1 rounded-pill">${sessionScope.CART.getCart().size()}</span>
                    </button>
                </a>
            </div>
        </div>
    </div>
</nav>
<!-- End Navigation-->