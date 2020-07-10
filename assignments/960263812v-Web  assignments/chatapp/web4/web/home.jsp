<%-- 
    Document   : home
    Created on : Oct 28, 2019, 7:40:55 PM
    Author     : Ayodhya Perera
--%>

<%@page import="database.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="css/newcss.css" type="text/css"/>
    </head>
    <body onload="loaduser(),setInterval(viewchat,2000);">
        <h1>Home</h1>
        <%
        HttpSession hs=request.getSession();
        
        if(hs.getAttribute("u")==null){
        response.sendRedirect("login.jsp");
        
        }else{
        
       User u1= (User)hs.getAttribute("u");
        
        %>
        
    <hl><%=u1.getName()+":"+u1.getMobile()%></hl> 
    
    <select id="sec1">
            
        </select>
        
        <br>
        <span>Messege</span>
        <br>
        <textarea id="txt">
            
        </textarea>
        <button onclick="sendmessege();">SEND</button>
        
        <br><br>
        
        <div class="chat_box" id="div1">
            
        </div>
        
        <button onclick="viewchat();">VIEW</button>
   
        <%} %>
        
         <script type="text/javascript" src="js/js1.js"></script>
    </body>
</html>
