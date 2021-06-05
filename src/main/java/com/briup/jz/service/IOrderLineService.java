package com.briup.jz.service;

import com.briup.jz.bean.OrderLine;
import com.briup.jz.utils.CustomerException;
import java.util.List;

public interface IOrderLineService {
	void saveOrUpdate(OrderLine OrderLine) throws CustomerException;
	
	List<OrderLine> query(Double price,Long productId);
	
	void deleteById(long id) throws CustomerException;

}
