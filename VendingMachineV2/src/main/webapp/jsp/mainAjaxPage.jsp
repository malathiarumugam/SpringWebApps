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

        <!-- Custom styles for this template -->
        <!--<link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">-->

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <style>
            #items {
                background-color: #b4b4b4;
            }
            img {
                width: 100%;
            }
            #inputMoney {
                padding: 0px 15px 0px 15px;
            }
            #inputCode {
                padding: 20px 15px 0px 15px;
            }
            #vendButton {
                padding-bottom: 10px;
            }
            .container {
                background-color: #f4f4f4;
            }

        </style>
    </head>
    <body>
        <div class="container">
            <!--            <h1>Vending Machine</h1>
                        <hr/>-->
            <div class="navbar">
                <ul class="nav nav-tabs">   
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation" class="active">
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
            <div class="row">
                <div class="col-md-offset-2 col-md-6">
                    <img src="img/pepsi2.jpg"/>
                </div>
                <div class="col-md-4" id="items">
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
                    <form class="form-horizontal" role="form">
                        <div class="form-group" id="inputCode">
                            <select id="vend-code">

                            </select>
                            <!--                            <input type="text"
                                                               class="form-control"
                                                               id="vend-code"
                                                               placeholder="Item Code"/>-->
                        </div>

                        <div class="form-group" id="inputMoney">
                            <input type="text"
                                   class="form-control"
                                   id="vend-money"
                                   placeholder="Enter money amount here"/>
                        </div>
                        <div class="form-group" id="vendButton">
                            <div class="col-md-8">
                                <button type="submit"
                                        id="vend-button"
                                        class="btn btn-default">
                                    Vend
                                </button>
                            </div>
                        </div>
                        <table id="money-id" class="table table-hover">
                            <tbody id="moneyRows"></tbody>
                        </table>
                    </form>
                    <form>
                        <table id="money-id" class="table table-hover">
                            <tbody id="changeRows"></tbody>
                        </table>
                        <div class="form-group" id="changeButton">
                            <button type="submit"
                                    id="change-button"
                                    class="btn btn-default">
                                Return Change
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class=" col-md-offset-8 col-md-4" id="inputs">

                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/vending.js"></script>
    </body>
</html>

