<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録失敗画面</title>
</head>
<body>
	<h1>タスク登録失敗画面</h1>
	<hr>
	<h1>情報の登録に失敗しました。</h1>

	<form action="task-add-servlet" method="GET">
		<input type="submit" value="登録画面へ">
	</form>
	<br>
	<form action="menu.jsp" method="POST">
		<input type="submit" value="メニュー画面へ">
	</form>
</body>
</html>