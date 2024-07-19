<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.content{
	width: 400px;
	height: 300px;
}
</style>
<body>
<jsp:include page="/include/header.jsp"/>
<h3>게시판등록</h3>
<form method="post" action="insert.mo">
<table border= "1">
<colgroup>
	<col width="200px">
	<col width="400px">
</colgroup>
<tr><th>제목</th>
	<td><input type= "text" name="subject"></td>
</tr>
<tr><th>작성자</th>
	<td><input type= "text" name="name"></td>
</tr>
<tr><th>E-Mail</th>
	<td><input type= "text" name="email"></td>
</tr>
<tr><th>작성일자</th>
	<td><input type= "date" name="nalja"></td>
</tr>
<tr><th>내용</th>
	<td><input type= "text" name="content" class="content"></td>
</tr>
<tr><th>패스워드</th>
	<td><input type= "password" name="password"></td>
</tr>
</table>
<button>글올리기</button>
<button type="button" onclick="location='register.mo?numb=${dto.numb}'">다시입력</button>
<button type="button" onclick="location='list.mo'">작성취소</button>
</form>

</body>
</html>