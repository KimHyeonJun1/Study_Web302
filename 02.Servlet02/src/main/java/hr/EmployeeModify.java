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

@WebServlet("/employee/employeeModify")
public class EmployeeModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//비지니스 로직
		//정보화면에서 전달한 파라미터 사번 꺼내기
		int id = Integer.parseInt(request.getParameter("id")); // String -> int 바꾸는 처리
		
		
		//DB에서 사원정보를 조회해와 수정화면에 출력
		//1.DB연결: DAO
		//2,사원정보 조회 메소드 호출
		HrDAO dao = new HrDAO();
//		dao.employeeInfo(id);
		EmployeeDTO dto = dao.employeeInfo(id);
		
		//응답화면에서 출력에 사용할 정보를 request영역에 attribute로 담기
		request.setAttribute("dto", dto);
		
		//응답화면
		 RequestDispatcher rd = request.getRequestDispatcher("modifyView");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
