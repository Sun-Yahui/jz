package com.briup.jz.service;

import com.briup.jz.bean.Product;
import com.briup.jz.utils.CustomerException;

import java.util.List;

public interface IProductService {

    void saveOrUpdate(Product product) throws CustomerException;

    List<Product> pageQuery(String name);

    void deleteById(long id) throws CustomerException;
}
