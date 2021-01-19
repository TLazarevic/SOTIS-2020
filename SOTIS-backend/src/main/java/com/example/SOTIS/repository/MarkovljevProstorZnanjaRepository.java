package com.example.SOTIS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SOTIS.model.DTO.MarkovljevProstorZnanja;

public interface MarkovljevProstorZnanjaRepository extends JpaRepository<MarkovljevProstorZnanja, Long> {

	List<MarkovljevProstorZnanja> getByUcenikIdAndTestId(Long ucenikId, Long testId);

}
