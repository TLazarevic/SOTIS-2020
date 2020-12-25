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

	@OneToOne
	private Pitanje pitanje;

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

	public Pitanje getPitanje() {
		return pitanje;
	}

	public void setPitanje(Pitanje pitanje) {
		this.pitanje = pitanje;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id == null) ? 0 : label.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cvor other = (Cvor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

}
