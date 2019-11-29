package com.sp.bdi.user;

import java.util.List;
import java.util.Map;


public interface UserDAO {

	public List<Map<String,String>> selectUserList();
	
	public List<UserVO> viewUserVOList(UserVO user);
	public List<UserVO> getUserVOList(UserVO user);
	public int insertUserInfo(UserVO user);
	public int updateUserInfo(UserVO user);
	public int deleteUser(UserVO user);
	public UserVO selectUserInfo(UserVO user);
}
