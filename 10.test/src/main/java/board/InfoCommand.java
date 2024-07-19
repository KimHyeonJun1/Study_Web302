package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardDTO;
import common.Command;

public class InfoCommand implements Command{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//비지니스로직
		//선택한 게시판을 DB에서 조회해오기
		
		    int numb = Integer.parseInt(request.getParameter("numb"));
		
		    BoardDTO dto = new BoardDAO().getOneBoard(numb);
		
		//checknumBoard
		    
		  new BoardDAO().checkNumBoard(numb);
		  
		//화면에 출력할수 있게 request에 저장하기
		request.setAttribute("dto", dto);
		
	}

}
