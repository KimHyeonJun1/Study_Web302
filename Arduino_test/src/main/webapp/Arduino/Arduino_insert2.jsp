<%@ page language="java" contentType="text/html; charset=UTF-8" %>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean id ="Arduino1Dto" class="Arduino.Arduino1DTO"/>
<jsp:useBean id="ArduinoDao" class="Arduino.ArduinoDAO"/>
<jsp:setProperty name="Arduino1Dto" property="*"/>

<%
// 	String v01 = request.getParameter("f01");
// 	String v02 = request.getParameter("f02");
// 	String v03 = request.getParameter("f03");
// 	String v04 = request.getParameter("f04");
	
// 	//System.out.println(v01 + " " + v02 + " " + v03 + " " + v04);
	
// 	boolean result = ArduinoDao.Arduino_Save(v01, v02, v03, v04);
	String v01 = Arduino1Dto.getS01();	// MAC Address
	String v02 = Arduino1Dto.getS02();	// WiFi 수신감도 (-100 이하가 적당)

	System.out.println(v01 + " " + v02 );
	
// 	//자료 추가
// 	boolean result1 = ArduinoDao.Arduino_Insert(Arduino1Dto);
// 	// 자료 수정1
// 	boolean result2 = ArduinoDao.Arduino_Update1(Arduino1Dto);
// 	// 자료 수정1
// 	boolean result3 = ArduinoDao.Arduino_Update2(Arduino1Dto);
	
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2><%=v01 %>  <%=v02 %></h2>
</body>
</html>