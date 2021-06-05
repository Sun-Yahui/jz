package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.BasePrivilege;
import com.briup.jz.bean.Category;
import com.briup.jz.utils.CustomerException;

public interface IPrivilegeService {

	void saveOrUpdate(BasePrivilege basePrivilege) throws CustomerException;
	
	List<BasePrivilege> query(String name);
	
	void deleteById(long id) throws CustomerException;

}
