package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.ShopCatalog;
import model.Condition;
import model.Emo_cart;
import model.Emoticon_info;
import model.Emoticon_sale;
import model.Have_emo_info;
import model.Have_emoticon;
import model.Refund_emoticon;
import model.User_info;
import util.Define;

@Controller
public class ShopController {

	@Autowired
	private ShopCatalog shopCatalog;
	
	@RequestMapping(value="/shop/refundEmo.html")
	public ModelAndView refundEmo(HttpSession session,String emo_id) {
		ModelAndView mav = new ModelAndView("home/refundResult");
		User_info loginUser= (User_info)session.getAttribute("loginUser");
		try {
			Emoticon_sale sale= new Emoticon_sale();
			sale.setEmo_id(emo_id);
			sale.setUser_id(loginUser.getUser_id());
			String code=shopCatalog.selectOrdCode(sale);
			Date date = new Date();
			SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String refund_date =sdf.format(date);
			Refund_emoticon refund =new Refund_emoticon();
			refund.setEmo_order_code(code);
			refund.setRefund_date(refund_date);
			shopCatalog.refundEmoticon(refund);
			Have_emoticon have= new Have_emoticon();
			have.setEmo_id(emo_id);
			have.setUser_id(loginUser.getUser_id());
			shopCatalog.deleteHaveEmo(have);
			List<Have_emo_info> myEmoList = shopCatalog.selectHaveEmoInfo(loginUser.getUser_id());
			session.setAttribute("myEmoList", myEmoList);
			mav.addObject("result", "yes");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("result", "no");
		}
			return mav;
		
	}
	
	
	@RequestMapping(value="/shop/emoBuyResult.html")
	public ModelAndView buyResult(HttpSession session) {
		ModelAndView mav = new ModelAndView("home/emoBuyResult");
		User_info loginUser= (User_info)session.getAttribute("loginUser");
		List<Have_emo_info> emoList= (List<Have_emo_info>)session.getAttribute("emoCart");
		try {
			for(Have_emo_info emo:emoList) {
				String emo_id=emo.getEmo_id();
				Integer num =Integer.parseInt(shopCatalog.getSaleId().split("SA")[1])+1;
				String emo_order_code = "SA"+String.format("%04d", num);
				Date date = new Date();
				SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String order_date =sdf.format(date);
				Integer price= emo.getEmo_price();
				String user_id = loginUser.getUser_id();
	 			Emoticon_sale sale = new Emoticon_sale();
	 			sale.setEmo_id(emo_id);
	 			sale.setEmo_order_code(emo_order_code);
	 			sale.setOrder_date(order_date);
	 			sale.setPrice(price);
	 			sale.setUser_id(user_id);
	 			Have_emoticon have= new Have_emoticon();
	 			have.setEmo_id(emo_id);
	 			have.setUser_id(user_id);
				shopCatalog.buyEmoticon(sale);
				shopCatalog.intsertHaveEmo(have);
				session.removeAttribute("emoCart");
				mav.addObject("result","ok");
				List<Have_emo_info> myEmoList = shopCatalog.selectHaveEmoInfo(loginUser.getUser_id());
				session.setAttribute("myEmoList", myEmoList);
				
				Emo_cart emo_cart=new Emo_cart();
				emo_cart.setEmo_id(emo_id);
				emo_cart.setUser_id(loginUser.getUser_id());
				shopCatalog.outCart(emo_cart);
				List<Have_emo_info> cartList = shopCatalog.selectCartEmoInfo(loginUser.getUser_id());
				session.setAttribute("myCartList", cartList);
			}
			return mav;
		}catch (Exception e) {
				e.printStackTrace();
				mav.addObject("result","no");
				return mav;
		}
	}
	
	
	@RequestMapping(value = "/shop/buyEmo.html")
	public ModelAndView buyEmo(String emo_id,HttpSession session) {
		ModelAndView mav = new ModelAndView("home/emoBuy");
		User_info loginUser = (User_info) session.getAttribute("loginUser");
		if (loginUser == null) {
			mav.addObject("result", "noLogin");
			return mav;
		}
		if(emo_id!=null) {
			Emoticon_info emoticon_info = shopCatalog.selectEmoticon(emo_id);
			Have_emo_info have=new Have_emo_info();
			have.setEmo_id(emoticon_info.getEmo_id());
			have.setEmo_info(emoticon_info.getEmo_info());
			have.setEmo_name(emoticon_info.getEmo_name());
			have.setEmo_picture(emoticon_info.getEmo_picture());
			have.setEmo_price(emoticon_info.getEmo_price());
			List<Have_emo_info> emoList=new ArrayList<Have_emo_info>();
			emoList.add(have);
			mav.addObject("emoList", emoList);
			session.setAttribute("emoCart", emoList);
		}else {
			List<Have_emo_info> emoList=shopCatalog.selectCartEmoInfo(loginUser.getUser_id());
			mav.addObject("emoList",emoList);
			session.setAttribute("emoCart", emoList);
		}
		return mav;
	}

