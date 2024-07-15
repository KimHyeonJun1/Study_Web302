<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>고객목록</h3>
<a href="register.do">신규고객등록</a>
<table border="1">
<colgroup>
	<col width="150px">
	<col width="200px">
	<col width="200px">
</colgroup>

<tr><th>고객명</th>
	<th>이메일</th>
	<th>전화번호</th>
</tr>

<c:forEach items= "${list }" var="dto">
<tr><td><a href="info.do?id=${dto.id}">${dto.name }</a></td>
	<td>${dto.email }</td>
	<td>${dto.phone }</td>
</tr>
</c:forEach>
</table>

</body>
</html>