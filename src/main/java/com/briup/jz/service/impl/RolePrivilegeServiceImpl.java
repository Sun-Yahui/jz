package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.BaseRole;
import com.briup.jz.bean.BaseRoleExample;
import com.briup.jz.bean.BaseRolePrivilege;
import com.briup.jz.bean.BaseRolePrivilegeExample;
import com.briup.jz.bean.BaseUser;
import com.briup.jz.bean.BaseUserRole;
import com.briup.jz.bean.BaseUserRoleExample;
import com.briup.jz.bean.Category;
import com.briup.jz.bean.CategoryExample;
import com.briup.jz.dao.BaseRolePrivilegeMapper;
import com.briup.jz.service.IRolePrivilegeService;
import com.briup.jz.utils.CustomerException;

@Service
public class RolePrivilegeServiceImpl implements IRolePrivilegeService{
	
	@Autowired
	private BaseRolePrivilegeMapper baseRolePrivilegeMapper;

	@Override
	public void saveOrUpdate(BaseRolePrivilege baseRolePrivilege) throws CustomerException {
		// TODO Auto-generated method stub
		if(baseRolePrivilege.getId()!=null) {
			baseRolePrivilegeMapper.updateByPrimaryKey(baseRolePrivilege);
		}else {
			BaseRolePrivilegeExample example=new BaseRolePrivilegeExample();
			example.createCriteria().andPrivilegeIdEqualTo(baseRolePrivilege.getPrivilegeId());
			List<BaseRolePrivilege> list = baseRolePrivilegeMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("同名的分类已存在");
			}
			baseRolePrivilegeMapper.insert(baseRolePrivilege);
		}
		
	}


	@Override
	public void deleteById(long id) throws CustomerException {
		// TODO Auto-generated method stub
		BaseRolePrivilege baseRolePrivilege=baseRolePrivilegeMapper.selectByPrimaryKey(id);
		if(baseRolePrivilege == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		baseRolePrivilegeMapper.deleteByPrimaryKey(id);
		
	}

	

	@Override
	public List<BaseRolePrivilege> query() {
		// TODO Auto-generated method stub

		BaseRolePrivilegeExample example=new BaseRolePrivilegeExample();
		
		
		return baseRolePrivilegeMapper.selectByExample(example);
		
	}

}
