package com.briup.jz.dao.extend;

import java.util.List;

import com.briup.jz.bean.Comment;
import com.briup.jz.bean.extend.CommentExtend;

public interface CommentExtendMapper {
	List<CommentExtend> select(String comment,String status);
	
	List<Comment> selectByArticleId(Long articleId);
	
	List<Comment> selectById(long id);
}
