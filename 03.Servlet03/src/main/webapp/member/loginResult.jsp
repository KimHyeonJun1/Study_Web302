<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인 정보</h2>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");
//id: hong , pw: 0000 로그인 성공 -> 웰컴화면으로 연결
//실패하면 로그인화면으로 연결
String view = "";
if(id.equals("hong") && "0000".equals(pw)){
	//로그인 성공시 로그인정보를 session에 저장하기
	session.setAttribute("id", id);
	
	view = "../";
}else{
	view = "login.jsp";
// 	request.getRequestDispatcher(view).forward(request, response);
}
response.sendRedirect(view);

%>



</body>
</html>