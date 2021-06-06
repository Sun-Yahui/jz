package com.briup.jz.dao.extend;

import com.briup.jz.bean.extend.ProductExtend;

import java.util.List;

public interface ProductExtendMapper {
    List<ProductExtend> select(String name, String status, Long productCategoryId);

    ProductExtend selectById(Long id);
}
