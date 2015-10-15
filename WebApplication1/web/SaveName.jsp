<%-- 
    Document   : SaveName
    Created on : Oct 14, 2015, 9:19:50 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   String name = request.getParameter( "username" );
   session.setAttribute( "theName", name );
%>
<HTML>
<BODY>
<%
   response.sendRedirect("NextPage.jsp");
   %>
</BODY>
</HTML>
