package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.BaseUser;
import com.briup.jz.bean.extend.BaseUserExtend;
import com.briup.jz.utils.CustomerException;

public interface IUserService {
	void saveOrUpdate(BaseUser baseUser) throws CustomerException;
	
	List<BaseUser> query(String username,String status);
	
	BaseUserExtend read(long id);
	
	void deleteById(long id) throws CustomerException;
	
	List<BaseUserExtend> selectByIdToAccount(Long id);


}
