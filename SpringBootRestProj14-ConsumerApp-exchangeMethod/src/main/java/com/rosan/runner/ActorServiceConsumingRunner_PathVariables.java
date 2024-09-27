package com.rosan.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsumingRunner_PathVariables implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// create RestTemplate class object
		RestTemplate template = new RestTemplate();
		// define service url
		String serviceUrl = "http://localhost:8080/SpringBootRestProj14-ProviderApp/actor/wish/{id}/{name}";
		// Generate Http request with GET mode to consume the web service (API)
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.GET, null, String.class, 102,
				"rani");

//		ResponseEntity<String> response = template.getForEntity(serviceUrl, String.class,
//				Map.of("id", 1, "name", "raja")); // 2nd arg is

		// display the received details from the response
		System.out.println("Response body (output) :: " + response.getBody());
		System.out.println("Response status code value :: " + response.getStatusCodeValue());
		;
		System.out.println("Response status code :: " + response.getStatusCode());

//		Object obj = template.getForObject(serviceUrl, String.class);
//		System.out.println("Response body :: " + obj);

System.out.println("------------------");	}

}
