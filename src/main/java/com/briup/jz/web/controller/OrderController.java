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

import com.briup.jz.bean.Order;
import com.briup.jz.service.IOrderService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="资讯分类相关接口")
@Validated
@RestController
@RequestMapping("/order")
public class OrderController {

  @Autowired
  private IOrderService orderService;

  @ApiOperation("多条件符合查询")
  @ApiImplicitParams({
		@ApiImplicitParam(name="id",value="订单号",paramType="query"),
		@ApiImplicitParam(name="status",value="状态[已完成，待接单，待派单，待服务]",paramType="query"),
	})
  @GetMapping("query")
  public Message query(Long id,String status){
      List<Order> list = orderService.query(id,status);
      return MessageUtil.success(list);
  }

  @ApiOperation(value = "通过id删除")
  @GetMapping("deleteById")
  @ApiImplicitParams({
      @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
  })
  public Message deleteById(@NonNull Long id){
      orderService.deleteById(id);
      return MessageUtil.success("删除成功");
  }
  @ApiOperation(value = "保存或更新资讯分类信息")
  @ApiImplicitParams({
      @ApiImplicitParam(name="id",value = "主键",paramType = "form"),
      @ApiImplicitParam(name="orderTime",value = "订单时间",paramType = "form",required = true),
      @ApiImplicitParam(name="serviceTime",value = "服务时间",paramType = "form"),
      @ApiImplicitParam(name="total",value = "总时",paramType = "form"),
      @ApiImplicitParam(name="status",value = "状态",paramType = "form"),
      @ApiImplicitParam(name="remark",value = "标记",paramType = "form"),
      @ApiImplicitParam(name="customerId",value = "客户id",paramType = "form"),
      @ApiImplicitParam(name="addressId",value = "地址id",paramType = "form"),
      @ApiImplicitParam(name="employeeId ",value = "雇员id",paramType = "form"),

  })
  @PostMapping("saveOrUpdate")
  public Message saveOrUpdate(Order order){
  	orderService.saveOrUpdate(order);
      return MessageUtil.success("操作成功");
  }
}