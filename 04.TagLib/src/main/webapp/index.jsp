<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>홈</h2>

<div><a href="jstl/core.jsp">코어라이브러리</a></div>
<div><a href="jstl/functions.jsp">함수라이브러리</a></div>
<div><a href="jstl/fmt.jsp">포맷라이브러리</a></div>
<hr>
<div><a href="scope/scopeData.jsp">Scope에 데이터 저장, 출력</a></div>
<div><a href="param/join.jsp">파라미터 출력</a></div>
<div><a href="operator/cal.jsp">계산기</a></div>
<div><a href="array/data.jsp">배열 출력</a></div>
<div><a href="test.jsp">URL링크</a></div>
<hr>
<div>홍길동: ${phones["홍길동"] } </div>
<div>심청: ${phones["심청"] }</div>
<div>박문수: ${phones['박문수'] }</div>
</body>
</html>