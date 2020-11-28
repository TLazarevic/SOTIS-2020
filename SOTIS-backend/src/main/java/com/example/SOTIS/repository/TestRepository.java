package com.example.SOTIS.repository;

import com.example.SOTIS.model.Test;
import com.example.SOTIS.model.DTO.TestDTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestRepository extends JpaRepository<Test, Long> {

	@Query("SELECT new com.example.SOTIS.model.DTO.TestDTO(t, n) from Test t JOIN t.nastavnik n WHERE n.id=?1")
	public List<TestDTO> findAllByNastavnik(Long id);

	@Query("SELECT new com.example.SOTIS.model.DTO.TestDTO(t, n) from Test t join t.predmet p join p.ucenik u join t.nastavnik n WHERE u.id=?1")
	public List<TestDTO> findAllByUcenik(Long id);

}
