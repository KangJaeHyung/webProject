package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.ManageCatalog;
import model.Board;
import model.User_info;

@Controller
public class ManageController {
	
	
	@Autowired
	private ManageCatalog manageCatolog; 
	
	
	@RequestMapping(value="/manage/deleteBoard.html")
	public ModelAndView deleteBoard(Integer board_id) {
		ModelAndView mav= new ModelAndView("home/noLogin");
		Board board=manageCatolog.selectBoard(board_id);
		manageCatolog.deleteBoard(board);
		mav.addObject("result", "deleteS");
		return mav;
	}
	
	@RequestMapping(value="/manage/boardList.html")
	public ModelAndView boardList() {
		ModelAndView mav= new ModelAndView("home/boardList");
		List<Board> boardList= manageCatolog.selectBoardList();
		mav.addObject("boardList",boardList);
		return mav;	
	}
	
	@RequestMapping(value="/manage/BoardManage.html")
	public ModelAndView BoardPage(HttpSession session) {
		ModelAndView mav= new ModelAndView("home/main");
		User_info loginUser= (User_info)session.getAttribute("loginUser");
		if(loginUser!=null) {
			if(!loginUser.getUser_stat().equals("M")) {
				mav.addObject("BODY","noLogin.jsp");
				mav.addObject("result","noManager");
				return mav;
			}
		}
		List<Board> boardList= manageCatolog.selectBoardList();
		mav.addObject("boardList",boardList);
		mav.addObject("BODY","boardSetting.jsp");
		mav.addObject(new Board());
		return mav;	
	}
	@RequestMapping(value="/manage/addBoard.html")
	public ModelAndView addBoard(Board board,HttpSession session) {
		ModelAndView mav= new ModelAndView("home/main");
		Board oriBoard=manageCatolog.selectLoca(board.getBoard_location());
		Integer id=manageCatolog.selectMaxId();
		if(id==null) {
			id=0;
		}
		board.setBoard_id(id+1);
		if(oriBoard==null) {
			manageCatolog.insertBoard(board);
			mav.addObject("result","addS");
			mav.addObject("BODY","noLogin.jsp");
		}else {
			session.setAttribute("newBoard", board);
			mav.addObject("BODY","boardChange.jsp");
			mav.addObject(new Board());
			mav.addObject("oriBoard",oriBoard);
		}
		return mav;
	}
	@RequestMapping(value="/manage/changeLoca.html")
	public ModelAndView changeLoca(HttpSession session,Board board) {
		ModelAndView mav = new ModelAndView("home/noLogin");
		Board newBoard = (Board)session.getAttribute("newBoard");
		if(manageCatolog.selectBoard(newBoard.getBoard_id())==null) {
			newBoard.setBoard_id(manageCatolog.selectMaxId()+1);
			newBoard.setBoard_location(manageCatolog.selectBoardLoca()+1);
			manageCatolog.insertBoard(newBoard);
			manageCatolog.twoBoardLocaUpdate(newBoard, board);
			mav.addObject("result","addS");
		}else {
			newBoard=manageCatolog.selectBoard(newBoard.getBoard_id());
			manageCatolog.twoBoardLocaUpdate(newBoard, board);
			mav.addObject("result","addS");
		}
		session.removeAttribute("newBoard");
		return mav;
	}
	
	@RequestMapping(value="/manage/boardUpdate.html")
	public ModelAndView updateBoard(Integer board_id) {
		ModelAndView mav = new ModelAndView("home/main");
		Board board = manageCatolog.selectBoard(board_id);
		mav.addObject(board);
		mav.addObject("BODY","updateBoard.jsp");
		return mav;
	}
	
	@RequestMapping(value="/manage/updateBoard.html")
	public ModelAndView updateBoard(HttpSession session,Board board) {
		ModelAndView mav = new ModelAndView("home/main");
		Board oriBoard=manageCatolog.selectLoca(board.getBoard_location());
		if(oriBoard==null) {
			manageCatolog.oneBoardLocaUpdate(board);
			mav.addObject("result","updateS");
			mav.addObject("BODY","noLogin.jsp");
		}else {
			if(oriBoard.getBoard_id().equals(board.getBoard_id())) {
				manageCatolog.oneBoardLocaUpdate(board);
				mav.addObject("result","updateS");
				mav.addObject("BODY","noLogin.jsp");
			}else {
				session.setAttribute("newBoard", board);
				mav.addObject("BODY","boardChange.jsp");
				mav.addObject(new Board());
				mav.addObject("oriBoard",oriBoard);
			}
		}
		return mav;
	}
	
}
