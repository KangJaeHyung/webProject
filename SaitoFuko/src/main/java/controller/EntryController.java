package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.UserCatalog;
import model.User_info;;

@Controller
public class EntryController {
	@Autowired
	private UserCatalog userCatalog;
	
	@RequestMapping(value="/entry/entry.html", method=RequestMethod.POST)
	public ModelAndView entry(User_info user_info) {
		ModelAndView mav= new ModelAndView("home/main");
		user_info.setUser_stat("N");
		userCatalog.insertUser(user_info);
		mav.addObject("BODY","noLogin.jsp");
		mav.addObject("result", "entryS");
		return mav;
		}
	
	@RequestMapping(value="/entry/entryForm.html",method=RequestMethod.GET)
	public ModelAndView entry() {
		ModelAndView mav= new ModelAndView("home/main");
		mav.addObject(new User_info());
		mav.addObject("BODY","userEntryForm.jsp");
		return mav;
	}
}
