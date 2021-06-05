package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.BaseRolePrivilege;
import com.briup.jz.service.IRolePrivilegeService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="角色和特权id相关接口")
@Validated
@RestController
@RequestMapping("/roleprivilege")
public class RolePrivilegeController {
	 @Autowired
	    private IRolePrivilegeService iRolePrivilegeService;

	    @ApiOperation(value = "查询所有角色和特权id")
	    @GetMapping("query")
	    public Message query(){
	        List<BaseRolePrivilege> list = iRolePrivilegeService.query();
	        return MessageUtil.success(list);
	    }

	    @ApiOperation(value = "通过id删除")
	    @GetMapping("deleteById")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
	    })
	    public Message deleteById(@NotNull Long id){
	    	iRolePrivilegeService.deleteById(id);
	        return MessageUtil.success("删除成功");
	    }

	    @ApiOperation(value = "保存或更新角色和特权id信息")
	    @ApiImplicitParams({
	            @ApiImplicitParam(name="id",value = "主键",paramType = "form"),
	            @ApiImplicitParam(name="roleId",value = "角色id",paramType = "form"),
	            @ApiImplicitParam(name="privilegeId",value = "特权id",paramType = "form"),

	    })
	    @PostMapping("saveOrUpdate")
	    public Message saveOrUpdate(BaseRolePrivilege baseRolePrivilege){
	    	iRolePrivilegeService.saveOrUpdate(baseRolePrivilege);
	        return MessageUtil.success("更新成功");
	    }

}
