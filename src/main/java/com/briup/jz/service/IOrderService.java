package com.briup.jz.service;

import com.briup.jz.bean.Order;
import com.briup.jz.utils.CustomerException;
import java.util.List;

public interface IOrderService {
	void saveOrUpdate(Order Order) throws CustomerException;
	
	List<Order> query(Long id,String status);
	
	void deleteById(long id) throws CustomerException;


}
