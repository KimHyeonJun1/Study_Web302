<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href='./'>홈으로</a></div>
<hr>
	<h2>숫자합 계산 [ <%=session.getAttribute("id") %> ]</h2>
<%-- <%= sum %>	 --%>
<%= no1 %>	
<%
int sum = 0;
for(int no =1; no<=10; no++){
	sum += no;
}
out.print(sum);

no1 = 10;
no2 = 5;
operator = "*";
calculate();
int result = calculate();
%>	
	<div>합 :  <%= sum %></div>
	<div> <%= "1~10까지의 합=" + sum %></div>
	<div><%= no1 + operator + no2 + " = " + calculate() %></div> <%-- calculate() 메소드 대신 result넣어도됨 똑같음 --%>
<%!

int no1, no2;
String operator;

int calculate(){
	if(operator.equals("+")){
		return no1 + no2;
	}else if( operator.equals("-")){
		return no1 - no2;
	}else if( operator.equals("*")){
		return no1 * no2;
	}else{
		return no1 / no2;
	}
}

%>	
	<%@ include file="include/footer.jsp" %>
</body>
</html>