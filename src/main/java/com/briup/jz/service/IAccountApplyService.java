package com.briup.jz.service;

import java.util.List;
import com.briup.jz.bean.AccountApply;
import com.briup.jz.bean.AccountApplyExample;

public interface IAccountApplyService {
	
 void saveOrUpdate(AccountApply accountApply);
 
 boolean deleteById(Long id);
 
 List<AccountApply> pageQuery(Long page,Long pageSize,String applyType, String status, Long userId,Long beginTime,Long endTime,Long id);
 
 AccountApply findById(Long id);
}
