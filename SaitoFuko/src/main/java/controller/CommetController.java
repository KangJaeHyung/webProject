package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.EmoDao;
import logic.PostCatalog;
import model.Comment_post;
import model.User_info;

@Controller
public class CommetController {
	
	@Autowired
	private PostCatalog postCatalog;
	@Autowired
	private EmoDao emoDao;
	
	@RequestMapping(value="/comment/deleteComment.html")
	public ModelAndView deleteComment(Integer comment_no,Integer post_no) {
		ModelAndView mav= new ModelAndView("home/commentResult");
		postCatalog.deleteCommentOne(comment_no);
		mav.setViewName("home/commentResult");
		mav.addObject("post_no",post_no);
		mav.addObject("result","ok");
		return mav;
	}
	
	@RequestMapping(value="/comment/readComment.html")
	public ModelAndView readComment(Integer post_no) {
		ModelAndView mav= new ModelAndView("home/commentPage");
		List<Comment_post> commentList = postCatalog.selectCommentList(post_no);
		for(Comment_post comment: commentList) {
			if(comment.getEmo_id()!=null) {
				comment.setEmo_picture(emoDao.selectEmoticon(comment.getEmo_id()).getEmo_picture());
			}
		}
		mav.addObject("commentList", commentList);
		return mav;
	}
	@RequestMapping(value="/comment/commentWrite.html")
	public ModelAndView commentWrite(String comment_content,HttpSession session,Integer post_no,Integer comment_parent,String emo_id) {
		ModelAndView mav= new ModelAndView();
		User_info loginUser= (User_info)session.getAttribute("loginUser");
		if(loginUser==null) {
			mav.setViewName("home/commentResult");
			mav.addObject("result","noLoginC");
			mav.addObject("post_no",post_no);
			return mav;
		}
		Comment_post comment = new Comment_post();
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		if(comment_content!=null) {
			comment_content=comment_content.replace("\r\n", "<br/>");
		}
		String comment_date = simple.format(date);
		
		comment.setComment_content(comment_content);
		comment.setComment_date(comment_date);
		comment.setComment_no(postCatalog.selectMaxCommentNo()+1);
		if(comment_parent==null) {
			comment.setComment_parent(comment.getComment_no());
		}else {
			comment.setComment_parent(comment_parent);
			Comment_post commentP =	postCatalog.selectComment(comment_parent);
			if(comment.getComment_content()==null) {
				comment.setComment_content("<font color='blue'>RE]"+commentP.getNickname()+"</font>");
			}else {
				comment.setComment_content("<font color='blue'>RE]"+commentP.getNickname()+"</font>"
						+comment.getComment_content());
			}
			
		}
		comment.setEmo_id(emo_id);
		comment.setPost_no(post_no);
		comment.setUser_id(loginUser.getUser_id());
		postCatalog.insertComment(comment);
		mav.addObject("post_no",post_no);
		mav.setViewName("home/commentResult");
		mav.addObject("result","commentS");
		return mav;
	}
	
}
