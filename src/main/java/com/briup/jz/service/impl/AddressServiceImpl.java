package com.briup.jz.service.impl;

import com.briup.jz.bean.*;
import com.briup.jz.dao.AddressMapper;
import com.briup.jz.dao.ProductMapper;
import com.briup.jz.service.IAddressService;
import com.briup.jz.utils.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public void saveOrUpdate(Address address) throws CustomerException {
        if(address.getId()!=null) {
            addressMapper.updateByPrimaryKey(address);
        } else {
            // 判断是否有同名的分类，如果有抛出异常
            AddressExample example = new AddressExample();
            example.createCriteria().andAddressEqualTo(address.getAddress());
            List<Address> list = addressMapper.selectByExample(example);
            if(list.size()>0) {
                throw new CustomerException("同名的分类已存在");
            }
            addressMapper.insert(address);
        }
    }

    @Override
    public List<Address> pageQuery(String name){
        AddressExample example = new AddressExample();
        if(name!=null){
            example.createCriteria().andAddressEqualTo("%"+name+"%");
        }
        List<Address> list = addressMapper.selectByExample(example);
        return list;
    }

    @Override
    public  void deleteById(long id) throws CustomerException {
        Address address = addressMapper.selectByPrimaryKey(id);
        if (address == null) {
            throw new CustomerException("要删除的分类信息不存在");
        }
        addressMapper.deleteByPrimaryKey(id);
    }
}
