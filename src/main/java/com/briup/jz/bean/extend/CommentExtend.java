package com.briup.jz.bean.extend;

import com.briup.jz.bean.Article;
import com.briup.jz.bean.BaseUser;
import com.briup.jz.bean.Comment;

public class CommentExtend extends Comment {
	private static final long serialVersionUID = 1L;
	
	private Article article;
	
	private BaseUser user;

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public BaseUser getUser() {
		return user;
	}

	public void setUser(BaseUser user) {
		this.user = user;
	}
	
	
}
