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

<h3>고객정보 수정</h3>
<form method="post" action="update.do">
<input type="hidden" name="id" value="${dto.id }">
<table border="1">
<colgroup>
	<col width="200px">
	<col width="400px">
</colgroup>
<tr><th>고객명</th>
	<td><input type="text" name="name" value="${dto.name }"></td>
</tr>
<tr><th>성별</th>
	<td>
		<label>
		<input type="radio" name="gender" value="남" 
									${dto.gender eq "남" ? "checked" : "" }>남
		</label>
		
		<label>
		<input type="radio" name="gender" value="여" 
				<c:if test="${dto.gender == '여'}">checked</c:if> >여
		</label>
	</td>
</tr>
<tr><th>이메일</th>
	<td><input type="text" name="email" value="${dto.email }"></td>
</tr>
<tr><th>전화번호</th>
	<td><input type="text" name ="phone" value="${dto.phone }"></td>
</tr>
</table>
<button>저장하기</button>
<button type="button" onclick="location='info.do=${dto.id}'">취소하기</button>
</form>
</body>
</html>