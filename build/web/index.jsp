<%-- 
    Document   : index
    Created on : Mar 5, 2022, 11:09:57 AM
    Author     : TungNT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Vegetable Store</title>
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles_index.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="./components/navbar.jsp" %>
        <!-- Header-->
        <header class="py-5 image">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">Fresh Vegetable</h1>
                    <p class="lead fw-normal text-white-30 mb-0">Specializing in providing fresh fruits and vegetables for a hustle life</p>
                </div>
            </div>
        </header>
        <!-- Section-->
        <c:if test="${requestScope.SHOPPING_MESSAGE != null}">
            <div class="alert alert-success" role="alert">
                <center>
                    <strong>Success!</strong> ${requestScope.SHOPPING_MESSAGE}
                </center>
            </div>
        </c:if>
        <c:if test="${requestScope.ERROR_SHOPPING_MESSAGE != null}">
            <div class="alert alert-danger">
                <center>
                    <strong>Alert!</strong> ${requestScope.ERROR_SHOPPING_MESSAGE}
                </center>
            </div>
        </c:if>
        <form action="MainController">
            <section class="py-5">
                <!<!-- SEARCH SECTION -->
                <div style="width: 20%; margin: auto" class="input-group mb-3">
                    <input type="text" name="search" class="form-control" value="${param.search}" placeholder="Search" aria-label="" aria-describedby="basic-addon1">
                    <div class="input-group-prepend">
                        <input class="btn btn-outline-secondary" type="submit" name="action" value="Search"></input>
                    </div>
                </div>

                <!-- SELECT CATEGORY -->
                
                <input type="hidden" name="position" value="index_page"/>
                <div style="width: 20%; margin: auto">
                    <%@include file="components/cmbCategory.jsp" %>
                </div>
        </form>

        <div class="container px-4 px-lg-5 mt-5">
            <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                <!-- Giữ nguyên -->
                <c:forEach items="${requestScope.LIST_PRODUCTS}" var="p" varStatus="status">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img style="width: 268px; height: 230px; position: center" class="card-img-top" src="${p.image}" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5>${p.productName}</h5>
                                    <!-- Product price-->
                                    <c:set var="price" value="${p.price}"/>
                                    ${p.showPrice(price)} VNĐ
                                </div>
                                
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center">
                                    <c:choose>
                                        <c:when test="${p.quantity == 0}">
                                            <p style="color: red; font-weight: bold">Out of stock</p>
                                        </c:when>
                                        <c:otherwise>
                                            <c:choose>
                                                <c:when test="${empty selectedCategory}">
                                                    <a class="btn btn-outline-dark mt-auto" href="MainController?action=Add to cart&productID=${p.productID}&productName=${p.productName}&image=${p.image}&price=${p.price}&quantity=1&cmbCategory=${"All Product"}&position=index_page">
                                                        Add to cart
                                                    </a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a class="btn btn-outline-dark mt-auto" href="MainController?action=Add to cart&productID=${p.productID}&productName=${p.productName}&image=${p.image}&price=${p.price}&quantity=1&cmbCategory=${selectedCategory}&position=index_page">
                                                        Add to cart
                                                    </a>
                                                </c:otherwise>
                                            </c:choose>

                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                            <div class="text-center" style="margin-top: 10px">
                                    <!-- Product name-->
                                    <p style="color: lightgray;">Số lượng còn lại: ${p.quantity} ${p.unit} </p>
                                </div>
                        </div>
                    </div>
                </c:forEach>
                
            </div>
        </div>
    </section>

    <%@include file="components/footer.jsp" %>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
                        window.setTimeout(function () {
                            $(".alert").fadeTo(500, 0).slideUp(500, function () {
                                $(this).remove();
                            });
                        }, 2000);
    </script>
</body>
</html>
