<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");  
String gender = request.getParameter("gender");  
String hobby[] = request.getParameterValues("hobby");
%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href= "../">홈으로</a></div>
<div><a href= "join.jsp">회원가입</a></div>
<hr>
<h2>회원정보</h2>
<table border='1'>
<tr><th>성명</th><td><%= name %></td></tr>
<tr><th>성별</th><td><%= gender %></td></tr>
<tr><th>취미</th>
<td>
<%
if(hobby != null){
for( String h : hobby){
		out.print("<span>" + h + "</span>");
	}
}

pageContext.setAttribute("pageInfo", "스마트IoT");
request.setAttribute("requestInfo", "웹");
%>
</td>
</tr>
</table>

<div>pageScope정보 : <%=pageContext.getAttribute("pageInfo") %></div>
<div>requestScope정보 : <%= request.getAttribute("requestInfo") %></div>
<%
/* 현재페이지를 다른페이지로 연결해 응답하기 */
// request.getRequestDispatcher("../").forward(request, response);
response.sendRedirect("../");
%>

</body>
</html>