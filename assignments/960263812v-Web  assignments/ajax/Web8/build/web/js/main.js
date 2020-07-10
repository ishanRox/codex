function signin(){
    
    var un=document.getElementById("un").value;
    var pw=document.getElementById("pw").value;
    
    var para="un="+un+"&pw="+pw;
    
    var request=new XMLHttpRequest();
    
    request.onreadystatechange= function (){
        if(request.readyState===4 && request.status===200){
            var response=request.responseText;
            if(response==="0"){
                alert("Invalid Details");
            }else{
                alert("user found")
                window.location="home.jsp"
            }
        }
    }
    
    
    request.open("POST","signIn",true);
    request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
   
    request.send(para);
    
}


function loadProducts(){
    
    var request=new XMLHttpRequest();
    
    request.onreadystatechange=function (){
        if(request.readyState===4 && request.status === 200){
            var response=request.responseText;
            alert(response);
            
            document.getElementById("pa").innerHTML=request.responseText;
            
        }
    }
    
    request.open("GET","loadProducts",true);
    request.send();
    
}

function addToCart(id){
    
    var request=new XMLHttpRequest();
    
    var qty=document.getElementById("p"+id).value;
    
    var para="id="+id+"&qty="+qty;
    
    alert(para);
    
    request.onreadystatechange=function (){
        
    };
    
    request.open("GET","addToCart?"+para,true);
    request.send();
    
}