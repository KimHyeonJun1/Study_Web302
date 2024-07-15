package hr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeDTO;
import model.HrDAO;

@WebServlet("/employee/employeeUpdate")
public class EmployeeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//비지니스로직
		//수정화면에서 변경입력한 정보를 수집하기
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployee_id (Integer.parseInt(request.getParameter("employee_id")));
		dto.setLast_name(request.getParameter("last_name"));
		dto.setFirst_name(request.getParameter("first_name"));
		//.....
		
		//수집된 정보로 DB에 변경저장하기: DB연결 - 변경저장메소드를 호출
		HrDAO dao = new HrDAO();
		dao.employeeUpdate(dto);
	
		//응답화면: 정보화면으로 연결
//		request.getRequestDispatcher("employeeInfo?id=" + dto.getEmployee_id())
//		.forward(request, response);;
		response.sendRedirect("employeeInfo?id=" + dto.getEmployee_id());
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
