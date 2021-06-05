package com.briup.jz.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.BaseLog;
import com.briup.jz.bean.BaseLogExample;
import com.briup.jz.bean.BaseLogExample.Criteria;
import com.briup.jz.dao.BaseLogMapper;
import com.briup.jz.service.IBaseLogService;
import com.briup.jz.utils.CustomerException;

@Service
public class BaseLogServiceImpl implements IBaseLogService{

	@Autowired
	public BaseLogMapper baseLogMapper;
	
	@Override
	public void saveOrUpdate(BaseLog baseLog) throws CustomerException {
		if(baseLog.getId() == null) {
			// 初始化
			baseLog.setLogTime(new Date().getTime());
		} else {
			baseLog.setLogTime(new Date().getTime());
			baseLogMapper.updateByPrimaryKey(baseLog);
		}
		
	}

	@Override
	public List<BaseLog> query(String realname,String method) {
		BaseLogExample example = new BaseLogExample();
		Criteria criteria =example.createCriteria();
		if(realname!=null) {
			criteria.andRealnameLike("%"+realname+"%");
		}
		if(method!=null) {
			criteria.andMethodEqualTo(method);
		}
		
		return baseLogMapper.selectByExample(example);
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		BaseLog baseLog = baseLogMapper.selectByPrimaryKey(id);
		if(baseLog == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		baseLogMapper.deleteByPrimaryKey(id);
		
	}

}
