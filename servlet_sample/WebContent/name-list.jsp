<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, 
　initial-scale=1.0, user-scalable=yes">
<meta charset="UTF-8">
<title>データベースの接続確認</title>
</head>
<body>
	<%
	List<String> name = (List<String>) request.getAttribute("name");
	%>

	<p>データベースに保存されているユーザー名一覧</p>
	<form action="DeleteTest" method="get">
		<%
		for (String n : name) {
		%>
		<label><input type="radio" name="name" value="<%=n%>"><%=n%></label>
		<br>
		<%
		}
		%>
		<input type="submit" value="削除"><br>
	</form>
	<a href="input.html">登録画面に移動する</a>
</body>
</html>