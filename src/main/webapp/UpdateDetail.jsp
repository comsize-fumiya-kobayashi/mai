<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UpdateBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細画面</title>
</head>
<body>
	<%
		UpdateBean updateDetail = (UpdateBean) session.getAttribute("updateDetail");
	%>
	<h1>商品詳細画面</h1>
	<hr>
	<table border="1">
		<tr>
			<th>タスク名</th>
			<td><%=updateDetail.getTaskName()%></td>
		</tr>
			<tr>
				<th>カテゴリ情報</th>
				<td><%=updateDetail.getCategoryName()%></td>
			</tr>
			<tr>
				<th>期限</th>
				<td><%=updateDetail.getLimitDate()%></td>
			</tr>
			<tr>
				<th>担当者情報</th>
				<td><%=updateDetail.getUserName()%></td>
			</tr>
			<tr>
				<th>ステータス情報</th>
				<td><%=updateDetail.getStatusName()%></td>
			</tr>
			<tr>
				<th>メモ</th>
				<td><%=updateDetail.getMemo()%></td>
			</tr>
		</table>
	<br>
	<table>
	<tr>
	<td>
	<form action="Update.jsp" method="POST">
		<input type="submit" value="変更する">
	</form>
	</td>
	<td>
	<form action="DeleteConfirm" method="POST">
		<input type="submit" value="削除する">
	</form>
	</td>
	<td>
	<form action="TaskListServlet" method="GET">
		<input type="submit" value="一覧表示">
	</form>
	</td>
	</tr>
	</table>
</body>
</html>