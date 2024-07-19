package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import common.Command;

public class DeleteCommand implements Command{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//비지니스로직
		// 선택한 고객정보를 DB에서 삭제하기
		int numb = Integer.parseInt(request.getParameter("numb"));
		new BoardDAO().deleteBoard(numb);
		
	
		
	}

}
