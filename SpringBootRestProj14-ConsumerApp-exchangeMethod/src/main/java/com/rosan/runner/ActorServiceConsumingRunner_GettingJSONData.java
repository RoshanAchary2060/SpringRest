package com.rosan.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rosan.model.Actor;

@Component
public class ActorServiceConsumingRunner_GettingJSONData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ActorServiceConsumingRunner_GettingJSONData.run()");
		// create RestTemplate class object
		RestTemplate template = new RestTemplate();
		// define service url
		String serviceUrl = "http://localhost:8080/SpringBootRestProj14-ProviderApp/actor/find";

		// invoke service method/operation using exchange() method
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);
		// display the details
		System.out.println("Response body :: " + response.getBody());
		System.out.println("------------------");

		// converting JSON text response(body) to Java class object/Model class
		// obj/Entity class obj using JACKSON api
		String jsonBody = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		Actor actor = mapper.readValue(jsonBody, Actor.class);
		System.out.println("Response body as the Actor object data :: " + actor);
	}

}
