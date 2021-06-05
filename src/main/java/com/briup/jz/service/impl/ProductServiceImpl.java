package com.briup.jz.service.impl;

import com.briup.jz.bean.*;
import com.briup.jz.dao.ProductMapper;
import com.briup.jz.service.IProductService;
import com.briup.jz.utils.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public void saveOrUpdate(Product product) throws CustomerException{
        if(product.getId()!=null) {
            productMapper.updateByPrimaryKey(product);
        } else {
            // 判断是否有同名的分类，如果有抛出异常
            ProductExample example = new ProductExample();
            example.createCriteria().andNameEqualTo(product.getName());
            List<Product> list = productMapper.selectByExample(example);
            if(list.size()>0) {
                throw new CustomerException("同名的分类已存在");
            }
            productMapper.insert(product);
        }
    }

    @Override
    public List<Product> pageQuery(String name,String status,Long productCategoryId){
        ProductExample example = new ProductExample();
        if(name!=null){
            example.createCriteria().andNameLike("%"+name+"%");
        }
        if(status!=null){
            example.createCriteria().andStatusEqualTo(status);
        }
        if(productCategoryId!=null){
            example.createCriteria().andProductCategoryIdEqualTo(productCategoryId);
        }
        List<Product> list = productMapper.selectByExample(example);
        return list;
    }

    @Override
    public  void deleteById(long id) throws CustomerException {
        Product product = productMapper.selectByPrimaryKey(id);
        if (product == null) {
            throw new CustomerException("要删除的分类信息不存在");
        }
        productMapper.deleteByPrimaryKey(id);
    }
}
