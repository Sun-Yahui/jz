package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.BaseRole;
import com.briup.jz.bean.BaseRolePrivilege;
import com.briup.jz.utils.CustomerException;

public interface IRolePrivilegeService {
	
	void saveOrUpdate(BaseRolePrivilege baseRolePrivilege) throws CustomerException;
	
	List<BaseRolePrivilege> query();
	
	void deleteById(long id) throws CustomerException;

}
