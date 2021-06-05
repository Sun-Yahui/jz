package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.OrderComment;
import com.briup.jz.bean.OrderCommentExample;
import com.briup.jz.bean.OrderCommentExample.Criteria;
import com.briup.jz.dao.OrderCommentMapper;
import com.briup.jz.service.IOrderCommentService;
import com.briup.jz.utils.CustomerException;

@Service
public class OrderCommentServiceImpl implements IOrderCommentService {
	
	@Autowired
	private OrderCommentMapper orderCommentMapper;

	@Override
	public void saveOrUpdate(OrderComment orderComment) throws CustomerException {
		if(orderComment.getId()!=null) {
			orderCommentMapper.updateByPrimaryKey(orderComment);
		} else {
			// 判断是否有同名的分类，如果有抛出异常
			OrderCommentExample example = new OrderCommentExample();
			example.createCriteria().andContentEqualTo(orderComment.getContent());
			List<OrderComment> list = orderCommentMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("同名的分类已存在");
			}
			orderCommentMapper.insert(orderComment);
		}
	}

	@Override
	public List<OrderComment> query(String content,String status) {
		OrderCommentExample example = new OrderCommentExample();
		Criteria criteria = example.createCriteria();
		if(content!=null){
			criteria.andContentLike("%"+content+"%");
		}
		if(status!=null) {
			criteria.andStatusEqualTo(status);
		}
		return orderCommentMapper.selectByExample(example);
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		OrderComment orderComment = orderCommentMapper.selectByPrimaryKey(id);
		if(orderComment == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		orderCommentMapper.deleteByPrimaryKey(id);
		
	}

	

}