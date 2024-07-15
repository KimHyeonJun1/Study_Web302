<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Scope 확인</h2>

<%
pageContext.setAttribute("page", 130);
request.setAttribute("request", 200);
session.setAttribute("session", 300);

pageContext.setAttribute("data", 100);
request.setAttribute("data", 200);
session.setAttribute("data", 300);
%>
<div>페이지: <%=pageContext.getAttribute("page") %></div>
<div>request: ${request} </div>
<div>session: ${session }</div>
<hr>
<div>페이지 데이터: ${data }</div>
<div>request 데이터: ${requestScope.data }</div>
<div>session 데이터: ${sessionScope.data }</div>
</body>
</html>