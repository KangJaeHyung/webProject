package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.User_info;

@Controller
public class HomeController {

	@RequestMapping(value="/home/userPage.html")
	public ModelAndView userPage() {
		ModelAndView mav = new ModelAndView("home/main");
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
