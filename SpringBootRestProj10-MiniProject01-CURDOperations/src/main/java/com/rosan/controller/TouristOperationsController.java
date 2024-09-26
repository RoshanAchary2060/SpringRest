package com.rosan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rosan.entity.Tourist;
import com.rosan.service.ITouristMgmtService;

@RestController
@RequestMapping("/tourist")
public class TouristOperationsController {
	@Autowired
	private ITouristMgmtService service;

	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
		try {// use service
			String resultMsg = service.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg, HttpStatus.CREATED); // 201 content created successfully
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<String>("Problem in tourist enrollment!", HttpStatus.INTERNAL_SERVER_ERROR); // 500
																													// error
		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<?> displayAllTourists() {
		try {
			List<Tourist> list = service.fetchAllTourists();
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			ex.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching tourists data!", HttpStatus.INTERNAL_SERVER_ERROR); // 500

		}
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayTouristById(@PathVariable("id") Integer id) {
		try {
			Tourist tourist = service.fetchTouristById(id);
			return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<String>("Tourist not found with the id " + id + "!",
					HttpStatus.INTERNAL_SERVER_ERROR); // 500
		}
	}

	@PutMapping("/modify")
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist) {
		try {
			String msg = service.updateTouristDetails(tourist);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // 500
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeTourist(@PathVariable("id") Integer id) {
		try {// use service
			String msg = service.deleteTouristById(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PatchMapping("/budgetmodify/{id}/{hike}")
	public ResponseEntity<String> ModifyTouristBudgetById(@PathVariable("id") Integer id,
			@PathVariable("hike") Double hikePercent) {
		try {// use service
			String msg = service.updateTouristBudgetById(id, hikePercent);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		}

	}
}
