package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.AccountApply;
import com.briup.jz.bean.AccountApplyExample;
import com.briup.jz.bean.AccountApplyExample.Criteria;
import com.briup.jz.dao.AccountApplyMapper;
import com.briup.jz.service.IAccountApplyService;
@Service
public class AccountApplyServiceImpl implements IAccountApplyService{
   @Autowired
	private AccountApplyMapper accountApplyMapper;
 
   private AccountApplyExample accountApplyExample;
	@Override
	public void saveOrUpdate(AccountApply accountApply) {
		// TODO Auto-generated method stub
		if(accountApply.getId()==null) {
			accountApplyMapper.insert(accountApply);
		}else {
			accountApplyMapper.updateByPrimaryKey(accountApply);
		}
		
	}

	@Override
	public boolean deleteById(Long id) {
		accountApplyMapper.deleteByPrimaryKey(id);
		return true;
	}

	@Override
	public List<AccountApply> pageQuery(Long page,Long pageSize,String applyType, String status, Long userId,Long beginTime,Long endTime,Long id) {
		// TODO Auto-generated method stub
		
		//增加一个参数模板
		AccountApplyExample exmple=new AccountApplyExample();
		Criteria criteria = exmple.createCriteria();
		if(beginTime != null) {
			criteria.andApplyTimeBetween(beginTime, endTime);
		}
		if(applyType != null) {
			criteria.andApplyTypeEqualTo(applyType);
		}
		if(status != null) {
			criteria.andStatusEqualTo(status);
		}
		if(userId != null) {
			criteria.andUserIdEqualTo(userId);
		}if(id != null) {
			criteria.andIdEqualTo(id);
		}
		return accountApplyMapper.selectByExample(exmple);
	}

	@Override
	public AccountApply findById(Long id) {
		// TODO Auto-generated method stub
		
		return accountApplyMapper.selectByPrimaryKey(id);
	}

}
