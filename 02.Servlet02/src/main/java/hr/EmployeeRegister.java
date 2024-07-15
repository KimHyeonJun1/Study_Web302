package hr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeDTO;
import model.HrDAO;

@WebServlet("/employee/employeeRegister")
public class EmployeeRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비지니스 로직
		//화면에서 입력한 정보로 DB에 저장하기
		//파라미터 정보를 수집하기
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
		dto.setLast_name(request.getParameter("last_name"));
		dto.setFirst_name(request.getParameter("first_name")); 
		
		//DB연결
		HrDAO dao = new HrDAO();
		dao.employeeRegister(dto);
		//응답화면 - 사원목록화면으로 연결
//		RequestDispatcher rd = request.getRequestDispatcher("employeeList");
//		rd.forward(request, response);
		response.sendRedirect("employeeList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
