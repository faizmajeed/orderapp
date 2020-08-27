package com.example.order.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.order.dao.OrderDao;
import com.example.order.entity.OrderEntity;
import com.example.order.exception.OrderException;
import com.example.order.feign.ClientStore;
import com.example.order.util.Utility;
import com.example.order.vo.OrderItemVo;
import com.example.order.vo.OrderVo;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao dao;
	
	@Autowired
	private Utility utility;
	
	@Autowired
	private ClientStore clientStore;

	public Iterable<OrderEntity> getAllOrders() {
		return dao.findAll();
	}

	public OrderVo getOrderById(Long orderId) {
		List<OrderItemVo> orderItems = clientStore.findByOrderId(orderId);
		OrderEntity order = dao.findById(orderId).orElseThrow(() -> new OrderException());
		OrderVo orderVo = utility.toToVo(order);
		orderVo.setOrderItems(orderItems);
		return orderVo;
	}

	public String saveOrder(OrderVo order) {
		OrderEntity entity = utility.toToDto(order);
		entity.setOrderDate(new Date());
		entity = dao.save(entity);
		Long orderId = entity.getOrderId();
		List<OrderItemVo> orderItems = order.getOrderItems();
		orderItems.forEach(item -> item.setOrderId(orderId));
		clientStore.addOrderItemVo(orderItems);
		return "Order Saved Successfully with id -> "+orderId;
	}

	public String deleteOrder(Long orderId) {
		clientStore.deleteOrderItemVo(orderId);
		dao.deleteById(orderId);
		return "Order Deleted SuccessFully with id ->"+orderId;
	}

}
