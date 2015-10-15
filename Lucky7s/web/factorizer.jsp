<%-- 
    Document   : factorizer
    Created on : Oct 14, 2015, 11:22:39 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fact o Rise It!</title>
    </head>
    <body>
        <h1>Factor This!</h1>
        <form action="middlefact.jsp" method="POST">
            <p>Please enter in the value you would like to factor?<input type="text" name="answer" value="" /></p>
            <input type="submit" value="Submit" name="submit" />
        </form>
        
    </body>
</html>
<jsp:include page="footer.jsp"/>