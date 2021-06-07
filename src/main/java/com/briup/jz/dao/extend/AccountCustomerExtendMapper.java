package com.briup.jz.dao.extend;

import java.util.List;
import com.briup.jz.bean.AccountCustomer;
import com.briup.jz.bean.extend.AccountCustomerExtend;

public interface AccountCustomerExtendMapper {
	List<AccountCustomerExtend> select(Long page, Long pageSize, String type, String status, Long userId,
			Long transferTime, Long endTime, Long id);
	List<AccountCustomer> selectToAccountApply(long userId);}
