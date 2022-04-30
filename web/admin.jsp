<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 11:07:39 AM
    Author     : TungNT
--%>

<%@page import="utils.Utils"%>
<%@page import="data.dto.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>ADMIN PAGE</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
        crossorigin="anonymous"></script>
    </head>

    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="#">VEGETABLE STORE</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i
                    class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <a href="add-product.jsp" class="btn btn-primary btn-sm" role="button" aria-pressed="true">Add Product</a>
                </div>
            </form>

            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="LogoutController">Log Out</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <a class="nav-link" href="#">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Product Management
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        ${sessionScope.LOGIN_USER.fullName}
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Product Management</h1>
                        <div class="card mb-4">
                            <div class="card-body">
                                <!-- CATEGORY PRODUCT -->
                                <p style="color: green">${requestScope.MESSAGE}</p>
                                <form action="MainController">
                                    <input type="hidden" name="position" value="admin_page"/>
                                    <div style="width: 11%;">
                                        <%@include file="components/cmbCategory.jsp" %>
                                    </div>
                                </form>
                                <!-- CLOSE CATEGORY PRODUCT -->
                                <c:set var="product" value="${requestScope.LIST_PRODUCTS}"/>
                                <!-- End category combo box -->
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th style="text-align: center">Product Name</th>
                                            <th style="text-align: center">Price</th>
                                            <th style="text-align: center">Image</th>
                                            <th style="text-align: center">Quantity</th>
                                            <th style="text-align: center">Unit</th>
                                            <th style="text-align: center">Import Date</th>
                                            <th style="text-align: center">Using Date</th>
                                            <th style="text-align: center">Update</th>
                                            <th style="text-align: center">Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="dto" items="${product}" varStatus="status">
                                            <tr>
                                                <td style="text-align: center; font-weight: bold">
                                                    ${dto.productName}
                                                </td>
                                                <td style="text-align: center">
                                                    <c:set var="price" value="${dto.price}"/>
                                                    ${dto.showPrice(price)} VNĐ
                                                </td>
                                                <td style="text-align: center">
                                                    <img style="width: 172px; height: 156px" src="${dto.image}" alt="alt"/>
                                                </td>
                                                <td style="text-align: center">
                                                    ${dto.quantity}
                                                </td>
                                                <td style="text-align: center">
                                                    ${dto.unit}
                                                </td>
                                                <td style="text-align: center">
                                                    ${dto.importDate}
                                                </td>
                                                <td style="text-align: center">
                                                    ${dto.usingDate}
                                                </td>
                                                <td>
                                                    <button style="margin-left: 18px; margin-top: 55px" class="btn btn-outline-primary">
                                                        <a style="text-decoration: none" href="MainController?action=Edit&productID=${dto.productID}&productName=${dto.productName}&price=${dto.price}&image=${dto.image}&quantity=${dto.quantity}&unit=${dto.unit}&categoryID=${dto.categoryID}&categoryName=${dto.categoryName}&importDate=${dto.importDate}&usingDate=${dto.usingDate}&position=admin_page">Edit Product</a>
                                                    </button>
                                                </td>
                                                <td>
                                                    <button style="margin-left: 23px; margin-top: 55px" class="btn btn-outline-primary">
                                                        <a style="text-decoration: none" href="MainController?action=Delete Product&productID=${dto.productID}&cmbCategory=${selectedCategory}&position=admin_page">Delete Product</a>
                                                    </button>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Vegetable Store 2022</div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>