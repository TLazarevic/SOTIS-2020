package com.example.SOTIS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SOTIS.model.Ucenik;
import com.example.SOTIS.service.UserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(value = "/ucenik", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> addUcenik(@RequestBody Ucenik ucenik) {
		System.out.println(ucenik);
		if (userService.addUcenik(ucenik)) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
