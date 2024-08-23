<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<%@ page import ="java.util.Vector" %>
<%@ page import="Arduino.Arduino1DTO"%>
<jsp:useBean id="ArduinoDao" class="Arduino.ArduinoDAO"/>


	<%
	Vector<Arduino.Arduino1DTO> vlist = null;
			String msg = "";
			
		
			String v01 = request.getParameter("s01");
			//System.out.println(v01);
			
			vlist = ArduinoDao.Arduino_Get2(v01);
			if(vlist.isEmpty()){
		out.println("자료가 없습니다.");
			}else {
		//Systom.out.println("자료 : " + vlist.size());
			 for (int i = 0; i<vlist.size(); i++){
		 Arduino.Arduino1DTO bean = vlist.get(i);
	// 			 int numb = bean.getS01();
	// 			 String s01 = bean.getS01();
	// 			 String s02 = bean.getS02();
	// 			 String s03 = bean.getS03();
	// 			 String s04 = bean.getS04();
		 String s04 = bean.getS04();
		 msg += s04;
			 }
		 System.out.println(msg);
		out.println(msg);
		 
			}
	%>















