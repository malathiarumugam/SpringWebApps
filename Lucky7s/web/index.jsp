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
            body {
                background-color: #80E6FF;
                font-size: 20px;
                
            }
            #toptitle {
                width: 100%;
                height: 60px;
                text-align: center;
                vertical-align: middle;
                display: block;
                border: black 1px solid; 
                padding-top: 15px;
                margin: 10px;
                background-color: #CCFFCC;
            }
            
            #middlediv {
                width: 80%;
                height: 350px;
                text-align: center;
                vertical-align: middle;
                display: block;
                border: black 1px solid; 
                padding-top: 15px;
                margin: 0px;
                margin: auto;
                background-color: #FFFFAD;
            }
            img {
                height: 300px;
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
                left: -10px;
                background-color: #94FFB8;
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
            <a href="index.jsp" >Home</a> | <a href="luckyseven.jsp" >Lucky Sevens</a> | <a href="factorizer.jsp" >Factorizer</a> | <a href="interestcalc.jsp" >Interest Calculator</a> | <a href="flooringCalc.jsp" >Flooring Calculator</a> | <a href="tipCalc.jsp" >Tip Calculator</a> | <a href="converter.jsp" >Unit Converter</a>
        </div>
        
        <div id="middlediv">
            Click on one of the programs in the above ribbon and Go Nuts!
            <br><img src="bunny.jpg" />
        </div>
    </body>
</html>
<jsp:include page="footer.jsp"/>