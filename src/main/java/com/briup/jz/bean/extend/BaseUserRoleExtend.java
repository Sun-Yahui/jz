package com.briup.jz.bean.extend;

import com.briup.jz.bean.BaseUser;
import com.briup.jz.bean.BaseUserRole;

public class BaseUserRoleExtend extends BaseUserRole{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BaseUser baseUser;

	public BaseUser getBaseUser() {
		return baseUser;
	}

	public void setBaseUser(BaseUser baseUser) {
		this.baseUser = baseUser;
	}
	
	

}
