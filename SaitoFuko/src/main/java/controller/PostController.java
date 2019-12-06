package controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.BoardDao;
import logic.PostCatalog;
import model.Board;
import model.Comment_post;
import model.Condition;
import model.Post;
import model.User_info;
import util.Define;

@Controller
public class PostController {
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private PostCatalog postCatalog;

	
	@RequestMapping(value= "/post/postUpdate.html")
	public ModelAndView postUpdate(Post post) {
		ModelAndView mav = new ModelAndView("home/commentResult");
		post.setContent(post.getContent().replaceAll("<img", "<img style='max-width:100%; height:auto;'"));
		postCatalog.updatePost(post);
		mav.addObject("post_no", post.getPost_no());
		mav.addObject("result","updatePost");
		return mav;
	}
	@RequestMapping(value = "/post/updatePostForm.html")
	public ModelAndView updatePostForm(Integer post_no,HttpServletRequest request) {
		String userAgent= (String)request.getHeader("User-Agent");
		 ModelAndView mav= new ModelAndView("home/main");
		 String[] mobileos= Define.mobileos;
	     int j = -1;
	     if(userAgent != null && !userAgent.equals("")){
	          for(int i = 0 ; i<mobileos.length ; i++){
	               j = userAgent.indexOf(mobileos[i]);
	               if(j>  -1){
	            	   mav.setViewName("home/mobile");
	               }
	          }
	     }
		Post post = postCatalog.selectPostDetail(post_no);
		List<Board> boardList = boardDao.selectBoardList();
		post.setContent(post.getContent().replaceAll("<img style='max-width:100%; height:auto;'","<img"));
		mav.addObject(post);
		mav.addObject("boardList",boardList);
		mav.addObject("BODY","postUpdateForm.jsp");
		return mav;
	}
	
	
	
	@RequestMapping(value = "/post/deletePost.html")
	public ModelAndView deletePost(Integer post_no) {
		ModelAndView mav = new ModelAndView("home/noLogin");
		Post p = postCatalog.selectPostDetail(post_no);
		Comment_post comment_post=new Comment_post();
		comment_post.setPost_no(post_no);
		postCatalog.deleteCommentAll(comment_post);
		postCatalog.deletePost(p);
		mav.addObject("result","deletePost");
		return mav;
	}
	
	
	
	@RequestMapping(value = "/post/postRead.html")
	public ModelAndView postRead(Integer post_no, HttpSession session,HttpServletRequest request) {
		String userAgent= (String)request.getHeader("User-Agent");
		 ModelAndView mav= new ModelAndView("home/main");
		 String[] mobileos= Define.mobileos;
	     int j = -1;
	     if(userAgent != null && !userAgent.equals("")){
	          for(int i = 0 ; i<mobileos.length ; i++){
	               j = userAgent.indexOf(mobileos[i]);
	               if(j>  -1){
	            	   mav.setViewName("home/mobile");
	               }
	          }
	     }
		User_info loginUser = (User_info) session.getAttribute("loginUser");
		Post post = postCatalog.selectPostDetail(post_no);
		if (post.getBoard_grade() == 1) {
			post.setPost_views(post.getPost_views()+1);
			postCatalog.updatePost(post);
			mav.addObject("BODY", "postDetail.jsp");
			mav.addObject("post", post);
			
		} else if (post.getBoard_grade() == 2) {
			if (loginUser == null) {
				mav.addObject("BODY", "noLogin.jsp");
				mav.addObject("result", "nologinPost");
			} else{
				post.setPost_views(post.getPost_views()+1);
				postCatalog.updatePost(post);
				mav.addObject("BODY", "postDetail.jsp");
				mav.addObject("post", post);
			}
		}else if (post.getBoard_grade() == 3) {
				if (loginUser==null||!loginUser.getUser_stat().equals("M")) {
					mav.addObject("BODY", "noLogin.jsp");
					mav.addObject("result", "readOnlyManager");
				} else {
					post.setPost_views(post.getPost_views()+1);
					postCatalog.updatePost(post);
					mav.addObject("BODY", "postDetail.jsp");
					mav.addObject("post", post);
				}
			}
		return mav;
	}

	@RequestMapping(value = "/post/postList.html")
	public ModelAndView postList(Integer pageNum, Integer board_id,HttpServletRequest request) {
		String userAgent= (String)request.getHeader("User-Agent");
		 ModelAndView mav= new ModelAndView("home/main");
		 String[] mobileos= Define.mobileos;
	     int j = -1;
	     if(userAgent != null && !userAgent.equals("")){
	          for(int i = 0 ; i<mobileos.length ; i++){
	               j = userAgent.indexOf(mobileos[i]);
	               if(j>  -1){
	            	   mav.setViewName("home/mobile");
	               }
	          }
	     }
		Condition c = new Condition();
		c.setBoard_id(board_id);
		Integer cnt = postCatalog.selectboardCnt(board_id);
		if (cnt == null)
			cnt = 0;
		int startRow = 0;
		int endRow = 0;
		int pageCnt = 1;
		int currentPage = 0;
		if (pageNum == null) {
			currentPage = 1;
			pageNum = 1;
		} else
			currentPage = pageNum;
		if (cnt > 0) {
			pageCnt = cnt / 10;
			if (cnt % 10 > 0)
				pageCnt++;
			startRow = (currentPage - 1) * 10 + 1;
			endRow = currentPage * 10;
			if (endRow > cnt)
				endRow = cnt;
		}
		c.setStartRow(startRow);
		c.setEndRow(endRow);
		List<Post> postList=postCatalog.selectPostList(c);;
		if (board_id !=null) {
			Board board = boardDao.selectBoard(board_id);
			String board_name = board.getBoard_name();
			mav.addObject("board_name", board_name);
		}else {
			mav.addObject("board_name", "전체 게시판");
		}
		mav.addObject("pageCount", pageCnt);
		mav.addObject("pageNum", pageNum);
		mav.addObject("board_id", board_id);
		mav.addObject("postList", postList);
		mav.addObject("BODY", "postList.jsp");
		return mav;
	}

