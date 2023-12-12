<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録失敗画面</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body class="mx-auto text-center">
	<br>
	<h1 class="text text-primary">タスク登録失敗画面</h1>
	<hr>
	<h1 class="text text-danger">情報の登録に失敗しました。</h1>
	<br>
	<form action="task-add-servlet" method="GET">
		<input class="btn btn-info" type="submit" value="登録画面へ">
	</form>
	<br>
	<form action="menu.jsp" method="POST">
		<input class="btn btn-primary" type="submit" value="メニュー画面へ">
	</form>
</body>
</html>