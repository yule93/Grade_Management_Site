<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강 신청 과목 조회</title>
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath }/resources/css/main.css">
</head>
<body>
	<h2> 신청한 과목  </h2>
	<table class = "formtable1">
		<tr>
			<td class = "can"> 연도 </td>
			<td class = "can"> 학기  </td>
			<td class = "can"> 교과코드 </td>
			<td class = "can"> 교과목명 </td>
			<td class = "can"> 구분 </td>
			<td class = "can"> 학점 </td>
		</tr>
		<c:forEach var = "offer" items = "${offers}">
			<tr>
				<td class = "can1"> <c:out value = "${offer.id}"/> </td>
				<td class = "can1"> <c:out value = "${offer.year}"/> </td>
				<td class = "can1"> <c:out value = "${offer.semester}"/> </td>
				<td class = "can1"> <c:out value = "${offer.code}"/> </td>
				<td class = "can1"> <c:out value = "${offer.name}"/> </td>
				<td class = "can1"> <c:out value = "${offer.sort}"/> </td>
				<td class = "can1"> <c:out value = "${offer.credit}"/> </td>
			</tr> 
		</c:forEach>
	</table>

</body>
</html>