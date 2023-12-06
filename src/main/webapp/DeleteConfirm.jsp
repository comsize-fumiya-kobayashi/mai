
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
		UpdateBean deleteDetail = (UpdateBean) session.getAttribute("deleteTask");
	
	%>

	<h1>タスク削除確認画面</h1>
	<hr>
	<h2>タスクを削除します。よろしいですか？</h2>
	<br>
	
		<form action="task-delete-servlet" method="POST">
	
		<table border="1">
			
			<tr>
				<th>タスク名</th>
				<td><%=deleteDetail.getTaskName()%></td>
			</tr>
			<tr>
				<th>カテゴリ情報</th>
				<td><%=deleteDetail.getCategoryName()%></td>
			</tr>
			<tr>
				<th>期限</th>
				<td><%=deleteDetail.getLimitDate()%></td>
			</tr>
			<tr>
				<th>担当者情報</th>
				<td><%=deleteDetail.getUserName()%></td>
			</tr>
			<tr>
				<th>ステータス情報</th>
				<td><%=deleteDetail.getStatusName()%></td>
			</tr>
			<tr>
				<th>メモ</th>
				<td><%=deleteDetail.getMemo()%></td>
			</tr>
		</table>
	<br>
	
		<input type ="hidden" value="<%=deleteDetail.getTaskId() %>" name ="task_id">
		<input type="submit" value="削除する">
	</form>
	<br>
	<form action="menu.jsp" method="POST">
		<input type="submit" value="詳細表示へ">
	</form>
</body>
</html>