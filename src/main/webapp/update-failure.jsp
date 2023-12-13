<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.entity.TaskCategoryUserStatusBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク編集失敗画面</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body class="mx-auto">
<%
	TaskCategoryUserStatusBean taskDetail = (TaskCategoryUserStatusBean) request.getAttribute("updateTask");
	
	%>
	<br>
	<h1 class="text text-primary text-center">タスク編集失敗画面</h1>
	<hr>
	<h1 class="text text-danger text-center">情報の登録に失敗しました。</h1>
	<table class="mx-auto table table-primary table-striped table-bordered" style="width:800px;">
		<tr>
			<th>タスク名</th>
			<td><%=taskDetail.getTaskName()%></td>
		</tr>
		<tr>
			<th>カテゴリ情報</th>
			<td><%=taskDetail.getCategoryName()%></td>
		</tr>
		<tr>
			<th>期限</th>
			<td>
			<%
			if(taskDetail.getLimitDate() != null){
			%>
				<%=taskDetail.getLimitDate()%>
			<%
			}
			%>
			</td>
				</tr>
		<tr>
			<th>担当情報</th>
			<td><%=taskDetail.getUserName()%></td>
		</tr>
		<tr>
			<th>ステータス情報</th>
			<td><%=taskDetail.getStatusName()%></td>
		</tr>
		<tr>
			<th>メモ</th>
			<td><%=taskDetail.getMemo()%></td>
		</tr>
	</table>
	<form action="task-list-servlet" method="POST" class="text-center">
		<input class="btn btn-primary" type="submit" value="タスク一覧画面へ">
		
	</form>
</body>
</html>