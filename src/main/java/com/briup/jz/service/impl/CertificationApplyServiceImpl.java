package com.briup.jz.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.CertificationApply;
import com.briup.jz.bean.CertificationApplyExample;
import com.briup.jz.bean.extend.CertificationApplyExtend;
import com.briup.jz.dao.CertificationApplyMapper;
import com.briup.jz.dao.extend.CertificationApplyExtendMapper;
import com.briup.jz.service.ICertificationApplyService;
import com.briup.jz.utils.CustomerException;
@Service
public class CertificationApplyServiceImpl implements ICertificationApplyService{
	
	@Autowired
	private CertificationApplyMapper certificationApplyMapper;
	
	@Autowired
	private CertificationApplyExtendMapper certificationApplyExtendMapper;

	@Override
	public void saveOrUpdate(CertificationApply certificationApply) throws CustomerException {
		// TODO Auto-generated method stub
		if(certificationApply.getId()!=null) {
			certificationApply.setApplyTime(new Date().getTime());
			certificationApplyMapper.updateByPrimaryKey(certificationApply);
		} else {
			// 判断是否有同名的分类，如果有抛出异常
			certificationApply.setApplyTime(new Date().getTime());
			certificationApplyMapper.insert(certificationApply);
		}
		
	}

	@Override
	public List<CertificationApply> query(String name) {
		CertificationApplyExample example = new CertificationApplyExample();
		if(name!=null){
			example.createCriteria().andRealnameLike("%"+name+"%");
		}
		List<CertificationApply> list = certificationApplyMapper.selectByExample(example);
		return list;
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		// TODO Auto-generated method stub
		CertificationApply certificationApply = certificationApplyMapper.selectByPrimaryKey(id);
		if(certificationApply == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		certificationApplyMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public List<CertificationApplyExtend> queryCascade(String realName, String status) {
		// TODO Auto-generated method stub
		return certificationApplyExtendMapper.select(realName, status);
	}

}
