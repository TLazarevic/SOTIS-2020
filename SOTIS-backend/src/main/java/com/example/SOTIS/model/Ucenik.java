package com.example.SOTIS.model;

import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
/** @pdOid a8444d5b-5cb7-4497-865b-0eb2abb0682d */
public class Ucenik {

	@Id
	/** @pdOid 09de1032-caf4-47b1-9ee1-586656fbb2d2 */
	private long id;

	@Column
	/** @pdOid 0959a844-ca2b-42ba-b6d6-756bdcffe819 */
	private String name;

	@Column
	/** @pdOid ce10ec1b-51a0-48cf-ae50-72d9f042f277 */
	private String lastName;

	@OneToMany
	/**
	 * @pdRoleInfo migr=no name=Test assc=association4 coll=java.util.Collection
	 *             impl=java.util.HashSet mult=0..* type=Aggregation
	 */
	public Set<Test> test;

	@OneToMany
	/**
	 * @pdRoleInfo migr=no name=ProstorZnanja assc=association5 mult=0..*
	 *             type=Composition
	 */
	public Set<ProstorZnanja> prostorZnanja;
	
	@ManyToMany
	@JoinTable(name = "ucenik_predmet", joinColumns = @JoinColumn(name = "ucenik_id"), inverseJoinColumns = @JoinColumn(name = "predmet_id"))
	public Set<Predmet> predmet;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Test> getTest() {
		return test;
	}

	public void setTest(Set<Test> test) {
		this.test = test;
	}

	public Set<ProstorZnanja> getProstorZnanja() {
		return prostorZnanja;
	}

	public void setProstorZnanja(Set<ProstorZnanja> prostorZnanja) {
		this.prostorZnanja = prostorZnanja;
	}

}