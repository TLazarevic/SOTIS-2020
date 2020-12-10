package com.example.SOTIS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SOTIS.model.Cvor;
import com.example.SOTIS.model.ProstorZnanja;
import com.example.SOTIS.service.ZnanjeService;

@RestController
@RequestMapping("/znanje")
@CrossOrigin(origins = "http://localhost:4200")
public class ZnanjeController {

	@Autowired
	ZnanjeService znanjeService;

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProstorZnanja>> getAllGrafovi() {
		return new ResponseEntity<>(znanjeService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProstorZnanja> getGraf(@PathVariable Long id) {
		return new ResponseEntity<>(znanjeService.findById(id), HttpStatus.OK);
	}

	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> newSpace(@RequestBody ProstorZnanja pz) {
		if (this.znanjeService.newProstor(pz))
			return new ResponseEntity<>(true, HttpStatus.OK);
		else
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
