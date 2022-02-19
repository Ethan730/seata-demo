package com.ethan.tcc.impl;

import com.alibaba.fastjson.JSONObject;
import com.ethan.dao.OrderDao;
import com.ethan.entity.Order;
import com.ethan.tcc.OrderTccAction;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderTccActionImpl implements OrderTccAction {
    @Autowired
    private OrderDao orderDao;
    @Override
    public boolean createOrder(BusinessActionContext businessActionContext, Order order) {
        order.setStatus(1);
        orderDao.insertTcc(order);
        log.info("创建订单：tcc一阶段try成功");
        return true;
    }

    @Override
    public boolean commit(BusinessActionContext businessActionContext) {
        Order order = ((JSONObject) businessActionContext.getActionContext("order")).toJavaObject(Order.class);
        order.setStatus(0);
        orderDao.update(order);
        log.info("创建订单：tcc二阶段commit成功");
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext businessActionContext) {
        Order order = ((JSONObject) businessActionContext.getActionContext("order")).toJavaObject(Order.class);
        orderDao.delete(order);
        log.info("创建订单：tcc二阶段rollback成功");
        return true;
    }
}
