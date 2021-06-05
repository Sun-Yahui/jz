package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.BaseUser;
import com.briup.jz.utils.CustomerException;

public interface IUserService {
	void saveOrUpdate(BaseUser baseUser) throws CustomerException;
	
	List<BaseUser> query(String username,String status);
	
	void deleteById(long id) throws CustomerException;
	
	

}
