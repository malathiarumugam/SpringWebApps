<%-- 
    Document   : interestcalc
    Created on : Oct 14, 2015, 2:19:21 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to the interest calculator<br><br><br></h1>
        <form action="icresponse.jsp" method="POST">
            Enter the amount you want to invest: <input type="number" name="entry" value="" />
            <input type="submit" />
        </form>
    </body>
</html>
<jsp:include page="footer.jsp"/>