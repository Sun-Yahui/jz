package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.BaseConfig;
import com.briup.jz.bean.BaseConfigExample;
import com.briup.jz.bean.BaseConfigExample.Criteria;
import com.briup.jz.dao.BaseConfigMapper;
import com.briup.jz.service.IBaseConfigService;
import com.briup.jz.utils.CustomerException;

@Service
public class BaseConfigServiceImpl implements IBaseConfigService{

	@Autowired
	public BaseConfigMapper baseConfigMapper;
	
	@Override
	public void saveOrUpdate(BaseConfig baseConfig) throws CustomerException {
		if(baseConfig.getId()!=null) {
			baseConfigMapper.updateByPrimaryKey(baseConfig);
		} else {
			// 判断是否有同名的分类，如果有抛出异常
			BaseConfigExample example = new BaseConfigExample();
			example.createCriteria().andNameEqualTo(baseConfig.getName());
			List<BaseConfig> list = baseConfigMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("同名的分类已存在");
			}
			baseConfigMapper.insert(baseConfig);
		}
		
	}

	@Override
	public List<BaseConfig> query(String name,String val) {
		BaseConfigExample example = new BaseConfigExample();
		Criteria criteria = example.createCriteria();
		// 多条件符合查询
		if(name != null) {
			criteria.andNameLike("%"+name+"%");
		}
		if(val != null) {
			criteria.andValEqualTo(val);
		}
		// 返回查询结果
		return baseConfigMapper.selectByExample(example);
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		BaseConfig baseConfig = baseConfigMapper.selectByPrimaryKey(id);
		if(baseConfig == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		baseConfigMapper.deleteByPrimaryKey(id);
		
	}

}
