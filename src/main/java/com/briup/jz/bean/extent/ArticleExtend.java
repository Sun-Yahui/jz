package com.briup.jz.bean.extent;

import com.briup.jz.bean.Article;
import com.briup.jz.bean.BaseUser;
import com.briup.jz.bean.Category;

public class ArticleExtend extends Article {
	private static final long serialVersionUID = 1L;
	
	private Category category;
	
	private BaseUser author;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BaseUser getAuthor() {
		return author;
	}

	public void setAuthor(BaseUser author) {
		this.author = author;
	}
	
	
}
