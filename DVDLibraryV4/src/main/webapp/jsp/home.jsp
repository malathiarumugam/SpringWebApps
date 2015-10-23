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
            <h1>DVD Library!</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">   
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/Add">Add</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/Display">Display</a>
                    </li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <h2>My Movies</h2>
                    <table id="total" class="table table-hover">
                        <tr>
                            <th>Total Number of movies</th>
                        </tr>
                        <tbody id="totalRows"></tbody>
                    </table>
                    <table id="DVD-id" class="table table-hover">
                        <tr>
                            <th width="30%">Title</th>
                            <th width="10%">Release Date</th>
                        </tr>
                        <tbody id="contentRows"></tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="modal fade" id="detailsModal" tabindex="-1" role="dialog"
             aria-labelledby="detailsModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="detailsModalLabel">The chosen one.</h4>
                    </div>
                    <div class="modal-body">
                        <h3 id="dvd-id"></h3>
                        <table id="movieTable" class="table table-hover">
                            <tr>
                                <tr>
                                <th>Title:</th>
                                <td id="add-title"></td>
                            </tr>
                            <tr>
                                <th>Release Date:</th>
                                <td id="add-release"></td>
                            </tr>
                            <tr>
                                <th>MPAA Rating:</th>
                                <td id="add-rating"></td>
                            </tr>
                            <tr>
                                <th>Director:</th>
                                <td id="add-director"></td>
                            </tr>
                            <tr>
                                <th>Studio:</th>
                                <td id="add-studio"></td>
                            </tr>
                            <tr>
                                <th>Note:</th>
                                <td id="add-note"></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div> 
                    
        <div class="modal fade" id="editModal" tabindex="-1" role="dialog"
             aria-labelledby="detailsModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="detailsModalLabel">Edit Entry</h4>
                    </div>
                    <div class="modal-body">
                        <h3 id="dvd-id"></h3>
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="edit-title" class="col-md-4 control-label">
                                    Title:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-title" placeholder="Blank Title">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-release" class="col-md-4 control-label">
                                    Release Date:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-release" placeholder="When did it come out?">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-rating" class="col-md-4 control-label">
                                    MPAA Rating:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-rating" placeholder="Rated R?">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-director" class="col-md-4 control-label">
                                    Director:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-director" placeholder="Who was the Director?">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-studio" class="col-md-4 control-label">
                                    Studio:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-studio" placeholder="Who paid a bunch to make it?">
                                </div>
                            </div>    
                            <div class="form-group">
                                <label for="edit-note" class="col-md-4 control-label">
                                    Note:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-note" placeholder="Any notes?">
                                </div>
                            </div>    
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                    <button type="submit" id="edit-button" class="btn btn-default" data-dismiss="modal">
                                        Edit Movie
                                    </button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">
                                        Cancel
                                    </button>
                                    <input type="hidden" id="edit-DVD-id">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>                 
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/dvdlibrary.js"></script>
</body>
</html>
