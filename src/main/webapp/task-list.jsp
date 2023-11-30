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
		<form action="menu.jsp" method="POST">
		<input type="submit" value="メニュー画面へ">
		</form>
		<br>

	<table border="1">
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
		for (TaskListBean task : taskList) {
		%>
		<tr>
			<td><%=task.getTaskName()%></td>
			<td><%=task.getCategoryName()%></td>
			<td><%=task.getLimitDate()%></td>
			<td><%=task.getUserName()%></td>
			<td><%=task.getStatusName()%></td>
			<td><%=task.getMemo()%></td>
			<td>
			<form action="task-update-servlet" method="GET">
			<input type="submit" value="編集">
			</form>
			</td>
			<td>
			<form action="DeleteConfirm.jsp" method="POST">
			<input type="submit" value="削除">
			</form>
			</td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>