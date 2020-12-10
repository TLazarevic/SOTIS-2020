package com.example.SOTIS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
public class Cvor {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cvorId;

	@Column(name = "string_id")
	private String id;

	@Column
	private String label;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pz_id", referencedColumnName = "id")
	private ProstorZnanja pz;

	@JsonIgnore
	@OneToOne(mappedBy = "source")
	private Veza veza;

	@JsonIgnore
	@OneToOne(mappedBy = "target")
	private Veza veza2;

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

	public ProstorZnanja getPz() {
		return pz;
	}

	public void setPz(ProstorZnanja pz) {
		this.pz = pz;
	}

	public Veza getVeza() {
		return veza;
	}

	public void setVeza(Veza veza) {
		this.veza = veza;
	}

	public Veza getVeza2() {
		return veza2;
	}

	public void setVeza2(Veza veza2) {
		this.veza2 = veza2;
	}

}
