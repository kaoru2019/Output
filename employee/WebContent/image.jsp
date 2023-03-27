<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");
%>
<%
String image = request.getParameter("image");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ここでは画像を編集します</title>
</head>
<body>
	<p>
		<br> <img src="/employee/upload/<%=image%>" width="240"
			height="180">
	</p>
	<form action="Image" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value=<%=id%>> 登録する画像を選択<br>
		<input type="file" name="image"><br>
		<button type="submit">決定</button>
		<br> <a href="Select">一覧に戻る</a>
	</form>
</body>
</html>