<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,model.entity.CategoryBean, java.util.List,model.entity.StatusBean, java.util.List,model.entity.UserBean, java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録画面</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body class="mx-auto">
	<%
	List<CategoryBean> categoryList = (List<CategoryBean>) session.getAttribute("categoryList");
	List<StatusBean> statusList = (List<StatusBean>) session.getAttribute("statusList");
	List<UserBean> userList = (List<UserBean>) session.getAttribute("userList");
	LocalDate localDate = (LocalDate) request.getAttribute("localDate");
	%>
	<br>
	<h1 class="text text-primary text-center">タスク登録画面</h1>
	<hr>
	<form action="task-add-servlet" method="POST">
	
		<table class="mx-auto table table-primary table-stripped" style="width:400px">
			<tr>
				<th>タスク名</th>
				<td><input type="text" name="task_name" required></td>
			</tr>
			<tr>
				<th>カテゴリ情報</th>
				<td>
					<select name="category_id">
						<%
						for (CategoryBean category : categoryList) {
						%>
							<option value="<%=category.getCategoryId()%>"><%=category.getCategoryName()%></option>
						<%
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<th>期限</th>
				<td><input type="date" name="limit_date" min="<%=localDate %>"></td>
			</tr>
			<tr>
				<th>担当者情報</th>
				<td>
					<select name="user_id">
						<%
						for (UserBean user : userList) {
						%>
							<option value="<%=user.getUserId()%>"><%=user.getUserName()%></option>
						<%
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<th>ステータス情報</th>
				<td>
					<select name="status_code">
						<%
						for (StatusBean status : statusList) {
						%>
							<option value="<%=status.getStatusCode()%>"><%=status.getStatusName()%></option>
						<%
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<th>メモ</th>
				<td><input type="text" name="memo"></td>
			</tr>
		</table>
		<br>
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