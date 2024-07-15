package customer;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.CustomerDAO;
import model.CustomerDTO;

public class ListCommand implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		//DB에서 고객목록을 조회해와 화면에 출력할 수 있게 request에 저장하기
		//처리하는 DAO의 메소드 호출
		CustomerDAO dao = new CustomerDAO();
		ArrayList<CustomerDTO> list = dao.getListOfcustomer();
		
		request.setAttribute("list", list);
	}

}







