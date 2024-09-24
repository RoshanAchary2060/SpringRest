package com.rosan.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rosan.model.Customer;

@RestController
public class CustomerOperationsController {

	@PostMapping("/register")
	public String registerCustomer(@RequestBody Customer cust) {
		return cust.toString();
	}
}
