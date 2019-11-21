package logic;

import java.util.List;

import model.Board;

public interface ManageCatalog {
	Board selectLoca(Integer board_location);
	void twoBoardLocaUpdate(Board newBoard,Board board);
	void oneBoardLocaUpdate(Board board);
	void insertBoard(Board board);
	List<Board> selectBoardList();
	void deleteBoard(Board board);
	Integer selectMaxId();
	Board selectBoard(Integer board_id);
	Integer selectBoardLoca();
}
