package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Calculator;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//화면에서 입력한 두 수와 선택한 연산자를 가져오기
		//String --> int 변환처리
		int no1 = Integer.parseInt(request.getParameter("no1"));
		int no2 = Integer.valueOf(request.getParameter("no2"));
		String operator = request.getParameter("operator");
	
		//연산처리: 비지니스로직
//		 int result = calculate(no1, no2, operator);
		Calculator c = new Calculator(no1, no2, operator);
		
		//응답할 화면(View)만들기 - 프리젠테이션로직
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<ul>");
		out.print("<li><a href='index.html'>홈으로</a></li>");
		
		out.print("<li><a href='calculator.html'>계산기화면</a></li>");
		
		out.print("</ul>");
		out.print("<hr>");
		out.print("<h2>계산결과</h2>");
		out.printf("%d %s %d = %d", no1, operator, no2, c.getResult());
		
		
		
		
		out.print("</body>");
		out.print("</html>");
	}

//	int calculate(int no1, int no2, String operator) {
//		int result = 0;
//		switch(operator) {
//		case "+":
//			result = no1 + no2 ;
//			break;
//		case "-":
//			result = no1 - no2;
//			break;
//		case "*":
//			result = no1 * no2;
//			break;
//		default :
//			result = no1 / no2;
//			//break;없어도됨 디폴트가 끝이기때문
//		}
//		return result;
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
