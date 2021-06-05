package com.briup.jz.dao.extend;

import java.util.List;

import com.briup.jz.bean.extend.CertificationApplyExtend;

public interface CertificationApplyExtendMapper {
	
	List<CertificationApplyExtend> select(String realName,String status);

}
