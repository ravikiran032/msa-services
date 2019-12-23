package com.salesorder.service.customerservice.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.salesorder.service.customerservice.configuration.CustomerConfiguration;
import com.salesorder.service.customerservice.entity.Customer;
import com.salesorder.service.customerservice.repository.CustomerRepository;

@RestController
@EnableHystrix
public class CustomerController {
    
	public static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerConfiguration customerConfiguration;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return customerRepository.findAll();
	}
	
	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		
		return customerRepository.save(customer);
	}
	
	@GetMapping("/customers/{customerId}")
	public Optional<Customer> getCustomer(@PathVariable Long customerId) {
		 log.info("inside customer Controller");
		return customerRepository.findById(customerId);
	}
	
	@GetMapping("/customers/fallback-tolerence")
	@HystrixCommand(fallbackMethod="fallbackTolerance")
	public Customer getCustomerFallback() {
		throw new RuntimeException(":Some issue");
	}
	
	
	public Customer fallbackTolerance() {
		
		return new Customer(1000L,customerConfiguration.getDefaultEmail(),customerConfiguration.getDefaultFirstname(),customerConfiguration.getDefaultLastname());
	}
}
