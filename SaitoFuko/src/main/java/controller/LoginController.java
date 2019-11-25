package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.ShopCatalog;
import logic.UserCatalog;
import model.Have_emo_info;
import model.User_info;

@Controller
public class LoginController {
	@Autowired
	private UserCatalog userCatalog;
	@Autowired
	private ShopCatalog shopCatalog;
	
	@RequestMapping(value="/login/logout.html")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView("home/main");
		session.removeAttribute("loginUser");
		session.removeAttribute("myEmoList");
		return mav;
	}
	
	@RequestMapping(value="/login/mobileLogin.html")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("home/mobileLoginForm");
		mav.addObject(new User_info());
		return mav;
	}
	
	
	@RequestMapping(value="/login/login.html")
	public ModelAndView login(User_info user_info,HttpSession session) {
		ModelAndView mav = new ModelAndView("home/loginResult");
		User_info loginUser=userCatalog.selectUserById(user_info.getUser_id());
		if(loginUser!=null) {
			if(user_info.getPassword().equals(loginUser.getPassword())) {
				if(loginUser.getUser_stat().equals("N")||loginUser.getUser_stat().equals("M")) {
					session.setAttribute("loginUser", loginUser);
					List<Have_emo_info> myEmoList = shopCatalog.selectHaveEmoInfo(loginUser.getUser_id());
					session.setAttribute("myEmoList", myEmoList);
					List<Have_emo_info> cartList = shopCatalog.selectCartEmoInfo(loginUser.getUser_id());
					session.setAttribute("myCartList", cartList);
					mav.addObject("result","yes");
				}else if(loginUser.getUser_stat().equals("B")) {
					mav.addObject("result","banUser");
				}else if(loginUser.getUser_stat().equals("D")) {
					mav.addObject("result","deleteUser");
				}
			}else {
				mav.addObject("result","no");
			}
		}else {
			mav.addObject("result","noAccount");
		}
		return mav;
	}
	
}
