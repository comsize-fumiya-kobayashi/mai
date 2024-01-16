<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.CommentBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コメント削除結果画面</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body class="mx-auto">
	<%
	CommentBean commentResult = (CommentBean) session.getAttribute("selectComment");
	int processingNumber = (Integer) request.getAttribute("processingNumber");
	%>
	<br>
	<h1 class="text text-primary text-center">コメント削除結果画面</h1>
	<hr>
	<%
	if (processingNumber > 0) {
	%>
		<h2 class="text text-success text-center">次のデータを削除しました。</h2>
	<% 
	} else {
	%>
		<h2 class="text text-danger text-center">次のデータを削除できませんでした。</h2>
	<%
	}
	%>
	<br>
	<table class="mx-auto table table-primary table-striped table-bordered" style="width:400px;">
		<tr>
			<th>タスクID</th>
			<td><%=commentResult.getTaskId()%></td>
		</tr>
		<tr>
			<th>タスク名</th>
			<td><%=commentResult.getTaskName()%></td>
		</tr>
		<tr>
			<th>ユーザID</th>
			<td>
				<%=commentResult.getUserId()%>
			</td>
		</tr>
		<tr>
			<th>コメントID</th>
			<td><%=commentResult.getCommentId() %></td>
		</tr>
		<tr>
			<th>コメント</th>
			<td><%=commentResult.getComment()%></td>
		</tr>
		<tr>
			<th>投稿日</th>
			<td><%=commentResult.getUpdateTime()%></td>
		</tr>
	</table>
	<form action="menu.jsp" method="POST" class="text-center">
		<input class="btn btn-primary" type="submit" value="メニュー画面へ">
	</form>
</body>
</html>