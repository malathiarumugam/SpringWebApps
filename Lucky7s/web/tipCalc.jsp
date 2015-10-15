<%-- 
    Document   : tipCalc
    Created on : Oct 14, 2015, 3:40:11 PM
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
        <form action="tcresponse.jsp" method="POST">
            <p>What is the bill amount?<input type="text" name="bill" value="" /></p>
            <p>What percent do you want to tip?<input type="text" name="percentTip" value="" /></p>
            <input type="submit" />
        </form>
    </body>
</html>
<jsp:include page="footer.jsp"/>

