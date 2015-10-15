<%-- 
    Document   : Lsresponse
    Created on : Oct 14, 2015, 12:20:56 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="lucky" class="gamesbot.LuckySevens" scope="session" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= lucky.run() %></h1>
    </body>
</html>
