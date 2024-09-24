package com.rosan.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rosan.model.Company;
import com.rosan.model.Customer;

@RestController
public class CustomerOperationsController {

	@GetMapping("/report")
	public ResponseEntity<Customer> showData() {
		Customer cust = new Customer(Integer.valueOf(1001), "raja", 4000.0f, new String[] { "red", "green", "blue" },
				List.of("10th", "10+2", "B.Tech"), Set.of(444454544l, 565655655l),
				Map.of("aadhar", 3334l, "panNo", 33434l), new Company("Samsung", "hyd", "Electronics", 4000));

		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<Customer>(cust, status);
	}
}
