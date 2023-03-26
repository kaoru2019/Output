<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>個人情報の編集</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>ここでは個人情報を個別に編集します</h1>
	<form action="Edit" method="get">
		<p>
			<input type="hidden" name="id" value=<%=id%>>
		</p>
		<p>
			変更後の氏名<br> <input type="text" name="name">
		</p>
		<p>
			変更後の年齢<br> <input type="text" name="age">
		</p>
		<p>
			<input type="radio" name="gender" value="男性" checked>男性 <input
				type="radio" name="gender" value="女性">女性
		</p>
		<p>
			<input type="hidden" form="form2" name="id" value=<%=id%>>
			<button type="submit" form="form2" class="btn1">編集</button>
		</p>
		<p>
			変更後の住所<br> <input type="text" name="address">
		</p>
		<p>
			変更後の所属<br> <select name="department">
				<option>営業部</option>
				<option>総務部</option>
				<option>開発部</option>
				<option>調達部</option>
				<option>経理部</option>
			</select>
		</p>
		<p>
			<input type="submit" value="設定">
		</p>
		<a href="Select">一覧に戻る</a>

	</form>
	<form action="image.jsp" id="form2"></form>

</body>
</html>