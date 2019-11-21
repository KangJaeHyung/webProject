package controller;

import java.io.File;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.UserCatalog;
import model.User_info;

@Controller
public class FindController {

	@Autowired
	private UserCatalog userCatalog;
	@Autowired
	private JavaMailSenderImpl mailSender;

	@RequestMapping(value = "/find/findIdForm.html")
	public ModelAndView findIdForm() {
		ModelAndView mav = new ModelAndView("home/main");
		mav.addObject("BODY", "findId.jsp");
		mav.addObject(new User_info());
		return mav;

	}

	@RequestMapping(value = "/find/findPasswordForm.html")
	public ModelAndView findIdPassword() {
		ModelAndView mav = new ModelAndView("home/main");
		mav.addObject("BODY", "findPassword.jsp");
		mav.addObject(new User_info());
		return mav;

	}

	@RequestMapping(value = "/find/findId.html")
	public ModelAndView findId(User_info user_info) {
		ModelAndView mav = new ModelAndView("home/main");
		List<String> userList = userCatalog.selectUserIdByNameAndEmail(user_info);
		if (userList.isEmpty()) {
			mav.addObject("result", "noUser");
		} else if (userList.size() >= 2) {
			mav.addObject("result", "multipleUser");
			mav.addObject("userList", userList);
		} else {
			mav.addObject("result", "oneUser");
			mav.addObject("user", userList.get(0));
		}
		mav.addObject("BODY", "findIdResult.jsp");
		return mav;
	}

	@RequestMapping(value = "/find/findPassword.html")
	public ModelAndView findPassword(final User_info user_info) {
		ModelAndView mav = new ModelAndView("home/main");
		final String password = userCatalog.selectUserPassword(user_info);
		if(password!=null) {
			final MimeMessagePreparator preparator = new MimeMessagePreparator() {
				public void prepare(MimeMessage mimeMessage) throws Exception {
					final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
					helper.setFrom("Fuko <rkdwo321@naver.com>");
					helper.setTo(user_info.getEmail());
					helper.setSubject("안녕하세요. SaitoFuko입니다.");
					String text= "<img alt='' src='cid:title.png'><br/>";
					text=text+"<h3>"+user_info.getUser_name()+" 님의 비밀번호는</h3><br/>";
					text=text+"<h1><font color='red' style='font:bold;'>"+password+"</font><h1/>";
					text=text+"<br/><h3>입니다.</h3><br/>";
					text=text+"<p align='right'><a href=''>홈페이지로 가기</a></p>";
					helper.setText(text, true);
					FileSystemResource file = new FileSystemResource(new File("E:/title.png"));
					helper.addInline("title.png", file);
				}
			};
			mailSender.send(preparator);
			mav.addObject("result","ok");
		}else {
			mav.addObject("result","no");
		}
		mav.addObject("BODY","findPwdResult.jsp");
		return mav;
	}

}
