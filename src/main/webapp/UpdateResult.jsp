<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UpdateBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集登録結果画面</title>
</head>
<body>
	<h1>編集登録結果画面</h1>
	<hr>
	<%
		UpdateBean updateTask = (UpdateBean) request.getAttribute("updateTask");
		int processingNumber = (Integer) request.getAttribute("processingNumber");
	%>
	<%	if (processingNumber > 0) { %>
	<h2>次のデータを編集登録しました。</h2>
	<%  } else {%>
	<h2>次のデータを編集登録できませんでした。</h2>
	<%  }%>
	<br>
	<br>
	<table border="1">
		<tr>
			<th align="left">タスク名</th>
			<td width="600"><%=updateTask.getTaskName()%></td>
		</tr>
		<tr>
			<th align="left">カテゴリ情報</th>
			<td><%=updateTask.getCategoryName()%></td>
		</tr>
		<tr>
			<th align="left">期限</th>
			<td><%=updateTask.getLimitDate()%></td>
		</tr>
		<tr>
			<th align="left">担当者情報</th>
			<td><%=updateTask.getUserName()%></td>
		</tr>
	</table>

</body>
</html>