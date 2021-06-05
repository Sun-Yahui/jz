package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.BaseConfig;
import com.briup.jz.service.IBaseConfigService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="配置模块相关接口")
@Validated
@RestController
@RequestMapping("/baseConfig")
public class BaseConfigController {
	
	@Autowired
	public IBaseConfigService baseConfigService;
	
	
	    @ApiOperation("多条件符合查询")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name="name",value = "栏目名称",paramType = "query"),
	    	@ApiImplicitParam(name="val",value = "栏目描述",paramType = "query"),
	    })
	    @GetMapping("query")
	    public Message query(String name,String val){
	        List<BaseConfig> list = baseConfigService.query(name,val);
	        return MessageUtil.success(list);
	    }

	    @ApiOperation(value = "通过id删除")
	    @GetMapping("deleteById")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
	    })
	    public Message deleteById(@NotNull Long id){
	    	baseConfigService.deleteById(id);
	        return MessageUtil.success("删除成功");
	    }

	    @ApiOperation(value="保存或更新配置信息",notes="如果id为空是保存否则是更新")
	    @ApiImplicitParams({
	            @ApiImplicitParam(name="id",value = "主键",paramType = "form",dataType="int"),
	            @ApiImplicitParam(name="name",value = "栏目名称",paramType = "form",required = true,dataType="String"),
	            @ApiImplicitParam(name="val",value = "栏目描述",paramType = "form",required = true,dataType="String"),
	            @ApiImplicitParam(name="introduce",value = "序号",paramType = "form",required = true,dataType="String"),
	            
	    })
	    @PostMapping("saveOrUpdate")
	    public Message saveOrUpdate(BaseConfig baseConfig){
	    	baseConfigService.saveOrUpdate(baseConfig);
	        return MessageUtil.success("更新成功");
	    }
}
