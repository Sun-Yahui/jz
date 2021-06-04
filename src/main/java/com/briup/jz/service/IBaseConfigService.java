package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.BaseConfig;
import com.briup.jz.utils.CustomerException;

public interface IBaseConfigService {
	
    void saveOrUpdate(BaseConfig baseConfig) throws CustomerException;
	
	List<BaseConfig> query(String name);
	
	void deleteById(long id) throws CustomerException;
}
