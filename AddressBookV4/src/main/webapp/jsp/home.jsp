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
        <title>Address Book</title>
    </head>
    <body>
        <div class="container">
                <h1>Address Book</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">   
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation" >
                        <a href="${pageContext.request.contextPath}/add">Add</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                </ul>
            </div>
            <h1>All the Entries!!!</h1>
            <div class="row">
                <div class="col-md-9">
                    <h2>My Contacts</h2>
                    <table id="addressTable" class="table table-hover">
                        <tr>
                            <th width="35%">Contact Name</th>
                            <th width="35%">Street</th>
                            <th width="10%">City</th>
                            <th width="5%">State</th>
                            <th width="10%">Zip Code</th>
                        </tr>
                        <tbody id="contentRows"></tbody>
                    </table>
                </div>
            </div>
        </div>
                    
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>   
        <script src="${pageContext.request.contextPath}/js/addressbook.js"></script>
    </body>
</html>
