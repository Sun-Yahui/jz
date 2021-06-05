package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.BaseUserRole;
import com.briup.jz.service.IUserRoleService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="用户和角色id相关接口")
@Validated
@RestController
@RequestMapping("/userrole")
public class UserRoleController {
	@Autowired
    private IUserRoleService iUserRoleService;

    @ApiOperation(value = "查询所有id")
    @GetMapping("query")
    public Message query(){
        List<BaseUserRole> list = iUserRoleService.query();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过id删除")
    @GetMapping("deleteById")
    @ApiImplicitParams({
        @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
    })
    public Message deleteById(@NotNull Long id){
    	iUserRoleService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "保存或更新id信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "主键",paramType = "form"),
            @ApiImplicitParam(name="userId",value = "用户id",paramType = "form",dataType="long"),
            @ApiImplicitParam(name="roleId",value = "角色id",paramType = "form",dataType="long")
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(BaseUserRole baseUserRole){
    	iUserRoleService.saveOrUpdate(baseUserRole);
        return MessageUtil.success("更新成功");
    }

}
