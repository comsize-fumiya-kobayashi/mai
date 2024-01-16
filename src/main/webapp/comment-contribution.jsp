<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.TaskCategoryUserStatusBean,model.entity.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コメント投稿</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
	
<body class="mx-auto">
	<% TaskCategoryUserStatusBean taskInfo = (TaskCategoryUserStatusBean) session.getAttribute("taskInfo"); %>
	<% String userId  = (String) session.getAttribute("userId");%>
	<% String userName  = (String) session.getAttribute("userName");%>
	
	<br>
	<h1 class="text text-primary text-center">タスク登録画面</h1>
	<hr>
	<form action="comment-contribution-servlet" method="POST">
		<table class="mx-auto table table-primary table-striped" style="width: 400px">
			<tr>
				<th>タスクID</th>
				<th>タスク名</th>
				<th>期限</th>
				<th>ステータス</th>
			</tr>
			<tr>
				<td>
				<%= taskInfo.getTaskId() %>
				<input type = "hidden" value="<%=taskInfo.getTaskId() %>" name="task_id">
				</td>
				<td><%= taskInfo.getTaskName() %></td>
				<td>
				<%
				if ((taskInfo.getLimitDate()) == null) {
				%>
					<%= "" %>
				<%
				} else {
				%>
					<%= taskInfo.getLimitDate() %>
				<%
				}
				%>
				</td>
				<td><%= taskInfo.getStatusName() %></td>
			</tr>
		</table>
		
		<table class="mx-auto table table-primary table-striped" style="width: 400px">
			<tr>
				<th>投稿者ID</th><!-- ここのIDと投稿者がタスク作成者になってしまっているため、ログインしている人に変える必要がある -->
				<td><%= userId %>
				<input type = "hidden" value="<%=userId %>" name="user_id">
				</td>
			</tr>
			<tr>
				<th>投稿者</th>
				<td><%= userName %></td>
			</tr>
			
			<tr>
				<th>コメント</th>
				<td><input type="text" name="comment"></td>
			</tr>
		</table>
		<div class="text-center">
			<input class="btn btn-success" type="submit" value="登録実行">
			<input class="btn btn-secondary" type="reset" value="クリア">
		</div>
	</form>
	<br>
	<form action="menu.jsp" method="POST" class="text-center">
		<input class="btn btn-primary" type="submit" value="メニュー画面へ">
	</form>
</body>
</html>