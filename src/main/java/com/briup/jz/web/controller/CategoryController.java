package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.Category;
import com.briup.jz.bean.extend.CategoryExtend;
import com.briup.jz.service.ICategoryService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "资讯分类相关接口")
@Validated
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @ApiOperation(value = "查询所有资讯分类")
    @GetMapping("query")
    public Message query(String name){
        List<Category> list = categoryService.query(name);
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过id删除")
    @GetMapping("deleteById")
    @ApiImplicitParams({
        @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
    })
    public Message deleteById(@NotNull Long id){
        categoryService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value="保存或更新资讯信息",notes="如果id为空是保存否则是更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "主键",paramType = "form",dataType="int"),
            @ApiImplicitParam(name="name",value = "栏目名称",paramType = "form",required = true,dataType="String"),
            @ApiImplicitParam(name="description",value = "栏目描述",paramType = "form",dataType="String"),
            @ApiImplicitParam(name="no",value = "序号",paramType = "form",dataType="int"),
            @ApiImplicitParam(name="parentId",value = "父栏目id",paramType = "form",dataType="int"),
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Category category){
        categoryService.saveOrUpdate(category);
        return MessageUtil.success("更新成功");
    }
    
    @ApiOperation("查看资讯")
    @ApiImplicitParams({
    	 @ApiImplicitParam(name="id",value = "资讯id",paramType = "query",dataType="Long"),
    })
    @GetMapping("look")
    
    public Message look(Long id) {
    	CategoryExtend category=categoryService.look(id);
    	return MessageUtil.success(category);
    }
}
