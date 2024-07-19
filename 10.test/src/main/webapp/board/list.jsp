<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
</head>

<style>
.board{
 display: flex; 
 justify-content: center;
}
#fee{
    width: 1000px;
    margin: 0 auto;
}

</style>
<body>
<jsp:include page="/include/header.jsp" />

<section>
	<article class="board">
		<h2>게시판</h2>
	</article>
 </section>

<button type="button" onclick="location='register.mo'">글올리기</button>
<section>
            <article>
<table border="1" id="fee">
<colgroup>
	<col width="50px">
	<col width="300px">
	<col width="100px">
	<col width="100px">
	<col width="80px">
</colgroup>

<tr><th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일</th>
	<th>조회수</th>
</tr>
<c:forEach items="${list}" var="dto">
<tr><td>${dto.numb }</td>
	<td><a href= "info.mo?numb=${dto.numb } "> ${dto.subject} </a></td>
	<td>${ dto.name }</td>
	<td>${dto.nalja }</td>
	<td>${dto.check_num }</td>
</tr>
</c:forEach>
</table>
</article>
            </section>
</body>
</html>