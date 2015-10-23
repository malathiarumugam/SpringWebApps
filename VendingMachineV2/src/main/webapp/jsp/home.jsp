<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hello Controller Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <!--<link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">-->

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <style>
            #items {
                border: #222 solid 1px;
                height: 35em;

            }
            #inputs {
                border: #222 solid 1px;
                height: 35em;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Vending Machine</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">   
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-8" id="items">
                    <h3>Item List</h3>
                    <table id="vending-id" class="table table-hover">
                        <tr>
                            <th width="50%">Item Name</th>
                            <th width="20%">Quantity</th>
                            <th width="20%">Price</th>
                            <th width="10%">Code</th>
                        </tr>
                        <tbody id="contentRows"></tbody>
                    </table>
                </div>
                <div class="col-md-4" id="inputs">

                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <input type="text"
                                   class="form-control"
                                   id="add-code"
                                   placeholder="Item Code"/>
                        </div>
                        <table id="money-id" class="table table-hover">
                            <tbody id="moneyRows"></tbody>
                        </table>
                        <div class="form-group">
                            <input type="text"
                                   class="form-control"
                                   id="add-money"
                                   placeholder="Enter money amount here"/>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-2 col-md-8">
                                <button type="submit"
                                        id="add-button"
                                        class="btn btn-default">
                                    Vend!
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/vending.js"></script>
    </body>
</html>

