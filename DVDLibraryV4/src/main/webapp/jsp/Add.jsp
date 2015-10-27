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
            <h1>Add a DVD</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">   
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/Add">Add</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                </ul>
            </div>
            <div class="row">        
                <div class="col-md-10">
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-title" class="col-md-2 control-label">
                                Title:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-title"
                                       placeholder="A catchy title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-release" class="col-md-2 control-label">
                                Release Date:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-release"
                                       placeholder="When did this thing come out?"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-rating" class="col-md-2 control-label">
                                MPAA Rating:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-rating"
                                       placeholder="PG-13, R where we at?"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-director" class="col-md-2 control-label">Director:</label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-director"
                                       placeholder="Who directed this?"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-studio" class="col-md-2 control-label">Studio:</label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-studio"
                                       placeholder="Who made this?"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-note" class="col-md-2 control-label">Notes:</label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-note"
                                       placeholder="Any notes?"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-2 col-md-8">
                                <button type="submit"
                                        id="add-button"
                                        class="btn btn-default">
                                    Create Movie
                                </button>
                            </div>
                        </div>
                    </form>   
                    <div id="validationErrors" style="color: red"></div>
                </div>
            </div>
        </div>
                    
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> 
                <script src="${pageContext.request.contextPath}/js/dvdlibrary.js"></script>  
    </body>
</html>
