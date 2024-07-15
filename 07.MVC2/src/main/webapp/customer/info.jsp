<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>고객정보</h3>
<table border = "1">
<colgroup>
	<col width= "200px">
	<col width= "400px">
</colgroup>
<tr><th>고객명</th>
	<td>${dto.name}</td>
</tr>
<tr><th>성별</th>
	<td>${dto.gender }</td>
</tr>
<tr><th>이메일</th>
	<td>${dto.email }</td>
</tr>
<tr><th>전화번호</th>
	<td>${dto.phone }</td>
</tr>
</table>
<button onclick="location='modify.do?id=${dto.id}'">수정하기</button>
<button onclick="fnDelete()">삭제하기</button>
<script>
	function fnDelete(){
		if( confirm("삭제?")){
			location = "delete.do?id=${dto.id}"
		}
	}
</script>

</body>
</html>