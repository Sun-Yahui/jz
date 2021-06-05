package com.briup.jz.dao.extend;

import java.util.List;

import com.briup.jz.bean.extend.AccountEmployeeExtend;

public interface AccountEmployeeExtendMapper {
	List<AccountEmployeeExtend> select(Long page,Long pageSize,String type, String status, Long userId,Long transferTime,Long endTime);
}
