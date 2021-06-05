package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.BaseUser;
import com.briup.jz.bean.BaseUserRole;
import com.briup.jz.utils.CustomerException;

public interface IUserRoleService {
	
	void saveOrUpdate(BaseUserRole baseUserRole) throws CustomerException;
	
	List<BaseUserRole> query();
	
	void deleteById(long id) throws CustomerException;
	
	

}
