
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UpdateBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク削除確認画面</title>
</head>
<body>
	<%
		UpdateBean updateDetail = (UpdateBean) session.getAttribute("updateDetail");
	%>

	<h1>タスク削除確認画面</h1>
	<hr>
	<h2>タスクを削除します。よろしいですか？</h2>
	<br>
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
	<form action="task-delete-servlet" method="POST">
		<input type="hidden" name="item_code" value="<%=updateDetail.getTaskName()%>">
		<input type="submit" value="削除する">
	</form>
	<br>
	<form action="item-detail.jsp" method="POST">
		<input type="submit" value="詳細表示へ">
	</form>
</body>
</html>