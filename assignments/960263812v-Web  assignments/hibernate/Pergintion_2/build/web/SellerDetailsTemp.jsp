<%@page import="database.Seller"%>
<%
    if(request.getAttribute("seller") != null){
    Seller seller = (Seller)request.getAttribute("seller");
%>
<span id="title" >Seller Details</span>
<br/><br/>
<span>
    <center>
        <img src="">
    </center>
</span>
<br/><br>
<span id="sub-title"><%= seller.getName() %></span>
<br>
<span>Mobile : <%= seller.getMobile() %></span>
<br>
<span>Gender : <%= seller.getGender() %></span>
<br>
<span>City : <%= seller.getCity() %></span>
<% } %>