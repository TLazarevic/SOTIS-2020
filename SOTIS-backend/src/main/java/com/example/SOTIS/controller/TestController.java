package com.example.SOTIS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.example.SOTIS.service.TestService;
import com.example.SOTIS.model.Test;
import com.example.SOTIS.model.DTO.TestDTO;

@RestController
@RequestMapping(value = "/test")
@CrossOrigin(origins = "http://localhost:4200")
public class TestController {

	@Autowired
	TestService testService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Test> getTest(@PathVariable Long id) {
		System.out.print(testService.findById(id));
		return new ResponseEntity<>(testService.findById(id), HttpStatus.OK);
	}

	@GetMapping(value = "/nastavnik/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TestDTO>> getAllByNastavnik(@PathVariable Long id) {
		return new ResponseEntity<>(testService.findAllByNastavnik(id), HttpStatus.OK);
	}

	@GetMapping(value = "/ucenik/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TestDTO>> getAllByUcenik(@PathVariable Long id) {
		return new ResponseEntity<>(testService.findAllByUcenik(id), HttpStatus.OK);
	}

	@PostMapping(value = "/uradjen/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TestDTO>> submitTest(@PathVariable Long id, @RequestBody Test test) {
		System.out.print(test);
		if (testService.submitTest(id, test))
			return new ResponseEntity<>(testService.findAllByUcenik(id), HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
