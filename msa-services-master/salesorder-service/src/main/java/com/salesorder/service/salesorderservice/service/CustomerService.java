package com.salesorder.service.salesorderservice.service;

import java.util.Optional;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.salesorder.service.salesorderservice.entity.SalesOrder;

//@FeignClient(name="customer-service")
@FeignClient(name="zuul-service")
@RibbonClient(name="customer-service")
public interface CustomerService {
	  
	@GetMapping("customer-service/customers/{customerId}")
	public Optional<SalesOrder> getCustomer(@PathVariable("customerId") Long customerId); 

}

