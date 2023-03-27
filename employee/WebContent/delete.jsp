<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");
%>
<%
String name = request.getParameter("name");
%>
<%
String department = request.getParameter("department");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報の削除</title>
</head>
<body>
	<h1>社員情報の削除を行います</h1>
	<p>以下の社員情報を削除します</p>

	<form action="Delete">
		<p>
			ID：<%=id%></p>
		<p>
			氏名：<%=name%></p>
		<p>
			部署：<%=department%></p>
		<input type="hidden" name="id" value=<%=id%>> <input
			type="hidden" name="id" value=<%=name%>> <input type="hidden"
			name="id" value=<%=department%>>
		<button type="submit" class="btn1">はい</button>
	</form>
	<button onclick="location.href='Select'">いいえ</button>
</body>
</html>