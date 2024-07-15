<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href= "../">홈으로</a></div>
<hr>
 <h2>회원가입</h2>
 
 <form method="post" action="data.jsp">
 <table border = '1'>
 <tr><th>이름</th>
 <td><input type="text" name="name"></td>
 </tr>
 <tr><th>아이디</th>
 <td><input type="text" name="id"></td>
 
 <tr><th>비밀번호</th>
 <td><input type="password" name="pw"></td>
 </tr>
 <tr><th>전화번호</th>
 <td><input type="text" name="phone"></td>
 </tr>
 <tr><th>성별</th>
 
 
 <td>
 <label><input type="radio" name="gender" value="남">남</label>
 <label><input type="radio" name="gender" value="여" checked>여</label>
 </td>
 </tr>
 
 <tr><th>취미</th>
 <td>
 <label><input type="checkbox" name="hobby" value="수영">수영</label>
 <label><input type="checkbox" name="hobby" value="영상보기">영상보기</label>
 <label><input type="checkbox" name="hobby" value="바둑">바둑</label>
 </td>
 </tr>
 </table>
 <button>가입하기</button>
 </form>
</body>
</html>