<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href='../'>홈으로</a></div>
<hr>
<h2>구구단</h2>
<div>3단 출력하기</div>
<% 
int no1=3;
int sum=0;
for(int no=1; no<=9; no++){
	sum = no1 * no;
	out.println("<div>" + no1 +"X"+ no +"=" + sum + "</div>");
}
 %>
 
<hr>

 
	
</body>
</html>