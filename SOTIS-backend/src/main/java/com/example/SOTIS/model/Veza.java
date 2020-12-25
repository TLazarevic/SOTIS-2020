package com.example.SOTIS.model;

import javax.persistence.CascadeType;
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
public class Veza {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vezaId;

	@Column(name = "string_id")
	private String id;

	@Column
	private String label;

	@OneToOne(cascade = { CascadeType.ALL })
	private Cvor source;

	@OneToOne(cascade = { CascadeType.ALL })
	private Cvor target;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pz_id", referencedColumnName = "id")
	@JsonIgnore
	private ProstorZnanja pz;

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

	public ProstorZnanja getPz() {
		return pz;
	}

	public void setPz(ProstorZnanja pz) {
		this.pz = pz;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
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
		Veza other = (Veza) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		return true;
	}

	

}
