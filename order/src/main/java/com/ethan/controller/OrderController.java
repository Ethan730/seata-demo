package com.ethan.controller;

import com.ethan.entity.Account;
import com.ethan.entity.Order;
import com.ethan.service.AccountFeignService;
import com.ethan.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private AccountFeignService accountFeignService;


    @RequestMapping(value = "/order/create")
    @GlobalTransactional
    public String create() {
        Order order = new Order();
        order.setId(2);
        order.setNumber(100);
        int result = orderService.create(order);
        log.info("*****插入结果：" + result);
        Account account = new Account();
        account.setId(100);
        account.setMoney(100);
        int insert = accountFeignService.insert(account);
        return "Success";
    }

    @RequestMapping(value = "/order/get/{id}")
    public String getOrderById(@PathVariable("id") Long id) {
        Order order = orderService.getOrderById(id);
        log.info("*****插入结果：" + order);
        return "Success";
    }

    @RequestMapping(value = "/consumer/account/get/{id}")
    public Account getAccountByFegin(@PathVariable("id") Long id) {
        Account account = accountFeignService.get(id);
        log.info("{}", account);
        return account;
    }

    @RequestMapping("/order/create/tcc")
    @GlobalTransactional
    public String createTcc() {
        String result = orderService.tcc();
        return result;
    }
}
