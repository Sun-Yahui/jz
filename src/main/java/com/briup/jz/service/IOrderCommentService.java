package com.briup.jz.service;

import com.briup.jz.bean.OrderComment;
import com.briup.jz.utils.CustomerException;
import java.util.List;

public interface IOrderCommentService {
	void saveOrUpdate(OrderComment OrderComment) throws CustomerException;
	
	List<OrderComment> query(String content,String status);
	
	void deleteById(long id) throws CustomerException;



}
