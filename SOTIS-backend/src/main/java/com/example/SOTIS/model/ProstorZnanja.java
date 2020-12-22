package com.example.SOTIS.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "prostor_znanja")
/** @pdOid 57a62dc1-ac08-4a92-a809-4b89906c4e06 */
public class ProstorZnanja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/** @pdOid 0c5692b5-f53e-4085-b01f-3137c8eef333 */
	private long id;

	@OneToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "predmet_id", referencedColumnName = "id")
	/**
	 * @pdRoleInfo migr=no name=Predmet assc=association9 mult=0..1 type=Aggregation
	 */
	public Predmet predmet;
	
	@Column
	public Boolean generisan;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pz", orphanRemoval = true, fetch = FetchType.EAGER)
	public Set<Cvor> cvorovi = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pz", orphanRemoval = true, fetch = FetchType.EAGER)
	public Set<Veza> veze = new HashSet<>();

	public ProstorZnanja() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Set<Cvor> getCvorovi() {
		return cvorovi;
	}

	public void setCvorovi(Set<Cvor> cvorovi) {
		// https://stackoverflow.com/questions/43246259/jpa-manytoone-onetomany-not-inserting-the-value-on-child
		// sve me boli
		for (Cvor child : cvorovi) {
			// initializing the TestObj instance in Children class (Owner side)
			// so that it is not a null and PK can be created
			child.setPz(this);
		}
		this.cvorovi = cvorovi;
	}

	public Set<Veza> getVeze() {
		return veze;
	}

	public void setVeze(Set<Veza> veze) {
		// https://stackoverflow.com/questions/43246259/jpa-manytoone-onetomany-not-inserting-the-value-on-child
		// sve me boli
		for (Veza child : veze) {
			// initializing the TestObj instance in Children class (Owner side)
			// so that it is not a null and PK can be created
			child.setPz(this);
		}
		this.veze = veze;
	}

	@Override
	public String toString() {
		return "ProstorZnanja [id=" + id + "]";
	}

	public Boolean getGenerisan() {
		return generisan;
	}

	public void setGenerisan(Boolean generisan) {
		this.generisan = generisan;
	}

}