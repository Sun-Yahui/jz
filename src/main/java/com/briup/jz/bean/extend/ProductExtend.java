package com.briup.jz.bean.extend;

import com.briup.jz.bean.OrderLine;
import com.briup.jz.bean.Product;
import com.briup.jz.bean.ProductCategory;

import java.util.List;


//用于封装多表查询的结果
public class ProductExtend extends Product {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    //多对一关系,多个文章对应一个栏目分类,一个文章有一个栏目分类
    private ProductCategory productCategory;

    //一对多关系
    private List<OrderLine> order;

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public List<OrderLine> getOrder() {
        return order;
    }

    public void setOrder(List<OrderLine> order) {
        this.order = order;
    }
}












