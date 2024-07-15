<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>오류</h2>
<div>내부적인 오류가 발생했습니다</div>
<div>빠른시간 내 복구하겠습니다</div>
<div>오류원인: <%= exception.getMessage() %></div>
</body>
</html>