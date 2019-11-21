package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Board;
import model.Condition;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	SqlSession session;
	
	
	public void insertBoard(Board board) {
		session.insert("insertBoard",board);
		
	}

	public List<Board> selectBoardList() {
		return session.selectList("selectBoardList");
	}

	public void deleteBoard(Board board) {
		session.update("deleteBoard",board);
		
	}

	public Board selectLoca(Integer board_location) {
		return session.selectOne("selectLoca",board_location);
	}

	public void twoBoardLocaUpdate(Board newBoard,Board board) {
		Integer tmp=board.getBoard_location();
		Integer tmp2=newBoard.getBoard_location();
		board.setBoard_location(3000);
		session.update("oneBoardLocaUpdate",board);
		newBoard.setBoard_location(tmp);
		session.update("oneBoardLocaUpdate",newBoard);
		board.setBoard_location(tmp2);
		session.update("oneBoardLocaUpdate",board);
	}

	public void oneBoardLocaUpdate(Board board) {
		session.update("oneBoardLocaUpdate",board);
	}

	public Integer selectMaxId() {
		return session.selectOne("selectMaxId");
	}

	public Board selectBoard(Integer board_id) {

		return session.selectOne("selectBoard",board_id);
	}

	public Integer selectMaxloca() {
		return session.selectOne("selectMaxloca");
	}

	public List<Board> selectBoardListByGrade(Condition c) {
		return session.selectList("selectBoardListByGrade",c);
	}

	
}
