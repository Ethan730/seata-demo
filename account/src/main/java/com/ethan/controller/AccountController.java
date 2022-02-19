package com.ethan.controller;

import com.ethan.entity.Account;
import com.ethan.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class AccountController {
    @Autowired
    private AccountService accountService;


    @PostMapping(value = "/account/create")
    public int create(@RequestBody Account account) {
        int result = accountService.create(account);
        return result;
    }

    @RequestMapping(value = "/account/get/{id}")
    public Account getOrderById(@PathVariable("id") Long id) {
        Account account = accountService.getAccountById(id);
        log.info("*****插入结果：" + account);
        return account;
    }
}
