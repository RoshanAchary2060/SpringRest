package com.rosan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rosan.entity.Tourist;

@Controller
public class TouristOperationsConsumerController {
	@Autowired
	private RestTemplate template;

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/list_tourists")
	public String displayTouristsReport(Map<String, Object> map) throws Exception {
		/*
		 * consume SpringRest service/method/operation url :
		 * http://localhost:8080/SpringBootRestProj11-MiniProject01-ExceptionHandler/
		 * tourist/findAll method : GET response content type : application/json
		 * (default) No path variables / No query strings no headers, body required
		 */

		String serviceUrl = "http://localhost:8080/SpringBootRestProj11-MiniProject01-ExceptionHandler/tourist/findAll";
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);
		String jsonRespBody = response.getBody();
		// convert String json response body to List<Tourist> (List of Model objs)
		ObjectMapper mapper = new ObjectMapper();
		List<Tourist> listTourist = mapper.readValue(jsonRespBody, new TypeReference<List<Tourist>>() {

		});
		// keep results in Map collection
		map.put("touristList", listTourist);
		// return LVN
		return "tourist_report";
	}

	@GetMapping("/add") // To launch register form page
	public String showRegisterTouristForm(@ModelAttribute("tst") Tourist tourist) {
		return "add_tourist";
	}

	@PostMapping("/add")
	public String RegisterTourist(RedirectAttributes attrs, @ModelAttribute("tst") Tourist tourist) throws Exception {
		// convert Object to JSON using Jackson api
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(tourist);
		// invoke spring rest service
		String serviceUrl = "http://localhost:8080/SpringBootRestProj11-MiniProject01-ExceptionHandler/tourist/register";
		// prepare HttpEntity object (header + body)
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonData, headers);
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.POST, entity, String.class);
		String result = response.getBody();
		attrs.addFlashAttribute("result", result);
		return "redirect:list_tourists";
	}

	@GetMapping("/edit")
	public String showEditFormPage(@RequestParam("id") Integer id, @ModelAttribute("tst") Tourist tourist)
			throws Exception {
		// invoke Rest Service
		String serviceUrl = "http://localhost:8080/SpringBootRestProj11-MiniProject01-ExceptionHandler/tourist/find/{id}";
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.GET, null, String.class, id);
		// get json body from response
		String jsonBody = response.getBody();
		// convert jsonBody to Tourist object uisng ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		Tourist tourist1 = mapper.readValue(jsonBody, Tourist.class);
		BeanUtils.copyProperties(tourist1, tourist);
		return "edit_tourist";
	}

	@PostMapping("/edit")
	public String editTourist(RedirectAttributes attrs, @ModelAttribute("tst") Tourist tourist) throws Exception {
		// convert Object to JSON using Jackson api
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(tourist);
		// invoke spring rest service
		String serviceUrl = "http://localhost:8080/SpringBootRestProj11-MiniProject01-ExceptionHandler/tourist/modify";
		// prepare HttpEntity object (header + body)
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonData, headers);
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.PUT, entity, String.class);
		String result = response.getBody();
		attrs.addFlashAttribute("result", result);
		return "redirect:list_tourists";
	}

	@GetMapping("/delete")
	public String deleteTourist(RedirectAttributes attrs, @RequestParam("id") Integer id) {
		String serviceUrl = "http://localhost:8080/SpringBootRestProj11-MiniProject01-ExceptionHandler/tourist/delete/{id}";
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.DELETE, null, String.class, id);
		String result = response.getBody();
		attrs.addFlashAttribute("result", result);
		return "redirect:list_tourists";
	}
}
