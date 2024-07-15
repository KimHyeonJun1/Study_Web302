<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href="./">홈으로</a></div>
<div><a href="calculator.jsp">계산기화면</a></div>

<h2>오류</h2>
<div>내부적인 오류가 발생했습니다</div>
<div>빠른시간 내 복구하겠습니다</div>
<%
String msg="";
if(exception instanceof NumberFormatException){
	msg = "숫자만 입력하세요";
}else if( exception instanceof ArithmeticException){
	msg = "잘못된 연산 : 0으로 나눗셈 불가";
}else{
	msg = exception.getMessage();
}

%>
<%= msg %>

</body>
</html>