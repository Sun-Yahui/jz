package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.AccountCustomer;

public interface IAccountCustomerService {
	void saveOrUpdate(AccountCustomer accountCustomer);
	boolean deleteById(Long id);
	List<AccountCustomer> findAll(Long page,Long pageSize,String type, String status, Long userId,Long transferTime,Long endTime,Long id);
}
