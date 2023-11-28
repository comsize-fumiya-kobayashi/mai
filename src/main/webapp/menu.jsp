<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
</head>
<body>
	<h1>メニュー画面</h1>
	<hr>
	ログインユーザ：<%= session.getAttribute("userName") %>さん
	<br>
	<form action="task-add-servlet" method="GET">
		<input type="submit" value="タスク登録画面へ">
	</form>
	<br>
	<form action="task-list-servlet" method="GET">
		<input type="submit" value="タスク一覧表示画面へ">
	</form>
	<br>
	<form action="logout.jsp" method="POST">
		<input type="submit" value="ログアウト">
	</form>
</body>
</html>