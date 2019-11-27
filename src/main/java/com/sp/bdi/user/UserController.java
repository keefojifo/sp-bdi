package com.sp.bdi.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {

	@Autowired
	@Qualifier("UserServiceImpl")
	private UserService us;
	
	@RequestMapping("/user/list")
	

	public String getUserList( Model model) {
		
		
		List<Map<String,String>> param = us.getUserList();
		
		model.addAttribute("list",param);
		/*request.setAttribute("list", param);
		RequestDispatcher rd =request.getRequestDispatcher(path);
		rd.forward(request, response);*/
		
		return "user/ajaxlist";
	}
	
	@RequestMapping("/user/list/ajax")
	public  @ResponseBody List<UserVO> getUserVOList(){
		return us.getUserVOList();
	}
	
	
	
	
}
