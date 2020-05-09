<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="ISO-8859-1">
<title>{Code}</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css"
	media="all">
</head>
<body id="top">
	<div class="bgded overlay" style="background-image: url('aaa.jpeg');">
		<div class="wrapper row0">
			<div id="topbar" class="hoc clear">
				<div class="fl_left">
					<ul class="nospace">
						<li><a href="home.jsp"><i class="fa fa-lg fa-home"></i></a></li>
						<li><a href="logn.jsp">Login</a></li>
						<li><a href="sgnup.jsp">Register</a></li>
					</ul>
				</div>
				<div class="fl_right">
					<ul class="nospace">
						<li><i class="fa fa-phone"></i> +00 (123) 456 7890</li>
						<li><i class="fa fa-envelope-o"></i>code123@gmail.com</li>
					</ul>
				</div>
			</div>
		</div>

		<div class="wrapper row1">
			<header id="header" class="hoc clear">
				<div id="logo" class="fl_left">
					<h1>
						<a href="index.jsp">{code}</a>
					</h1>
				</div>
				<nav id="mainav" class="fl_right">
					<ul class="clear">
						<li class="active"><a href="home.jsp">Home</a></li>
						<li><a href="size.jsp">Size</a></li>
						<li><a href="variable.jsp">Variables</a></li>
						<li><a href="method.jsp">Methods</a></li>
						<li><a href="inheritance.jsp">Inheritances</a></li>
						<li><a href="coupling.jsp">Coupling</a></li>
						<li><a href="control.jsp">Control Structures</a></li>
						<li><a href="total.jsp">Total Complexity</a></li>
			</header>
		</div>

		<div class="wrapper">
			<div id="pageintro" class="hoc clear">
				<article>
					<div>
						<p class="heading" style="font-size: 20px">
							Get better experience with us... <br>
							<br> Evaluate code due to the customer requirements 100%
							free online. No email required, completely anonymous.<br>
							<br>
							<br> How to convert PDF to Word: <br>
							<br>Step 1: Upload your file. <br>Step 2: Download your
							resolution pdf.
						</p>
					</div>
					<footer>
						<h3>File Upload</h3>
						<form method="post" action=""
							enctype="multipart/form-data">
							<h1>Select file to upload:</h1>
							<input type="file" name="file" size="60" /><br /> <br /> <input
								class="btn" type="submit" value="Upload File" />
						</form>
					</footer>
				</article>
			</div>
		</div>

	</div>

<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*" %>
<%@ page import = "org.apache.commons.fileupload.*" %>
<%@ page import = "org.apache.commons.fileupload.disk.*" %>
<%@ page import = "org.apache.commons.fileupload.servlet.*" %>
<%@ page import = "org.apache.commons.io.output.*" %>

<%!
File globalFile =null;
     %>

