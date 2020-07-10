

<%@page import="database.Product"%>
<%@page import="java.util.List"%>
<table>
    
<%
        List<Product> p_list=(List<Product>)request.getAttribute("p_list");
        
        for(Product p:p_list){
            
%>
        <tr>
            <td><%= p.getIdproduct()%></td>
            <td><%= p.getName() %></td>
            <td><%= p.getPrice() %></td>
            <td><%= p.getQty() %></td>
            <td>
                <input id="p<%=p.getIdproduct()%>" type="text"/>
                <button onclick="addToCart(<%=p.getIdproduct()%>);">Add To Cart</button>
            </td>
        </tr>
<%


        }


%>

    
</table>
    
