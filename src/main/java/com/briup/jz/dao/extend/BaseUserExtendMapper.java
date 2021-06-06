package com.briup.jz.dao.extend;



import java.util.List;

import com.briup.jz.bean.extend.BaseUserExtend;

public interface BaseUserExtendMapper {

	BaseUserExtend selectById(long id);
	
	List<BaseUserExtend> selectByIdToAccount(Long id);

}
