package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.BaseRole;
import com.briup.jz.bean.BaseRoleExample;
import com.briup.jz.dao.BaseRoleMapper;

import com.briup.jz.service.IRoleService;
import com.briup.jz.utils.CustomerException;

@Service
public class RoleServiceImpl implements IRoleService{
	
	@Autowired
	BaseRoleMapper baseRoleMapper;

	@Override
	public void saveOrUpdate(BaseRole baseRole) throws CustomerException {
		// TODO Auto-generated method stub
		if(baseRole.getId()!=null) {
			baseRoleMapper.updateByPrimaryKey(baseRole);
		} else {
			// 判断是否有同名的分类，如果有抛出异常
			BaseRoleExample example = new BaseRoleExample();
			example.createCriteria().andNameEqualTo(baseRole.getName());
			List<BaseRole> list = baseRoleMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("同名的分类已存在");
			}
			baseRoleMapper.insert(baseRole);
		}
		
	}

	@Override
	public List<BaseRole> query(String name) {
		// TODO Auto-generated method stub
		BaseRoleExample example = new BaseRoleExample();
		if(name!=null){
			example.createCriteria().andNameLike("%"+name+"%");
		}
		List<BaseRole> list = baseRoleMapper.selectByExample(example);
		return list;
		
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		// TODO Auto-generated method stub
		BaseRole baseRole = baseRoleMapper.selectByPrimaryKey(id);
		if(baseRole == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		baseRoleMapper.deleteByPrimaryKey(id);
		
	}

}
