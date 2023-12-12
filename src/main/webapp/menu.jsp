<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>メニュー画面</title>
</head>
<body class="mx-auto text-center">
<br>
	<h1 class="text text-primary">メニュー画面</h1>
	<hr>
	ログインユーザ：<%= session.getAttribute("userName") %>さん
	<br>
	<br>
	<form action="task-add-servlet" method="GET">
		<input class="btn btn-primary" type="submit" value="タスク登録画面へ">
	</form>
	<br>
	<form action="task-list-servlet" method="GET">
		<input class="btn btn-info" type="submit" value="タスク一覧表示画面へ">
	</form>
	<br>
	<form action="logout.jsp" method="POST">
		<input class="btn btn-secondary" type="submit" value="ログアウト">
	</form>
</body>
</html>