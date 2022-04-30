<%-- 
    Document   : cmbCategory
    Created on : Mar 9, 2022, 8:01:11 PM
    Author     : TungNT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="selectedCategory" value="${param.cmbCategory}"/>
<c:set var="category" value="${sessionScope.LIST_CATEGORIES}"/>
<input type="hidden" name="action" value="FilterCategory"/>

    <select name="cmbCategory" class="form-select mbCategform-select-sm" aria-label=".form-select-sm example" onchange="this.form.submit()">
        <c:choose>
            <c:when test="${empty selectedCategory}">
                <option value="All Product">All Product</option>
            </c:when>
            <c:otherwise>
                <c:set var="all" value="All Product"/>
                <c:if test="${selectedCategory ne all}">
                    <option value="${selectedCategory}">${selectedCategory}</option>
                    <option value="All Product">All Product</option>
                </c:if>
                <c:if test="${selectedCategory eq all}">
                    <option value="${selectedCategory}">${selectedCategory}</option>
                </c:if>
            </c:otherwise>
        </c:choose>
        <c:forEach items="${category}" var="c" varStatus="status">
            <c:if test="${c.title ne selectedCategory}">
                <option value="${c.title}">${c.title}</option>
            </c:if>
        </c:forEach>
    </select>