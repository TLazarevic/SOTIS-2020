package com.example.SOTIS.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.example.SOTIS.service.TestService;
import com.example.SOTIS.model.DTO.TestDTO;

@RestController
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	TestService testService;
	
	@GetMapping(value="/nastavnik", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TestDTO>> getAllByNastavnik(Long nastavnikId){
		return new ResponseEntity<>(testService.findAllByNastavnik(nastavnikId),HttpStatus.OK);
	}
	
	@GetMapping(value="/ucenik", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TestDTO>> getAllByUcenik(Long ucenikId){
		return new ResponseEntity<>(testService.findAllByUcenik(ucenikId),HttpStatus.OK);
	}
}
