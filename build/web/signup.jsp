<%-- 
    Document   : signup
    Created on : Mar 1, 2022, 12:01:39 PM
    Author     : TungNT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Colorlib Templates">
        <meta name="author" content="Colorlib">
        <meta name="keywords" content="Colorlib Templates">

        <!-- Title Page-->
        <title>REGISTRATION PAGE</title>

        <!-- Icons font CSS-->
        <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
        <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
        <!-- Font special for pages-->
        <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
              rel="stylesheet">
        <script src="https://www.google.com/recaptcha/api.js"></script>

        <!-- Vendor CSS-->
        <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
        <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

        <!-- Main CSS-->
        <link href="css/signup.css" rel="stylesheet" media="all">
    </head>

    <body>
        <div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
            <div class="wrapper wrapper--w960">
                <div class="card card-2">
                    <div class="card-heading"></div>
                    <div class="card-body">
                        <h2 class="title">User Registration Information</h2>
                        <c:set var="error" value="${requestScope.USER_ERROR}"/>
                        <form action="MainController" method="POST">


                            <p style="font-weight: bold; font-size: 12px; color: red">${error.emailError}</p>

                            <div class="input-group">
                                <input type="email" name="email" placeholder="Email" required="" class="input--style-2" pattern="[a-z0-9._%+-]+@(gmail.com|fpt.edu.vn)" title="Email addresses must start with a lowercase letter and end with domains '@gmail.com' or '@fpt.edu.vn'">
                            </div>

                            <div class="input-group">
                                <input type="text" name="fullName" placeholder="Full Name" required="" pattern=".{4,50}" title="Fullname length must be [4, 50]"
                                       class="input--style-2">
                            </div>

                            <div class="input-group">
                                <input type="password" name="password" placeholder="Password" required="" id="password" onkeyup='check();'
                                       class="input--style-2"
                                       pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                                       title="Must contain at least one  number and one uppercase and lowercase letter, and at least 8 or more characters">
                            </div>

                            <p style="font-weight: bold; font-size: 12px; color: red">${error.confirm}</p>

                            <p id='message' style="font-weight: bold; font-size: 12px"></p>
                            <div class="input-group">
                                <input type="password" name="confirm" placeholder="Confirm Password" required="" id="confirm" onkeyup='check();' 
                                       class="input--style-2"
                                       pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                                       title="Must contain at least one  number and one uppercase and lowercase letter, and at least 8 or more characters">
                            </div>

                            <div class="row row-space">
                                <div class="col-2">
                                    <div class="input-group">
                                        <input type="text" name="birthday" placeholder="Birthdate" required=""
                                               class="input--style-2 js-datepicker">
                                        <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
                                    </div>
                                </div>
                                <div class="col-2">
                                    <div class="input-group">
                                        <div class="rs-select2 js-select-simple select--no-search">
                                            <select name="roleID">
                                                <option disabled="disabled">Role ID</option>
                                                <option value="US" selected="selected">USER</option>
                                            </select>
                                            <div class="select-dropdown"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="input-group">
                                <input type="text" name="address" placeholder="Address" required="" class="input--style-2">
                            </div>

                            <div class="input-group">
                                <input type="text" name="phone" placeholder="Phone" required="" class="input--style-2" pattern="[0][0-9]{9}" title="Phone number contains 10 numbers and start with '0'">
                            </div>
                            <div style="margin-left: 95px" class="g-recaptcha" data-sitekey="6Le7ZqgeAAAAAHHg2a5N9WAw9H4BzBS-8UOLG5TC" data-callback="enableBtn"></div>
                            <div style="margin-top: 30px">
                                <p style="text-align: center; color: red">${requestScope.ERROR}</p>
                            </div>
                            <div style="margin-left: 72px; margin-top: 5px" class="p-t-30">
                                <button class="btn btn--radius btn--green"><a style="text-decoration: none; color: white" href="login.jsp">LOGIN PAGE</a></button>
                                <button type="submit" name="action" value="Register" class="btn btn--radius btn--green" id="button1" disabled="disabled">REGISTER</button>
                                <button type="reset"" class="btn btn--radius btn--green">RESET</button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Jquery JS-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <!-- Vendor JS-->
        <script src="vendor/select2/select2.min.js"></script>
        <script src="vendor/datepicker/moment.min.js"></script>
        <script src="vendor/datepicker/daterangepicker.js"></script>

        <!-- Main JS-->
        <script src="js/global.js"></script>

    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document--
