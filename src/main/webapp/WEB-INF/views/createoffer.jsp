<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 등록</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">
</head>
<body>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate"
		modelAttribute="offer">

		<table class="formtable">
			<tr>
				<td class="label">Year:</td>
				<td><sf:input class="control" type="text" path="year" /> <br />
					<sf:errors path="year" class="error" /></td>
			</tr>
			<tr>
				<td class="label">Semester:</td>
				<td><sf:input class="control" type="text" path="semester" /> <br />
					<sf:errors path="semester" class="error" /></td>
			</tr>
			<tr>
				<td class="label">Code:</td>
				<td><sf:input class="control" type="text" path="code" /> <br />
					<sf:errors path="code" class="error" /></td>
			</tr>
			<tr>
				<td class="label">Name:</td>
				<td><sf:input class="control" type="text" path="name" /> <br />
					<sf:errors path="name" class="error" /></td>
			</tr>
			<tr>
				<td class="label">Sort:</td>
				<td><sf:input class="control" type="text" path="sort" /> <br />
					<sf:errors path="sort" class="error" /></td>
			</tr>
			<tr>
				<td class="label">Credit:</td>
				<td><sf:input class="control" type="text" path="credit" /> <br />
					<sf:errors path="credit" class="error" /></td>
			</tr>

			<tr>
				<td class="label"></td>
				<td><input class="control" type="submit" value="새 제안" /></td>
			</tr>

		</table>

	</sf:form>

</body>
</html>