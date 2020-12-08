package com.example.SOTIS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SOTIS.model.DTO.PitanjeDTO;
import com.example.SOTIS.service.PitanjeService;

@RestController
@RequestMapping(value = "/pitanje")
@CrossOrigin(origins = "http://localhost:4200")
public class PitanjeController {

	@Autowired 
	PitanjeService pitanjeService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> submitPitanje( @RequestBody PitanjeDTO pitanje) {
		System.out.print(pitanje);
		if (pitanjeService.dodajPitanje(pitanje))
			return new ResponseEntity<>(true, HttpStatus.OK);
		else
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
