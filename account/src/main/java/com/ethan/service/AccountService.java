package com.ethan.service;

import com.ethan.dao.AccountDao;
import com.ethan.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    public int create(Account account)
    {
        return accountDao.create(account);
    }

    public Account getAccountById(Long id)
    {
        return accountDao.getAccountById(id);
    }
}
