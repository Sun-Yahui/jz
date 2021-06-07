package com.briup.jz.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.BaseUser;
import com.briup.jz.bean.extend.BaseUserExtend;
import com.briup.jz.service.IUserService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="用户信息相关接口")
@Validated
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "查询用户信息")
    @GetMapping("query")
    @ApiImplicitParams({
        @ApiImplicitParam(name="username",value = "用户名",paramType = "query"),
        @ApiImplicitParam(name="status",value = "实名制状态[正常、禁用]",paramType = "query"),})
    public Message query(String username,String status){
        List<BaseUser> list = userService.query(username,status);
        return MessageUtil.success(list);
    }
    
    @ApiOperation(value = "查询用户账户下所有信息")
    @GetMapping("selectByIdToAccount")
    public Message selectByIdToAccount(Long id){
        return MessageUtil.success( userService.selectByIdToAccount(id));
    }
    
    @ApiOperation(value = "查询用户信息")
    @GetMapping("read")
    @ApiImplicitParams({
        @ApiImplicitParam(name="id",value = "id",paramType = "query"),})
    public Message read(long id){
    	BaseUserExtend list = userService.read(id);
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过id删除")
    @GetMapping("deleteById")
    @ApiImplicitParams({
        @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
    })
    public Message deleteById(@NotNull Long id){
    	userService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "保存或更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "主键",paramType = "form",dataType="long"),
            @ApiImplicitParam(name="username",value = "用户名",paramType = "form",required=true),
            @ApiImplicitParam(name="password",value = "密码",paramType = "form",required=true),
            @ApiImplicitParam(name="telephone",value = "电话",paramType = "form"),
            @ApiImplicitParam(name="realname",value = "姓名",paramType = "form"),
            @ApiImplicitParam(name="gender",value = "性别",paramType = "form"),
            @ApiImplicitParam(name="birth",value = "生日",paramType = "form",dataType="long"),
            @ApiImplicitParam(name="email",value = "email",paramType = "form"),
            @ApiImplicitParam(name="status",value = "状态",paramType = "form"),
            @ApiImplicitParam(name="userFace",value = "用户头像",paramType = "form"),
            @ApiImplicitParam(name="registerCime",value = "注册时间",paramType = "form",dataType="long"),
            @ApiImplicitParam(name="nation",value = "民族",paramType = "form"),
            @ApiImplicitParam(name="idCard",value = "身份证号",paramType = "form"),
            @ApiImplicitParam(name="idcardPhotoPositive",value = "身份证正面",paramType = "form"),
            @ApiImplicitParam(name="idcardPhotoNegative",value = "身份证反面",paramType = "form"),
            @ApiImplicitParam(name="bankCard",value = "银行卡号",paramType = "form"),
            @ApiImplicitParam(name="bankCardPhoto",value = "银行卡照片",paramType = "form"),
            @ApiImplicitParam(name="balance",value = "账户余额",paramType = "form",dataType="long"),
            @ApiImplicitParam(name="certificationStatus",value = "实名制状态【正常、禁用】",paramType = "form"),
            @ApiImplicitParam(name="certificationTime",value = "实名制时间",paramType = "form",dataType="long")
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(BaseUser baseUser){
    	userService.saveOrUpdate(baseUser);
        return MessageUtil.success("更新成功");
    }

    // 这里是假登录
    @PostMapping("login")
    public Message login(String username,String password) {
        Map<String, String> map = new HashMap<>();
        map.put("token", "admin");
        return MessageUtil.success(map);
    }

    // 这里是假获取用户信息
    @GetMapping("info")
    public Message info(String token) {
        BaseUser user = new BaseUser();
        user.setRealname("张三");
        user.setUserFace("http://121.199.29.84:8888/group1/M00/00/16/rBD-SV_EpjyAa0qIAAA-lQCALyU911.jpg");
        return MessageUtil.success(user);
    }
    
 // 这里是假退出
 	@PostMapping("logout")
 	public Message logout() {
 		return MessageUtil.success(null);
 	}

}