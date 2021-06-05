package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.BaseLog;

import com.briup.jz.service.IBaseLogService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="系统日志相关接口")
@Validated
@RestController
@RequestMapping("/baseLog")
public class BaseLogController {
	
	@Autowired
	public IBaseLogService baseLogService;
	
	@ApiOperation("多条件符合查询")
	
	@ApiImplicitParams({
		@ApiImplicitParam(name="realname",value = "真实名字",paramType = "query"),
		@ApiImplicitParam(name="method",value = "方法",paramType = "query"),
	})
    @GetMapping("query")
    public Message query(String realname,String method){
        List<BaseLog> list = baseLogService.query(realname,method);
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过id删除")
    @GetMapping("deleteById")
    @ApiImplicitParams({
        @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
    })
    public Message deleteById(@NotNull Long id){
    	baseLogService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value="保存或更新日志分类信息",notes="如果id为空是保存否则是更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "主键",paramType = "form",dataType="Long"),
            @ApiImplicitParam(name="realname",value = "真实名字",paramType = "form",required = true,dataType="String"),
            @ApiImplicitParam(name="method",value = "方法",paramType = "form",required = true,dataType="String"),
            @ApiImplicitParam(name="content",value = "文章",paramType = "form",required = true,dataType="String"),
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Long id,String realname,String method,String content){
    	BaseLog baseLog = new BaseLog();
    	baseLog.setId(id);
    	baseLog.setRealname(realname);
    	baseLog.setMethod(method);
    	baseLog.setContent(content);
    	baseLogService.saveOrUpdate(baseLog);
    	return MessageUtil.success("操作成功");
    }
	
	
}
