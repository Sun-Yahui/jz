package com.briup.jz.bean.extent;

import com.briup.jz.bean.Product;
import com.briup.jz.bean.ProductCategory;


//用于封装多表查询的结果
public class ProductExtend extends Product {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    //多对一关系,多个文章对应一个栏目分类,一个文章有一个栏目分类
    private ProductCategory productCategory;

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}