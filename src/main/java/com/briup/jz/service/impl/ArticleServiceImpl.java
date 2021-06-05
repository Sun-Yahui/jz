package com.briup.jz.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.Article;
import com.briup.jz.bean.ArticleExample;
import com.briup.jz.bean.ArticleExample.Criteria;
import com.briup.jz.bean.extend.ArticleExtend;
import com.briup.jz.dao.ArticleMapper;
import com.briup.jz.dao.extend.ArticleExtendMapper;
import com.briup.jz.service.IArticleService;
import com.briup.jz.utils.CustomerException;

@Service
public class ArticleServiceImpl implements IArticleService{
	
	@Autowired
	public ArticleMapper articleMapper;
	
	@Autowired
	public ArticleExtendMapper articleExtendMapper;

	
	@Override
	public void saveOrUpdate(Article article) throws CustomerException {
		if(article.getId() == null) {
			// 初始化
			article.setPublishTime(new Date().getTime());
			article.setReadTimes(0l);
			article.setThumpUp(0l);
			article.setStatus("未审核");
			articleMapper.insert(article);
		} else {
			article.setPublishTime(new Date().getTime());
			article.setReadTimes(0l);
			article.setThumpUp(0l);
			article.setStatus("未审核");
			articleMapper.updateByPrimaryKey(article);
		}
		
	}

	@Override
	public List<Article> query(String title, String status, Long categoryId) {
		ArticleExample example = new ArticleExample();
		Criteria criteria = example.createCriteria();
		// 多条件符合查询
		if(title != null) {
			criteria.andTitleLike("%"+title+"%");
		}
		if(status != null) {
			criteria.andStatusEqualTo(status);
		}
		if(categoryId != null) {
			criteria.andCategoryIdEqualTo(categoryId);
		}
		// 返回查询结果
		return articleMapper.selectByExample(example);
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		Article article = articleMapper.selectByPrimaryKey(id);
		if(article == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		articleMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public List<ArticleExtend> queryCascade(String title, String status, Long categoryId) {
		return articleExtendMapper.select(title, status, categoryId);
	}
		
	}
	
