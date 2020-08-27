package com.example.order.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.order.entity.OrderEntity;

public interface OrderDao extends CrudRepository<OrderEntity, Long> {


}
