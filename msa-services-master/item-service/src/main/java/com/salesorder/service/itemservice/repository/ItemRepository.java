package com.salesorder.service.itemservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesorder.service.itemservice.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	public Item findByItemName(String name);
}
