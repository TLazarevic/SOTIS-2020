package com.example.SOTIS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SOTIS.model.ProstorZnanja;

public interface ProstorZnanjaRepository extends JpaRepository<ProstorZnanja, Long> {

	List<ProstorZnanja> findByPredmetId(Long id);

}
