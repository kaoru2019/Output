<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報の追加</title>
</head>
<body>
	<h1>ここでは社員情報の追加を行います</h1>
	<form action="Insert" method="get" enctype="multipart/form-data">
		<p>
			氏名<br> <input type="text" name="name">
		</p>
		<p>
			年齢<br> <input type="text" name="age">
		</p>
		<p>
			<input type="radio" name="gender" value="男性" checked>男性 <input
				type="radio" name="gender" value="女性">女性
		</p>
		<p>
			登録する画像<br> <input type="file" name="image">
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
</body>
</html>