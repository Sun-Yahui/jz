package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.AccountSystem;
import com.briup.jz.bean.Platform;
import com.briup.jz.service.IAccountCustomerService;
import com.briup.jz.service.IPlatformService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "平台管理相关接口")
@Validated
@RestController
@RequestMapping("/Platform")
public class PlatformController {
	@Autowired
	private IPlatformService platformService;
	@ApiOperation(value = "查询所有平台管理")
	@GetMapping("query")
	public Message findAll() {
		List<Platform> list = platformService.findAll();
		return MessageUtil.success(list);
	}

	@ApiOperation(value = "通过id删除平台管理")
	@GetMapping("deleteById")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", paramType = "query", required = true,dataType="int"), })
	public Message deleteById(@NotNull Long id) {
		platformService.deleteById(id);
		return MessageUtil.success("删除成功");
	}

	@ApiOperation(value = "保存或更新账户平台管理")
	@ApiImplicitParam(name = "id", value = "主键", paramType = "form",dataType="int")
	@PostMapping("saveOrUpdate")
	public Message saveOrUpdate(Platform platform) {
		platformService.saveOrUpdate(platform);
		return MessageUtil.success("更新成功");
	}

	}