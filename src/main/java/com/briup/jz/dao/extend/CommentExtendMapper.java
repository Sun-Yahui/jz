package com.briup.jz.dao.extend;

import java.util.List;

import com.briup.jz.bean.extend.CommentExtend;

public interface CommentExtendMapper {
	List<CommentExtend> select(String comment,String status);
}
