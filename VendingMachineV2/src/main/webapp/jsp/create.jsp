<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <!--<link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">-->

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
            <h1>Create the Vending Machine Inventory</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">   
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/create">Create</a>
                    </li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-6" id="items">
                    <h3>Item List</h3>
                    <table id="vending-id" class="table table-hover">
                        <tr>
                            <th width="50%">Item Name</th>
                            <th width="20%">Quantity</th>
                            <th width="20%">Price</th>
                            <th width="10%">Code</th>
                        </tr>
                        <tbody id="editRows"></tbody>
                    </table>
                </div>
                <div class="col-md-6">
                    <h2>Add New Item</h2>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-name" class="col-md-4 control-label">
                                Item name:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-name"
                                       placeholder="Snickers?"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-cost" class="col-md-4 control-label">
                                Item cost:
                            </label>
                            <div class="col-md-8">
                                <input type="number" min="0" max="99"
                                       class="form-control"
                                       id="add-cost"
                                       placeholder="price?"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-code" class="col-md-4 control-label">
                                Item code:
                            </label>

                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id="add-code"
                                       placeholder="A2?"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-count" class="col-md-4 control-label">
                                Item Inventory:
                            </label>
                            <div class="col-md-8">
                                <input type="number" min="1" max="10"
                                       class="form-control"
                                       id="add-count"
                                       placeholder="How many in stock?"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit"
                                        id="add-button"
                                        class="btn btn-default">
                                    Create Item
                                </button>
                            </div>
                        </div>

                        <div id="validationErrors" style="color:red"></div>
                </div>
                </form>
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
                        <h4 class="modal-title" id="detailsModalLabel">Edit Item</h4>
                    </div>
                    <div class="modal-body">
                        <h3 id="contact-id"></h3>
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="edit-Item-code" class="col-md-4 control-label">
                                    Code:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-Item-code" placeholder="Code please" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-name" class="col-md-4 control-label">
                                    Item Name:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-name" placeholder="Name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-cost" class="col-md-4 control-label">
                                    Cost:
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-cost" placeholder="Price per unit?">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-count" class="col-md-4 control-label">
                                    Inventory:
                                </label>
                                <div class="col-md-8">
                                    <input type="number" class="form-control" id="edit-count" placeholder="How many?">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                    <button type="submit" id="edit-button" class="btn btn-default">
                                        Edit Item
                                    </button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">
                                        Cancel
                                    </button>
                                    <input type="hidden" id="edit-item-code">
                                </div>
                            </div>
                        </form>
                        <div id="validationErrors" style="color:red"/>
                    </div>
                </div>
            </div>
        </div>            
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/vending.js"></script>          
    </body>
</html>