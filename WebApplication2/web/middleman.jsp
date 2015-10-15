<%-- 
    Document   : middleman
    Created on : Oct 14, 2015, 12:04:20 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="lucky" class="gamesbot.LuckySevens" scope="session" />
<jsp:setProperty name="lucky" property="*" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            response.sendRedirect("Lsresponse.jsp");
            %>
    </body>
</html>
