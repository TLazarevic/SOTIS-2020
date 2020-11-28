package com.example.SOTIS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SOTIS.model.Test;
import com.example.SOTIS.model.Ucenik;
import com.example.SOTIS.model.DTO.TestDTO;
import com.example.SOTIS.repository.TestRepository;
import com.example.SOTIS.repository.UcenikRepository;

@Service
public class TestService {

	@Autowired
	TestRepository testRepo;

	@Autowired
	UcenikRepository ucenikRepo;

	public List<TestDTO> findAllByNastavnik(Long id) {
		System.out.println(testRepo.findAllByNastavnik(id).size());
		return testRepo.findAllByNastavnik(id);
	}

	public List<TestDTO> findAllByUcenik(Long id) {
		return testRepo.findAllByUcenik(id);
	}

	public boolean submitTest(Long id, Test test) {
		try {
			Ucenik ucenik = ucenikRepo.findById(id).get();
			ucenik.test.add(test);
			ucenikRepo.save(ucenik);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Test findById(Long id) {
		try {
			return testRepo.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
