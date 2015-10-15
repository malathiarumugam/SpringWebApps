<%-- 
    Document   : icresponse
    Created on : Oct 14, 2015, 2:19:39 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<jsp:useBean id="calc" class="gamecode.InterestCalculator" scope="session" />
<jsp:setProperty name="calc" property="*" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>SO MUCH MONEY!<br><br><br></h1>
        <h2><%= calc.run() %></h2>
    </body>
</html>
<jsp:include page="footer.jsp"/>