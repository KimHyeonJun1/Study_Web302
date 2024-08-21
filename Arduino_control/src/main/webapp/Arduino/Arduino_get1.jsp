<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import="Arduino.Arduino1DTO"%>
<jsp:useBean id="ArduinoDao" class="Arduino.ArduinoDAO"/>


	<% String v01 = request.getParameter("f01");
		System.out.println(v01);
		
		Arduino1DTO arduinoBean = ArduinoDao.Arduino_Get1(v01);	//제어값 가져오기 한 건만 조회
		//String msg1 = String.format("%05d", arduinoBean.getNumb()); //String msg1 = Integer.toString
		String msg1 = arduinoBean.getF05();
		String msg2 = arduinoBean.getF06();
		String msg = msg1 + msg2;
		
		System.out.println(msg);
		out.println(msg);
	%>















