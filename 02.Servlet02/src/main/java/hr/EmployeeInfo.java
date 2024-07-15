package hr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeDTO;
import model.HrDAO;

@WebServlet("/employee/employeeInfo")
public class EmployeeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String --> int 로 변환하는 처리가 필요함
		int employee_id = Integer.parseInt(request.getParameter("id"));
		
		//선택한 사원의 정보를 DB에서 조회해오기
		HrDAO dao = new HrDAO();
		EmployeeDTO dto = dao.employeeInfo(employee_id);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<div><a href='../'>홈화면</a></div>");
		out.print("<div><a href='employeeList'>사원목록</a></div>");
		out.print("<hr>");
		
		out.print("<h2>사원정보</h2>");
		out.print("");
		out.print("<table border = '1'>");
		out.print("<colgroup>");
			out.print("<col width='200px'>");
			out.print("<col width='500px'>");
		out.print("</colgroup>");
		out.printf("<tr><th>사번</th><td>%s</td></tr>", dto.getEmployee_id());
		out.printf("<tr><th>사원명</th><td>%s</td></tr>", dto.getName());
		out.printf("<tr><th>전화번호</th><td>%s</td></tr>", dto.getPhone_number());
		out.printf("<tr><th>이메일</th><td>%s</td></tr>", dto.getEmail());
		out.printf("<tr><th>입사일자</th><td>%s</td></tr>", dto.getHire_date());
		out.printf("<tr><th>급여</th><td>%s$</td></tr>", dto.getSalary());
		out.printf("<tr><th>부서</th><td>%s</td></tr>", dto.getDepartment_name());
//		out.printf("<tr><th>업무</th><td>%s</td></tr>", dto.getJob_id()); --추가해도 상관없음
		out.printf("<tr><th>업무정보</th><td>%s</td></tr>", dto.getJob_title());

		out.print("</table>");
		out.print("<button onclick='location=\"employeeModify?id="+dto.getEmployee_id() +"\"'>정보수정</button>");
// 해볼려다가 포기		out.print("<button onclick='location=\"employeeDelete?id="+dto.getEmployee_id()+"\"'>정보삭제</button>");
		
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
