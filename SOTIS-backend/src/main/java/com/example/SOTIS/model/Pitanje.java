package com.example.SOTIS.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
/** @pdOid ca9d29ef-a4f5-4bcf-9b64-ba4b4ea47657 */
public class Pitanje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JsonIgnore
	@ManyToMany(mappedBy = "pitanje")
	/**
	 * @pdRoleInfo migr=no name=Odgovor assc=association2 coll=java.util.Set
	 *             impl=java.util.Set mult=0..* type=Composition
	 */
	public Set<Test> test;

	@Column
	private String tekst;

	public Pitanje(long id, String tekst) {
		super();
		this.id = id;
		this.tekst = tekst;
	}


	@OneToOne
	public Cvor cvor;


	//@ManyToOne
	/**
	 * @pdRoleInfo migr=no name=Predmet assc=association8 mult=0..1 type=Aggregation
	 */
	@Column
	public Long predmetId;

	public Pitanje() {
		super();
	}

	public Set<Test> getTest() {
		return test;
	}

	public void setTest(Set<Test> test) {
		this.test = test;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pitanje [id=" + id + ", test=" + test + ", tekst=" + tekst + "]";
	}

	public Long getPredmetId() {
		return predmetId;
	}

	public void setPredmetId(Long predmet_id) {
		this.predmetId = predmet_id;
	}
	
	
	public Cvor getCvor() {
		return cvor;
	}

	public void setCvor(Cvor cvor) {
		this.cvor = cvor;
	}


	
}