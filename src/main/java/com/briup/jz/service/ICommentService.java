package com.briup.jz.service;

import java.util.List;


import com.briup.jz.bean.Comment;
import com.briup.jz.bean.extent.CommentExtend;
import com.briup.jz.utils.CustomerException;

public interface ICommentService {
	
	List<CommentExtend> queryCascade (String comment,String status);
	
	void saveOrUpdate(Comment comment) throws CustomerException;
	
	List<Comment> query(String comment,String status);
	
	void deleteById(long id) throws CustomerException;
	
	
}
