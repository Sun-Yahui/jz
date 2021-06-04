package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.Platform;
import com.briup.jz.bean.PlatformExample;
import com.briup.jz.dao.PlatformMapper;
import com.briup.jz.service.IPlatformService;
@Service
public class PlatformServiceImpl implements IPlatformService{
	@Autowired
	private PlatformMapper platformMapper;
	private PlatformExample platformExample;
		

	@Override
	public void saveOrUpdate(Platform platform) {
		// TODO Auto-generated method stub
		if(platform.getId()==null) {
			platformMapper.insert(platform);
		}else {
			platformMapper.updateByPrimaryKey(platform);
		}
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		platformMapper.deleteByPrimaryKey(id);
		return true;
	}

	@Override
	public List<Platform> findAll() {
		// TODO Auto-generated method stub
		return platformMapper.selectByExample(platformExample);
	}

}
