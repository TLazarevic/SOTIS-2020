package com.example.SOTIS.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.JoinColumn;

@Entity
@Table(name="prostor_znanja")
/** @pdOid 57a62dc1-ac08-4a92-a809-4b89906c4e06 */
public class ProstorZnanja {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	/** @pdOid 0c5692b5-f53e-4085-b01f-3137c8eef333 */
	private long id;

	@OneToOne(cascade = { CascadeType.MERGE })
	/**
	 * @pdRoleInfo migr=no name=Predmet assc=association9 mult=0..1 type=Aggregation
	 */
	public Predmet predmet;

	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	@JoinColumn(name = "prostor_znanja_id")
	public Set<Cvor> cvorovi = new HashSet<>();

	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	@JoinColumn(name = "prostor_znanja_id")
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
		this.cvorovi = cvorovi;
	}

	public Set<Veza> getVeze() {
		return veze;
	}

	public void setVeze(Set<Veza> veze) {
		this.veze = veze;
	}

	@Override
	public String toString() {
		return "ProstorZnanja [id=" + id + "]";
	}

}