<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UpdateBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報-変更確認画面</title>
</head>
<%
UpdateBean updateDetail = (UpdateBean) session.getAttribute("updateDetail");
UpdateBean updateTask = (UpdateBean) request.getAttribute("updateTask");
%>

<h1>商品情報-変更確認画面</h1>
<hr>

<h2>商品情報を以下の内容に変更します。よろしいですか？</h2>
<br>
<br>
<form action="task-update-servlet" method="POST">
	<table border="1">
		<tr>
			<th>タスク名</th>
			<td><%=updateDetail.getTaskName()%><input type="hidden"
				name="task_name" value="<%=updateDetail.getTaskName()%>"></td>
		</tr>
		<tr>
			<th>カテゴリ情報</th>
			<td><%=updateDetail.getCategoryName()%><input type="hidden"
				name="category_name" value="<%=updateDetail.getCategoryName()%>"></td>
		</tr>
		<tr>
			<th>期限</th>
			<td><%=updateDetail.getLimitDate()%><input type="hidden"
				name="limit_date" value="<%=updateDetail.getLimitDate()%>"></td>
		</tr>
		<tr>
			<th>担当者情報</th>
			<td><%=updateDetail.getUserName()%>円<input type="hidden" name="user_name"
				value="<%=updateDetail.getUserName()%>"></td>
		</tr>
	</table>
	<br> <input type="submit" value="変更する"> <input
		type="hidden" name="task_id"
		value="<%=updateDetail.getTaskId()%>">
</form>
<br>
<form action="Update.jsp" method="POST">
	<input type="hidden" name="task_id"
		value="<%=updateDetail.getTaskId()%>"> <input type="submit"
		value="変更入力フォームへ">
</form>
</body>
</html>