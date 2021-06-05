package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.Category;
import com.briup.jz.bean.CertificationApply;
import com.briup.jz.utils.CustomerException;

public interface ICertificationApplyService {

	void saveOrUpdate(CertificationApply certificationApply) throws CustomerException;
	
	List<CertificationApply> query(String name);
	
	void deleteById(long id) throws CustomerException;

}
