package com.briup.jz.web.controller;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.AccountApply;
import com.briup.jz.bean.Category;
import com.briup.jz.service.IAccountApplyService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "账户管理相关接口")
@Validated
@RestController
@RequestMapping("/AccountApply")
public class AccountApplyController {
	@Autowired
	private IAccountApplyService accountApplyService;

	@ApiOperation(value = "分页查询账户变动信息")
	@GetMapping("pageQuery")
	@ApiImplicitParams({ 
	@ApiImplicitParam(name = "id", value = "主键", paramType = "query",dataType="int"), 
	@ApiImplicitParam(name = "status", value = "通过，不通过，未审核", paramType = "query",dataType="String"),
	@ApiImplicitParam(name = "applyType", value = "充值，提现", paramType = "query",dataType="String"),})
	public Message pageQuery(Long page,Long pageSize,String applyType, String status, Long userId,Long beginTime,Long endTime,Long id) {
		
		List<AccountApply> list = accountApplyService.pageQuery(page,pageSize,applyType,status,userId, beginTime,endTime,id);
		return MessageUtil.success(list);
	}
 
	@ApiOperation(value = "撤销账户变动申请")
	@GetMapping("revokeAccountApply")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", paramType = "query",dataType="int"), })
	public Message revokeAccountApply(Long id) {
		accountApplyService.deleteById(id);
		return MessageUtil.success("撤销账户变动申请成功");
	}

//	@ApiOperation(value = "保存或更新账户申请信息")
//	@ApiImplicitParams({
//	
//	@ApiImplicitParam(name = "id", value = "主键", paramType = "form",dataType="int"),
//	@ApiImplicitParam(name = "money", paramType = "form",dataType="double"),
//	@ApiImplicitParam(name = "applyType", paramType = "form",dataType="String"),
//	@ApiImplicitParam(name = "applyTime", paramType = "form",dataType="int"),
//	@ApiImplicitParam(name = "status", paramType = "form",dataType="String"),
//	@ApiImplicitParam(name = "userId", value = "外键",paramType = "form",dataType="int"),
//	@ApiImplicitParam(name = "reason", paramType = "form",dataType="String"),})
//	@PostMapping("saveOrUpdate")
//	public Message saveOrUpdate(AccountApply accountApply) {
//		accountApplyService.saveOrUpdate(accountApply);
//		return MessageUtil.success("更新成功");
//	}
	@ApiOperation(value = "审核不通过")
	@GetMapping("checkNoPass")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", paramType = "query", required = true,dataType="int"), })
	public Message checkNoPass(String reason,Long id) {
		AccountApply accountApply = accountApplyService.findById(id);
		accountApply.setId(id);
		accountApply.setReason(reason);
		accountApply.setStatus("不通过");
		accountApplyService.saveOrUpdate(accountApply);
		return MessageUtil.success("设置不通过成功");
	}

	@ApiOperation(value = "审核通过")
	@GetMapping("checkPass")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", paramType = "query", required = true,dataType="int"), })
	public Message checkPass(@NotNull Long id) {
		AccountApply accountApply = accountApplyService.findById(id);
		accountApply.setStatus("通过");
		accountApplyService.saveOrUpdate(accountApply);
		return MessageUtil.success("设置通过成功");
}
	@ApiOperation(value = "提交账户变动申请")
	@PostMapping("submitAccountApply")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键", paramType = "query",dataType="int"), 
    @ApiImplicitParam(name = "status", value = "该框不许填写，默认为未审核", paramType = "query"),
    @ApiImplicitParam(name = "applyType", value = "提现，充值", paramType = "query"),
    @ApiImplicitParam(name = "applyTime", value = "该框不许填写，默认为当前时间", paramType = "query"),})
	public Message submitAccountApply(AccountApply accountApply) {
		accountApply.setStatus("未审核");
		accountApply.setApplyTime(new Date().getTime());
		accountApplyService.saveOrUpdate(accountApply);
		return MessageUtil.success("提交账户变动申请成功");
	}}
