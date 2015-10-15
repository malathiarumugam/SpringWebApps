<%-- 
    Document   : middlefact
    Created on : Oct 14, 2015, 11:28:03 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="fact" class="gamecode.Factorizer" scope="session"/>
<jsp:setProperty name="fact" property="*"/> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            response.sendRedirect("factResponse.jsp");
            %>
       
    </body>
</html>
