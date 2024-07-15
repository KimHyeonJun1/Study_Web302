package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.DeleteCommand;
import customer.InfoCommand;
import customer.InsertCommand;
import customer.ListCommand;
import customer.UpdateCommand;

@WebServlet("*.do")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getServletPath();
		String view = null;
		boolean redirect = false;
		//고객관리화면(고객목록화면) 요청
		if(uri.equals("/list.do")) {
			//비지니스로직
			new ListCommand().exec(request, response);
			
			
			//응답화면 연결
			view = "customer/list.jsp";
		}
		//고객정보화면 요청
		else if(uri.equals("/info.do")) {
			//비지니스로직
			new InfoCommand().exec(request, response);
			 
			//응답화면 연결
			view = "customer/info.jsp";
		}
		//고객정보 수정화면 요청
		else if(uri.equals("/modify.do")) {
			//비지니스로직
			new InfoCommand().exec(request, response);
			//응답화면
			view = "customer/modify.jsp";
		}
		//고객정보 수정저장 처리 요청
		else if(uri.equals("/update.do")) {
			//비지니스로직
			new UpdateCommand().exec(request, response);
			
			//응답화면
			view = "info.do?id=" + request.getParameter("id");
			redirect = true;
		}
		//고객정보 삭제처리 요청
		else if(uri.equals("/delete.do")) {
			//비지니스로직
			new DeleteCommand().exec(request, response);
			//응답화면
			view = "list.do";
			redirect = true;
		}
		//신규고객등록 화면 요청
		else if(uri.equals("/register.do")) {
			
			//응답화면
			view = "customer/register.jsp";
		}
		
			//신규고객 등록처리 요청
		else if(uri.equals("/insert.do")) {
			//비지니스로직
			new InsertCommand().exec(request, response);
			//응답화면
			view = "list.do";
			redirect = true;
			
			
		}
		
		if(redirect) {
			response.sendRedirect(view);
		}else
		request.getRequestDispatcher(view).forward(request, response);
		
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	
}
