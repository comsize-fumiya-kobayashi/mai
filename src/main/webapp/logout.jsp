<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>ログアウト画面</title>
</head>
<body>
	<br>
	<h1 class="text text-primary">ログアウト画面</h1>
	<hr>
	<%= session.getAttribute("userName") %>さん
	<% session.invalidate(); %>
	<h5 class="alert alert-success" role="alert">ログアウトしました。</h5>
	<form action="login.jsp" method="post">
		<input type="submit" value="ログイン画面へ" class="btn btn-primary">
	</form>
</body>
</html>