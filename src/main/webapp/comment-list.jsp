<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,java.util.ArrayList,model.entity.TaskCategoryUserStatusBean,model.entity.CommentBean,model.entity.UserBean,java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>コメント一覧</title>
</head>
<body class="mx-auto">
	<%
	List<CommentBean> commentList = (List<CommentBean>) request.getAttribute("commentList");
	%>
	<%
	TaskCategoryUserStatusBean taskData = (TaskCategoryUserStatusBean) request.getAttribute("taskData");
	%>
	
	<% String userId = (String) session.getAttribute("userId"); %>
	<br>
	<h1 class="text text-primary text-center">コメント一覧</h1>
	<hr>
	<form action="menu.jsp" method="POST" style="margin-left:1150px;">
		<input class="btn btn-primary align-right" type="submit" value="メニュー画面へ">
	</form>
	<br>
	
<table class="mx-auto table table-primary table-striped table-bordered" style="width:95%;">
		<tr>
			<th>タスク名</th>
			<th>カテゴリ情報</th>
			<th>期限</th>
			<th>担当者情報</th>
			<th>ステータス情報</th>
			<th>メモ</th>
			
		</tr>
		<tr>
			<td><%=taskData.getTaskName()%></td>
			<td><%=taskData.getCategoryName()%></td>
			<td>
				<%
				if ((taskData.getLimitDate()) == null) {
				%>
					<%= "" %>
				<%
				} else {
				%>
					<%= taskData.getLimitDate() %>
				<%
				}
				%>
			</td>
			<td><%=taskData.getUserName()%></td>
			<td><%=taskData.getStatusName()%></td>
			<td><%=taskData.getMemo()%></td>
		<tr>
	</table>
	
	<table class="mx-auto table table-primary table-striped table-bordered" style="width:95%;">
		<tr>
			<!-- <th>タスクID</th>
			<th>タスク名</th> -->
			<th>ユーザID</th>
			<th>コメントID</th>
			<th>コメント</th>
			<th>投稿日</th>
			<th>削除</th>
		</tr>
		<%
		for (CommentBean comment : commentList) {
		%>
		<tr>
			<!-- <td><%=comment.getTaskId()%></td>
			<td><%=comment.getTaskName()%></td> -->
			<td><%=comment.getUserId()%></td>
			<td><%=comment.getCommentId()%></td>
			<td><%=comment.getComment()%></td>
			<td><%=comment.getUpdateTime() %></td>
			<td>
			<!-- ここでの条件式はコメントが投稿者のみ削除できるため、comment.getUserId() == login.getUserId()となる -->
				<% if(comment.getUserId().equals(userId)){ %>
					<form action="comment-delete-servlet" method="GET">
						<input type = "hidden" value="<%=comment.getCommentId() %>" name="comment_id"><!-- 削除したいタスクのIDを送る -->
						<input class="btn btn-danger" type="submit" value="削除">
					</form>
				<% } %>
			</td>
		</tr>
		<%
		}
		%>
	</table>
</body>

</html>