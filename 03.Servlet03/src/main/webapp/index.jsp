<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>홈 [ <%=session.getAttribute("id") %> ]</h2>
 <div><a href="sum.jsp">숫자합 계산</a></div>
 <div><a href="out.jsp">출력하기</a></div>
 <div><a href="member/join.jsp">회원가입</a></div>
 <div><a href="member/login.jsp">로그인</a></div>
 <div><a href="calculator.jsp">계산기</a></div>
 <div><a href="member/gugudan.jsp">구구단 출력하기</a></div>
 <hr>
 <%
 // java.utl.Date date = new java.util.Date();
 Date date = new Date();
 //날짜를 포맷시켜 표현
 String now = new SimpleDateFormat("yyyy년 MM월 dd일 E HH:mm:ss")
 	.format(date);
 %>
 <div>오늘날짜: <%= date %></div>
 <div>현재: <%= now %> </div>
 
 <div>pageScope정보 : <%=pageContext.getAttribute("pageInfo") %></div>
<div>requestScope정보 : <%= request.getAttribute("requestInfo") %></div>

<%--  <%@ include file="include/footer.jsp" %> --%>
<jsp:include page="include/footer.jsp">
	<jsp:param value="010-5487-5481" name="phone"/>
	</jsp:include>
</body>
</html>