<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>ログイン画面</title>
</head>
<body class="mx-auto">
	<br>
	<h1 class="text-primary text-center">ログイン画面</h1>
	<hr>
	<br>
	<%
	String message = null;
	message = (String)request.getAttribute("message");
	if(message != null){
	%>
		<h5 class="alert alert-danger mx-auto text-center" role="alert" style="width: 50%;">
			<%= message %>
		</h5>
	<%
	}
	%>
	<form action="login-servlet" method="post" class="text-center">
	ユーザID：<input type="text" name="user_id" size="50px" required>
	<br>
	<br>
	パスワード：<input type="password" name="password" size="50px" required>
	<br>
	<br>
	<input type="submit" value="ログイン" class="btn btn-primary">
	<input type="reset" value="クリア" class="btn btn-secondary">
	</form>
</body>
</html>