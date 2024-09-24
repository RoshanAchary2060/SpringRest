package com.rosan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerOperationsController {

	@GetMapping("/report/no/name")
	public String fetchData(@PathVariable("name") String cname, @PathVariable Integer no) {
		return "from fetchData";
	}

	@GetMapping("/report/no/{name}")
	public String fetchData2(@PathVariable(name = "name", required = false) String cname,
			@PathVariable(required = false) Integer no) {
		return "from fetchData2";
	}

	@GetMapping("/report/{no}/{name}")
	public String fetchData3(@PathVariable(name = "name", required = false) String cname,
			@PathVariable(required = false) Integer no) {
		return "from fetchData3";
	}

	@GetMapping("/report/{no}/{name}")
	public String fetchData4(@PathVariable(name = "name", required = false) String cname,
			@PathVariable(required = false) Integer no) {
		return "from fetchData4";
	}

}
