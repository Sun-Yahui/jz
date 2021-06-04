package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.AccountSystem;

public interface IAccountSystemService {
	void saveOrUpdate(AccountSystem accountSystem);
	boolean deleteById(Long id);
	 List<AccountSystem> findAll(Long page,Long pageSize,String type, String status,Long transferTime,Long endTime);
     

}
