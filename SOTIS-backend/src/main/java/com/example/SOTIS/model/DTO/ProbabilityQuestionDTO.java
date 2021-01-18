package com.example.SOTIS.model.DTO;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.example.SOTIS.model.Pitanje;

public class ProbabilityQuestionDTO {

	public Pitanje pitanje;
	Set<Pitanje> preostalaPitanja;
	private List<List<String>> kSpaces;
	private List<Double> probabs;

	@Override
	public String toString() {
		return "ProbabilityQuestionDTO [pitanje=" + pitanje + ", preostalaPitanja=" + preostalaPitanja + ", kSpaces="
				+ kSpaces + ", probabs=" + probabs + "]";
	}

	public ProbabilityQuestionDTO() {
		super();
	}

	public ProbabilityQuestionDTO(Pitanje pitanje, Set<Pitanje> preostalaPitanja, List<List<String>> kSpaces,
			List<Double> probabs) {
		super();
		this.pitanje = pitanje;
		this.preostalaPitanja = preostalaPitanja;
		this.kSpaces = kSpaces;
		this.probabs = probabs;
	}

	public Set<Pitanje> getPreostalaPitanja() {
		return preostalaPitanja;
	}

	public void setPreostalaPitanja(Set<Pitanje> preostalaPitanja) {
		this.preostalaPitanja = preostalaPitanja;
	}

	public Pitanje getPitanje() {
		return pitanje;
	}

	public void setPitanje(Pitanje pitanje) {
		this.pitanje = pitanje;
	}

	public List<List<String>> getkSpaces() {
		return kSpaces;
	}

	public void setkSpaces(List<List<String>> kSpaces) {
		this.kSpaces = kSpaces;
	}

	public List<Double> getProbabs() {
		return probabs;
	}

	public void setProbabs(List<Double> probabs) {
		this.probabs = probabs;
	}

}