	@RequestMapping(value="/shop/outCartEmoPage.html")
	public ModelAndView outCartEmoPage(HttpSession session, String emo_id) {
		ModelAndView mav = new ModelAndView("home/cartEmoticon");
		Emo_cart emo_cart = new Emo_cart();
		User_info loginUser = (User_info) session.getAttribute("loginUser");
		List<Emo_cart> cart = shopCatalog.selectEmoCart(loginUser.getUser_id());
		for (Emo_cart c : cart) {
			if (c.getEmo_id().equals(emo_id) && c.getUser_id().equals(loginUser.getUser_id())) {
				emo_cart.setEmo_id(emo_id);
				emo_cart.setUser_id(loginUser.getUser_id());
				shopCatalog.outCart(emo_cart);
				mav.addObject("result", "outYes");
				List<Have_emo_info> cartList = shopCatalog.selectCartEmoInfo(loginUser.getUser_id());
				session.setAttribute("myCartList", cartList);
				return mav;
			}
		}
		mav.addObject("result", "haveCart");
		return mav;
	}
	
	
	@RequestMapping(value = "/shop/inCartEmo.html")
	public ModelAndView inCartEmo(HttpSession session, String emo_id, Integer pageNum, HttpServletRequest request) {
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
		mav.addObject("pageNum",pageNum);
		Emo_cart emo_cart = new Emo_cart();
		User_info loginUser = (User_info) session.getAttribute("loginUser");
		if (loginUser == null) {
			mav.setViewName("home/emoResult");
			mav.addObject("result", "noLogin");
			return mav;
		}

		List<Emo_cart> cart = shopCatalog.selectEmoCart(loginUser.getUser_id());
		for (Emo_cart c : cart) {
			if (c.getEmo_id().equals(emo_id) && c.getUser_id().equals(loginUser.getUser_id())) {
				mav.addObject("BODY", "emoResult.jsp");
				mav.addObject("result", "haveCart");
				return mav;
			}
		}
		emo_cart.setEmo_id(emo_id);
		emo_cart.setUser_id(loginUser.getUser_id());
		shopCatalog.inCart(emo_cart);
		mav.addObject("BODY", "emoResult.jsp");
		mav.addObject("result", "inYes");
		List<Have_emo_info> cartList = shopCatalog.selectCartEmoInfo(loginUser.getUser_id());
		session.setAttribute("myCartList", cartList);
		return mav;
	}

	@RequestMapping(value = "/shop/outCartEmo.html")
	public ModelAndView outCartEmo(HttpSession session, String emo_id, Integer pageNum) {
		ModelAndView mav = new ModelAndView("home/main");
		
		
		
		Emo_cart emo_cart = new Emo_cart();
		mav.addObject("pageNum",pageNum);
		User_info loginUser = (User_info) session.getAttribute("loginUser");
		if (loginUser == null) {
			mav.setViewName("home/emoResult");
			mav.addObject("result", "noLogin");
			return mav;
		}
		List<Emo_cart> cart = shopCatalog.selectEmoCart(loginUser.getUser_id());
		for (Emo_cart c : cart) {
			if (c.getEmo_id().equals(emo_id) && c.getUser_id().equals(loginUser.getUser_id())) {
				emo_cart.setEmo_id(emo_id);
				emo_cart.setUser_id(loginUser.getUser_id());
				shopCatalog.outCart(emo_cart);
				mav.addObject("BODY", "emoResult.jsp");
				mav.addObject("result", "outYes");
				return mav;
			}
		}
		mav.addObject("BODY", "emoResult.jsp");
		mav.addObject("result", "haveCart");
		return mav;
	}

	@RequestMapping(value = "/shop/shopPage.html")
	public ModelAndView shopPage(HttpServletRequest request,Integer pageNum, HttpSession session) {
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
		Integer cnt = shopCatalog.selectEmoCount();
		if (cnt == null)
			cnt = 0;
		int startRow = 0;
		int endRow = 0;
		int pageCnt = 0;
		int currentPage = 0;
		if (pageNum == null) {
			currentPage = 1;
			pageNum = 1;
		} else
			currentPage = pageNum;
		
		User_info loginUser = (User_info) session.getAttribute("loginUser");
		if (cnt > 0) {
			pageCnt = cnt / 12;
			if (cnt % 12 > 0)
				pageCnt++;
			startRow = (currentPage - 1) * 12 + 1;
			endRow = currentPage * 12;
			if (endRow > cnt)
				endRow = cnt;
		}
		c.setStartRow(startRow);
		c.setEndRow(endRow);
		List<Have_emoticon> list;
		if(loginUser==null) {
			list= null;
		}else {
			list= shopCatalog.selectHaveEmoticon(loginUser.getUser_id());
		}
		if(list==null||list.isEmpty()) {
			c.setHave_emoticon(null);
		}else {
			c.setHave_emoticon(list);
			pageCnt = (cnt-list.size())/ 12;
			if (cnt % 12 > 0) pageCnt++;
		}
		List<Emoticon_info> emoList = shopCatalog.selectEmoticonList(c);
		
		if (loginUser != null) {
			List<Emo_cart> emo_cart = shopCatalog.selectEmoCart(loginUser.getUser_id());
			for (Emoticon_info e : emoList) {
				for (Emo_cart cart : emo_cart) {
					if (e.getEmo_id().equals(cart.getEmo_id())) {
						
						break;
					}
				}
				for (Emo_cart cart : emo_cart) {
					if (e.getEmo_id().equals(cart.getEmo_id())) {
						e.setEmo_cart(true);
						break;
					}
				}
			}
		}
		mav.addObject("BODY", "shopPage.jsp");
		mav.addObject("pageCount", pageCnt);
		mav.addObject("emoList", emoList);
		mav.addObject("pageNum", pageNum);
		return mav;
	}
}
