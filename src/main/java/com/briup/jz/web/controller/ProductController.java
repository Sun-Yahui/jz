package com.briup.jz.web.controller;

import com.briup.jz.bean.OrderLine;
import com.briup.jz.bean.Product;
import com.briup.jz.bean.extend.ProductExtend;
import com.briup.jz.service.IProductService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@Api(description = "jz-产品相关接口")
@Validated
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;


    @GetMapping("order")
    @ApiOperation("产品订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "产品订单编号",required=true,dataType="long",paramType="query")
    })
    public Message order(Long id){
        ProductExtend product = productService.order(id);
        return MessageUtil.success(product);
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation(value = "保存或更新产品信息",notes = "如果ID不为空，为修改操作，根据ID进行修改；如果ID为空，为保存操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "产品编号",dataType="long",paramType="query"),
            @ApiImplicitParam(name="name",value = "产品名称",dataType="string",paramType="query"),
            @ApiImplicitParam(name="price",value = "产品价格",dataType="double",paramType="query"),
            @ApiImplicitParam(name="status",value = "产品状态",dataType="string",paramType="query"),
            @ApiImplicitParam(name="productCategoryId",value = "类别id",dataType="long",paramType="query"),
    })
    public Message saveOrUpdate(Product product){
        productService.saveOrUpdate(product);
        return MessageUtil.success("更新成功");
    }

    @GetMapping("pageQuery")
    @ApiOperation("分页查询产品相关信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value = "产品名称",dataType="string",paramType="query"),
            @ApiImplicitParam(name="status",value = "产品状态",dataType="string",paramType="query"),
            @ApiImplicitParam(name="productCategoryId",value = "类别id",dataType="long",paramType="query")
    })
    public Message pageQuery(String name,String status,Long productCategoryId){
        List<Product> list = productService.pageQuery(name,status,productCategoryId);
        return MessageUtil.success(list);
    }

    @GetMapping("queryCascade")
    @ApiOperation(value = "分页查询产品相关信息",notes = "级联查询出文章所属分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value = "产品名称",dataType="string",paramType="query"),
            @ApiImplicitParam(name="status",value = "产品状态",dataType="string",paramType="query"),
            @ApiImplicitParam(name="productCategoryId",value = "产品类别分类",dataType="long",paramType="query")
    })
    public Message queryCascade(String name,String status,Long productCategoryId){
        List<ProductExtend> list = productService.queryCascade(name,status,productCategoryId);
        return MessageUtil.success(list);
    }

    @GetMapping("deleteById")
    @ApiOperation("通过id删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "产品编号",required=true,dataType="string",paramType="query"),
    })
    public Message deleteById(@NotNull Long id){
        productService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
}
