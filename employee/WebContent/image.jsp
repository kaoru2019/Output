<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");
%>
<%
id = "6";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ここでは画像を編集します</title>
</head>
<body>
	<form action="Image" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value=<%=id%>> 写真:<input
			type="file" name="image"><br>
		<button type="submit">決定</button>
	</form>
</body>
</html>