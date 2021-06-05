package com.briup.jz.service.impl;


import com.briup.jz.bean.Category;
import com.briup.jz.bean.CategoryExample;
import com.briup.jz.bean.ProductCategory;
import com.briup.jz.bean.ProductCategoryExample;
import com.briup.jz.dao.ProductCategoryMapper;
import com.briup.jz.service.IProductCategoryService;
import com.briup.jz.utils.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements IProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public void  saveOrUpdate(ProductCategory productCategory) throws CustomerException {
        if(productCategory.getId()!=null) {
            productCategoryMapper.updateByPrimaryKey(productCategory);
        } else {
            // 判断是否有同名的分类，如果有抛出异常
            ProductCategoryExample example = new ProductCategoryExample();
            example.createCriteria().andNameEqualTo(productCategory.getName());
            List<ProductCategory> list = productCategoryMapper.selectByExample(example);
            if(list.size()>0) {
                throw new CustomerException("同名的分类已存在");
            }
            productCategoryMapper.insert(productCategory);
        }
    }

    @Override
    public List<ProductCategory> pageQuery(String name){
       ProductCategoryExample example = new ProductCategoryExample();
//        if(id!=null){
//            example.createCriteria().andIdEqualTo(id);
//        }
        if(name!=null){
            example.createCriteria().andNameLike("%"+name+"%");
        }
        //返回查询结果
        return productCategoryMapper.selectByExample(example);
    }

    @Override
    public  void deleteById(long id) throws CustomerException {
        ProductCategory productCategory = productCategoryMapper.selectByPrimaryKey(id);
        if (productCategory == null) {
            throw new CustomerException("要删除的分类信息不存在");
        }
        productCategoryMapper.deleteByPrimaryKey(id);
    }


}
