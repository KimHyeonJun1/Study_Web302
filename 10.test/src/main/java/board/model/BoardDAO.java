package board.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import mybatis.MybatisFactory;

public class BoardDAO {
	private SqlSession sql;	
	public BoardDAO() {
		sql = MybatisFactory.getHrInstance();
	}
	// CRUD
	// 게시판 등록하기
	public int registerBoard(BoardDTO dto) {
		return sql.insert("board.registerBoard", dto);
//		 int numb = dto.getNumb();
//		 sql.update("board.initializeCheckNumBoard", numb);
//		 return numb;
	}
	
	
	
	// 게시판 수정
	public int updateBoard(BoardDTO dto) {
		return sql.update("board.updateBoard", dto);
	}
	
	// 게시판 삭제
	public int deleteBoard(int numb) {
		return sql.delete("board.deleteBoard", numb);
	}
	
	// 게시판 정보조회
	public BoardDTO getOneBoard(int numb) {
		BoardDTO dto = sql.selectOne("board.getOneBoard", numb);
		return dto;
	}
	
	// 게시판 목록조회
	public List<BoardDTO> getListOfBoard(){
		List<BoardDTO> list = sql.selectList("board.getListOfBoard");
		return list;
	}
	
	//조회수 변경 메소드
	public void checkNumBoard(int numb){
		sql.update("board.checkNumBoard", numb);
		
	}
	
}
