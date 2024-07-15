<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href = "../">홈으로</a>
	<hr>
	<h2>계산기</h2>
	
	<form method="post" action="result.jsp">
	<input type="text" name="no1">
	<select name="operator">
		<option>+</option>
		<option>-</option>
		<option>*</option>
		<option>/</option>
		<option>%</option>
	</select>
	
	<input type="text" name="no2">
	<button>계산하기</button>
	
	</form>
</body>
</html>