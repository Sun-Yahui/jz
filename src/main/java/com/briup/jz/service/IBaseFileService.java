package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.BaseFile;
import com.briup.jz.utils.CustomerException;

public interface IBaseFileService {
	
    void saveOrUpdate(BaseFile baseFile) throws CustomerException;
	
	List<BaseFile> query(String fileName);
	
	void deleteById(String id) throws CustomerException;
}
