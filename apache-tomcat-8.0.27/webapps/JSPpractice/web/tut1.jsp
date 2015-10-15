<%-- 
    Document   : tut1
    Created on : Oct 13, 2015, 2:28:29 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            
            TD {
                padding: 20px;
                background-color: purple;
                font-size: 25px;
                
            }
        </style>
    </head>
    <body><%
    System.out.println( "Evaluating date now" );
    Date date = new Date();
%>
Hello!  The time is now <%= date %>
        <TABLE BORDER=2>
<%
    for ( int i = 0; i < 9; i++ ) {
        %>
        
        <TR>
            <TD>Number</TD>
        <TD><%= i+1 + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Trees" %></TD>
        </TR>
        <%
    }
%>
</TABLE>

    </body>
</html>
