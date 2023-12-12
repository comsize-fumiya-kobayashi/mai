<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>ログイン画面</title>
</head>
<body>
	<br>
	<h1 class="text text-primary">ログイン画面</h1>
	<hr>
	<%
	String message = null;
	message = (String)request.getAttribute("message");
	if(message != null){
	%>
		<h5 class="alert alert-danger" role="alert">
			<%= message %>
		</h5>
	<%
	}
	%>
	<form action="login-servlet" method="post">
	<table>
		<tr>
			<th class="text-left">ユーザID:</th>
			<td><input type="text" name="user_id" required></td>
		</tr>
		<tr>
			<th class="text-left">パスワード:</th>
			<td><input type="password" name="password" required></td>
		</tr>
		<tr>
			<th>　</th>
		</tr>
		<tr>
			<td><input type="submit" value="ログイン" class="btn btn-primary"></td>
			<td><input type="reset" value="クリア" class="btn btn-secondary"></td>
		</tr>
	</table>
	</form>
</body>
</html>