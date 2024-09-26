package com.rosan.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsumingRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// create RestTemplate class object
		RestTemplate template = new RestTemplate();
		// define service url
		String serviceUrl = "http://localhost:8080/SpringBootRestProj13-ProviderApplication/actor/wish";
//		// Generate Http request with GET mode to consume the web service (API)
//		ResponseEntity<String> response = template.getForEntity(serviceUrl, String.class); // 2nd arg is response type
//		// display the received details from the response
//		System.out.println("Response body (output) :: " + response.getBody());
//		System.out.println("Response status code value :: " + response.getStatusCodeValue());
//		;
//		System.out.println("Response status code :: " + response.getStatusCode());

		Object obj = template.getForObject(serviceUrl, String.class);
		System.out.println("Response body :: " + obj);

//		System.exit(0);
	}

}
