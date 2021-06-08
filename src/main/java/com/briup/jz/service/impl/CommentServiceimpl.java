package com.briup.jz.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.Carousel;
import com.briup.jz.bean.CarouselExample;
import com.briup.jz.bean.Comment;
import com.briup.jz.bean.CommentExample;
import com.briup.jz.bean.CommentExample.Criteria;
import com.briup.jz.bean.extend.CommentExtend;
import com.briup.jz.dao.CommentMapper;
import com.briup.jz.dao.extend.CommentExtendMapper;
import com.briup.jz.service.ICommentService;
import com.briup.jz.utils.CustomerException;


@Service
public class CommentServiceimpl implements ICommentService{

	@Autowired
	public CommentMapper commentMapper;
	
	@Autowired
	public CommentExtendMapper commentExtendMapper;
	
	@Override
	public void saveOrUpdate(Comment comment) throws CustomerException {
		if (comment.getId() != null) {
			commentMapper.updateByPrimaryKey(comment);
        } else {
            // 判断是否有同名的分类，如果有抛出异常
        	CommentExample example = new CommentExample();
            example.createCriteria().andCommentEqualTo(comment.getComment());
            List<Comment> list = commentMapper.selectByExample(example);
            if (list.size() > 0) {
                throw new CustomerException("同名的分类已存在");
            }
            commentMapper.insert(comment);
        }
	}

	@Override
	public List<Comment> query(String comment,String status) {
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		if(comment!=null) {
			criteria.andCommentLike("%"+comment+"%");
		}
		if(status!=null) {
			criteria.andStatusEqualTo(status);
		}
		return commentMapper.selectByExample(example);
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		
			Comment comment = commentMapper.selectByPrimaryKey(id);
			if(comment == null) {
				throw new CustomerException("要删除的分类信息不存在");
			}
			commentMapper.deleteByPrimaryKey(id);
			
		}

	@Override
    public List<CommentExtend> queryCascade(String comment, String status) {
		
		return commentExtendMapper.select(comment, status);
	}

		
	}
	