<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.entity.TaskCategoryUserStatusBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>タスク一覧</title>
</head>
<body class="mx-auto">
	<%
		List<TaskCategoryUserStatusBean> taskList = (List<TaskCategoryUserStatusBean>) request.getAttribute("taskList");
	%>
	<br>
	<h1 class="text text-primary text-center">タスク一覧</h1>
	<hr>
	<form action="menu.jsp" method="POST" class="text text-right">
		<input class="btn btn-primary" type="submit" value="メニュー画面へ">
	</form>
	<br>

	<table class="table table-primary table-striped">
		<tr>
			<th>タスク名</th>
			<th>カテゴリ情報</th>
			<th>期限</th>
			<th>担当者情報</th>
			<th>ステータス情報</th>
			<th>メモ</th>
			<th>編集</th>
			<th>削除</th>
		</tr>
		<%
				for (TaskCategoryUserStatusBean task : taskList) {
		%>
		<tr>
			<td><%=task.getTaskName()%></td>
			<td><%=task.getCategoryName()%></td>
			<td>
			<% if ((task.getLimitDate()) == null) { %>
			<%= "" %>
			<% } else { %>
			<%= task.getLimitDate() %>
			<% } %>
			</td>
			<td><%=task.getUserName()%></td>
			<td><%=task.getStatusName()%></td>
			<td><%=task.getMemo()%></td>
			<td>
			<form action="task-update-servlet" method="GET">
				<input type = "hidden" value="<%=task.getTaskId() %>" name="task_id">
				<input class="btn btn-primary" type="submit" value="編集">
			</form>
			</td>
			<td>
			<form action="task-delete-servlet" method="GET">
				<input type = "hidden" value="<%=task.getTaskId() %>" name="task_id">
			<input class="btn btn-primary" type="submit" value="削除">
			</form>
			</td>
		</tr>
		<%
		}
		%>
		</div>
	</table>

</body>
</html>