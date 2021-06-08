package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.AccountEmployee;
import com.briup.jz.bean.extend.AccountEmployeeExtend;

public interface IAccountEmployeeService {
	void	saveOrUpdate(AccountEmployee accountEmployee) ;
	boolean deleteById(Long id);
	List<AccountEmployee> findAll(Long page,Long pageSize,String type, String status, Long userId,Long transferTime,Long endTime);
	List<AccountEmployeeExtend> select(Long page,Long pageSize,Long id,String type, String status, Long userId,Long transferTime,Long endTime);

}
