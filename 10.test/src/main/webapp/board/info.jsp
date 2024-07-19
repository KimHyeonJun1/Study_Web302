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
.subject{
display: flex; 
 justify-content: center;
}
#fee{
    width: 1000px;
    margin: 0 auto;
}
</style>
<body>
<jsp:include page="/include/header.jsp"/>
<h3>게시판정보</h3>
<table border= "1" id="fee">
<colgroup>
	<col width="200px">
	<col width="400px">
</colgroup>

 <section>
	<article class="subject">
		<h3>${dto.subject }</h3>
	</article>
 </section>
 
<%--  <tr><h3>${dto.subject }</h3><tr> --%>
 
<tr><th>작성자</th>
	<td>${dto.name }</td>
</tr>

<tr><th>작성일자</th>
	<td>${dto.nalja }</td>
</tr>
<tr><th>조회수</th>
	<td>${dto.check_num }</td>
</tr>
<tr><th>내용</th>
	<td>${dto.content }</td>
</tr>
</table>
<button type="button" onclick="location='modify.mo?numb=${dto.numb}'">수정하기</button>
<%-- <button type="button" onclick="location='info.mo?numb=${dto.numb}'">다시입력</button> --%>
<button type="button" onclick="location='delete.mo?numb=${dto.numb}'">삭제하기</button>
<button type="button" onclick="location='list.mo'">리스트</button>

</body>
</html>