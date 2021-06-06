package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.BaseRolePrivilege;
import com.briup.jz.bean.BaseRolePrivilegeExample;
import com.briup.jz.bean.BaseUser;
import com.briup.jz.bean.BaseUserExample;
import com.briup.jz.bean.BaseUserRole;
import com.briup.jz.bean.BaseUserRoleExample;
import com.briup.jz.bean.extend.BaseUserRoleExtend;
import com.briup.jz.dao.BaseUserRoleMapper;
import com.briup.jz.dao.extend.BaseUserRoleExtendMapper;
import com.briup.jz.service.IUserRoleService;
import com.briup.jz.utils.CustomerException;

@Service
public class UserRoleServiceImpl implements IUserRoleService{
	
	@Autowired
	private BaseUserRoleMapper baseUserRoleMapper;
	
	@Autowired
	private BaseUserRoleExtendMapper baseUserRoleExtendMapper;

	@Override
	public void saveOrUpdate(BaseUserRole baseUserRole) throws CustomerException {
		if(baseUserRole.getId()!=null) {
			baseUserRoleMapper.updateByPrimaryKey(baseUserRole);
		}else {
			BaseUserRoleExample example=new BaseUserRoleExample();
			example.createCriteria().andUserIdEqualTo(baseUserRole.getUserId());
			List<BaseUserRole> list= baseUserRoleMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("同名的分类已存在");
			}
			baseUserRoleMapper.insert(baseUserRole);
		}
		
	}
	
	

	@Override
	public void deleteById(long id) throws CustomerException {
		// TODO Auto-generated method stub
		BaseUserRole baseUserRole = baseUserRoleMapper.selectByPrimaryKey(id);
		if(baseUserRole==null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		baseUserRoleMapper.deleteByPrimaryKey(id);
		
	}





	@Override
	public List<BaseUserRole> query() {

		BaseUserRoleExample example=new BaseUserRoleExample();
		
		
		return baseUserRoleMapper.selectByExample(example);
	}



	@Override
	public List<BaseUserRoleExtend> queryCascade(long id) {
		// TODO Auto-generated method stub
		return baseUserRoleExtendMapper.select(id);
	}

}
