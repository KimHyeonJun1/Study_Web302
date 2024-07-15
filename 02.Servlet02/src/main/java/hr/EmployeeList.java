package hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeDTO;
import model.HrDAO;


@WebServlet("/employee/employeeList")
public class EmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//DB에서 사원목록을 조회해오기
		HrDAO dao = new HrDAO();
		ArrayList<EmployeeDTO> list = dao.employeeList();
		
		//프리젠테이션로직
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<div><a href='../'>홈화면</a></div>");
		out.print("<div><a href='index.html'>사원관리</a></div>");
		
		out.print("<hr>");
		
		out.print("<h2>사원목록</h2>");
		
		out.print("<table border='1'>");
		out.print("<colgroup>");
		out.print("<col width=\"100px\">");
		out.print("<col width=\"200px\">");
		out.print("<col width=\"250px\">");
		out.print("<col width=\"250px\">");
		out.print("<col width=\"150px\">");
		out.print("</colgroup>");
		out.print("<tr><th>사번</th><th>성명</th><th>부서</th><th>업무</th><th>입사일자</th></tr>");
		
		
		for( EmployeeDTO dto : list) {
		out.printf("<tr><td>%s</td><td><a href='employeeInfo?id=%s'>%s</a></td><td>%s</td><td>%s</td><td>%s</td></tr>"
				, dto.getEmployee_id(), dto.getEmployee_id(), dto.getName(), dto.getDepartment_id(), dto.getJob_id(), dto.getHire_date()
				
				);
		  
		}
		
		out.print("</table>");
		
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
