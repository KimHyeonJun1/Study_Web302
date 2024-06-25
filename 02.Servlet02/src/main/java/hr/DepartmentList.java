package hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentDTO;
import model.EmployeeDTO;
import model.HrDAO;

@WebServlet("/employee/departmentList")
public class DepartmentList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB에서 부서목록을 조회해오기
		HrDAO dao = new HrDAO();
		ArrayList<DepartmentDTO> list = dao.departmentList();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<div><a href='../'>홈화면</a></div>");
		out.print("<div><a href='index.html'>부서관리</a></div>");
		
		out.print("<hr>");
		
		out.print("<h2>부서목록</h2>");
		
		out.print("<table border='1'>");
		out.print("<colgroup>");
		out.print("<col width=\"100px\">");
		out.print("<col width=\"200px\">");
		out.print("<col width=\"250px\">");
		out.print("<col width=\"250px\">");
		out.print("</colgroup>");
		out.print("<tr><th>부서코드</th><th>부서이름</th><th>매니저 아이디</th><th>지역</th></tr>");
		
		
		for( DepartmentDTO dto : list) {
		out.printf("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>"
				, dto.getDepartment_id(), dto.getDepartment_name(), dto.getManager_id(), dto.getLocation_id()
				
				);
		  
		}
		
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
