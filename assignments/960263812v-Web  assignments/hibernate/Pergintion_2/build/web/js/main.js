function loadBrands(){
    var request = new XMLHttpRequest();
    request.onreadystatechange = function (){
        if(request.readyState === 4 & request.status === 200){
            document.getElementById("brand_optgroup").innerHTML = request.responseText;
            searchProducts();
            loadModels();
        }
    };
    request.open("GET","LoadBrands",true);
    request.send();
}

function loadModels(){
    var brand_name = document.getElementById("brand_optgroup").value;
    var parameter = "brand_name="+brand_name;
    
    var request = new XMLHttpRequest();
    request.onreadystatechange = function (){
        if(request.readyState === 4 & request.status === 200){
            document.getElementById("model_list").innerHTML = request.responseText;
        }
    };
    request.open("GET","LoadProducts?"+parameter,true);
    request.send();
}

function loadLocations(){
    
    var request = new XMLHttpRequest();
    request.onreadystatechange = function (){
        if(request.readyState === 4 & request.status === 200){
            document.getElementById("location_list").innerHTML = request.responseText;
        }
    };
    request.open("GET","LoadLocations",true);
    request.send();
}

function searchProducts(){
    var brand = document.getElementById("brand_optgroup").value;
    var model = document.getElementById("model_list").value ;
    var price_from = document.getElementById("price_from").value ;
    var price_to = document.getElementById("price_to").value ;
    var location = document.getElementById("location_list").value ;
    var feature = document.getElementById("feature").value ;
    var order_by = document.getElementById("order_by").value ;
//    alert(brand);alert(model);alert(price_from); alert(price_to); alert(location); alert(feature);alert(order_by);
    
    var parameter = "brand="+brand+"&"+"model="+model+"&"+"price_from="+price_from+"&"+"price_to="+price_to+"&"+"location="+location+"&"+"feature="+feature+"&"+"order_by="+order_by;
    
    var request = new XMLHttpRequest();
    request.onreadystatechange = function (){
        if(request.readyState === 4 & request.status === 200){
            document.getElementById("productsHolder").innerHTML = request.responseText;
        }
    };
    request.open("GET","SearchProduct?"+parameter,true);
    request.send();
}

function viewSellerDetails(seller_id){
    var parameter = "seller_id="+seller_id ;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function (){
        if(request.readyState === 4 & request.status === 200){
            alert(request.responseText);
            var seller = JSON.parse(request.responseText);
            document.getElementById("seller_name").innerHTML = seller.name;
            document.getElementById("seller_mobile").innerHTML = seller.mobile;
            document.getElementById("seller_gen").innerHTML = seller.gender;
            document.getElementById("seller_city").innerHTML = seller.city;
        }
    };
    request.open("GET","LoadSellerDetails?"+parameter,true);
    request.send();
}