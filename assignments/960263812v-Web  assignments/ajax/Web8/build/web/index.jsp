<%-- 
    Document   : index
    Created on : Nov 1, 2019, 8:05:19 PM
    Author     : ayodhya
--%>

<%@page import="database.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% 
                HttpSession ses=request.getSession();
                
                if(ses.getAttribute("customer")!=null){
                    response.sendRedirect("home.jsp");
                }
        %>
        
        <h1>Sign In</h1>
        
        <span>Username</span>
        
        <input type="text" id="un">
        
        <br><br>
        
        <span>Password</span>
        
        <input type="password" id="pw">
        
        <br><br>
        
        <button onclick="signin();">Sign In</button>
        
        
        <script type="text/javascript" src="js/main.js"></script>
    </body>
</html>
