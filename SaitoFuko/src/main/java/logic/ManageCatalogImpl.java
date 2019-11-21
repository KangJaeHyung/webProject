package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDao;
import model.Board;

@Service
public class ManageCatalogImpl implements ManageCatalog {
	
	@Autowired
	BoardDao boardDao;
	public Board selectLoca(Integer board_location) {
		return boardDao.selectLoca(board_location);
	}

	public void twoBoardLocaUpdate(Board newBoard,Board board) {
		boardDao.twoBoardLocaUpdate(newBoard,board);
		
	}

	public void oneBoardLocaUpdate(Board board) {
		boardDao.oneBoardLocaUpdate(board);
		
	}

	public void insertBoard(Board board) {
		boardDao.insertBoard(board);
		
	}

	public List<Board> selectBoardList() {
		return boardDao.selectBoardList();
	}

	public void deleteBoard(Board board) {
		boardDao.deleteBoard(board);
	}
	public Integer selectMaxId() {
		return boardDao.selectMaxId();
	}

	public Board selectBoard(Integer board_id) {
	
		return boardDao.selectBoard(board_id);
	}

	public Integer selectBoardLoca() {
		return boardDao.selectMaxloca();
	}
	
}
