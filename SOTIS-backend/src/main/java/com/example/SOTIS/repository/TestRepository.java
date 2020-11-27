package com.example.SOTIS.repository;

import com.example.SOTIS.model.Test;
import com.example.SOTIS.model.DTO.TestDTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestRepository extends JpaRepository<Test, Long> {
	
	@Query("SELECT t, n from Nastavnik n JOIN n.test t")
	public List<TestDTO> findAllByNastavnik(Long id);

}
