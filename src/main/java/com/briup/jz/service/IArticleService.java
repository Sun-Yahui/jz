package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.Article;
import com.briup.jz.bean.extend.ArticleExtend;
import com.briup.jz.utils.CustomerException;

public interface IArticleService {
	
	List<ArticleExtend> queryCascade(String title,String status,Long categoryId);
	
	void saveOrUpdate(Article article) throws CustomerException;
	
	List<Article> query(String title,String status, Long categoryId);
	
	void deleteById(long id) throws CustomerException;

	ArticleExtend read(Long id);
}
