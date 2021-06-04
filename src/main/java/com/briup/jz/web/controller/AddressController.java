package com.briup.jz.web.controller;

import com.briup.jz.bean.Address;
import com.briup.jz.bean.Product;
import com.briup.jz.service.IAddressService;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@Api(description = "jz-地址相关接口")
@Validated
@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @PostMapping("saveOrUpdate")
    @ApiOperation(value = "保存或更新地址信息",notes = "如果ID不为空，为修改操作，根据ID进行修改；如果ID为空，为保存操作")
    public Message saveOrUpdate(Address address){
        addressService.saveOrUpdate(address);
        return MessageUtil.success("更新成功");
    }

    @GetMapping("pageQuery")
    @ApiOperation("分页查询地址相关信息")
    public Message pageQuery(String name){
        List<Address> list = addressService.pageQuery(name);
        return MessageUtil.success(list);
    }

    @GetMapping("deleteById")
    @ApiOperation("通过id删除")
    public Message deleteById(@NotNull Long id){
        addressService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

}
