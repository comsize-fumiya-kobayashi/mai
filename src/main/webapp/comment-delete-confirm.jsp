<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.CommentBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コメント削除確認画面</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body class="mx-auto">
	<%
	CommentBean selectComment = (CommentBean) session.getAttribute("selectComment");
	%>
	<br>
	<h1 class="text text-primary text-center">タスク削除確認画面</h1>
	<hr>
	<h2 class="text text-danger text-center">タスクを削除します。よろしいですか？</h2>
	<br>
	<form action="comment-delete-servlet" method="POST">
		<table class="mx-auto table table-primary table-striped table-bordered" style="width:400px;">	
			<tr>
				<th>タスクID</th>
				<td><%=selectComment.getTaskId()%></td>
			</tr>
			<tr>
				<th>タスク名</th>
				<td><%=selectComment.getTaskName()%></td>
			</tr>
			
			<tr>
				<th>ユーザID</th>
				<td><%=selectComment.getUserId()%></td>
			</tr>
			<tr>
				<th>コメントID</th>
				<td><%=selectComment.getCommentId()%></td>
			</tr>
			<tr>
				<th>コメント</th>
				<td><%=selectComment.getComment()%></td>
			</tr>
			<tr>
				<th>投稿日</th>
				<td><%=selectComment.getUpdateTime()%></td>
			</tr>
		</table>
	<div class="text-center">
		<input type ="hidden" value="<%=selectComment.getCommentId() %>" name ="comment_id">
		<input class="btn btn-danger"  type="submit" value="削除する">
	</div>
	</form>
	<br>
	<form action="comment-list-servlet" method="GET" class="text-center">
	<input type ="hidden" value="<%=selectComment.getTaskId() %>" name ="task_id">
		<input class="btn btn-secondary" type="submit" value="コメント一覧画面へ">
	</form>
</body>
</html>