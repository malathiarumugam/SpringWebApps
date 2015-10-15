<%-- 
    Document   : NextPage
    Created on : Oct 14, 2015, 9:10:45 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello, <%= session.getAttribute( "theName" ) %></h1>
    </body>
</html>
