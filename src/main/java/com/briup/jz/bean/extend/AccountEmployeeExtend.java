package com.briup.jz.bean.extend;

import com.briup.jz.bean.AccountEmployee;
import com.briup.jz.bean.BaseUser;

public class AccountEmployeeExtend extends AccountEmployee{
	private BaseUser baseUser;

	public BaseUser getBaseUser() {
		return baseUser;
	}

	public void setBaseUser(BaseUser baseUser) {
		this.baseUser = baseUser;
	}
	
}
