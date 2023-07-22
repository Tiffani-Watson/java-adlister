<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alaniz
  Date: 7/19/23
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>8080 Login</title>
    <%@ include file="partials/head.jsp" %>
</head>
<body>
<main>
    <%@ include file="partials/navbar.jsp" %>
    <form action="login.jsp" method="post">
        <div class="m-5">
            <label class="form-label" for="username">Username: </label>
            <input class="form-control mb-3" type="text" name="username" id="username">
            <label class="form-label" for="password">Password: </label>
            <input class="form-control mb-3" type="password" name="password" id="password">
            <input type="submit" value="submit" name="submit">
        </div>

    </form>

    <c:if test="${param.submit != null}">
        <c:choose>
            <c:when test="${param.username == 'admin' && param.password == 'password'}">
                <% response.sendRedirect("/profile.jsp"); %>
            </c:when>
            <c:otherwise>
                <% response.sendRedirect("/login.jsp"); %>
            </c:otherwise>
        </c:choose>
    </c:if>

    <%@ include file="partials/bs_scripts.jsp" %>
</main>
</body>
</html>