package com.salesorder.service.salesorderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesorder.service.salesorderservice.entity.SalesOrder;

public interface SalesOrderRespository extends JpaRepository<SalesOrder, Long> {

}
