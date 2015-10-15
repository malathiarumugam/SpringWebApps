<%-- 
    Document   : factResponse
    Created on : Oct 14, 2015, 11:32:41 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<jsp:useBean id="fact" class="gamecode.Factorizer" scope="session"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1><%= fact.run() %></h1>
         <a href="index.jsp" >Back to home page?</a>
    </body>
</html>
<jsp:include page="footer.jsp"/>