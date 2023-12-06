<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.entity.UpdateBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	UpdateBean taskDetail = (UpdateBean) request.getAttribute("updateTask");
	
	%>
	<br>
	<h1>編集失敗</h1>
	<hr>
	<h2>以下は編集できませんでした。</h2>
		
	<table border="1">
		<tr>
			<th>タスク名</th>
			<td><%=taskDetail.getTaskName()%></td>
		</tr>
		<tr>
			<th>カテゴリ情報</th>
			<td><%=taskDetail.getCategoryName()%></td>
		</tr>
		<tr>
			<th>期限</th>
			<td>
			<%
			if(taskDetail.getLimitDate() != null){
			%>
				<%=taskDetail.getLimitDate()%>
			<%
			}
			%>
			</td>
				</tr>
		<tr>
			<th>担当情報</th>
			<td><%=taskDetail.getUserName()%></td>
		</tr>
		<tr>
			<th>ステータス情報</th>
			<td><%=taskDetail.getStatusName()%></td>
		</tr>
		<tr>
			<th>メモ</th>
			<td><%=taskDetail.getMemo()%></td>
		</tr>
	</table>
	<br>
	
	<form action="task-list-servlet" method="POST">
		<input type="submit" value="タスク一覧画面へ">
		
	</form>
</body>
</html>