package com.briup.jz.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.briup.jz.bean.Comment;
import com.briup.jz.bean.CommentExample;

import com.briup.jz.dao.CommentMapper;
import com.briup.jz.service.ICommentService;
import com.briup.jz.utils.CustomerException;


@Service
public class CommentServiceimpl implements ICommentService{

	@Autowired
	public CommentMapper commentMapper;
	
	@Override
	public void saveOrUpdate(Comment comment) throws CustomerException {
		if(comment.getId() == null) {
			// 初始化
			comment.setCommentTime(new Date().getTime());
			comment.setStatus("通过");
			comment.setArticleId(68l);
			commentMapper.insert(comment);
		} else {
			comment.setCommentTime(new Date().getTime());
			comment.setStatus("通过");
			comment.setArticleId(68l);
			commentMapper.updateByPrimaryKey(comment);
		}
		
	}

	@Override
	public List<Comment> query(String comment) {
		CommentExample example = new CommentExample();
		if(comment!=null){
			example.createCriteria().andCommentLike("%"+comment+"%");
		}
		List<Comment> list = commentMapper.selectByExample(example);
		return list;
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		
			Comment comment = commentMapper.selectByPrimaryKey(id);
			if(comment == null) {
				throw new CustomerException("要删除的分类信息不存在");
			}
			commentMapper.deleteByPrimaryKey(id);
			
		}
		
	}
	