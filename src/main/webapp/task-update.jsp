<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,model.entity.TaskCategoryUserStatusBean,model.entity.CategoryBean,model.entity.StatusBean, model.entity.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク編集画面</title>
</head>
<body>
	<h1>タスク編集画面</h1>
	<hr>
	<%
	TaskCategoryUserStatusBean taskDetail = (TaskCategoryUserStatusBean) session.getAttribute("updateTask");
	List<CategoryBean> categoryList = (List<CategoryBean>) session.getAttribute("categoryList");
	List<StatusBean> statusList = (List<StatusBean>) session.getAttribute("statusList");
	List<UserBean> userList = (List<UserBean>) session.getAttribute("userList");
	%>
	<br>

	<form action="task-update-servlet" method="POST">
				
	
		<table border="1">
			<tr>
				<th>タスク名</th>
				<td><input type="text" value="<%=taskDetail.getTaskName()%>"
					name="task_name">
			</tr>

			<tr>
				<th>カテゴリ情報</th>
				<td><select name="select_category">
						<option
							value="<%=taskDetail.getCategoryId()%>,<%=taskDetail.getCategoryName()%>">
							<%=taskDetail.getCategoryName()%>
						</option>
						<%
						for (CategoryBean category : categoryList) {
							if (!(taskDetail.getCategoryName().equals(category.getCategoryName()))) {
						%>
						<option
							value="<%=category.getCategoryId()%>,<%=category.getCategoryName()%>">
							<%=category.getCategoryName()%>
						</option>
						<%
						}
						}
						%>
				</select></td>
			</tr>

			<tr>
				<th>期限</th>
				<td><input type="date" value="<%=taskDetail.getLimitDate()%>"
					name="limit_date"></td>

			</tr>
			<tr>
				<th>担当者情報</th>
				<td><select name="user_name">
						<option
							value="<%=taskDetail.getUserId()%>,<%=taskDetail.getUserName()%>">
							<%=taskDetail.getUserName()%></option>
						<%
						for (UserBean user : userList) {
							if (!(taskDetail.getUserName().equals(user.getUserName()))) {
						%>
						<option value="<%=user.getUserId()%>,<%=user.getUserName()%>">
							<%=user.getUserName()%></option>

						<%
						}
						}
						%>
				</select></td>
			</tr>

			<tr>
				<th>ステータス情報</th>
				<td><select name="status_name">
						<option
							value="<%=taskDetail.getStatusCode()%>,<%=taskDetail.getStatusName()%>">
							<%=taskDetail.getStatusName()%></option>
						<%
						for (StatusBean status : statusList) {
							if (!(taskDetail.getStatusName().equals(status.getStatusName()))) {
						%>
						<option
							value="<%=status.getStatusCode()%>,<%=status.getStatusName()%>">
							<%=status.getStatusName()%></option>
						<%
						}
						}
						%>

				</select></td>
			</tr>
			<tr>
				<th>メモ</th>
				<td><input type="text" value="<%=taskDetail.getMemo()%>"
					name="memo"></td>

			</tr>
		</table>
		<br>
		<input type ="hidden" value="<%=taskDetail.getTaskId() %>" name ="task_id">
		<input type="submit" value="変更する">
	</form>
	<br>
	<form action="task-list-servlet" method="GET">
		<input type="submit" value="タスク一覧画面へ">
	</form>
</body>
</html>

