package com.briup.jz.bean.extend;

import java.util.List;

import com.briup.jz.bean.Article;
import com.briup.jz.bean.Category;

public class CategoryExtend extends Category {
	private static final long serialVersionUID = 1L;
	
	private List<Article> articles;

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
}
