<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href="../">홈으로</a></div>
<div><a href="cal.jsp">계산기</a></div>
<hr>
<h2>계산결과</h2>

<h3>논리연산</h3>
<div>no1: 값이 ${empty param.no1 ? "없다" : "있다"}</div>
<div>no3: 값이 ${empty param.no3 ? "없다" : "있다"}</div>

<div>no1: 값이 ${ not empty param.no1 ? "있다" : "없다"}</div>
<div>no3: 값이 ${ ! empty param.no3 ? "있다" : "없다"}</div>
<!--             not 써도 되고 ! 써도 됨 -->

<div>no1 과 no2 모두 값이 ${! empty param.no1 &&  not empty param.no2 ? "있다" : "아니다"}</div>

<hr>
<h3>비교연산</h3>
<div>${param.no1 } 과 ${param.no2 } 중 더 큰 수:
	${param.no1  -  param.no2 gt 0 ? param.no1 : param.no2} 
<!-- 	> <-이 비교문자를 gt 로 표현 가능 -->


</div>
<hr>
<div>${param.no1} + ${param.no2}  = ${param.no1 + param.no2 }</div>
<div>${param.no1} - ${param.no2}  = ${param.no1 - param.no2 }</div>
<div>${param.no1} * ${param.no2}  = ${param.no1 * param.no2 }</div>
<div>${param.no1} / ${param.no2}  = 
					${param.no2 == 0 ? 0 : param.no1 div param.no2 }</div>
<div>${param.no1} % ${param.no2}  = 
					${param.no2 eq 0 ? 0 : param.no1 mod param.no2 }</div>
</body>
</html>