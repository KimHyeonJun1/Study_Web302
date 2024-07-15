<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>사원목록</h2>
<table border= "1">
<tr><th>사번</th><th>성명</th></tr>
<c:forEach items= "${list}" var="dto">
<tr><td>${dto.employee_id }</td>
<td>${dto.last_name }${dto.first_name}</td></tr>
</c:forEach>
</table>
</body>
</html>