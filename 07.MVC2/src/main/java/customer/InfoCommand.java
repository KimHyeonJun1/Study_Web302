package customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.CustomerDAO;
import model.CustomerDTO;

public class InfoCommand implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
			//비지니스로직
		int id = Integer.parseInt(request.getParameter("id"));
			//DB에서 선택한 고객정보를 DB에서 조회해오기 - 해당 메소드 호출
			CustomerDAO	dao = new CustomerDAO();
			CustomerDTO dto = dao.getOneCustomer(id);
			
			//화면에 출력할 수 있도록 request 에 저장하기
			request.setAttribute("dto", dto);
			
		
		
		
		
		
		
		
		
		
		
		
	}

}
