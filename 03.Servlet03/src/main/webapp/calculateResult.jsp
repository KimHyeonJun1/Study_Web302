<%@page import="common.Calculator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "common.Calculator" %>
<!--     errorPage="calculateError.jsp" -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="calculator.jsp">계산기화면</a>
<%
int no1 = Integer.parseInt(request.getParameter("no1"));
int no2 = Integer.parseInt(request.getParameter("no2"));
String op = request.getParameter("operator");

	Calculator c = new Calculator(no1, no2, op);
	out.print( no1 + op + no2 + " = " + c.getResult());
// try{
// }catch(Exception e){
// 	request.getRequestDispatcher("calculateError.jsp").forward(request, response);
// }

%>
<%-- <%= no1 %> <%= op %> <%= no2 %> = <%=c.getResult() %> --%>


</body>
</html>