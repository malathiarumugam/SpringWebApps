<%-- 
    Document   : Isresponse
    Created on : Oct 14, 2015, 8:25:20 AM
    Author     : apprentice
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<jsp:useBean id="user" class="gamecode.LuckySevens" scope="request"/> 
<jsp:setProperty name="user" property="*"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <h3>
            <%                
                user.testNum();
                if ("2".equals(user.getStatus())) {
                    %>
                    <jsp:forward page="luckyseven.jsp" />
                    <%
                } else {
                    user.run();
                }
            %>
            <%= user.getOutput()%><BR>
        </h3>
    </body>
</html>
<jsp:include page="footer.jsp"/>