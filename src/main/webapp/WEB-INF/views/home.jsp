<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">
</head>
<body>
	<table class="formtable">	
		<tr>
			<td class ="label1"> <a href = "${pageContext.request.contextPath}/offers"> 학기별 이수 학점 조회</a> </td>
		</tr>
		<tr>
			<td class ="label1"> <a href = "${pageContext.request.contextPath}/createoffer"> Add a new offer</a> </td>
		</tr>
	
		<tr>
			<td class = "label">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<a href="javascript:document.getElementById('logout').submit()">Logout</a>
				</c:if>
			
				<form id="logout" action="<c:url value="/logout" />" method="post">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
			</td>
		</tr>
	</table>
</body>
</html>