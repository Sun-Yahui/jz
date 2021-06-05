package com.briup.jz.dao.extend;

import java.util.List;

import com.briup.jz.bean.extend.AccountApplyExtend;

public interface AccountApplyExtendMapper {
List<AccountApplyExtend> select(Long page, Long pageSize, String applyType, String status, Long userId,
		Long beginTime, Long endTime, Long id);
}
