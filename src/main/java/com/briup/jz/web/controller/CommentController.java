package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.Comment;
import com.briup.jz.bean.extent.CommentExtend;
import com.briup.jz.service.ICommentService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@Api(description="资讯评论相关接口")
@Validated
@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	public ICommentService commentService;
	
	 @ApiOperation("多条件符合查询")
	 
	 @ApiImplicitParams({
		 @ApiImplicitParam(name="comment",value = "评论信息",paramType = "query"),
		 @ApiImplicitParam(name="status",value = "状态",paramType = "query"),
	 })
	 @GetMapping("query")
	 public Message query(String comment,String status){
	      List<Comment> list = commentService.query(comment,status);
	      return MessageUtil.success(list);
	    }
	
	 @ApiOperation(value = "通过id删除")
	 @GetMapping("deleteById")
	 @ApiImplicitParams({
	 @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
	 })
	 public Message deleteById(@NotNull Long id){
		  commentService.deleteById(id);
	      return MessageUtil.success("删除成功");
	    }
	
	
	 @ApiOperation(value="保存或更新咨询或评论信息",notes="如果id为空是保存否则是更新")
	    @ApiImplicitParams({
	            @ApiImplicitParam(name="id",value = "主键",paramType = "form",dataType="Long"),
	            @ApiImplicitParam(name="comment",value = "评论信息",paramType = "form",required = true,dataType="String"),        
	            @ApiImplicitParam(name="userId",value = "用户id",paramType = "form",required = true,dataType="Long"),
	           
	    })
	    @PostMapping("saveOrUpdate")
	    public Message saveOrUpdate(Long id,String comment,Long userId){
		 	Comment comment1 = new Comment();
		 	comment1.setId(id);
		 	comment1.setComment(comment);
		 	comment1.setUserId(userId);
		 	commentService.saveOrUpdate(comment1);
	    	return MessageUtil.success("操作成功");
	    }
	 
     @ApiOperation(value="多条件符合级联查询",notes="级联查询出资讯评论")
	 
	 @ApiImplicitParams({
		 @ApiImplicitParam(name="comment",value = "评论信息",paramType = "query"),
		 @ApiImplicitParam(name="status",value = "状态",paramType = "query"),
	 })
	 @GetMapping("queryCascade")
	 public Message queryCascade(String comment,String status){
	      List<CommentExtend> list = commentService.queryCascade(comment,status);
	      return MessageUtil.success(list);
	    }

}
