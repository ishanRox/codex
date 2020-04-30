
<%@page import="model.Method"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.regex.Matcher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
<%@ page import="org.apache.commons.io.output.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ishan File Upload</title>
<style>
table, td, th {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th {
	height: 50px;
}
</style>
</head>
<body>
	<%
		File file = null;
	int maxFileSize = 5000 * 1004;
	int maxMemSize = 5000 * 1004;
	String filePath = "E:/";
	List<String> list = new ArrayList();
	//Set<String> listOfOtherMethodCallsThisFile = new HashSet();

	Map<String, String> normalToNormal = new LinkedHashMap();
	Map<String, String> normalToRecursive = new LinkedHashMap();
	Map<String, String> RecursiveToNormal = new LinkedHashMap();
	Map<String, String> RecursiveToRecursive = new LinkedHashMap();

	Map<String, String> globalVar = new LinkedHashMap();

	String contentType = request.getContentType();
	if ((contentType.indexOf("multipart/form-data") >= 0)) {

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(maxMemSize);
		//  factory.setRepository(new File("c:\\text"));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(maxFileSize);
		try {
			List fileItems = upload.parseRequest(request);
			Iterator i = fileItems.iterator();
			out.println("<h1>Main code</h1>");
			out.println("<hr>");
			while (i.hasNext()) {
		FileItem fi = (FileItem) i.next();
		if (!fi.isFormField()) {
			String fieldName = fi.getFieldName();
			String fileName = fi.getName();
			boolean isInMemory = fi.isInMemory();
			long sizeInBytes = fi.getSize();
			file = new File(filePath + "yourFileName");
			fi.write(file);
			//   out.println("Uploaded Filename: " + filePath + fileName + "<br>");
		}
			}

			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		String line;
		int no = 1;

		while ((line = br.readLine()) != null) {
			// process the line.
			//Add to list for no and codeline
			list.add(no + "#" + line);
			out.println(line + "</br>");
			no++;
		}
			}
			out.println("<hr>");
			out.println("<br><br>");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	} else {
		out.println("<html>");
		out.println("<body>");
		out.println("<p>No file uploaded</p>");
		out.println("</body>");
		out.println("</html>");
	}

	String regexString = "";

	for (int i = 0; i < list.size(); i++)
		regexString += list.get(i) + "\n";

	System.out.println(regexString);

	//Finding  methods
	//Map designed with method name and method body
	Map<String, Method> thisFileMethods = new HashMap();

	Matcher m = Pattern.compile("((.+\\(.*\\))( )*\\{(\\n|\\r|\\n|.)*?\\})").matcher(regexString);
	while (m.find()) {

		//name with access and return 
		String methodName = m.group(2);

		String methodWithAccessAndReturn = (methodName.replaceAll("\\(.*\\)", ""));

		String onlyMethodName = methodWithAccessAndReturn.substring(methodWithAccessAndReturn.lastIndexOf(" "));

		//System.out.println(onlyMethodName);
		System.out.println("__________________________________________");

		Method method = new Method();
		String methodBody = m.group().substring(m.group().indexOf("{"));
		method.setMethodBody(methodBody);

		//get no of the recursive call to own mwthod
		Pattern pattern = Pattern.compile("(\\d*)#.*" + onlyMethodName);
		Matcher matcher = pattern.matcher(methodBody);
		//set recursive call no and put to method object
		if (matcher.find()) {

			//check if method recursive
			method.setRecursiveCall(true);
			// 			System.out.println(matcher.group() + " own method call found");
			// 			System.out.println(matcher.group(1));
			method.setRecursiveCallNo(matcher.group(1));
		}
		System.out.println(thisFileMethods+"_________________________________________");

		thisFileMethods.put(onlyMethodName, method);
	}
	//all methods are added

	//check global vaiables

	//remove methods from class
	String[] removeMetho = { regexString };

	thisFileMethods.entrySet().forEach(e -> {
		removeMetho[0] = removeMetho[0].replace(e.getValue().getMethodBody(), "");
	});

	Matcher globalVariables = Pattern.compile("(\\d)+#.+ (.+)=.+;").matcher(removeMetho[0]);
	while (globalVariables.find()) {

		System.out.println(globalVariables.group(1) + " Globle variable found");
		globalVar.put(globalVariables.group(1), globalVariables.group(2));
	}
	System.out.println(removeMetho[0]);

	//find other methods called in this method 

	thisFileMethods.entrySet().stream().forEach((entry) -> {
		System.out.println("\n\n");
		System.out.println(entry.getKey() + "  a mwthod in this file");
		// 		System.out.println("body of it without own method calls");

		//System.out.println(entry.getValue().getMethodBody().replaceAll(entry.getKey() + "|if", ""));

		System.out.println(entry.getValue().isRecursiveCall() + " is rec");

		String bodyWithOutMethod = entry.getValue().getMethodBody().replaceAll(entry.getKey(), "");

		thisFileMethods.entrySet().stream().filter(e -> !e.getKey().equals(entry.getKey())).forEach(methodName -> {
			//get other method calls from this method	
			System.out.println(methodName.getKey());
			//	System.out.println(bodyWithOutMethod);

			Pattern pattern = Pattern.compile("(\\d*)#.*" + methodName.getKey().trim());
			Matcher matcher = pattern.matcher(bodyWithOutMethod);

			//set recursive call no and put to method object
			if (matcher.find()) {
		System.out.println(entry.getKey() + " method  inner call " + methodName.getKey());
		System.out.println(matcher.group(1) + " number ");

		if (entry.getValue().isRecursiveCall()) {
			//inside recursive method
			if (methodName.getValue().isRecursiveCall()) {
				//calling method recursive
				RecursiveToRecursive.put(methodName.getKey(), matcher.group(1));
			} else {
				//calling method not recursive
				RecursiveToNormal.put(methodName.getKey(), matcher.group(1));
			}

		} else {
			//inside normal method 
			if (methodName.getValue().isRecursiveCall()) {
				//calling method recursive
				normalToRecursive.put(methodName.getKey(), matcher.group(1));
			} else {
				//calling method normal
				normalToNormal.put(methodName.getKey(), matcher.group(1));

			}

		}

			}
			System.out.println();
			System.out.println();
			System.out.println();

		});

		// 		Pattern pattern = Pattern.compile(".*");
		// 					Matcher matcher = pattern.matcher(bodyWithOutMethod);
		// 					while (matcher.find()) {
		// 				System.out.println(matcher.group() + " other methods");
		// 					}

		//remove new
		// 			bodyWithOutMethod = bodyWithOutMethod.replaceAll("new (\\w)+?\\((.)*?\\)", "");

		// 			Pattern pattern = Pattern.compile("(\\w)+?\\((.)*?\\)");
		// 			Matcher matcher = pattern.matcher(bodyWithOutMethod);
		// 			while (matcher.find()) {
		// 		System.out.println(matcher.group() + " other methods");
		// 			}

		// 			System.out.println("");
	});

	System.out.println(normalToNormal + "  normalToNormal");
	System.out.println(normalToRecursive + " normalToRecursive");
	System.out.println(RecursiveToNormal + " RecursiveToNormal");
	System.out.println(RecursiveToRecursive + " RecursiveToRecursive");

	//no of recursive methods
	int Nr = thisFileMethods.values().stream().map(e -> e.isRecursiveCall() ? 1 : 0).reduce((v, t) -> v + t).get()
			.intValue();

	System.out.println(
			thisFileMethods.values().stream().map(e -> e.isRecursiveCall() ? 1 : 0).reduce((v, t) -> v + t).get().intValue()
			+ "  no of re");
	%>


	<table style="width: 100%">
		<colgroup>
			<col style="width: 1%;">
			<col style="width: 48%;">
			<col style="width: 1%;">

			<col style="width: 4%;">
			<col style="width: 4%;">
			<col style="width: 4%;">
			<col style="width: 4%;">
			<col style="width: 4%;">
			<col style="width: 4%;">
			<col style="width: 4%;">
			<col style="width: 4%;">
			<col style="width: 4%;">
			<col style="width: 4%;">
			<col style="width: 4%;">
			<col style="width: 4%;">

			<col style="width: 1%;">
		</colgroup>



		<!-- Put <thead>, <tbody>, and <tr>'s here! -->
		<tbody>
			<tr>
				<th>no</th>
				<th>Program statements</th>
				<th>Nr</th>
				<th>Nmcms</th>

				<th>Nmcmd</th>
				<th>Nmcmrs</th>

				<th>Nmcrmd</th>
				<th>Nrmcrms</th>

				<th>Nrmcrmd</th>
				<th>Nrmcms</th>

				<th>Nrmcmd</th>
				<th>Nmrgvs</th>

				<th>Nmrgvd</th>
				<th>Nrmrgvs</th>
				<th>Nrmrgvd</th>
				<th>Ccp</th>

			</tr>

			<%
				for (int i = 0; i < list.size(); i++) {

				String codeLine = list.get(i).toString();
				String number = codeLine.substring(0, codeLine.indexOf("#"));

				boolean[] isRecursiveMethod = { false };

				int[] normalToNormalVal = { 0 };
				int[] normalToRecursiveVal = { 0 };
				int[] RecursiveToNormalVal = { 0 };
				int[] RecursiveToRecursiveVal = { 0 };

				//check map  for any lines match this line
				//check map  for any lines match this line
				thisFileMethods.entrySet().forEach(e -> {
					if (e.getValue().getRecursiveCallNo().equals(number)) {
				isRecursiveMethod[0] = !isRecursiveMethod[0];
				System.out.println(e.getValue().getRecursiveCallNo() + "this line own recursive call happens");
					}
				});

				normalToNormal.entrySet().forEach(normal -> {

					if (normal.getValue().equals(number))
				normalToNormalVal[0]++;
				});

				normalToRecursive.entrySet().forEach(normal -> {

					if (normal.getValue().equals(number))
				normalToRecursiveVal[0]++;
				});

				RecursiveToNormal.entrySet().forEach(normal -> {

					if (normal.getValue().equals(number))
				RecursiveToNormalVal[0]++;
				});

				RecursiveToRecursive.entrySet().forEach(normal -> {

					if (normal.getValue().equals(number))
				RecursiveToRecursiveVal[0]++;
				});

				int globelVarUse[] = { 0 };

				int globalUsedByR = 0;
				int globalUsedByNonR = 0;

				globalVar.entrySet().forEach(e -> {

					System.out.println(codeLine + " line   val " + e);

				if (!e.getKey().trim().equals(number)) {

				if (codeLine.matches("(.*)[ \\(=]*" + e.getValue().trim() + "[ \\)=;](.*)")) {

					System.out.println(codeLine + " line founded   val " + e);
					globelVarUse[0]++;

				}
					}

				});

				if (isRecursiveMethod[0]) {
					globalUsedByR = globelVarUse[0];
				} else {
					globalUsedByNonR = globelVarUse[0];

				}

				// 				System.out.println(normalToNormalVal[0] + " normal to normal " + number);
				// 				System.out.println(normalToRecursiveVal[0] + " normalToRecursiveVal");
				// 				System.out.println(RecursiveToNormalVal[0] + " RecursiveToNormalVal");
				// 				System.out.println(RecursiveToRecursiveVal[0] + " RecursiveToRecursiveVal");
				// 				System.out.println(globelVarUse[0] + " regularGloblVal");
			%>
			<tr>

				<td><%=codeLine.substring(0, codeLine.indexOf("#"))%></td>
				<td><%=codeLine.substring(codeLine.indexOf("#") + 1)%></td>
				<td><%=(isRecursiveMethod[0]) ? "1" : "0"%></td>

				<td><%=normalToNormalVal[0]%></td>
				<td>0</td>

				<td><%=normalToRecursiveVal[0]%></td>
				<td>0</td>

				<td><%=RecursiveToRecursiveVal[0]%></td>
				<td>0</td>

				<td><%=RecursiveToNormalVal[0]%></td>
				<td>0</td>

				<td><%=globalUsedByNonR%></td>
				<td>0</td>


				<td><%=globalUsedByR%></td>
				<td>0</td>

				<td><%=globalUsedByR%></td>



			</tr>
			<%
				}
			%>





		</tbody>
	</table>



</body>
</html>