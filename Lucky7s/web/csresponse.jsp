<%-- 
    Document   : csresponse
    Created on : Oct 14, 2015, 4:05:04 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<jsp:useBean id="convert" class="gamecode.UnitConverter" scope="session" />
<jsp:setProperty name="convert" property="*" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>THE CONVERSION!</h1>
        <%= convert.run() %>
    </body>
</html>
<jsp:include page="footer.jsp"/>