package com.salesorder.service.salesorderservice.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.salesorder.service.salesorderservice.entity.SalesOrder;

//@FeignClient(name="item-service")
@FeignClient(name="zuul-service")
@RibbonClient(name="item-service")
public interface ItemService {
	
	@GetMapping("item-service/items/{itemname}")
	public SalesOrder getItemByName(@PathVariable String itemname);

}
