package com.sp.bdi.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired

	private UserDAO udao;
	
	@Override
	public List<Map<String, String>> getUserList() {

		System.out.println(udao.selectUserList());
		
		return udao.selectUserList();
		
	}


	@Override
	public List<UserVO> getUserVOList (UserVO user) {
		// TODO Auto-generated method stub
		return udao.getUserVOList(user);
	}


	@Override
	public Map<String, String> insertUserInfo(UserVO user) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("cnt", udao.insertUserInfo(user)+"");
		
		int result =udao.insertUserInfo(user);
		
		if(result==1) {
			rMap.put("msg", "게시물 저장 완료.");
		}else {
			rMap.put("msg", "게시물 저장 실패.");
		}
			
		return rMap;
	}


	@Override
	public Map<String, String> updateUserInfo(UserVO user) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("cnt", udao.updateUserInfo(user)+"");
		return rMap;
	}


	@Override
	public List<UserVO> viewUserVOList(UserVO user) {
				return udao.viewUserVOList(user);
	}


	@Override
	public Map<String, String> deleteUser(UserVO user) {
		Map<String, String> rMap = new HashMap<String,String>();
		System.out.println("=======service_delete===="+udao.deleteUser(user));
		rMap.put("cnt", udao.deleteUser(user)+"");
		return rMap;
		}


	@Override
	public UserVO login(UserVO user) {
		return udao.selectUserInfo(user);
		 
	}
	
	
		
	}


	


