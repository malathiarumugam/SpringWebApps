<%-- 
    Document   : fcresponse
    Created on : Oct 14, 2015, 3:10:32 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<jsp:useBean id="floor" class="gamecode.FlooringCalculator" scope="session" />
<jsp:setProperty name="floor" property="*" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>You cost estimate!
        </h2>
        <p><%= floor.run() %></p>
        
    </body>
</html>
<jsp:include page="footer.jsp"/>