package com.ethan.service;

import com.ethan.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("ACCOUNT")
public interface AccountFeignService {
    @GetMapping(value = "/account/create")
    int insert(Account account);

    @GetMapping(value = "/account/get/{id}")
    Account get(@PathVariable("id") Long id);
}
