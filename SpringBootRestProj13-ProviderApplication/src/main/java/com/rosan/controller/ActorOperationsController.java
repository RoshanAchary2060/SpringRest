package com.rosan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rosan.model.Actor;

@RestController
@RequestMapping("/actor")
public class ActorOperationsController {
//	@GetMapping("/wish")
//	public ResponseEntity<String> displayWishMessage() {
//		return new ResponseEntity<String>("Hello Actor, Good Morning", HttpStatus.OK);
//	}

//	@GetMapping("/wish/{id}/{name}")
//	public ResponseEntity<String> displayWishMessage(@PathVariable Integer id, @PathVariable String name) {
//		return new ResponseEntity<String>("Hello," + name + " Good Morning, your id is " + id, HttpStatus.OK);
//	}

	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor) {
		return new ResponseEntity<String>("Actor data :: " + actor.toString(), HttpStatus.OK);
	}
}
