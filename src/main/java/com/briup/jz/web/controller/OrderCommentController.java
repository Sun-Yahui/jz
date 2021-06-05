package com.briup.jz.web.controller;

import java.util.List;
//import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.OrderComment;
import com.briup.jz.service.IOrderCommentService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="jz-订单评论相关接口")
@Validated
@RestController
@RequestMapping("/orderComment")
public class OrderCommentController {

@Autowired
private IOrderCommentService orderCommentService;

@ApiOperation("多条件符合查询")

@ApiImplicitParams({
	@ApiImplicitParam(name="content",value="文章标题",paramType="query"),
	@ApiImplicitParam(name="status",value="状态[未审核、通过、不通过、推荐]",paramType="query"),
})
@GetMapping("query")
public Message query(String content ,String status){
  List<OrderComment> list = orderCommentService.query(content,status);
  return MessageUtil.success(list);
}

@ApiOperation(value = "通过id删除")
@GetMapping("deleteById")
@ApiImplicitParams({
  @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
})
public Message deleteById(@NonNull Long id){
  orderCommentService.deleteById(id);
  return MessageUtil.success("删除成功");
}

@ApiOperation(value = "保存或更新资讯分类信息")
@ApiImplicitParams({
	  @ApiImplicitParam(name="id",value = "主键",paramType = "form"),
  @ApiImplicitParam(name="content",value = "评价",paramType = "form",required = true),
  @ApiImplicitParam(name="commentTime",value = "时间",paramType = "form"),
  @ApiImplicitParam(name="status",value = "状况",paramType = "form"),
  @ApiImplicitParam(name="orderId",value = "订单编号",paramType = "form"),
  @ApiImplicitParam(name="customerId",value = "客户编号",paramType = "form"),

})
@PostMapping("saveOrUpdate")
public Message saveOrUpdate(OrderComment orderComment){
  orderCommentService.saveOrUpdate(orderComment);
  return MessageUtil.success("更新成功");
}
}