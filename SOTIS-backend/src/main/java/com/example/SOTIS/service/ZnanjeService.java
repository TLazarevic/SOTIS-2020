package com.example.SOTIS.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SOTIS.model.Cvor;
import com.example.SOTIS.model.ProstorZnanja;
import com.example.SOTIS.model.Veza;
import com.example.SOTIS.model.DTO.VezaRepository;
import com.example.SOTIS.repository.CvorRepository;
import com.example.SOTIS.repository.ProstorZnanjaRepository;

@Service
public class ZnanjeService {

	@Autowired
	CvorRepository cvorRepo;

	@Autowired
	VezaRepository vezaRepo;

	@Autowired
	ProstorZnanjaRepository znanjeRepo;

	public List<ProstorZnanja> findAll() {
		return znanjeRepo.findAll();
	}

	public ProstorZnanja findById(Long id) {
		return znanjeRepo.findById(id).get();
	}

	public boolean newProstor(ProstorZnanja prostor) {
		try {
			prostor.setId(-1);
			prostor.setGenerisan(false);
			this.znanjeRepo.save(prostor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<ProstorZnanja> findByPredmetId(Long id) {
		return this.znanjeRepo.findByPredmetId(id);
	}

	public String findByIdString(Long id) {
		try {
			ProstorZnanja pz = znanjeRepo.findById(id).get();

			String result = "";
			List<Veza> sortedVeze = new ArrayList<>(pz.veze);
			sortedVeze.sort((p1, p2) -> {
				if (p1.getSource().getCvorId().compareTo(p2.getSource().getCvorId()) == 0) {
					return p1.getTarget().getCvorId().compareTo(p2.getTarget().getCvorId());
				} else {
					return p1.getSource().getCvorId().compareTo(p2.getSource().getCvorId());
				}
			});
			for (Veza v : sortedVeze) {
				result += v.hashCode();
				// result += v.getSource().getLabel() + v.getTarget().getLabel()+" ";
			}
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
