<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>이수 학점 조회 페이지</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">
</head>
<body>

	<%-- <c:set var="offer" value ="${offers}" /> --%>
	<table class = "formtable">
		<tr>
			<td class = "can"> 년도 </td>
			<td class = "can"> 학기 </td>
			<td class = "can"> 이수 학점 </td>
			<td class = "can"> 상세학기 </td>
		</tr>
				<c:set var = "result" value = ""/>
			<c:forEach var = "offer" items = "${offers}" >
				<c:if test =" ${ offer.year eq result } ">
					<tr>
						<td class = "can1"> <c:out value = "${offer.year}"> </c:out> </td>
						<td class = "can1"> 학기 </td>
						<td class = "can1"> 이수 학점 </td>
						<td class = "can1"> <a href = "${pageContext.request.contextPath}/semesterlist"> 링크 보기 </a> </td>
					</tr>
				</c:if>
				<c:set var = "result" value ="${offer.year}" />
			</c:forEach>
		
	</table>
		
	<%-- <c:forEach var = "offer" items = "${offers}">
		<p>
			<c:out value = "[ "/>
			<c:out value = "${offer.id}, "/> <c:out value = "${offer.year}, "/> <c:out value = "${offer.semester}"/>
			<c:out value = "${offer.code}, "/> <c:out value = "${offer.name}, "/> <c:out value = "${offer.sort}, "/>
			<c:out value = "${offer.credit} "/>
			<c:out value = " ]"/>
		</p> 
	</c:forEach> --%>
		
</body>
</html>