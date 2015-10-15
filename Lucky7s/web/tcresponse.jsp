<%-- 
    Document   : tcresponse
    Created on : Oct 14, 2015, 3:43:32 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<jsp:useBean id="tips" class="gamecode.TipCalculator" scope="session"/>
<jsp:setProperty name="tips" property="*"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your tip!</h1>
        <p><%= tips.run() %></p>
    </body>
</html>
<jsp:include page="footer.jsp"/>
