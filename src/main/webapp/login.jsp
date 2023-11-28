<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
h2 {
	color: red;
}
th {
	text-align: left;
}
</style>
<title>ログイン画面</title>
</head>
<body>
	<h1>ログイン画面</h1>
	<hr>
	<%
	String message = null;
	message = (String)request.getAttribute("message");
	if(message != null){
	%>
		<h2><%= message %></h2>
	<%
	}
	%>
	<form action="login-servlet" method="post">
	<table>
		<tr>
			<th>ユーザID:</th>
			<td><input type="text" name="userId"></td>
		</tr>
		<tr>
			<th>パスワード:</th>
			<td><input type="password" name="password"></td>
		</tr>
	</table>
	<input type="submit" value="ログイン">
	<input type="reset" value="クリア">
	</form>
</body>
</html>