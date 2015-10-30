<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
            <h1>Machine that Vends</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/mainAjaxPage">VendingMachine</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/create">Create</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/j_spring_security_logout">Log
                            Out</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="container">
            <p><a href="${pageContext.request.contextPath}/login">Log In</a></p>
            <p>
                Welcome to the Vending Machine demonstration project. <br>Built by Kevin Gresmer
            </p>
        </div>
            <c:if test="${not empty pageContext.request.userPrincipal}">
                <p>worked!</p>
               <%response.sendRedirect("http://localhost:8080/VendingMachineV2/mainAjaxPage");%>
            </c:if>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
                <script src="${pageContext.request.contextPath}/js/vending.js"></script>
    </body>
</html>