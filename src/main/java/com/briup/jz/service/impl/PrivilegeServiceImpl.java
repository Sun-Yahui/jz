package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.BasePrivilege;
import com.briup.jz.bean.BasePrivilegeExample;
import com.briup.jz.bean.Category;
import com.briup.jz.bean.CategoryExample;
import com.briup.jz.dao.BasePrivilegeMapper;
import com.briup.jz.service.IPrivilegeService;
import com.briup.jz.utils.CustomerException;
@Service
public class PrivilegeServiceImpl implements IPrivilegeService{
	
	@Autowired
	private BasePrivilegeMapper basePrivilegeMapper;

	@Override
	public void saveOrUpdate(BasePrivilege basePrivilege) throws CustomerException {
		// TODO Auto-generated method stub
		if(basePrivilege.getId()!=null) {
			basePrivilege.setType("menu");
			basePrivilegeMapper.updateByPrimaryKey(basePrivilege);
		} else {
			// 判断是否有同名的分类，如果有抛出异常
			basePrivilege.setType("menu");
			basePrivilegeMapper.insert(basePrivilege);
		}
		
		
	}

	@Override
	public List<BasePrivilege> query(String name) {
		// TODO Auto-generated method stub
		BasePrivilegeExample example = new BasePrivilegeExample();
		if(name!=null){
			example.createCriteria().andNameLike("%"+name+"%");
		}
		List<BasePrivilege> list = basePrivilegeMapper.selectByExample(example);
		
		return list;
		
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		// TODO Auto-generated method stub
		BasePrivilege basePrivilege = basePrivilegeMapper.selectByPrimaryKey(id);
		if(basePrivilege == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		basePrivilegeMapper.deleteByPrimaryKey(id);
		
	}

}
