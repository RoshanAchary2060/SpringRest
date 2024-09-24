package com.rosan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rosan.model.Customer;

@RestController
public class CustomerOperationsController {

//	@GetMapping("/report")
//	public Customer showData() {
//		Customer cust = new Customer(1001, "raja", "hyd", 1000.0f);
//		return cust;
//	}

	@GetMapping("/report")
	public ResponseEntity<Customer> showData() {
		Customer cust = new Customer(1001, "raja", "hyd", 1000.0f);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
}
