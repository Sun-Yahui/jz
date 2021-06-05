package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.BasePrivilege;
import com.briup.jz.service.IPrivilegeService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="特权信息相关接口")
@Validated
@RestController
@RequestMapping("/privilege")
public class PrivilegeController {
	 @Autowired
	    private IPrivilegeService iPrivilegeService;

	    @ApiOperation(value = "查询所有特权信息")
	    @GetMapping("query")
	    public Message query(String name){
	        List<BasePrivilege> list = iPrivilegeService.query(name);
	        return MessageUtil.success(list);
	    }

	    @ApiOperation(value = "通过id删除")
	    @GetMapping("deleteById")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
	    })
	    public Message deleteById(@NotNull Long id){
	    	iPrivilegeService.deleteById(id);
	        return MessageUtil.success("删除成功");
	    }

	    @ApiOperation(value = "保存或更新特权信息")
	    @ApiImplicitParams({
	            @ApiImplicitParam(name="id",value = "主键",paramType = "form",dataType="long"),
	            @ApiImplicitParam(name="name",value = "栏目名称",paramType = "form",required = true),
	            @ApiImplicitParam(name="description",value = "栏目描述",paramType = "form"),
	            @ApiImplicitParam(name="route",value = "路线",paramType = "form"),
	            @ApiImplicitParam(name="routeName",value = "路线名称",paramType = "form"),
	            @ApiImplicitParam(name="icon",value = "图标",paramType = "form"),
	            @ApiImplicitParam(name="hidden",value = "hidden",paramType = "form",required = true,dataType="long"),
	            @ApiImplicitParam(name="num",value = "总和",paramType = "form",dataType="long"),
	            @ApiImplicitParam(name="parentId",value = "外键id",paramType = "form",dataType="long"),
	    })
	    @PostMapping("saveOrUpdate")
	    public Message saveOrUpdate(Long id,String name,String description,String route,String routeName,String icon,Integer hidden,Integer num,Long parentId){
	    	BasePrivilege basePrivilege =new BasePrivilege();
	    	basePrivilege.setId(id);
	    	basePrivilege.setName(name);
	    	basePrivilege.setDescription(description);
	    	basePrivilege.setRoute(route);
	    	basePrivilege.setRouteName(routeName);
	    	basePrivilege.setIcon(icon);
	    	basePrivilege.setHidden(hidden);
	    	basePrivilege.setNum(num);
	    	basePrivilege.setParentId(parentId);
	    	iPrivilegeService.saveOrUpdate(basePrivilege);
	        return MessageUtil.success("更新成功");
	    }

}
