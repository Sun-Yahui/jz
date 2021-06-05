package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.jz.bean.AccountEmployee;
import com.briup.jz.bean.AccountEmployeeExample;
import com.briup.jz.bean.AccountEmployeeExample.Criteria;
import com.briup.jz.dao.AccountEmployeeMapper;
import com.briup.jz.service.IAccountEmployeeService;
@Service
public class AccountEmployeeServiceImpl implements IAccountEmployeeService{
	@Autowired
private AccountEmployeeMapper accountEmployeeMapper;
	private AccountEmployeeExample accountEmployeeExample;
	@Override
	public void saveOrUpdate(AccountEmployee accountEmployee) {
		// TODO Auto-generated method stub
		if(accountEmployee.getId()==null) {
			accountEmployeeMapper.insert(accountEmployee);
		}else {
			accountEmployeeMapper.updateByPrimaryKey(accountEmployee);
		}
		
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		accountEmployeeMapper.deleteByPrimaryKey(id);
		return true;
	}

	@Override
	public List<AccountEmployee> findAll(Long page,Long pageSize,String type, String status, Long userId,Long transferTime,Long endTime) {
		// TODO Auto-generated method stub
		//增加一个参数模板
				AccountEmployeeExample exmple=new AccountEmployeeExample();
				Criteria criteria = exmple.createCriteria();
				if(transferTime != null) {
					criteria.andTransferTimeBetween(transferTime, endTime);
				}
				if(type != null) {
					criteria.andTypeEqualTo(type);
				}
				if(status != null) {
					criteria.andStatusEqualTo(status);
				}
				if(userId != null) {
					criteria.andUserIdEqualTo(userId);
				}
			
		return accountEmployeeMapper.selectByExample(exmple);
	}

}
