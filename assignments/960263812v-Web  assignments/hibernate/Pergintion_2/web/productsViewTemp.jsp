<%@page import="java.util.List"%>
<%@page import="database.Product"%>

    <%
        List<Product> products = (List<Product>) request.getAttribute("products");
        for (Product product : products) {
    %>
<tr>
    <td><img src='<%= product.getImgUrl()%>'></td>
    <td><%= product.getBrand()%>&nbsp;&nbsp;&nbsp;<%= product.getModel()%></td>
    <td><%= product.getDisc()%></td>
    <td style="color: red ; font-size: 20px;">LKR&nbsp;<%= product.getPrice()%></td>
    <td>
        <button onclick="viewSellerDetails(<%= product.getSeller().getId() %>);">View seller details</button>
    </td>
</tr>
<%
    }
%>


