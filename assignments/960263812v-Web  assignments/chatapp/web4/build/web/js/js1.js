function sign(){
   
    var mobile=document.getElementById("m").value;
    var password=document.getElementById("p").value;
    
    var parameter="mobile="+mobile+"&"+"password="+password;
    
    var request=new XMLHttpRequest();
  
    request.onreadystatechange=function (){
  if(request.readyState===4&&request.status===200){
      var response=request.responseText;
      
      if(response==="1"){
          
          document.getElementById("m").className="error";
            document.getElementById("p").className="error";
      
            
            }else{
                
                window.location="home.jsp";
            }
    
    
      
  } 
    
};
request.open("POST","signin",true);
   request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    request.send(parameter);

   
}

function loaduser(){
    
    var request=new XMLHttpRequest();
    request.onreadystatechange=function (){
  if(request.readyState===4&&request.status===200){
      var response=request.responseText;
      
      if(response==="1"){
          
        window.location="login.jsp";
      
            
            }else{
                document.getElementById("sec1").innerHTML=response;
               
            }
    
    
      
  } 
    
};
request.open("GET","loaduser",true);
 request.send(); 
    
    
}


function sendmessege(){
    
    var to=document.getElementById("sec1").value;
    var ms=document.getElementById("txt").value;
    
    var parameter="to="+to+"&"+"msg="+ms;
    var request=new XMLHttpRequest();
    request.onreadystatechange=function (){
  if(request.readyState===4&&request.status===200){
      var response=request.responseText;
      if(response==="1"){
          
       alert("messege sent");
      
            
            }else{
               alert("messege failed");
               
            }
     
  }
    
};
request.open("GET","savemessege?"+parameter,true);
 request.send(); 
    
    

    
}

function viewchat(){
      var mobile2=document.getElementById("sec1").value;
      var parameter="mobile2="+mobile2;
    var request=new XMLHttpRequest();
    request.onreadystatechange=function (){
  if(request.readyState===4&&request.status===200){
      var response=request.responseText;
      document.getElementById("div1").innerHTML=response;
 
  }
    
};
request.open("GET","viewchat?"+parameter,true);
 request.send(); 
    
}


