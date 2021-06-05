package com.briup.jz.service;

import java.util.List;
import com.briup.jz.bean.AccountApply;
import com.briup.jz.bean.AccountApplyExample;
import com.briup.jz.bean.extend.AccountApplyExtend;

public interface IAccountApplyService {
	
 void saveOrUpdate(AccountApply accountApply);
 
 boolean deleteById(Long id);
 
 List<AccountApply> pageQuery(Long page,Long pageSize,String applyType, String status, Long userId,Long applyTime,Long endTime,Long id);
 
 AccountApply findById(Long id);
 List<AccountApplyExtend> select(Long page,Long pageSize,String applyType, String status, Long userId,Long applyTime,Long endTime,Long id);
}
