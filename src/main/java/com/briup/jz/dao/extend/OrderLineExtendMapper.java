package com.briup.jz.dao.extend;

import com.briup.jz.bean.OrderLine;

import java.util.List;

public interface OrderLineExtendMapper {
    List<OrderLine> selectByProductId(Long productId);
}
