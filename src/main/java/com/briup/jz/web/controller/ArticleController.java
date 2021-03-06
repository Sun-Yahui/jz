package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.Article;

import com.briup.jz.bean.extend.ArticleExtend;
import com.briup.jz.service.IArticleService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="学生风采相关接口")
@Validated
@RestController
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	public IArticleService articleService;
	
	@ApiOperation("多条件符合查询")
	@ApiImplicitParams({
		@ApiImplicitParam(name="title",value="文章标题",paramType="query"),
		@ApiImplicitParam(name="status",value="状态[未审核、通过、不通过、推荐]",paramType="query"),
		@ApiImplicitParam(name="categoryId",value="资讯分类id",paramType="query")
	})
	@GetMapping("query")
    public Message query(String title,String status,Long categoryId){
		List<Article> list = articleService.query(title, status, categoryId);
        return MessageUtil.success(list);
    }
	
	@ApiOperation(value = "通过id删除")
    @GetMapping("deleteById")
    @ApiImplicitParams({
    @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
    })
	public Message deleteById(@NotNull Long id){
		System.out.println("==="+id);
		articleService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
	
	@ApiOperation(value="保存或更新",notes="如果id为空是保存否则是更新")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="编号[更新的时候需要填写]",paramType="form"),
		@ApiImplicitParam(name="title",value="文章标题", required=true, paramType="form"),
		@ApiImplicitParam(name="content",value="文章主体内容",paramType="form"),
		@ApiImplicitParam(name="cover",value="缩略图",paramType="form"),
		@ApiImplicitParam(name="categoryId",value="资讯分类id",paramType="form"),
		@ApiImplicitParam(name="publishTime",value="出版时间",paramType="form"),
		@ApiImplicitParam(name="readTimes",value="阅读次数",  paramType="form"),
		@ApiImplicitParam(name="status",value="状态",paramType="form"),
		@ApiImplicitParam(name="thumpUp",value="点赞数",paramType="form"),
		@ApiImplicitParam(name="authorId",value="作者id",paramType="form")
	})
	@PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Article article) {
		articleService.saveOrUpdate(article);
        return MessageUtil.success("更新成功");
    }
	
	@ApiOperation(value="多条件符合级联查询",notes="级联查询出文章所属分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name="title",value="文章标题",paramType="query"),
		@ApiImplicitParam(name="status",value="状态[未审核、通过、不通过、推荐]",paramType="query"),
		@ApiImplicitParam(name="categoryId",value="资讯分类id",paramType="query")
	})
	@GetMapping("queryCascade")
    public Message queryCascade(String title,String status,Long categoryId){
		List<ArticleExtend> list = articleService.queryCascade(title, status, categoryId);
        return MessageUtil.success(list);
    }
	
	@ApiOperation("阅读文章")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="文章id",paramType="query",required=true),
	})
	@GetMapping("read")
	public Message read(Long id) {
		ArticleExtend article=articleService.read(id);
		return MessageUtil.success(article);
	}

}
