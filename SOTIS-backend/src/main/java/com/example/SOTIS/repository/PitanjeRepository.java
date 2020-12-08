package com.example.SOTIS.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.SOTIS.model.Pitanje;
import com.example.SOTIS.model.DTO.TestDTO;

public interface PitanjeRepository extends JpaRepository<Pitanje, Long>{

	//Set<Pitanje> findByOdgovorId(Long id);
	
	//@Query("SELECT new com.example.SOTIS.model.DTO.TestDTO(t, n, ut.uradjen) from UcenikTest ut join ut.test t join t.predmet p join p.ucenik u join t.nastavnik n WHERE u.id=?1")
	//public List<TestDTO> findByUcenikId(Long id);

	/// Iz ovoga dobijam info o pitanju, a iz odgovori repository dobijam odgovore
	//Pitanje findById(Long id);
}