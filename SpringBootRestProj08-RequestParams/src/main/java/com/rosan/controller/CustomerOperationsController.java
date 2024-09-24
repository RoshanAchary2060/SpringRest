package com.rosan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerOperationsController {
	@GetMapping("/report")
	public String reportData(@RequestParam("cno") Integer cno,
			@RequestParam(value = "cname", required = false) String cname) {
		return cno + ", " + cname;
	}
}
