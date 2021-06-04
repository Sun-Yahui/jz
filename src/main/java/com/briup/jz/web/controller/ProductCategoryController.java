package com.briup.jz.web.controller;

import java.util.List;
import com.briup.jz.bean.ProductCategory;
import com.briup.jz.service.IProductCategoryService;
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

@Api(description = "jz-产品分类相关接口")
@Validated
@RestController
@RequestMapping("productCategory")
public class ProductCategoryController {

    @Autowired
    private IProductCategoryService productCategoryService;

    @PostMapping("saveOrUpdate")
    @ApiOperation(value = "保存或更新产品分类信息",notes="如果ID不为空，为修改操作，根据ID进行修改；如果ID为空，为保存操作")
    public Message saveOrUpdate(ProductCategory productCategory){
        productCategoryService.saveOrUpdate(productCategory);
        return MessageUtil.success("更新成功");
    }

    @GetMapping("pageQuery")
    @ApiOperation(value = "分页查询产品分类相关信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="id",value = "产品id",required=true,dataType="string",paramType="query"),
//    })
    public Message pageQuery(){
        List<ProductCategory> list = productCategoryService.pageQuery();
        return MessageUtil.success(list);
    }

    @GetMapping("deleteById")
    @ApiOperation(value = "通过id删除产品分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "产品id",dataType="long",paramType = "query", required=true),
    })
    public Message deleteById(@NotNull Long id){
        productCategoryService.deleteById(id);
        return MessageUtil.success("删除成功");
    }


}
