package com.service.subscriber.dthsubscriptionchannel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.subscriber.dthsubscriptionchannel.model.Customers;
import com.service.subscriber.dthsubscriptionchannel.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class CustomerController {
	@Autowired
	CustomerRepository customerRepository;

	
	
		
		/**
		 * Add new customer.
		 * @param customer
		 * @return
		 */
		@PostMapping("/addCustomer")
		public ResponseEntity<Customers> AddCustomer(@RequestBody Customers customer) {
			customerRepository.save(customer);
			log.info("adding customer details in the db");
			return ResponseEntity.status(HttpStatus.OK).body(customer);
		}
	
}