	@RequestMapping(value = "/post/postWrite.html")
	public ModelAndView postWrite(Post post) {
		ModelAndView mav = new ModelAndView("home/commentResult");
		post.setContent(post.getContent().replaceAll("<img", "<img style='max-width:100%; height:auto;'"));
		Integer post_no = postCatalog.selectMaxPostNo();
		post.setPost_no(post_no + 1);
		if (post.getOrigin_no() == null) {
			post.setOrigin_no(0);
			post.setGroup_ord(0);
			post.setGroupLayer(postCatalog.selectMaxGruopLayer() + 1);
		} else {
			post.setOrigin_no(post.getOrigin_no() + 1);
			postCatalog.updateGroupReply(post);
		}
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		String post_date = simple.format(date);
		post.setPost_date(post_date);
		post.setPost_views(0);
		postCatalog.insertPost(post);
		mav.addObject("post_no",post.getPost_no());
		mav.addObject("result", "postUploadS");
		return mav;
	}

	@RequestMapping(value = "/post/imageUpload.html")
	public ModelAndView imageUpload(HttpServletRequest request, MultipartFile img) throws Exception {
		ModelAndView mav = new ModelAndView("home/imageResult");
//		ServletContext context = request.getSession().getServletContext();
//		String filePath = context.getRealPath("/img");
//		String encType="UTF-8";
//		MultipartRequest multipart = new MultipartRequest(request,filePath,5*1024*1024,encType,new DefaultFileRenamePolicy());
//		String pictureName = multipart.getFilesystemName("img");
//		System.out.println(pictureName);
//		mav.addObject("pictureName",pictureName);
		MultipartFile multipartFile = img;
		String fileName = null;
		String path = null;
		OutputStream out = null;
		if (!img.getOriginalFilename().equals("")) {
			UUID uuid = UUID.randomUUID();
			fileName = uuid + multipartFile.getOriginalFilename();

			path = request.getSession().getServletContext().getRealPath("/img/" + fileName);
			System.out.println(path);
			File file = new File(path);
			try {
				out = new FileOutputStream(file);
				BufferedInputStream bis = new BufferedInputStream(multipartFile.getInputStream());
				byte[] buffer = new byte[5 * 1024 * 1024];
				int read = 0;
				while ((read = bis.read(buffer)) > 0) {
					out.write(buffer, 0, read);
				}
				if (out != null)
					out.close();
				if (bis != null)
					bis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		mav.addObject("picture", fileName);
		return mav;
	}

	@RequestMapping(value = "/post/image.html")
	public ModelAndView imagePage() {
		ModelAndView mav = new ModelAndView("home/imagePage");
		return mav;
	}

	@RequestMapping(value = "/post/text.html")
	public ModelAndView test(String text, String title) {
		ModelAndView mav = new ModelAndView("home/main");
		return mav;
	}

	@RequestMapping(value = "/post/PostForm.html")
	public ModelAndView postForm(HttpSession session,Integer board_id,HttpServletRequest request) {
		String userAgent= (String)request.getHeader("User-Agent");
		 ModelAndView mav= new ModelAndView("home/main");
		 String[] mobileos= Define.mobileos;
	     int j = -1;
	     if(userAgent != null && !userAgent.equals("")){
	          for(int i = 0 ; i<mobileos.length ; i++){
	               j = userAgent.indexOf(mobileos[i]);
	               if(j>  -1){
	            	   mav.setViewName("home/mobile");
	               }
	          }
	     }
		User_info loginUser = (User_info) session.getAttribute("loginUser");
		if (loginUser == null) {
			mav.setViewName("home/noLogin");
			mav.addObject("result", "noLoginhome");
			return mav;
		}
		if(board_id!=null) {
		Board board=boardDao.selectBoard(board_id);
		if(loginUser.getUser_stat().equals("N")) {
			if(board.getBoard_grade()==2) {
				
			}else {
				mav.setViewName("home/noLogin");
				mav.addObject("result", "noM");
				return mav;
			}
		}
		}
		Post post = new Post();
		post.setBoard_id(board_id);
		Condition c = new Condition();
		List<Board> boardList = null;
		if (loginUser.getUser_stat().equals("N")) {
			c.setBoard_grade(2);
			boardList = boardDao.selectBoardListByGrade(c);
		}
		if (loginUser.getUser_stat().equals("M")) {
			c.setBoard_grade(2);
			boardList = boardDao.selectBoardList();
		}
		mav.addObject("BODY", "postForm.jsp");
		mav.addObject("boardList", boardList);
		post.setUser_id(loginUser.getUser_id());
		mav.addObject(post);
		return mav;
	}
}
