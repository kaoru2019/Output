<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Bean"%>

<%
List<Bean> beanList = (ArrayList<Bean>) request.getAttribute("beanList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員管理ページ</title>
</head>
<body>
	<h1>社員管理ページへようこそ</h1>
	<p>社員情報を表示します</p>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>氏名</th>
			<th>部署名</th>
			<th>編集/追加/削除</th>
		</tr>
		<%
		for (Bean bean : beanList) {
		%>
		<tr>

			<td><%=bean.getId()%></td>
			<td><%=bean.getName()%></td>
			<td><%=bean.getDepartment()%></td>
			<td><form action="edit.jsp">
					<input type="hidden" name="id" value=<%=bean.getId()%>> <input
						type="hidden" name="name" value=<%=bean.getName()%>><input
						type="hidden" name="image" value=<%=bean.getImage()%>> <input
						type="hidden" name="department" value=<%=bean.getDepartment()%>>
					<button type="submit" class="btn1">編集</button>
				</form>
				<form action="add.jsp">
					<input type="hidden" name="id" value=<%=bean.getId()%>> <input
						type="hidden" name="name" value=<%=bean.getName()%>><input
						type="hidden" name="image" value=<%=bean.getImage()%>> <input
						type="hidden" name="department" value=<%=bean.getDepartment()%>>
					<button type="submit" class="btn3">追加</button>
				</form>
				<form action="delete.jsp">
					<input type="hidden" name="id" value=<%=bean.getId()%>> <input
						type="hidden" name="name" value=<%=bean.getName()%>> <input
						type="hidden" name="image" value=<%=bean.getImage()%>><input
						type="hidden" name="department" value=<%=bean.getDepartment()%>>
					<button type="submit" class="btn2">削除</button>
				</form></td>
			<%
			}
			%>
		
	</table>

</body>
</html>