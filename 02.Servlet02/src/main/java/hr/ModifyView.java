package hr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeDTO;

@WebServlet("/employee/modifyView")
public class ModifyView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//request 영역에 저장된 dto정보 꺼내기
		EmployeeDTO dto = (EmployeeDTO)request.getAttribute("dto");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<div><a href='../'>홈화면</a></div>");
		out.print("<div><a href='employeeInfo?id="+ dto.getEmployee_id() + "'>사원정보</a></div>");
		out.print("<hr>");
		
		out.print("<h2>사원정보수정</h2>");
		out.print("");
		out.print("<form method = 'post' action='employeeUpdate'>");
		out.print("<table border = '1'>");
		out.print("<colgroup>");
			out.print("<col width='200px'>");
			out.print("<col width='500px'>");
		out.print("</colgroup>");// <input type='text' name=''>
		out.printf("<tr><th>사번</th><td> "
				+ " <input type='text' name='employee_id' value='%s'></td></tr>", dto.getEmployee_id());
		out.printf("<tr><th>사원명</th><td>"
				+ "<input type='text' name='last_name' value='%s'>"
				+ "<input type='text' name='first_name' value='%s'></td></tr>", dto.getLast_name(), dto.getFirst_name());
		out.printf("<tr><th>전화번호</th><td>%s</td></tr>", dto.getPhone_number());
		out.printf("<tr><th>이메일</th><td>%s</td></tr>", dto.getEmail());
		out.printf("<tr><th>입사일자</th><td>%s</td></tr>", dto.getHire_date());
		out.printf("<tr><th>급여</th><td>%s$</td></tr>", dto.getSalary());
		out.printf("<tr><th>부서</th><td>%s</td></tr>", dto.getDepartment_name());
//		out.printf("<tr><th>업무</th><td>%s</td></tr>", dto.getJob_id()); --추가해도 상관없음
		out.printf("<tr><th>업무정보</th><td>%s</td></tr>", dto.getJob_title());

		out.print("</table>");
		out.print("<button>저장하기</button>");
		
		out.print("</form>");
		
		out.print("</body>");
		out.print("</html>");
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
