package com.briup.jz.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.briup.jz.bean.BaseFile;
import com.briup.jz.bean.BaseFileExample;
import com.briup.jz.bean.BaseFileExample.Criteria;
import com.briup.jz.dao.BaseFileMapper;
import com.briup.jz.service.IBaseFileService;
import com.briup.jz.utils.CustomerException;

@Service
public class BaseFileServiceImpl implements IBaseFileService{
	
	@Autowired
	public BaseFileMapper baseFileMapper;

	@Override
	public void saveOrUpdate(BaseFile baseFile) throws CustomerException {
	
		if(baseFile.getId()!= null) {
			// 初始化
			baseFile.setUploadTime(new Date().getTime());
			
			baseFileMapper.updateByPrimaryKey(baseFile);
		}else{
			baseFile.setUploadTime(new Date().getTime());
			baseFileMapper.insert(baseFile);
			
		}
		
	}

	@Override
	public List<BaseFile> query(String fileName,String groupName) {
		BaseFileExample example = new BaseFileExample();
		Criteria criteria=example.createCriteria();
		if(fileName!=null) {
			criteria.andFileNameLike("%"+fileName+"%");
		}
		if(groupName!=null) {
			criteria.andGroupNameEqualTo(groupName);
		}
		
		return baseFileMapper.selectByExample(example);
		
	}

	@Override
	public void deleteById(String id) throws CustomerException {
		BaseFile baseFile = baseFileMapper.selectByPrimaryKey(id);
		if(baseFile == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		baseFileMapper.deleteByPrimaryKey(id);
		
	}
	
	
	
	
}
