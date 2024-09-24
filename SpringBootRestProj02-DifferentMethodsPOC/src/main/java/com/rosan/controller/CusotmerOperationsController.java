package com.rosan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CusotmerOperationsController {
	@GetMapping("/report")
	public ResponseEntity<String> showCustomerReport() {
		return new ResponseEntity<String>("From GET-ShowReport Method", HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer() {
		return new ResponseEntity<String>("From Post-RegisterCustomer Method", HttpStatus.OK);
	}

	@PutMapping("/modify")
	public ResponseEntity<String> updateCustomer() {
		return new ResponseEntity<String>("From Put-UpdateCustomer Method", HttpStatus.OK);
	}

	@PatchMapping("/pmodify")
	public ResponseEntity<String> updateCustomerByNo() {
		return new ResponseEntity<String>("From Patch-UpdateCustomerByNo Method", HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCustomer() {
		return new ResponseEntity<String>("From Delete-DeleteCustomerByNo Method", HttpStatus.OK);
	}
}
