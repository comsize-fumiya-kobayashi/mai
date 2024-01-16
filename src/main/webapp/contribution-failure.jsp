<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コメント投稿失敗画面</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body class="mx-auto text-center">
	<br>
	<h1 class="text text-primary">コメント投稿失敗画面</h1>
	<hr>
	<h2 class="text text-danger">コメントの投稿に失敗しました。</h2>
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