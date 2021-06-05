package com.briup.jz.service;

import com.briup.jz.bean.Address;
import com.briup.jz.bean.Product;
import com.briup.jz.utils.CustomerException;

import java.util.List;

public interface IAddressService {

    void saveOrUpdate(Address address) throws CustomerException;

    List<Address> pageQuery(String name);

    void deleteById(long id) throws CustomerException;
}
