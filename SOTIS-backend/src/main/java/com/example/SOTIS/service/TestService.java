package com.example.SOTIS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SOTIS.model.DTO.TestDTO;
import com.example.SOTIS.repository.TestRepository;

@Service
public class TestService {

	@Autowired
	TestRepository testRepo;

	public List<TestDTO> findAllByNastavnik(Long id) {
		return testRepo.findAllByNastavnik(id);
	}

	public List<TestDTO> findAllByUcenik(Long id) {
		return null;
	}

}
