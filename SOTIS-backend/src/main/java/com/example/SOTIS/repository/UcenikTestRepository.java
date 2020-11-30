package com.example.SOTIS.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.SOTIS.model.Test;
import com.example.SOTIS.model.Ucenik;
import com.example.SOTIS.model.UcenikTest;
import com.example.SOTIS.model.DTO.TestDTO;

public interface UcenikTestRepository extends JpaRepository<UcenikTest, Long> {
	
	@Query("SELECT new com.example.SOTIS.model.DTO.TestDTO(t, n, ut.uradjen) from UcenikTest ut join ut.test t join t.predmet p join p.ucenik u join t.nastavnik n WHERE u.id=?1")
	public List<TestDTO> findByUcenikId(Long id);

	public UcenikTest findByUcenikAndTest(Ucenik ucenik, Test originalTest);

	
	

}
