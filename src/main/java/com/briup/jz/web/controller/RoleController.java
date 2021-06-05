package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.BaseRole;
import com.briup.jz.service.IRoleService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="角色分类相关接口")
@Validated
@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
    private IRoleService roleService;

    @ApiOperation(value = "查询所有角色分类")
    @GetMapping("query")
    public Message query(String name){
        List<BaseRole> list = roleService.query(name);
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过id删除")
    @GetMapping("deleteById")
    @ApiImplicitParams({
        @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
    })
    public Message deleteById(@NotNull Long id){
    	roleService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "保存或更新角色分类信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "主键",paramType = "form"),
            @ApiImplicitParam(name="name",value = "角色名称",paramType = "form",required = true),
           
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(BaseRole baseRole){
    	roleService.saveOrUpdate(baseRole);
        return MessageUtil.success("更新成功");
    }
}

