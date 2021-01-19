package com.example.SOTIS.model.DTO;

import java.util.List;
import java.util.Set;

import com.example.SOTIS.model.Pitanje;

public class ProbabilityQuestionDTO {

	public Pitanje pitanje = new Pitanje();
	Set<Pitanje> preostalaPitanja;
	private List<List<String>> kSpaces;
	private List<Double> probabs;
	private Double l;
	private Long ucenikId;
	private Long testId;

	@Override
	public String toString() {
		return "ProbabilityQuestionDTO [pitanje=" + pitanje + ", preostalaPitanja=" + preostalaPitanja + ", kSpaces="
				+ kSpaces + ", probabs=" + probabs + "]";
	}

	public ProbabilityQuestionDTO(Pitanje choosenQ, Set<Pitanje> set, List<List<String>> kspaces2,
			List<Double> probabs2, double choosenL, Long ucenikId, Long testId) {
		super();
		this.pitanje = choosenQ;
		this.preostalaPitanja = set;
		this.kSpaces = kspaces2;
		this.probabs = probabs2;
		this.l = choosenL;
		this.ucenikId = ucenikId;
		this.testId = testId;
	}

	public ProbabilityQuestionDTO() {
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

	public Double getL() {
		return l;
	}

	public void setL(Double l) {
		this.l = l;
	}

	public Long getUcenikId() {
		return ucenikId;
	}

	public void setUcenikId(Long ucenikId) {
		this.ucenikId = ucenikId;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

}
