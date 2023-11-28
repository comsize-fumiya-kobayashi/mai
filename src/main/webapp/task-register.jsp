<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.entity.CategoryBean" import="java.util.List,model.entity.StatusBean" import="java.util.List,model.entity.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録画面</title>
</head>
<body>
	<%
	List<CategoryBean> categoryList = (List<CategoryBean>) session.getAttribute("categoryList");
	List<StatusBean> statusList = (List<StatusBean>) session.getAttribute("statusList");
	List<UserBean> userList = (List<UserBean>) session.getAttribute("userList");
	%>
	<h1>タスク登録画面</h1>
	<hr>
	<form action="task-add-servlet" method="POST">
		<table border="1">
			<tr>
				<th>タスク名</th>
				<td><input type="text" name="task_name"></td>
			</tr>
			<tr>
				<th>カテゴリ情報</th>
				<td><select name="category_name">
				<%
					for (CategoryBean category : categoryList) {
					%>
					<option value="<%=category.getCategoryId()%>"><%=category.getCategoryName()%></option>
					<%
					}
					%>
					</select></td>
			</tr>
			<tr>
				<th>期限</th>
				<td><input type="date" name="date"></td>
			</tr>
			<tr>
				<th>担当者情報</th>
				<td><select name="user_name">
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
				<td><select name="status_name">
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
			<input type="submit" value="登録実行"> 
			<input type="reset"value="クリア">
	</form>
	<br>
	<br>
	<form action="menu.jsp" method="POST">
		<input type="submit" value="メニュー画面へ">
		</div>
	</form>
</body>
</html>