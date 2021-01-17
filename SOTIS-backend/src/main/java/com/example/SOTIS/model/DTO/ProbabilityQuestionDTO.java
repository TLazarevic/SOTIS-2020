package com.example.SOTIS.model.DTO;

import java.util.HashMap;
import java.util.Set;

import com.example.SOTIS.model.Pitanje;

public class ProbabilityQuestionDTO {

	public HashMap<Set<String>, Double> probabilities = new HashMap<>();
	public Pitanje pitanje;
	Set<Pitanje> preostalaPitanja;

	public ProbabilityQuestionDTO() {
		super();
	}

	public ProbabilityQuestionDTO(HashMap<Set<String>, Double> probabilities, Pitanje pitanje,
			Set<Pitanje> preostalaPitanja) {
		super();
		this.probabilities = probabilities;
		this.pitanje = pitanje;
		this.preostalaPitanja = preostalaPitanja;
	}

	public ProbabilityQuestionDTO(Pitanje pitanje, Set<Pitanje> preostalaPitanja) {
		super();
		this.pitanje = pitanje;
		this.preostalaPitanja = preostalaPitanja;
	}

	public ProbabilityQuestionDTO(HashMap<Set<String>, Double> probabilities, Pitanje pitanje) {
		super();
		this.probabilities = probabilities;
		this.pitanje = pitanje;
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

}
