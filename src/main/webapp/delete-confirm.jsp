
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.TaskCategoryUserStatusBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク削除確認画面</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body class="mx-auto">
	<%
		TaskCategoryUserStatusBean deleteDetail = (TaskCategoryUserStatusBean) session.getAttribute("deleteTask");
	%>
	<br>
	<h1 class="text text-primary text-center">タスク削除確認画面</h1>
	<hr>
	<h2 class="text text-danger text-center">タスクを削除します。よろしいですか？</h2>
	<br>
	<form action="task-delete-servlet" method="POST">
		<table class="mx-auto table table-primary table-striped table-bordered" style="width:400px;">
			
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
				<td>
				<%
				if(deleteDetail.getLimitDate() != null){
				%>
					<%=deleteDetail.getLimitDate()%>
				<%
				}
				%>
				</td>
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
	<div class="text-center">
		<input type ="hidden" value="<%=deleteDetail.getTaskId() %>" name ="task_id">
		<input class="btn btn-danger"  type="submit" value="削除する">
		</div>
	</form>
	<br>
	<form action="task-list-servlet" method="GET" class="text-center">
		<input class="btn btn-secondary" type="submit" value="タスク一覧画面へ">
	</form>
</body>
</html>