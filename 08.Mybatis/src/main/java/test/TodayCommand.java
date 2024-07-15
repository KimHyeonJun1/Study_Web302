package test;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.CustomerDTO;
import model.TestDAO;

public class TodayCommand implements Command{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//비지니스로직
		//DB에서 오늘날짜 조회하는 메소드 호출
		TestDAO dao = new TestDAO();
		Date today = dao.getOneToday();
		
		//화면에 출력할 수 있도록 request에 저장하기
		request.setAttribute("today", today);
		
		//DB에서 현재시각을 조회하는 메소드 호출
		String now = dao.getOneNow();
		request.setAttribute("now", now);
		
		CustomerDTO dto = dao.getOneCustomer();
		request.setAttribute("dto", dto);
		
		
		
		
		
		
		
		
	}

}
