package dao;

import java.util.List;

import model.Board;
import model.Condition;

public interface BoardDao {
	Integer selectMaxId();
	Board selectBoard(Integer board_id);
	Board selectLoca(Integer board_location);
	void twoBoardLocaUpdate(Board newBoard,Board board);
	void oneBoardLocaUpdate(Board board);
	void insertBoard(Board board);
	List<Board> selectBoardList();
	void deleteBoard(Board board);
	Integer selectMaxloca();
	List<Board> selectBoardListByGrade(Condition c);
}
