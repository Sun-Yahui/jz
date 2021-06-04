package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.AccountEmployeeExample;
import com.briup.jz.bean.AccountSystem;
import com.briup.jz.bean.AccountSystemExample;
import com.briup.jz.bean.AccountSystemExample.Criteria;
import com.briup.jz.dao.AccountSystemMapper;
import com.briup.jz.service.IAccountSystemService;

@Service
public class AccountSystemServiceImpl implements IAccountSystemService {
	@Autowired
	private AccountSystemMapper accountSystemMapper;
	private AccountSystemExample accountSystemExample;

	@Override
	public void saveOrUpdate(AccountSystem accountSystem) {
		// TODO Auto-generated method stub
		if (accountSystem.getId() == null) {
			accountSystemMapper.insert(accountSystem);
		} else {
			accountSystemMapper.updateByPrimaryKey(accountSystem);
		}
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		accountSystemMapper.deleteByPrimaryKey(id);
		return true;
	}

	@Override
	public List<AccountSystem> findAll(Long page,Long pageSize,String type, String status,Long transferTime,Long endTime) {
		// TODO Auto-generated method stub
		AccountSystemExample exmple=new AccountSystemExample();
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
		
		return accountSystemMapper.selectByExample(exmple);
	}

}
