package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.AccountEmployee;

public interface IAccountEmployeeService {
	void	saveOrUpdate(AccountEmployee accountEmployee) ;
	boolean deleteById(Long id);
	List<AccountEmployee> findAll(Long page,Long pageSize,String type, String status, Long userId,Long transferTime,Long endTime);
}
