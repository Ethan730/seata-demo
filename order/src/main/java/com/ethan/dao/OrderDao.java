package com.ethan.dao;

import com.ethan.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderDao {
    public int create(Order order);

    public Order getOrderById(@Param("id") Long id);

    public int update(Order order);

    public int delete(Order order);

    public int insertTcc(Order order);
}
