package board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardDTO;
import common.Command;

public class ListCommand implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//비지니스로직
		// DB에서 고객목록을 조회해오기
		List<BoardDTO> list = new BoardDAO().getListOfBoard();
		
		//화면에 출력할 수 있도록 request에 저장하기
		request.setAttribute("list", list);
	}

}
