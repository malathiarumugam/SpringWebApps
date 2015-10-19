<%-- 
    Document   : home
    Created on : Oct 16, 2015, 10:19:50 AM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Boostrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">      
        <title>DVD Library</title>
    </head>
    <body>
        <div class="container">
            <h1>List All the DVDs!</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">   
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/Add">Add</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/ListAll">List All</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/Display">Display</a>
                    </li>
                </ul>
            </div>
        </div>
                    
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>            
    </body>
</html>
