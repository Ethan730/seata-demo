package com.ethan.service;

import com.ethan.dao.OrderDao;
import com.ethan.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public int create(Order order)
    {
        return orderDao.create(order);
    }

    public Order getOrderById(Long id)
    {
        return orderDao.getOrderById(id);
    }
}
