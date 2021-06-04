package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.Platform;

public interface IPlatformService {
	void saveOrUpdate(Platform platform) ;
	boolean deleteById(Long id);
	List<Platform> findAll();
}
