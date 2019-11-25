package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.User_info;
import util.Define;

@Controller
public class HomeController {

	@RequestMapping(value="/home/userPage.html")
	public ModelAndView userPage(HttpServletRequest request) {
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
		mav.addObject("BODY","userPage.jsp");
		return mav;
	}
	
	@RequestMapping(value="/home/loginForm.html")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("home/loginForm");
		mav.addObject(new User_info());
		return mav;
	}
	@RequestMapping(value="/home/myEmo.html")
	public ModelAndView myEmoticon(HttpSession session) {
		ModelAndView mav = new ModelAndView("home/myEmoticon");
		User_info loginUser = (User_info) session.getAttribute("loginUser");
		if (loginUser == null) {
			mav.setViewName("home/noLogin");
			mav.addObject("result", "noLogin");
			return mav;
		}
		return mav;
	}
	@RequestMapping(value="/home/cartEmo.html")
	public ModelAndView cartEmoticon(HttpSession session) {
		ModelAndView mav = new ModelAndView("home/cartEmoticon");
		User_info loginUser = (User_info) session.getAttribute("loginUser");
		if (loginUser == null) {
			mav.setViewName("home/noLogin");
			mav.addObject("result", "noLogin");
			return mav;
		}
		return mav;
	}
}
