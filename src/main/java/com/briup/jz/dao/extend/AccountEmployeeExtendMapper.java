package com.briup.jz.dao.extend;

import java.util.List;
import com.briup.jz.bean.AccountEmployee;
import com.briup.jz.bean.extend.AccountEmployeeExtend;

public interface AccountEmployeeExtendMapper {
	List<AccountEmployeeExtend> select(Long page,Long pageSize,Long id,String type, String status, Long userId,Long transferTime,Long endTime);
	List<AccountEmployee> selectToAccountApply(long userId);}

