package com.example.SOTIS.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.SOTIS.model.Test;
import com.example.SOTIS.model.Ucenik;
import com.example.SOTIS.model.UcenikTest;
import com.example.SOTIS.model.DTO.TestDTO;

public interface UcenikTestRepository extends JpaRepository<UcenikTest, Long> {
	
	@Query("SELECT new com.example.SOTIS.model.DTO.TestDTO(t, n, ut.uradjen) from UcenikTest ut join ut.test t join ut.ucenik u join t.nastavnik n WHERE u.id=?1")
	public List<TestDTO> findByUcenikId(Long id);

	public UcenikTest findByUcenikAndTest(Ucenik ucenik, Test originalTest);

	public List<TestDTO> findByTestId(Long id);
	
	@Query("Select ut.ucenik.id from UcenikTest ut where ut.test.id = ?1 and ut.uradjen = true")
	public List<Long> studentsThatTookTheTest(Long id);

	public UcenikTest getByUcenikIdAndTestId(Long ucenikId, Long testId);
	
	

}