<%
   File file =null;
   int maxFileSize = 5000 * 1024;
   int maxMemSize = 5000 * 1024;
   ServletContext context = pageContext.getServletContext();
   String filePath = "";


   System.out.println("ok added");
   
   // Verify the content type
   String contentType = request.getContentType();
   
   if ((contentType!=null)&&(contentType.indexOf("multipart/form-data") >= 0)) {
   if ((contentType.indexOf("multipart/form-data") >= 0)) {
      DiskFileItemFactory factory = new DiskFileItemFactory();
      // maximum size that will be stored in memory
      factory.setSizeThreshold(maxMemSize);
      
      // Location to save data that is larger than maxMemSize.
      factory.setRepository(new File("c:\\temp"));

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);
      
      // maximum file size to be uploaded.
      upload.setSizeMax( maxFileSize );
      
      try { 
         // Parse the request to get file items.
         List fileItems = upload.parseRequest(request);

         // Process the uploaded file items
         Iterator i = fileItems.iterator();

         out.println("<html>");
         out.println("<head>");
         out.println("<title>JSP File upload</title>");  
         out.println("</head>");
         out.println("<body>");
         
         while ( i.hasNext () ) {
            FileItem fi = (FileItem)i.next();
            if ( !fi.isFormField () ) {
               // Get the uploaded file parameters
               String fieldName = fi.getFieldName();
               String fileName = fi.getName();
               boolean isInMemory = fi.isInMemory();
               long sizeInBytes = fi.getSize();
            
               // Write the file
               if( fileName.lastIndexOf("\\") >= 0 ) {
                  file = new File( filePath + 
                  fileName.substring( fileName.lastIndexOf("\\"))) ;
               } else {
                  file = new File( filePath + 
                  fileName.substring(fileName.lastIndexOf("\\")+1)) ;
               }
               fi.write( file ) ;
               out.println("Uploaded Filename: " + filePath + 
               fileName + "<br>");
            }
         }
         
         
      	List<String> allProgrammeList = new ArrayList();
        globalFile=file;
        
        
 
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String line;
			int no = 1;

			while ((line = br.readLine()) != null) {
				// process the line.
				//Add to list for no and codeline
				if (!line.trim().equals("")) {

					allProgrammeList.add(no + "#" + line);
					no++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
         
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String line;
			int no = 1;

			while ((line = br.readLine()) != null) {
				// process the line.
				//Add to list for no and codeline
				if (!line.trim().equals("")) {

					allProgrammeList.add(no + "#" + line);
					no++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String regexString = "";
		for (int x = 0; x < allProgrammeList.size(); x++)
			regexString += allProgrammeList.get(x) + "\n";
		
        System.out.println("ok added "+regexString);
        ServletContext setglobal = getServletConfig().getServletContext();  

        String data = "test";  
        setglobal.setAttribute("variable", regexString);  

      
         out.println("</body>");
         out.println("</html>");
      } catch(Exception ex) {
         System.out.println(ex);
      }
   } else {
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet upload</title>");  
      out.println("</head>");
      out.println("<body>");
      out.println("<p>No file uploaded</p>"); 
      out.println("</body>");
      out.println("</html>");
   }

   }
%>


	<div class="btn-group">
		<button>
			<a href="size.jsp" style="color: white">SIZE</a>
		</button>
		<button>
			<a href="variable.jsp" style="color: white">VARIABLE</a>
		</button>
		<button>
			<a href="method.jsp" style="color: white">METHOD</a>
		</button>
		<button>
			<a href="inheritance.jsp" style="color: white">INHERITANCE</a>
		</button>
	</div>

	<div class="btn-group2">
		<a href="coupling.jsp" style="color: white"><button>
			COUPLING
		</button></a>
		<button>
			<a href="control.jsp" style="color: white">CONTROL STRUCTURES </a>
		</button>
		<button>
			<a href="total.jsp" style="color: white">TOTAL COMPLEXITY</a>
		</button>
	</div>

	<div class="wrapper row4">
		<footer id="footer" class="hoc clear">
			<div class="one_half first">
				<h6 class="heading">{Code}</h6>
				<p class="btmspace-30">
					We care deeply about the quality of our services.<br>Helping
					the very best for customer needs.<br>Join with us & get better
					resolution.
				</p>
			</div>
			<div class="one_quarter">
				<h6 class="heading">Contact Us</h6>
				<ul class="nospace linklist contact">
					<li><i class="fa fa-map-marker"></i>
					<address>SLIIT, Malabe, Colombo</address></li>
					<li><i class="fa fa-phone"></i> +00 (123) 456 7890</li>
					<li><i class="fa fa-envelope-o"></i> code123@gmail.com</li>
				</ul>
			</div>
			<div class="one_quarter">
				<h6 class="heading">Community</h6>
				<ul class="nospace linklist">
					<li><a href="https://www.google.com/" class="google"><i
							class="fa fa-google" style="font-size: 30px"></i></a> Google</li>
					<li><a href="https://www.facebook.com/" class="facebook"><i
							class="fa fa-facebook" style="font-size: 30px"></i></a> Facebook</a></li>
					<li><a href="https://www.youtube.com/" class="youtube"><i
							class="fa fa-youtube" style="font-size: 30px"></i></a> YouTube</li>
				</ul>
			</div>
		</footer>
	</div>

	<div class="wrapper row5">
		<div id="copyright" class="hoc clear">
			<p class="fl_left">
				Copyright &copy; 2020 - All Rights Reserved - <a href="#">{Code}</a>
			</p>
		</div>
	</div>

	<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
	<script src="layout/scripts/jquery.min.js"></script>
	<script src="layout/scripts/jquery.backtotop.js"></script>
	<script src="layout/scripts/jquery.mobilemenu.js"></script>

</body>
</html>