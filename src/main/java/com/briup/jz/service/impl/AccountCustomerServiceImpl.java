package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.AccountApplyExample;
import com.briup.jz.bean.AccountCustomer;
import com.briup.jz.bean.AccountCustomerExample;
import com.briup.jz.bean.AccountCustomerExample.Criteria;
import com.briup.jz.bean.extend.AccountCustomerExtend;
import com.briup.jz.dao.AccountCustomerMapper;
import com.briup.jz.dao.extend.AccountCustomerExtendMapper;
import com.briup.jz.service.IAccountCustomerService;
@Service
public class AccountCustomerServiceImpl implements IAccountCustomerService{
	@Autowired
    private AccountCustomerMapper accountCustomerMapper;
	private AccountCustomerExample accountCustomerExample;
	@Autowired
	private AccountCustomerExtendMapper accountCustomerExtendMapper;
	@Override
	public void saveOrUpdate(AccountCustomer accountCustomer) {
		// TODO Auto-generated method stub
		if(accountCustomer.getId()==null) {
			accountCustomerMapper.insert(accountCustomer);
		}else {
			accountCustomerMapper.updateByPrimaryKey(accountCustomer);
		}
	}
	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		accountCustomerMapper.deleteByPrimaryKey(id);
		return true;
	}
	@Override
	public List<AccountCustomer> findAll(Long page,Long pageSize,String type, String status, Long userId,Long transferTime,Long endTime,Long id) {
		
		//增加一个参数模板
		AccountCustomerExample exmple=new AccountCustomerExample();
		Criteria criteria = exmple.createCriteria();
		if(transferTime != null) {
			criteria.andTransferTimeBetween(transferTime, endTime);
		}		
		if(status != null) {
			criteria.andStatusEqualTo(status);
		}
		if(userId != null) {
			criteria.andUserIdEqualTo(userId);
		}
		if(id != null) {
			criteria.andIdEqualTo(id);
		}
		if(type != null) {
			criteria.andTypeEqualTo(type);
		}
		List<AccountCustomer> list = accountCustomerMapper.selectByExample(exmple);
		
		return list ;
	}
	@Override
	public List<AccountCustomerExtend> select(Long page, Long pageSize, String type, String status, Long userId,
			Long transferTime, Long endTime, Long id) {
		// TODO Auto-generated method stub
		return accountCustomerExtendMapper.select(page, pageSize, type, status, userId, transferTime, endTime, id);
	}
	
}