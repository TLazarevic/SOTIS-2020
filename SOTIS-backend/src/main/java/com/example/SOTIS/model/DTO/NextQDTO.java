package com.example.SOTIS.model.DTO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.example.SOTIS.model.Pitanje;

public class NextQDTO {

	public HashMap<Set<String>, Double> probabilities = new HashMap<>();
	public Pitanje pitanje = new Pitanje();
	boolean tacnost = true;
	Set<Pitanje> preostalaPitanja = new HashSet<Pitanje>();


	public NextQDTO(HashMap<Set<String>, Double> probabilities, Pitanje pitanje, boolean tacnost,
			Set<Pitanje> preostalaPitanja) {
		super();
		this.probabilities = probabilities;
		this.pitanje = pitanje;
		this.tacnost = tacnost;
		this.preostalaPitanja = preostalaPitanja;
	}

	public NextQDTO() {
		super();
	}

	public Set<Pitanje> getPreostalaPitanja() {
		return preostalaPitanja;
	}

	public void setPreostalaPitanja(Set<Pitanje> preostalaPitanja) {
		this.preostalaPitanja = preostalaPitanja;
	}

	public HashMap<Set<String>, Double> getProbabilities() {
		return probabilities;
	}

	public void setProbabilities(HashMap<Set<String>, Double> probabilities) {
		this.probabilities = probabilities;
	}

	public Pitanje getPitanje() {
		return pitanje;
	}

	public void setPitanje(Pitanje pitanje) {
		this.pitanje = pitanje;
	}

	public boolean isTacnost() {
		return tacnost;
	}

	public void setTacnost(boolean tacnost) {
		this.tacnost = tacnost;
	}

}
