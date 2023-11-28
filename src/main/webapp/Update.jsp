<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,model.entity.UpdateBean,model.entity.CategoryBean,model.entity.StatusBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報-変更入力フォーム</title>
</head>
<body>
	<h1>商品情報-変更入力フォーム</h1>
	<hr>
	<%
	UpdateBean updateDetail = (UpdateBean) session.getAttribute("updateDetail");
	List<CategoryBean> categoryList = (List<CategoryBean>) session.getAttribute("categoryList");
	List<StatusBean> statusList = (List<StatusBean>) session.getAttribute("statusList");
	%>
	<br>

	<form action="ItemConfirmServlet" method="POST">
		<table border="1">
			<tr>
				<th>タスク名</th>
				<td><%=updateDetail.getTaskName()%></td>
			</tr>
			<tr>
				<th>カテゴリ情報</th>
				<td><select name="selectCategory">
						<option
							value="<%=updateDetail.getCategoryName()%>,<%=updateDetail.getCategoryName()%>"><%=updateDetail.getCategoryName()%></option>
						<%
						for (CategoryBean category : categoryList) {
							if (!(updateDetail.getCategoryName().equals(category.getCategoryName()))) {
						%>
						<option
							value="<%=category.getCategoryName()%>"><%=category.getCategoryName()%></option>
						<%
							}
						}
						%>
				</select></td>
			</tr>
			<tr>
				<th>期限</th>
				<td><input type="text" size="100" name="limitName"
					value="<%=updateDetail.getLimitDate()%>" ></td>
			</tr>
			<tr>
				<th>担当者情報</th>
				<td><input type="number" name="price"
					value="<%=updateDetail.getUserName()%>"></td>
			</tr>
			<tr>
				<th>ステータス情報</th>
				<td><select name="selectStatus">
						<option
							value="<%=updateDetail.getCategoryName()%>,<%=updateDetail.getCategoryName()%>"><%=updateDetail.getStatusName()%></option>
						<%
						for (StatusBean category : statusList) {
							if (!(updateDetail.getStatusName().equals(category.getStatusName()))) {
						%>
						<option
							value="<%=category.getStatusName()%>"><%=category.getStatusName()%><%=category.getStatusName()%></option>
						<%
							}
						}
						%>
				</select></td>
			</tr>
				<th>メモ</th>
				<td><input type="text" size="100" name="memo"
					value="<%=updateDetail.getMemo()%>" ></td>
			</tr>
		</table>
	<div class="form-container">
			<input type="submit" value="変更する">
	</form>
	<br>
	<form
		action="ItemDetailServlet?task_name=<%=updateDetail.getTaskName()%>"
		method="GET">
		<input type="hidden" value="<%=updateDetail.getTaskName()%>"
			name="item_code"> <input type="submit" value="キャンセル">
	</form>
	</div>
</body>
</html>