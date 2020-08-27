package com.example.order.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.order.entity.OrderEntity;
import com.example.order.vo.OrderVo;

@Component
public class Utility {
	
	public OrderVo toToVo(OrderEntity entity) {
		OrderVo orderVo = new OrderVo();
		BeanUtils.copyProperties(entity, orderVo);
		return orderVo;
	}
	
	public OrderEntity toToDto(OrderVo orderVo) {
		OrderEntity orderEntity = new OrderEntity();
		BeanUtils.copyProperties(orderVo, orderEntity);
		return orderEntity;
	}
}
