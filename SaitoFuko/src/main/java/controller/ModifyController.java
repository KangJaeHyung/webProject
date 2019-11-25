package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.UserCatalog;
import model.User_info;
import util.Define;

@Controller
public class ModifyController {

	@Autowired
	private UserCatalog userCatalog;
	@RequestMapping(value="modify/modifyForm.html")
	public ModelAndView modifyForm(String form,HttpServletRequest request) {
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
		mav.addObject("BODY","userModify.jsp");
		mav.addObject("form",form);
		return mav;
	}
	@RequestMapping(value="/modify/userModifyForm.html")
	public ModelAndView userModifyForm(String password, String form,HttpSession session,HttpServletRequest request) {
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
		
		User_info user=(User_info)session.getAttribute("loginUser");
		if(user.getPassword().equals(password)) {
			mav.addObject(new User_info());
			mav.addObject("BODY","userModifyForm.jsp");
			mav.addObject("form",form);
		}else {
			mav.addObject(new User_info());
			mav.addObject("BODY","userModifyForm.jsp");
			mav.addObject("form","no");
		}
		return mav;
	}
	@RequestMapping(value="/modify/delete.html")
	public ModelAndView deleteUser(HttpServletRequest request) {
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
		mav.addObject("BODY","deleteForm.jsp");
		return mav;
	}
	
	@RequestMapping(value="/modify/deleteConfirm.html")
	public ModelAndView deleteConfirm(HttpSession session,HttpServletRequest request) {
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
		User_info user= (User_info)session.getAttribute("loginUser");
		user.setUser_stat("D");
		session.removeAttribute("loginUser");
		userCatalog.updateUserStat(user);
		return mav;
	}
	
	
	@RequestMapping(value="/modify/modifyUser.html")
	public ModelAndView modifyUser(User_info user_info,HttpSession session,HttpServletRequest request) {
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
		User_info user=(User_info)session.getAttribute("loginUser");
		user_info.setUser_id(user.getUser_id());
		if(user_info.getBirthday()==null) {
			user_info.setBirthday(user.getBirthday());
		}
		if(user_info.getEmail()==null) {
			user_info.setEmail(user.getEmail());
		}
		if(user_info.getGender()==null) {
			user_info.setGender(user.getGender());
		}
		if(user_info.getNickname()==null) {
			user_info.setNickname(user.getNickname());
		}
		if(user_info.getPassword()==null) {
			user_info.setPassword(user.getPassword());
		}
		if(user_info.getUser_name()==null) {
			user_info.setUser_name(user.getUser_name());
		}
		userCatalog.updateUser(user_info);
		User_info loginUser= userCatalog.selectUserById(user.getUser_id());
		session.setAttribute("loginUser", loginUser);
		mav.addObject("BODY","modifyResult.jsp");
		return mav;
	}
	
}
