package com.rosan.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner_PostingJSONData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// create RestTemplate class object
		RestTemplate template = new RestTemplate();
		// define service url
		String serviceUrl = "http://localhost:8080/SpringBootRestProj13-ProviderApplication/actor/register";

		// prepare JSON data
		String json_body = "{\"id\":101, \"name\":\"suresh\",\"age\":30,\"type\":\"hero\"}";
		// prepare headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		// prepare Http request as HttpEntity object having head, body
		HttpEntity<String> request = new HttpEntity<String>(json_body, headers);
		// make http request call in post mode
		ResponseEntity<String> response = template.postForEntity(serviceUrl, request, String.class);
		// display the received details from the response
		System.out.println("Response body (output) :: " + response.getBody());
		System.out.println("Response status code value :: " + response.getStatusCodeValue());
		;
		System.out.println("Response status code :: " + response.getStatusCode());
		System.out.println("Response header :: " + response.getHeaders().toString());

//		Object obj = template.getForObject(serviceUrl, String.class);
//		System.out.println("Response body :: " + obj);

		System.exit(0); // optional, given to stop server automatically
	}

}
