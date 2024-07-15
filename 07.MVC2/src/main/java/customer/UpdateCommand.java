package customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.CustomerDAO;
import model.CustomerDTO;

public class UpdateCommand implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//비지니스로직
		//화면에서 입력한 정보 수집-DTO
		CustomerDTO dto = new CustomerDTO();
		dto.setEmail(request.getParameter("email"));
		dto.setGender(request.getParameter("gender"));
		dto.setName(request.getParameter("name"));
		dto.setPhone(request.getParameter("phone"));
		dto.setId( Integer.parseInt(request.getParameter("id")));
		
		//수집한 정보로 DB에 변경저장하기 - DAO의 처리메소드 호출
		CustomerDAO dao = new CustomerDAO();
		dao.updateCustomer(dto);
		
		//
		
		
	}

}









