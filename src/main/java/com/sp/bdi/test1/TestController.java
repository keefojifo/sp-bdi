package com.sp.bdi.test1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sp.bdi.user.UserVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public @ResponseBody Map<String,String> test(){
		Map<String,String> rMap = new HashMap<String,String>();
		return rMap;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Map<String,String> test(@RequestBody List<UserVO> param){
		log.debug("param:{}",param);
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("key", "value");
		return rMap;
	
}
}
