package com.example.SOTIS.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.bytecode.internal.javassist.BulkAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.validation.ValidationBindHandler;
import org.springframework.stereotype.Service;

import com.example.SOTIS.model.Cvor;
import com.example.SOTIS.model.Nastavnik;
import com.example.SOTIS.model.Odgovor;
import com.example.SOTIS.model.Pitanje;
import com.example.SOTIS.model.Predmet;
import com.example.SOTIS.model.Test;
import com.example.SOTIS.model.Ucenik;
import com.example.SOTIS.model.UcenikTest;
import com.example.SOTIS.model.Veza;
import com.example.SOTIS.model.DTO.PitanjeDTO;
import com.example.SOTIS.model.DTO.TestDTO;
import com.example.SOTIS.model.DTO.TestViewDTO;
import com.example.SOTIS.repository.OdgovoriRepository;
import com.example.SOTIS.repository.PitanjeRepository;
import com.example.SOTIS.repository.PredmetRepository;
import com.example.SOTIS.repository.TestRepository;
import com.example.SOTIS.repository.UcenikRepository;
import com.example.SOTIS.repository.UcenikTestRepository;

@Service
public class TestService {

	@Autowired
	TestRepository testRepo;

	@Autowired
	UcenikRepository ucenikRepo;

	@Autowired
	OdgovoriRepository odgovorRepo;

	@Autowired
	UcenikTestRepository ucenikTestRepo;

	@Autowired
	PredmetRepository predmetRepo;

	@Autowired
	PitanjeRepository pitanjeRepo;

	public List<TestDTO> findAllByNastavnik(Long id) {
		return testRepo.findAllByNastavnik(id);
	}

	public List<TestDTO> findAllByUcenik(Long id) {
		System.out.println(ucenikTestRepo.findByUcenikId(id).size());
		return ucenikTestRepo.findByUcenikId(id);
	}

	public boolean addTest(Test t) {
		Test newTest = new Test();
		newTest.setPitanje(new HashSet<Pitanje>());

		Predmet predmet = predmetRepo.findById(t.predmet.getId()).get();
		newTest.setPredmet(predmet);

		/*
		 * //Staviti da bude ulogovani nastavnik Nastavnik nastavnik = null;
		 * newTest.setNastavnik(nastavnik);
		 */
		for (Pitanje pitanje : t.pitanje) {
			newTest.pitanje.add(pitanjeRepo.findById(pitanje.getId()).get());
		}

		// Ucenik ucenik = ucenikRepo.findById(100L).get();

		testRepo.save(newTest);

//		//TEST
//		Ucenik u=new Ucenik();
//		u.setId(100);
//		ucenikTestRepo.save(new UcenikTest(u, testID, false));
		return true;
	}

	public boolean submitTest(Long id, TestViewDTO test) {
		try {
			Ucenik ucenik = ucenikRepo.findById(id).get();
			Test originalTest = testRepo.findById(test.getId()).get();
			for (PitanjeDTO pit : test.getPitanje()) {
				for (Odgovor o : pit.getOdgovori()) {
					Pitanje newPitanje = new Pitanje(pit.getId(), pit.getTekst());
					o.setPitanje(newPitanje);
					odgovorRepo.save(o);
				}

			}
			UcenikTest ut = ucenikTestRepo.findByUcenikAndTest(ucenik, originalTest);
			ut.setUradjen(true);
			ucenikTestRepo.save(ut);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
	public List<Cvor> BFS(List<Cvor> korenovi, List<Cvor> cvorovi, Set<Veza> veze) {

		List<Cvor> sorted = new ArrayList<Cvor>();
		sorted.addAll(0, korenovi);

		LinkedList<Cvor> queue = new LinkedList<>();
		for (Cvor k : korenovi) {
			queue.add(k);
		}

		while (queue.size() != 0) {
			for (int i = 0; i < korenovi.size(); i++) {
				Cvor c = korenovi.get(i);

				HashMap<Long, Boolean> visited = new HashMap<Long, Boolean>();
				for (Cvor tmp : cvorovi) {
					visited.put(tmp.getCvorId(), false);
				}
				visited.put(c.getCvorId(), true);

				// Dequeue a vertex from queue and print it
				c = queue.poll();

				// Get all adjacent vertices of the dequeued vertex s
				// If a adjacent has not been visited, then mark it
				// visited and enqueue it
				List<Cvor> lista = getSiblings(new ArrayList<>(veze), cvorovi, c.getId());
				for (Cvor n : lista) {

					if (!visited.get(n.getCvorId())) {
						visited.put(n.getCvorId(), true);
						queue.add(n);
						if (!sorted.contains(n))
							sorted.add(n);
					}

				}

			}
		}

		return sorted;

	}

	public List<Cvor> getSiblings(List<Veza> veze, List<Cvor> cvorovi, String l) {
		
		List<Cvor> resultCvor = new ArrayList<>();
		for (Veza v : veze) {

			if (v.getSource().getId().equals(l)) {
				
				Optional<Cvor> result = (cvorovi.stream().filter(cv -> v.getTarget().getCvorId() == cv.getCvorId())
						.findAny());
				if (result.isPresent()) {
					resultCvor.add(result.get());
				}

			}
		}

		return resultCvor;
	}

	public List<Cvor> sortirajCvorove(Test t) {

		Set<Cvor> cvorovi = t.getPredmet().getProstorZnanja().getCvorovi();
		Set<Veza> veze = t.getPredmet().getProstorZnanja().getVeze();

		List<Cvor> nisu_korenovi = new ArrayList<Cvor>();

		// svi cvorovi koji se javljaju kao target nisu korenovi

		for (Veza v : veze) {
			nisu_korenovi.add(v.getTarget());
		}

		// korenovi su preostali cvorovi

		Set<Cvor> korenovi = new HashSet<>(cvorovi);
		korenovi.removeAll(nisu_korenovi);

		return BFS(new ArrayList<>(korenovi), new ArrayList<>(cvorovi), veze);

	}

	public TestViewDTO findById(Long id) {
		try {
			Test t = testRepo.findById(id).get();

			List<Cvor> sortirani_cvorovi = sortirajCvorove(t);
			for (Cvor s : sortirani_cvorovi) {
				System.out.println(s.getLabel());
			}

			TestViewDTO dto = new TestViewDTO(t);

			for (Pitanje p : t.pitanje) {
				Set<Odgovor> o = odgovorRepo.findByPitanjeId(p.getId());
				PitanjeDTO pit = new PitanjeDTO(p, o);
				dto.pitanje.add(pit);

			}

			return dto;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
