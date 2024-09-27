package com.rosan.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rosan.model.Actor;

@Component
public class ActorServiceConsumingRunner_AllRecords implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ActorServiceConsumingRunner_AllRecords.run()");
// create RestTemplate class object
		RestTemplate template = new RestTemplate();
		// define service url
		String serviceUrl = "http://localhost:8080/SpringBootRestProj14-ProviderApp/actor/findAll";

		// invoke service method/operation using exchange() method
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);
		// display the details
		System.out.println("Response body :: " + response.getBody());
		System.out.println("------------------");

		// converting json text response body to java class obj /model class obj/entity
		// class obj using jackson api

		String jsonBody = response.getBody();
		// create ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		Actor[] actors = mapper.readValue(jsonBody, Actor[].class);
		List<Actor> listActors = Arrays.asList(actors);
		for (Actor actor : listActors) {
			System.out.println(actor);
		}
		System.out.println("------------------");
		List<Actor> listActors1 = mapper.readValue(jsonBody, new TypeReference<List<Actor>>() {
		});
		listActors1.forEach(System.out::println);
	}

}
