package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.UserCatalog;
import model.User_info;

@Controller
public class IdCheckController {
	@Autowired
	private UserCatalog UserCatalog;
	
	@RequestMapping(value="/idcheck/idcheck.html")
	public ModelAndView idCheck(String user_id) {
		ModelAndView mav = new ModelAndView("home/idCheck");
		User_info user=UserCatalog.selectUserById(user_id);
		if(user==null) {
			mav.addObject("DUP","NO");
		}else {
			mav.addObject("DUP","YES");		
		}
		mav.addObject("user_id",user_id);
		return mav;
	}
}
