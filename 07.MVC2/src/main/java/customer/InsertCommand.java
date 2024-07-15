package customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.CustomerDAO;
import model.CustomerDTO;

public class InsertCommand implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
			//비지니스 로직
		//화면에서 입력한 정보로 DB에 신규저장
		//화면에서 입력한 정보 수집하기
		CustomerDTO dto = new CustomerDTO();
		dto.setEmail(request.getParameter("email"));
		dto.setGender(request.getParameter("gender"));
		dto.setName(request.getParameter("name"));
		dto.setPhone(request.getParameter("phone"));
		
		//DB에 신규저장처리 메소드 호출
		new CustomerDAO().registerCustomer(dto);
		
	}

}
