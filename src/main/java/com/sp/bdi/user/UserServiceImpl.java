package com.sp.bdi.user;

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
	public List<UserVO> getUserVOList() {
		// TODO Auto-generated method stub
		return udao.getUserVOList();
	}

}
