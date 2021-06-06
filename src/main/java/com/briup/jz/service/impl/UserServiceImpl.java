package com.briup.jz.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.BaseUser;
import com.briup.jz.bean.BaseUserExample;

import com.briup.jz.bean.BaseUserExample.Criteria;
import com.briup.jz.bean.extend.BaseUserExtend;
import com.briup.jz.dao.BaseUserMapper;
import com.briup.jz.dao.extend.BaseUserExtendMapper;
import com.briup.jz.service.IUserService;
import com.briup.jz.utils.CustomerException;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private BaseUserMapper baseUserMapper;
	
	@Autowired
	private BaseUserExtendMapper baseUserExtendMapper;

	@Override
	public void saveOrUpdate(BaseUser baseUser) throws CustomerException {
		if(baseUser.getId()!=null) {
			baseUserMapper.updateByPrimaryKey(baseUser);
			}else {
				BaseUserExample example=new BaseUserExample();
				example.createCriteria().andUsernameEqualTo(baseUser.getUsername());
				List<BaseUser> list= baseUserMapper.selectByExample(example);
				if(list.size()>0) {
					throw new CustomerException("同名的分类已存在");
				}
				baseUserMapper.insert(baseUser);
			}
		
	}

	@Override
	public List<BaseUser> query(String username,String status) {
		// TODO Auto-generated method stub
		BaseUserExample example=new BaseUserExample();
		Criteria criteria =example.createCriteria();
		if(username!=null) {
			criteria.andUsernameLike("%"+username+"%");
		}
		if(status!=null) {
			criteria.andStatusEqualTo(status);
		}
		return baseUserMapper.selectByExample(example);
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		// TODO Auto-generated method stub
		BaseUser baseUser=baseUserMapper.selectByPrimaryKey(id);
		if(baseUser==null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		baseUserMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public BaseUserExtend read(long id) {
		// TODO Auto-generated method stub
		return baseUserExtendMapper.selectById(id);
	}

	@Override
	public List<BaseUserExtend> selectByIdToAccount(Long id) {
		// TODO Auto-generated method stub
		return baseUserExtendMapper.selectByIdToAccount(id);
	}

	

}
