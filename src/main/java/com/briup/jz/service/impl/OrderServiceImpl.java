package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.Order;
import com.briup.jz.bean.OrderExample;
import com.briup.jz.dao.OrderMapper;
import com.briup.jz.service.IOrderService;
import com.briup.jz.utils.CustomerException;
import com.briup.jz.bean.OrderExample.Criteria;

@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public void saveOrUpdate(Order order) throws CustomerException {
		if(order.getId()!=null) {
			orderMapper.updateByPrimaryKey(order);
		} else {
			// 判断是否有同名的分类，如果有抛出异常
			OrderExample example = new OrderExample();
			example.createCriteria().andOrderTimeEqualTo(order.getOrderTime());
			List<Order> list = orderMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("同名的分类已存在");
			}
			orderMapper.insert(order);
		}
	}

	@Override
	public List<Order> query(Long id,String status) {
		OrderExample example = new OrderExample();
		Criteria criteria = example.createCriteria();
		if(id!=null){
			criteria.andIdEqualTo(id);
		}
		if(status!=null) {
			criteria.andStatusEqualTo(status);
		}
		return orderMapper.selectByExample(example);
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		Order order = orderMapper.selectByPrimaryKey(id);
		if(order == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		orderMapper.deleteByPrimaryKey(id);
		
	}

}