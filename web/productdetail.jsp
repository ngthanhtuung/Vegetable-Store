<%-- 
    Document   : productdetail
    Created on : Mar 4, 2022, 1:57:32 PM
    Author     : TungNT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>PRODUCT DETAILS</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    </head>

    <body>
        <div class="container">
            <div style="width: 70%;" class="container-md">
                <h2 style="text-align: center; padding-top: 20px">Product Information</h2>
                <br>
                <form action="MainController">
                    <c:set var="p" value="${requestScope.PRODUCT_DETAIL}"/>
                    <div class="form-group">
                        <label>Product ID</label>
                        <input type="type" name="productID" value="${p.productID}" class="form-control" placeholder="Product ID" readonly="">
                    </div>
                    <div class="form-group">
                        <label>Product Name</label>
                        <input type="type" name="productName" value="${p.productName}" class="form-control" placeholder="Product Name" readonly="">
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input type="number" name="price" value="${p.price}" class="form-control" placeholder="Price" min="1000">
                    </div>
                    <div class="form-group">
                        <label>Image URL</label>
                        <input type="type" name="image" value="${p.image}" class="form-control" placeholder="Image">
                    </div>
                    <div class="form-group">
                        <label>Quantity</label>
                        <input type="number" name="quantity" value="${p.quantity}" class="form-control" placeholder="Quantity" min="1">
                    </div>
                    <div class="form-group">
                        <label>Unit</label>
                        <input type="text" name="unit" value="${p.unit}" class="form-control" placeholder="Unit" readonly="">
                    </div>
                    <div class="form-group">
                        <label>Category</label>
                        <c:set var="categories" value="${sessionScope.LIST_CATEGORIES}"/>
                        <c:set var="selectedCategoryName" value="${requestScope.PRODUCT_DETAIL.categoryName}"/>
  
                        <select name="cmbCategory" class="form-control">
                            <option value="${selectedCategoryName}">${selectedCategoryName}</option>
                            <c:forEach items="${categories}" var="categoryItem" varStatus="status">
                                <c:if test="${(categoryItem.title ne selectedCategoryName)}">
                                    <option value="${categoryItem.title}">${categoryItem.title}</option>
                                </c:if>
                            </c:forEach>
                        </select>      
                    </div>
                    <div class="form-group">
                        <label>Import Date (MM-DD-YYYY)</label>
                        <input type="date" name="importDate" value="${requestScope.PRODUCT_DETAIL.importDate}" class="form-control" placeholder="Import Date" readonly="">
                    </div>
                    <div class="form-group">
                        <label>Using Date (MM-DD-YYYY)</label>
                        <input type="date" name="usingDate" value="${requestScope.PRODUCT_DETAIL.usingDate}" class="form-control" placeholder="Using Date">
                    </div>
                    <input type="hidden" name="position" value="admin_page">
                    <button type="submit" name="action" value="Update Product" class="btn btn-primary">UPDATE</button>
                    <a style="margin-left: 20px" href="TransferDataToAdminController">BACK</a>
                </form>
            </div>
        </div>
    </body>
</html>
