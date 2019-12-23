package com.salesorder.service.salesorderservice.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.salesorder.service.salesorderservice.entity.Order;
import com.salesorder.service.salesorderservice.entity.OrderItem;
import com.salesorder.service.salesorderservice.entity.SalesOrder;
import com.salesorder.service.salesorderservice.repository.OrderItemRepository;
import com.salesorder.service.salesorderservice.repository.SalesOrderRespository;
import com.salesorder.service.salesorderservice.service.CustomerService;
import com.salesorder.service.salesorderservice.service.ItemService;

@RestController
@EnableHystrix
public class SalesOrderController {
	
	public static final Logger log = LoggerFactory.getLogger(SalesOrderController.class);

	@Autowired
	private SalesOrderRespository salesOrderRespository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/orders")
	@HystrixCommand(fallbackMethod="fallbackTolerance")
	public Long createOrder(@RequestBody Order order){
		
		log.info("Inside SalesOrder Controller");
	//	ResponseEntity<SalesOrder> customerEntity = new RestTemplate().getForEntity("http://localhost:8080/customerservice/customers/{customerId}",SalesOrder.class,order.getCustomerId());
				
		List<String> itemnames = order.getItemNames();
			
		int totalPrice = 0;
		for(String itemname : itemnames){
  
		  totalPrice = totalPrice + itemService.getItemByName(itemname).getItemPrice();
		}
		
		SalesOrder salesOrder = new SalesOrder();
		
		salesOrder.setCustomerId(customerService.getCustomer(order.getCustomerId()).get().getCustomerId());
		salesOrder.setOrderDate(order.getDate());
		salesOrder.setOrderDesc(order.getDescription());
		salesOrder.setItemPrice(totalPrice);
		
		salesOrderRespository.save(salesOrder);
		
		for(String itemname : itemnames){
		
			OrderItem orderItem = new OrderItem();
			
			orderItem.setItemQuantity(1);
			orderItem.setOrderId(salesOrder.getOrderId());
			orderItem.setItemName(itemname);
			
			orderItemRepository.save(orderItem);
		}
		
	
		return salesOrder.getOrderId();
	}
	
	@GetMapping("/orders/fallback-tolerence")
	@HystrixCommand(fallbackMethod="fallbackTolerance")
	public int getOrderFallback() {
		throw new RuntimeException(":Some issue");
	}
	
	public int fallbackTolerance() {
		
		return 0;
	}
		
}
