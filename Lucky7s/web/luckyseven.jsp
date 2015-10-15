<%-- 
    Document   : luckyseven
    Created on : Oct 13, 2015, 8:11:22 PM
    Author     : apprentice
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<jsp:useBean id="user" class="gamecode.LuckySevens" scope="request"/> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Sevens!</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
   	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <style>
           #stuff {
            background-color: #eff8fa; 
            margin: 25px;
            }
            #stuff:hover {
                margin: 25px;
                box-shadow: 15px 15px 15px 15px #999;
            }
            
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row text-center"  id="stuff">
                <h1>Bet on This!</h1>
                <% 
                  if ("2".equals(user.getStatus())) {
                      out.println(user.getError());
                      user.setStatus("1");
                  }
                %>
                <form name="getdata" action="Isresponse.jsp" method="POST">

                    <p>How Much do you want to bet?</p>
                    <p><input type="text" name="betIn" value="" size="20" /></p>
                    <input type="submit"/>

                </form>
            </div>
        </div>
    </body>
</html>
<jsp:include page="footer.jsp"/>