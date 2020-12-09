package com.example.SOTIS.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Veza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vezaId;

	@Column(name = "string_id")
	private String id;

	@Column
	private String label;

	@OneToOne(cascade = { CascadeType.MERGE })
	private Cvor source;

	@OneToOne(cascade = { CascadeType.MERGE })
	private Cvor target;
	
	@ManyToOne
	ProstorZnanja pz;

	public Veza() {
		super();
	}

	public Long getVezaId() {
		return vezaId;
	}

	public void setVezaId(Long vezaId) {
		this.vezaId = vezaId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Cvor getSource() {
		return source;
	}

	public void setSource(Cvor source) {
		this.source = source;
	}

	public Cvor getTarget() {
		return target;
	}

	public void setTarget(Cvor target) {
		this.target = target;
	}

}
