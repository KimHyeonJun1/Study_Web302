package hr;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.EmployeeDTO;
import model.HrDAO;

public class EmployeeListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 비지니스 로직처리
		HrDAO dao = new HrDAO();
		ArrayList<EmployeeDTO> list = dao.listOfEmployee();
		request.setAttribute("list", list);

	}

}
