package board;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardDTO;
import common.Command;

public class UpdateCommand implements Command{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		// 비지니스로직
		// 화면에서 변경입력한 정보 수집하기 -> 변경저장 메소드 호출
		BoardDTO dto = new BoardDTO();
		
		dto.setNumb(Integer.parseInt(request.getParameter("numb")));
		dto.setContent(request.getParameter("content"));
		dto.setSubject(request.getParameter("subject"));
		dto.setEmail(request.getParameter("email"));
		dto.setPassword(request.getParameter("password"));
		dto.setNalja(Date.valueOf(request.getParameter("nalja")));
		
		new BoardDAO().updateBoard(dto);
	}

}
