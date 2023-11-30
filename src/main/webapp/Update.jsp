<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,model.entity.UpdateBean,model.entity.CategoryBean,model.entity.StatusBean, model.entity.UserBean"%>
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
	UpdateBean taskDetail = (UpdateBean) session.getAttribute("updateTask");
	List<CategoryBean> categoryList = (List<CategoryBean>) session.getAttribute("categoryList");
	List<StatusBean> statusList = (List<StatusBean>) session.getAttribute("statusList");
	List<UserBean> userList = (List<UserBean>) session.getAttribute("userList");
	
	%>
	<br>

	<form action="task-update-servlet" method="POST">
		<table border="1">
			<tr>
				<th>タスク名</th>
				<td><input type="text" name="task_name"> 
				<td><%=taskDetail.getTaskName()%></td>
				</tr>
				
			<tr>
				<th>カテゴリ情報</th>
					<td><select name="select_category">
						<option
							value="<%=taskDetail.getCategoryId()%>,<%=taskDetail.getCategoryName()%>"><%=taskDetail.getCategoryName()%></option>
						<%
						for (CategoryBean category : categoryList) {
							if (!(taskDetail.getCategoryName().equals(category.getCategoryName()))) {
						%>
						<option
							value="<%=category.getCategoryId()%>,<%=category.getCategoryName()%>"><%=category.getCategoryName()%></option>
						<%
							}
						}
						%>
				</select></td>
			</tr> 
				
			<tr>
				<th>期限</th>
				<td><input type="date" name="date" value=""></td>
				
			</tr>
			<tr>
				<th>担当者情報</th>
				<td><select name="user_id">
				<%
					for (UserBean user : userList) {
					%>
					<option value="<%=user.getUserId()%>"><%=user.getUserName()%></option>
					<%
					}
					%>
					</select></td>
			</tr>
			
			<tr>
				<th>ステータス情報</th>
				<td><select name="status_code">
			<%
					for (StatusBean status : statusList) {
					%>
					<option value="<%=status.getStatusCode()%>"><%=status.getStatusName()%></option>
					<%
					}
					%>

					</select></td>
			</tr>
		<tr>
				<th>メモ</th>
				<td><input type="text" name="memo"></td>
					
			</tr>
		</table>
		<br>
		<div>
				<input type="submit" value="変更する">
	</form>
	<br>
		<form action="menu.jsp" method="POST">
		<input type="submit" value="メニュー画面へ">
		</div>
	</form>
</body>
</html>



















