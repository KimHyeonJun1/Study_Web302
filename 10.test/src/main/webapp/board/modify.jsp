<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<h3>게시판 수정</h3>

<form method="post" action="update.mo">
<input type="hidden" name="numb" value="${dto.numb }">
<table border="1">
<colgroup>
	<col width="200px">
	<col width="400px">
</colgroup>
<tr><th>제목</th>
	<td><input type= "text" name="subject" value="${dto.subject }"></td>
</tr>
<tr><th>작성자</th>
	<td>${dto.name}</td>
</tr>
<tr><th>E-Mail</th>
	<td><input type= "text" name="email" value="${dto.email }"></td>
</tr>
<tr><th>작성일자</th>
	<td><input type= "date" name="nalja" value=${dto.nalja }></td>
</tr>
<tr><th>내용</th>
	<td><input type= "text" name="content" value="${dto.content }" class="content"></td>
</tr>
<tr><th>패스워드</th>
	<td><input type= "password" name="password" value="${dto.password }"></td>
</tr>
</table>
<button>수정하기</button>

<button type="button" onclick="location='info.mo?numb=${dto.numb}'">수정취소</button>

</form>
</body>
</html>