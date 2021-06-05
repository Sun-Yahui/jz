package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.BaseFile;
import com.briup.jz.service.IBaseFileService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="附件表相关接口")
@Validated
@RestController
@RequestMapping("/baseFile")
public class BaseFileController {
	
	@Autowired
	public IBaseFileService baseFileService;
	
	@ApiOperation(value = "查询所有附件表")
    @GetMapping("query")
    public Message query(String fileName){
        List<BaseFile> list = baseFileService.query(fileName);
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过id删除")
    @GetMapping("deleteById")
    @ApiImplicitParams({
        @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
    })
    public Message deleteById(@NotNull String id){
    	baseFileService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "保存或更新资讯附件表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "主键",paramType = "form",dataType="String"),
            @ApiImplicitParam(name="fileName",value = "文件名字",paramType = "form",required = true,dataType="String"),
            @ApiImplicitParam(name="groupName",value = "组名",paramType = "form",dataType="String"),
            @ApiImplicitParam(name="uploadTime",value = "上传时间",paramType = "form",dataType="int"),
            @ApiImplicitParam(name="extName",value = "扩展名",paramType = "form",dataType="String"),
            @ApiImplicitParam(name="fileSize",value = "文件大小",paramType = "form",dataType="int"),
            @ApiImplicitParam(name="fileType",value = "文件类型",paramType = "form",dataType="String"),
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(BaseFile baseFile){
    	baseFileService.saveOrUpdate(baseFile);
        return MessageUtil.success("更新成功");
    }
}
