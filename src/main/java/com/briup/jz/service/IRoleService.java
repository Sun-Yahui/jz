package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.BaseRole;
import com.briup.jz.utils.CustomerException;

public interface IRoleService {
	
    void saveOrUpdate(BaseRole baseRole) throws CustomerException;
	
	List<BaseRole> query(String name);
	
	void deleteById(long id) throws CustomerException;

}
