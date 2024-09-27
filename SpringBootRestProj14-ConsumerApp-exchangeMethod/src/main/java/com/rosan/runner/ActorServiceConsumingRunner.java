package com.rosan.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsumingRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ActorServiceConsumingRunner.run()");
		// create RestTemplate class object
		RestTemplate template = new RestTemplate();
		// define service url
		String serviceUrl = "http://localhost:8080/SpringBootRestProj14-ProviderApp/actor/wish";

		// invoke service method/operation using exchange() method
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);
		// display the details
		System.out.println("Response body :: " + response.getBody());
		System.out.println("------------------");
	}

}
