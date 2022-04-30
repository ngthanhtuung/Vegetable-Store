<%-- 
    Document   : login
    Created on : Mar 1, 2022, 12:01:09 PM
    Author     : TungNT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>LOGIN PAGE</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->
    </head>

    <body>
        <div class="container-login100" style="background-image: url('images/background.jpg');">
            <div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">
                <form action="MainController" method="POST" class="login100-form validate-form">
                    <span class="login100-form-title p-b-37">
                        Sign In
                    </span>

                    <div class="wrap-input100 validate-input m-b-20" data-validate="Enter email">
                        <input class="input100" type="text" name="email" placeholder="Email">
                        <span class="focus-input100"></span>
                    </div>

                    <div class="wrap-input100 validate-input m-b-25" data-validate="Enter password">
                        <input class="input100" type="password" name="password" placeholder="Password">
                        <span class="focus-input100"></span>
                    </div>

                    <div class="container-login100-form-btn">
                        <button type="submit" name="action" value="Login" class="login100-form-btn">
                            Sign In
                        </button>
                    </div>
                    <!--ERROR-->
                    <div class="message">
                        <c:if test="${empty requestScope.ERROR}">
                            <c:set var="error" value=""/>
                            <p style="color: red; text-align: center; margin-top: 40px;"><c:out value="${error}"/></p>
                        </c:if>
                        <c:if test="${not empty requestScope.ERROR}">
                            <p style="color: red; text-align: center; margin-top: 40px;"><c:out value="${requestScope.ERROR}"/></p>
                        </c:if>
                    </div>
                    <!--SUCCESS-->
                    <div class="message">
                        <c:if test="${empty requestScope.SUCCESS_MESSAGE}">
                            <c:set var="success" value=""/>
                            <p style="color: green; text-align: center; margin-top: 40px;"><c:out value="${success}"/></p>
                        </c:if>
                        <c:if test="${not empty requestScope.SUCCESS_MESSAGE}">
                            <p style="color: green; text-align: center; margin-top: 40px;"><c:out value="${requestScope.SUCCESS_MESSAGE}"/></p>
                        </c:if>
                    </div>
                    <div class="text-center p-t-57 p-b-20">
                        <span class="txt1">
                            Or shopping and login with
                        </span>
                    </div>

                    <div class="flex-c p-b-112">
                        <a href="OnlineShoppingController" name="google" class="login100-social-item">
                            <img src="https://i.pinimg.com/originals/15/4f/df/154fdf2f2759676a96e9aed653082276.png" alt="SHOPPING CART">
                        </a>
                        <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/VegetableStore/LoginGoogleController&response_type=code
                           &client_id=1085468771805-uqqgf4dsts8cct07a66810r6ugdl1s0s.apps.googleusercontent.com&approval_prompt=force" name="google" class="login100-social-item">
                            <img src="images/icons/icon-google.png" alt="GOOGLE">
                        </a>
                    </div>

                    <div class="text-center">
                        <a href="signup.jsp" class="txt2 hov1">
                            Sign Up
                        </a>
                    </div>
                </form>
            </div>
        </div>



        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/daterangepicker/moment.min.js"></script>
        <script src="vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>

    </body>
</html>
