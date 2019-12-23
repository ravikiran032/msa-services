package com.salesorder.service.itemservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.salesorder.service.itemservice.configuration.ItemConfiguration;
import com.salesorder.service.itemservice.entity.Item;
import com.salesorder.service.itemservice.repository.ItemRepository;

@RestController
@EnableHystrix
public class ItemController {
	public static final Logger log = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ItemConfiguration itemConfiguration;
	
	@GetMapping("/items")
	public List<Item> getItems(){
	  
		return itemRepository.findAll();
	}
	
	@GetMapping("/items/{itemname}")
	public Item getItemByName(@PathVariable String itemname) {
		log.info("Inside ItemControler");
		return itemRepository.findByItemName(itemname);
	}
	
	@GetMapping("/items/fallback-tolerence")
	@HystrixCommand(fallbackMethod="fallbackTolerance")
	public Item getItemFallback() {
		throw new RuntimeException(":Some issue");
	}
	
	
	public Item fallbackTolerance() {
		
		return new Item(1000L,itemConfiguration.getDefaultItemName(),itemConfiguration.getDefaultItemDesc(),itemConfiguration.getDefaultItemPrice());
	}
}
