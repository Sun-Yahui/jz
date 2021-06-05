package com.briup.jz.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.jz.bean.CertificationApply;
import com.briup.jz.service.ICertificationApplyService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description="实名认证申请相关接口相关接口")
@Validated
@RestController
@RequestMapping("/certificationapply")
public class CertificationApplyController {
	@Autowired
    private ICertificationApplyService iCertificationApplyService;

    @ApiOperation(value = "查询所有实名认证信息")
    @GetMapping("query")
    public Message query(String name){
        List<CertificationApply> list = iCertificationApplyService.query(name);
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过id删除")
    @GetMapping("deleteById")
    @ApiImplicitParams({
        @ApiImplicitParam(name="id",value = "主键",paramType = "query", required=true),
    })
    public Message deleteById(@NotNull Long id){
    	iCertificationApplyService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "保存或更新实名认证信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "主键",paramType = "form",dataType="long"),
            @ApiImplicitParam(name="realname",value = "姓名",paramType = "form",required = true),
            @ApiImplicitParam(name="idCard",value = "身份证号",paramType = "form"),
            @ApiImplicitParam(name="idcardPhotoPositive",value = "身份证正面",paramType = "form"),
            @ApiImplicitParam(name="idcardPhotoNegative",value = "身份证反面",paramType = "form"),
            @ApiImplicitParam(name="bankCard",value = "银行卡号",paramType = "form"),
            @ApiImplicitParam(name="bankCardPhoto",value = "银行卡正面",paramType = "form"),
            @ApiImplicitParam(name="status",value = "状态【通过、不通过、未审核】",paramType = "form"),
            @ApiImplicitParam(name="reason",value = "审核不通过理由",paramType = "form"),
            @ApiImplicitParam(name="userId",value = "用户编号",paramType = "form",dataType="long"),
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Long id,String realname,String idCard,String idcardPhotoPositive,String idcardPhotoNegative,String bankCard,String bankCardPhoto,String status,String reason,Long userId){
    	CertificationApply certificationApply = new CertificationApply();
    	certificationApply.setId(id);
    	certificationApply.setRealname(realname);
    	certificationApply.setIdCard(idCard);
    	certificationApply.setIdcardPhotoPositive(idcardPhotoPositive);
    	certificationApply.setIdcardPhotoNegative(idcardPhotoNegative);
    	certificationApply.setBankCard(bankCard);
    	certificationApply.setBankCardPhoto(bankCardPhoto);
    	certificationApply.setStatus(status);
    	certificationApply.setReason(reason);
    	certificationApply.setUserId(userId);
    	
    	iCertificationApplyService.saveOrUpdate(certificationApply);
        return MessageUtil.success("更新成功");
    }

}
