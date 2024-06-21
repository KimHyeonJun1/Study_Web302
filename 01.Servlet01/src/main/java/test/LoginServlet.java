package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		System.out.println("로그인요청");
		//비지니스로직 처리
		//클라이언트의 요청에 의해 전송된 파라미터는 request 에 있다!
		//주소창을 통해 전달된 파라미터는 문자열
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println(id);
		System.out.println(pw);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<ul>");
		
		out.print("<li><a href='index.html'>홈으로</a></li>");
		out.print("<li><a href='loginForm.html'>로그인화면</a></li>");
		out.print("</ul>");
		out.print("<hr>");
		
		out.printf("<div>Request: %s</div>", request.getAttribute("request"));
		out.printf("<div>Session: %s</div>", request.getSession().getAttribute("session"));
		out.printf("<div>Application: %s</div>", getServletContext().getAttribute("app"));
		
		out.print("<h2>로그인정보</h2>");
		out.printf("<div>아이디: %s</div>",id);
		out.printf("<div>패스워드: %s</div>",pw);
		
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
