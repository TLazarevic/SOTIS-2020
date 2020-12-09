package com.example.SOTIS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cvor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cvorId;
	
	@Column(name="string_id")
	private String id;

	@Column
	private String label;
	
	@ManyToOne
	ProstorZnanja pz;

	public Cvor() {
		super();
	}

	public Long getCvorId() {
		return cvorId;
	}

	public void setCvorId(Long cvorId) {
		this.cvorId = cvorId;
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

}
