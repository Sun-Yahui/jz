package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.OrderLine;
import com.briup.jz.bean.OrderLineExample;
import com.briup.jz.dao.OrderLineMapper;
import com.briup.jz.service.IOrderLineService;
import com.briup.jz.utils.CustomerException;
import com.briup.jz.bean.OrderLineExample.Criteria;

@Service
public class OrderLineServiceImpl implements IOrderLineService {
	
	@Autowired
	private OrderLineMapper orderLineMapper;

	@Override
	public void saveOrUpdate(OrderLine orderLine) throws CustomerException {
		if(orderLine.getId()!=null) {
			orderLineMapper.updateByPrimaryKey(orderLine);
		} else {
			// 判断是否有同名的分类，如果有抛出异常
			OrderLineExample example = new OrderLineExample();
			example.createCriteria().andIdEqualTo(orderLine.getProductId());
			List<OrderLine> list = orderLineMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("同名的分类已存在");
			}
			orderLineMapper.insert(orderLine);
		}
	}

	@Override
	public List<OrderLine> query(Double price,Long productId) {
		OrderLineExample example = new OrderLineExample();
		Criteria criteria = example.createCriteria();
		if(price!=null){
			criteria.andPriceEqualTo(price);
		}
		if(productId!=null) {
			criteria.andProductIdEqualTo(productId);
		}
		return orderLineMapper.selectByExample(example);
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		OrderLine orderLine = orderLineMapper.selectByPrimaryKey(id);
		if(orderLine == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		orderLineMapper.deleteByPrimaryKey(id);
		
	}

	

}