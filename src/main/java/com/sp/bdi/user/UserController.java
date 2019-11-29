package com.sp.bdi.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {

	@Autowired
	@Qualifier("UserServiceImpl")
	private UserService us;

	@RequestMapping("/user/list")

	public String getUserList(Model model) {

		List<Map<String, String>> param = us.getUserList();

		model.addAttribute("list", param);

		return "user/ajaxlist";
	}

	@RequestMapping(value = "/user/ajaxview", method = RequestMethod.GET)
	public @ResponseBody List<UserVO> viewUserVOList(@ModelAttribute UserVO param) {
		log.debug("param :{}", param);
		System.out.println(us.viewUserVOList(param));
		return us.viewUserVOList(param);

	}

	@RequestMapping(value = "/user/list/ajax", method = RequestMethod.GET)
	public @ResponseBody List<UserVO> getUserVOList(@ModelAttribute UserVO param) {
		log.debug("========select=======param :{}", param);
		return us.getUserVOList(param);
	}

	@RequestMapping(value = "/user/ajaxinsert", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> insertUserVOList(@RequestBody UserVO user) {
		log.debug("user :{}", user);
		return us.insertUserInfo(user);
	}

	@RequestMapping(value = "/user/ajaxupdate", method = RequestMethod.PUT)
	public @ResponseBody Map<String, String> updateUserVOList(@RequestBody UserVO user) {
		log.debug("user :{}", user);
		return us.updateUserInfo(user);
	}

	@RequestMapping(value = "/user/ajaxdelete", method = RequestMethod.DELETE)
	public @ResponseBody Map<String, String> deleteUser(@RequestBody UserVO user) {
		log.debug("========delete=======user :{}", user);
		return us.deleteUser(user);
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public @ResponseBody UserVO login(@RequestBody UserVO user,HttpSession hs) {
		
		log.debug("user :{}", user);
		user =us.login(user);
		log.debug("========select=======user :{}", user);
		if(user!=null) {
			hs.setAttribute("user", user);
		}
		return user;
	}

}
