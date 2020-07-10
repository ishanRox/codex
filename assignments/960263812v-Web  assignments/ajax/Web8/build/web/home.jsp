<%-- 
    Document   : home
    Created on : Nov 1, 2019, 9:04:25 PM
    Author     : ayodhya
--%>

<%@page import="database.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link href="css/main.css" rel="stylesheet"/>
        
    </head>
    <body onload="loadProducts();">
        
        <h1>Hello World!</h1>
        
        <%
        HttpSession ses=request.getSession();

        if(ses.getAttribute("customer")==null){

            %>
            <h2>Not Sign In</h2>
            <%

        }else{

            Customer customer=(Customer)ses.getAttribute("customer");
                
        %>
        
        
        <h2><%= customer.getUsername() %></h2>
        
         <%
        
                }
        
        %>
        <div id="pa">
            
        </div>
        
       
        <script type="text/javascript" src="js/main.js"></script>
    </body>
</html>
