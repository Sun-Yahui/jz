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

import com.briup.jz.bean.OrderLine;
import com.briup.jz.service.IOrderLineService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="资讯分类相关接口")
@Validated
@RestController
@RequestMapping("/orderLine")
public class OrderLineController {

@Autowired
private IOrderLineService orderLineService;

@ApiOperation("多条件符合查询")
@ApiImplicitParams({
		@ApiImplicitParam(name="price",value="价格",paramType="query"),
		@ApiImplicitParam(name="productId",value="产品ID",paramType="query"),
		
	})
@GetMapping("query")
public Message query(Double price,Long productId){
    List<OrderLine> list = orderLineService.query(price,productId);
    return MessageUtil.success(list);
}

@ApiOperation(value = "通过id删除")
@GetMapping("deleteById")
@ApiImplicitParams({
    @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
})
public Message deleteById(@NonNull Long id){
    orderLineService.deleteById(id);
    return MessageUtil.success("删除成功");
}
@ApiOperation(value = "保存或更新资讯分类信息")
@ApiImplicitParams({
	  @ApiImplicitParam(name="id",value = "主键",paramType = "form"),
    @ApiImplicitParam(name="number",value = "数量",paramType = "form"),
    @ApiImplicitParam(name="price",value = "价格",paramType = "form"),
    @ApiImplicitParam(name="productId",value = "产品编号",paramType = "form",required = true),
    @ApiImplicitParam(name="orderId",value = "订单编号",paramType = "form"),

})
@PostMapping("saveOrUpdate")
public Message saveOrUpdate(OrderLine orderLine){
    orderLineService.saveOrUpdate(orderLine);
    return MessageUtil.success("更新成功");
}
}
