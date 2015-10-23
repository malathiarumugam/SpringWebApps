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
            <h1>Add an Entry!</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">   
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/add">Add</a>
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
                            <label for="add-first-name" class="col-md-2 control-label">
                                First Name:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-first-name"
                                       placeholder="First Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-last-name" class="col-md-2 control-label">
                                Last Name:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-last-name"
                                       placeholder="Last Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-street" class="col-md-2 control-label">
                                Street:
                            </label>

                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-street"
                                       placeholder="Street"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-city" class="col-md-2 control-label">City:</label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-city"
                                       placeholder="City"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-state" class="col-md-2 control-label">State:</label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-state"
                                       placeholder="State"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-zip" class="col-md-2 control-label">Zip Code:</label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-zip"
                                       placeholder="Zip"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-2 col-md-8">
                                <button type="submit"
                                        id="add-button"
                                        class="btn btn-default">
                                    Create Entry
                                </button>
                            </div>
                        </div>
                    </form>
                    <div id="validationErrors" style="color: red"/>
                </div>

            </div>



        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>   
        <script src="${pageContext.request.contextPath}/js/addBook.js"></script>  
    </body>
</html>
