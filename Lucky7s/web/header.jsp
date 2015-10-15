<%-- 
    Document   : index
    Created on : Oct 13, 2015, 8:59:37 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Menu</title>
        <style>
            #toptitle {
                width: 100%;
                height: 60px;
                text-align: center;
                vertical-align: middle;
                display: block;
                border: black 1px solid; 
                padding-top: 15px;
                margin: 2px;
            }
            
            #selectbar {
                width: 100%;
                height: 40px;
                line-height:40px;
                text-align: center;
                vertical-align: middle;
                display: block;
                border: black 1px solid; 
                margin: 2px;
            }
             span {
                display: block;
            }
            
        </style>
    </head>
    <body>
        <div id="toptitle"><span>Software Craftsmanship Guild Java Cohort</span>
            <span>JSP Site Lab</span>
        </div>
        
        <div id="selectbar">
            <a href="index.jsp" >Home</a>  | <a href="luckyseven.jsp" >Lucky Sevens</a> | <a href="factorizer.jsp" >Factorizer</a> | <a href="interestcalc.jsp" >Interest Calculator</a> | <a href="flooringCalc.jsp" >Flooring Calculator</a> | <a href="tipCalc.jsp" >Tip Calculator</a> | <a href="converter.jsp" >Unit Converter</a>
        </div>
    </body>
</html>
