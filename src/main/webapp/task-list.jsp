<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, model.entity.TaskListBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧</title>
</head>
<body>
	<%
	List<TaskListBean> taskList = (List<TaskListBean>) request.getAttribute("taskList");
	%>
	<h1>タスク一覧</h1>
	<hr>

	<table border="1">
		<tr>
			<th>タスク名</th>
			<th>カテゴリ情報</th>
			<th>期限</th>
			<th>担当者情報</th>
			<th>ステータス情報</th>
			<th>メモ</th>
		</tr>
		<%
		for (TaskListBean task : taskList) {
		%>
		<tr>
			<td>
			<a href="ItemDetailServlet?task_name=<%=task.getTaskName()%>"><%=task.getTaskName()%></a></td>
			<td><%=task.getCategoryName()%></td>
			<td><%=task.getLimitDate()%></td>
			<td><%=task.getUserName()%></td>
			<td><%=task.getStatusName()%></td>
			<td><%=task.getMemo()%></td>
		</tr>
		<%
		}
		%>
	</table>

	<br>
	<div>
		<form action="menu.jsp" method="POST">
			<input type="submit" value="メイン画面へ">
		</form>
	</div>

</body>
</html>