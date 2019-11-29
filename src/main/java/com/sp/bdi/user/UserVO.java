package com.sp.bdi.user;

import lombok.Data;

@Data
public class UserVO {
	private String uiName;
	private String active;
	private String uiId;
	private String moddat;
	private String modtim;
	private Integer uiNum;
	private String credat;
	private String cretim;
	private String uiPwd;
	private String[] search;
	private String searchStr;

}
