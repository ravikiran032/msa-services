package com.salesorder.service.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesorder.service.customerservice.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
