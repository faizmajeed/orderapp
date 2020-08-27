package com.example.order.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.order.vo.OrderItemVo;

@FeignClient(name = "client", url = "${feign.url}")
public interface ClientStore {

	@RequestMapping(value= "/getDetailsById/{id}",method = RequestMethod.GET)
	List<OrderItemVo> findByOrderId(@PathVariable("id") Long orderId);

	@RequestMapping(value = "/save",method = RequestMethod.POST, headers = "Content-Type: application/json")
	String addOrderItemVo(List<OrderItemVo> orderVo);

	@RequestMapping(value="delete/{id}",method = RequestMethod.DELETE)
	OrderItemVo deleteOrderItemVo(@PathVariable("id") Long orderId);

}
