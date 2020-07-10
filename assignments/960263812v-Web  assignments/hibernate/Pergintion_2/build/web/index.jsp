<%-- 
    Document   : index
    Created on : Oct 30, 2019, 2:40:27 PM
    Author     : Thilini
--%>

<%@page import="database.Seller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/main.css" type="text/css">
    </head>
    <body onload="loadBrands();
            loadLocations();
          ">
    <center>
        <h1>Product Search</h1>
        <table class="search">
            <tr>
                <td>
                    <span>Brand</span>
                    <select id="brand_optgroup" onchange="loadModels();">

                    </select>
                </td>
                <td>
                    <span>Price</span>
                    <input id="price_from" type="text" placeholder="Min Price" />
                    <input id="price_to" type="text" placeholder="Max Price" />
                </td>
                <td>
                    <span>Order by</span>
                    <select id="order_by">
                        <option>Price Low to High</option>
                        <option>Price High to Low</option>
                        <option>Model ASC</option>
                        <option>Model DES</option>
                    </select>
                </td>
                <td rowspan="3">
                    <button id="search-button" onclick="searchProducts();">Search</button>
                </td>
            </tr>
            <tr>
                <td>
                    <span>Model</span>
                    <select id="model_list">

                    </select>
                </td>
                <td>
                    <span>Features</span>
                    <input id="feature" type="text" placeholder="Features" />
                </td>
                <td>
                    <span>Location</span>
                    <select id="location_list">

                    </select>
                </td>
            </tr>
        </table>
    </center>

    <table class="ptable" id="productsHolder">

    </table>

    <div class="pdetails" id="sellerDetails">
        <span id="title" >Seller Details</span>
        <br/><br/>
        <span>
            <center>
                <img src="">
            </center>
        </span>
        <br/><br>
        <span id="seller_name"></span>
        <br>
        <span id="sub-title">Mobile : </span><span id="seller_mobile"></span>
        <br>
        <span id="sub-title">Gender : </span><span id="seller_gen"></span>
        <br>
        <span id="sub-title">City : </span><span id="seller_city"></span>
    </div>

    <script type="text/javascript" src="js/main.js">

    </script>
</body>
</html>
