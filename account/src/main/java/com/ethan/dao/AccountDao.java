package com.ethan.dao;

import com.ethan.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountDao {
    public int create(Account order);

    public Account getAccountById(@Param("id") Long id);
}
