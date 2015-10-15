<%-- 
    Document   : flooringCalc
    Created on : Oct 14, 2015, 3:06:47 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<jsp:useBean id="floor" class="gamecode.FlooringCalculator" scope="session" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>How much does your floor cost?</h1>
        <h4>
            <form action="fcresponse.jsp" method="POST">
                <p>Enter the floor length: <input type="number" name="length" VALUE="" /></p>
                <p>Enter the floor width: <input type="number" name="width" value="" /></p>
                <p>Enter the floor unit cost: <input type="text" name="unitCost" value="" /></p>
                <input type="submit" />
            </form>
        </h4>
    </body>
</html>
<jsp:include page="footer.jsp"/>