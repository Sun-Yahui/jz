package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.Carousel;

import com.briup.jz.service.ICarouselService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="轮播图相关接口")
@Validated
@RestController
@RequestMapping("/carousel")
public class CarouselController {
	
	@Autowired
	public ICarouselService carouselService;
	
	@ApiOperation(value = "查询所有轮播图")
    @GetMapping("query")
    public Message query(String name){
        List<Carousel> list = carouselService.query(name);
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过id删除")
    @GetMapping("deleteById")
    @ApiImplicitParams({
        @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
    })
    public Message deleteById(@NotNull Long id){
    	carouselService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "保存或更新轮播图")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "主键",paramType = "form",dataType="Long"),
            @ApiImplicitParam(name="name",value = "轮播图名称",paramType = "form",required = true,dataType="String"),
            @ApiImplicitParam(name="introduce",value = "轮播图介绍",paramType = "form",required = true,dataType="String"),
            @ApiImplicitParam(name="url",value = "路径",paramType = "form",dataType="String"),
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Long id,String name,String introduce,String url){
    	Carousel carousel = new Carousel();
    	carousel.setId(id);
    	carousel.setName(name);
    	carousel.setIntroduce(introduce);
    	carousel.setUrl(url);
    	carouselService.saveOrUpdate(carousel);
    	return MessageUtil.success("操作成功");
    }
}
