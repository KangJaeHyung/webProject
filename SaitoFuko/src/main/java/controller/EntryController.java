package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.UserCatalog;
import model.User_info;
import util.Define;;

@Controller
public class EntryController {
	@Autowired
	private UserCatalog userCatalog;
	
	@RequestMapping(value="/entry/entry.html", method=RequestMethod.POST)
	public ModelAndView entry(User_info user_info,HttpServletRequest request) {
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
		user_info.setUser_stat("N");
		userCatalog.insertUser(user_info);
		mav.addObject("BODY","noLogin.jsp");
		mav.addObject("result", "entryS");
		return mav;
		}
	
	@RequestMapping(value="/entry/entryForm.html",method=RequestMethod.GET)
	public ModelAndView entry(HttpServletRequest request) {
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
		mav.addObject(new User_info());
		mav.addObject("BODY","userEntryForm.jsp");
		return mav;
	}
}
