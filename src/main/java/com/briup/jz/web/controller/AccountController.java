package com.briup.jz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.AccountApply;
import com.briup.jz.bean.AccountCustomer;
import com.briup.jz.bean.AccountEmployee;
import com.briup.jz.bean.AccountSystem;
import com.briup.jz.bean.Platform;
import com.briup.jz.service.IAccountCustomerService;
import com.briup.jz.service.IAccountEmployeeService;
import com.briup.jz.service.IAccountSystemService;
import com.briup.jz.service.IPlatformService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "账户相关接口")
@Validated
@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private IAccountCustomerService accountCustomerService;
	@Autowired
	private IAccountEmployeeService accountEmployeeService;
	@Autowired
	private IAccountSystemService accountSystemService;
	@Autowired
	private IPlatformService platformService;
	
	@ApiOperation(value = "分页顾客查询账单")
	@GetMapping("pageQueryCustomerAcount")
	@ApiImplicitParams({ 
	@ApiImplicitParam(name = "id", value = "主键", paramType = "query",dataType="int"), 
	@ApiImplicitParam(name = "status", value = "状态【正常】", paramType = "query",dataType="String"),
	@ApiImplicitParam(name = "type", value = "充值，消费", paramType = "query",dataType="String"),
	@ApiImplicitParam(name = "transferTime", value = "开始时间", paramType = "query",dataType="long"),
	@ApiImplicitParam(name = "endTime", value = "结束时间", paramType = "query",dataType="long"),})
	public Message pageQueryCustomerAcount(Long page,Long pageSize,String type, String status, Long userId,Long transferTime,Long endTime,Long id) {
		
		List<AccountCustomer> list = accountCustomerService.findAll(page,pageSize,type,status,userId, transferTime,endTime,id);
		return MessageUtil.success(list);
	}
 
	@ApiOperation(value = "分页员工查询账单")
	@GetMapping("pageQueryEmployeeAcount")
	@ApiImplicitParams({ 
	
	@ApiImplicitParam(name = "status", value = "状态【正常】", paramType = "query",dataType="String"),
	@ApiImplicitParam(name = "type", value = "提现，收益", paramType = "query",dataType="String"),
	@ApiImplicitParam(name = "userId", value = "雇员编号", paramType = "query",dataType="String"),
	@ApiImplicitParam(name = "transferTime", value = "开始时间", paramType = "query",dataType="long"),
	@ApiImplicitParam(name = "endTime", value = "结束时间", paramType = "query",dataType="long"),})
	public Message pageQueryEmployeeAcount(Long page,Long pageSize,String type, String status, Long userId,Long transferTime,Long endTime) {
		
		List<AccountEmployee> list = accountEmployeeService.findAll(page,pageSize,type,status,userId, transferTime,endTime);
		return MessageUtil.success(list);
	}
 
	@ApiOperation(value = "分页系统查询账单")
	@GetMapping("pageQuerySystemAcount")
	@ApiImplicitParams({ 	
	@ApiImplicitParam(name = "status", value = "状态【正常】", paramType = "query",dataType="String"),
	@ApiImplicitParam(name = "type", value = "充值，收益，提现", paramType = "query",dataType="String"),
	@ApiImplicitParam(name = "transferTime", value = "开始时间", paramType = "query",dataType="long"),
	@ApiImplicitParam(name = "endTime", value = "结束时间", paramType = "query",dataType="long"),})
	public Message pageQuerySystemAcount(Long page,Long pageSize,String type, String status,Long transferTime,Long endTime) {
		
		List<AccountSystem> list = accountSystemService.findAll(page,pageSize,type,status,transferTime,endTime);
		return MessageUtil.success(list);


	}
	
}
