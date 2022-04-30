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
                <h2 style="text-align: center; padding-top: 20px">Create New Product</h2>
                <br>
                <c:if test="${requestScope.ERROR != null}">
                    <p style="color: red; font-weight: bold">${requestScope.ERROR}</p> 
                </c:if>
                <form action="MainController">
                    <div class="form-group">
                        <label>Product Name</label>
                        <input type="type" name="productName" class="form-control" placeholder="Product Name" required="">
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input type="number" name="price" class="form-control" placeholder="Price" min="1000" required="">
                    </div>
                    <div class="form-group">
                        <label>Image URL</label>
                        <input type="type" name="image" class="form-control" placeholder="Image" required="">
                    </div>
                    <div class="form-group">
                        <label>Quantity</label>
                        <input type="number" name="quantity" class="form-control" placeholder="Quantity" min="1" required="">
                    </div>
                    <div class="form-group">
                        <label>Unit</label>
                        <input type="text" name="unit" class="form-control" placeholder="Unit" required="">
                    </div>
                    <div class="form-group">
                        <label>Category</label>
                        <c:set var="categories" value="${sessionScope.LIST_CATEGORIES}"/>
                        <select name="cbCategory" class="form-control">
                            <c:forEach items="${categories}" var="categoryItem" varStatus="status">
                                <option value="${categoryItem.id}">${categoryItem.title}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Using Date (MM-DD-YYYY)</label>
                        <input type="date" name="usingDate" class="form-control" id="date_picker" placeholder="Using Date" required="">
                    </div>
                    <button type="submit" name="action" value="Add Product" class="btn btn-primary">ADD PRODUCT</button>
                    <a style="margin-left: 20px" href="TransferDataToAdminController">BACK</a> 

                </form>
            </div>
        </div>
        <script language="javascript">
            var today = new Date();
            var dd = String(today.getDate()).padStart(2, '0');
            var mm = String(today.getMonth() + 1).padStart(2, '0');
            var yyyy = today.getFullYear();

            today = yyyy + '-' + mm + '-' + dd;
            $('#date_picker').attr('min', today);
        </script>
    </body>
</html>
