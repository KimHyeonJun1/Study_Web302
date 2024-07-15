package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.TodayCommand;

@WebServlet("*.do")
public class MybatisController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uri = request.getServletPath();
		String view = null;
		boolean redirect = false;
		
		//테스트화면 요청
		if(uri.equals("/test.do")) {
			new TodayCommand().exec(request, response);
			
			view = "test.jsp";
		}
		
		if(redirect) 
			response.sendRedirect(view);
			else  
				request.getRequestDispatcher(view)
				.forward(request,response);
			
		}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
