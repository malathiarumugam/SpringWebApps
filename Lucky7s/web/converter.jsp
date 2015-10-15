<%-- 
    Document   : converter
    Created on : Oct 14, 2015, 3:48:13 PM
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
        <h1>CONVERT THIS!</h1>
        <form action="csresponse.jsp" method="POST">
            <p>What are you converting from?<select name="userFromChoice" size="3">
                <option>Fahrenheit</option>
                <option>Celsius</option>
                <option>Kelvin</option>
                </select></p>
            <p>What is the temperature?<input type="number" name="userTemp" value="" /></p>
            <p>What are you converting to?<select name="userToChoice" size="3">
                <option>Fahrenheit</option>
                <option>Celsius</option>
                <option>Kelvin</option>
            </select></p>
            <input type="submit" />
        </form>
    </body>
</html>
<jsp:include page="footer.jsp"/>