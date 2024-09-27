package com.rosan.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsumingRunner_PostingJSONData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// create RestTemplate class object
		RestTemplate template = new RestTemplate();
		// define service url
		String serviceUrl = "http://localhost:8080/SpringBootRestProj14-ProviderApp/actor/register";

		// prepare JSON data
		String json_body = "{\"id\":101, \"name\":\"salman\",\"age\":30,\"type\":\"actor\"}";
		// prepare headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		// prepare Http request as HttpEntity object having head, body
		HttpEntity<String> entity = new HttpEntity<String>(json_body, headers);
		// make http request call in post mode
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.POST, entity, String.class);
		// display the received details from the response
		System.out.println("Response body (output) :: " + response.getBody());
		System.out.println("Response status code value :: " + response.getStatusCodeValue());
		;
		System.out.println("Response status code :: " + response.getStatusCode());
		System.out.println("Response header :: " + response.getHeaders().toString());

//		Object obj = template.getForObject(serviceUrl, String.class);
//		System.out.println("Response body :: " + obj);

		System.out.println("------------------");
	}

}
