<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ishan  File Uploader</title>
</head>
<body>
<a>= File Upload:</a>
Select file: <br />
<form action="action_file_upload.jsp" method="post"
                        enctype="multipart/form-data">
<input type="file" name="file" multiple="multiple" size="50" />
<br />
<input type="submit" value="Upload File" />
</form>
</body>
</html>