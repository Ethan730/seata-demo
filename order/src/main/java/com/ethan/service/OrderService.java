package com.ethan.service;

import com.ethan.dao.OrderDao;
import com.ethan.entity.Order;
import com.ethan.tcc.OrderTccAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderTccAction orderTccAction;

    public int create(Order order) {
        return orderDao.create(order);
    }

    public Order getOrderById(Long id) {
        return orderDao.getOrderById(id);
    }

    public String tcc() {
        Order order = new Order();
        order.setId(2);
        order.setNumber(2);
        boolean result = orderTccAction.createOrder(null, order);
        int i = 1 / 0;
        return "success";
    }
}
