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
		if (article.getId() != null) {
			articleMapper.updateByPrimaryKey(article);
        } else {
            // 判断是否有同名的分类，如果有抛出异常
        	ArticleExample example = new ArticleExample();
            example.createCriteria().andTitleEqualTo(article.getTitle());
            List<Article> list = articleMapper.selectByExample(example);
            if (list.size() > 0) {
                throw new CustomerException("同名的分类已存在");
            }
            articleMapper.insert(article);
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

	@Override
	public ArticleExtend read(Long id) {
		
		return articleExtendMapper.selectById(id);
	}
		
	}
	
