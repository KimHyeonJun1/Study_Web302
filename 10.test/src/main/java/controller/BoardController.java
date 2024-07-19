package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.DeleteCommand;
import board.InfoCommand;
import board.InsertCommand;
import board.ListCommand;
import board.UpdateCommand;

@WebServlet("*.mo")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getServletPath();
		String view = null;
		boolean redirect = false;
	//게시판 목록화면 요청
	if(uri.equals("/list.mo")) {
		//비지니스로직
		new ListCommand().exec(request, response);
		
		//응답화면
		view = "board/list.jsp";
	}
	//게시판 정보화면 요청
	else if(uri.equals("/info.mo")) {
		//비지니스로직
		new InfoCommand().exec(request, response);
		
		//응답화면
		view = "board/info.jsp";
	}
	//게시판 수정화면 요청
	else if(uri.equals("/modify.mo")) {
		//비지니스로직
		new InfoCommand().exec(request, response);
		
		//응답화면
		view = "board/modify.jsp";
	}
	//게시판 수정저장 처리 요청
	else if(uri.equals("/update.mo")) {
		//비지니스로직
		new UpdateCommand().exec(request, response);
		
		//응답화면
		view = "info.mo?numb=" + request.getParameter("numb");
		redirect = true;
	}
	//게시판 삭제처리 요청
	else if(uri.equals("/delete.mo")) {
		//비지니스로직
		new DeleteCommand().exec(request, response);
		
		//응답화면
		redirect = true;
		view = "list.mo";
	}
	
	//신규게시판 등록화면 요청
	else if(uri.equals("/register.mo")) {
		//응답화면
		view = "board/register.jsp";
		
	}
	//신규게시판 신규저장 처리 요청
	else if(uri.equals("/insert.mo")) {
		//비지니스로직
		new InsertCommand().exec(request, response);
		
		//응답화면
		view = "list.mo";
		redirect = true;
	}
	
	
	
		if(redirect)
			response.sendRedirect(view);
		else
			request.getRequestDispatcher(view).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
