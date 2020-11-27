package com.example.SOTIS.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
/** @pdOid 57a62dc1-ac08-4a92-a809-4b89906c4e06 */
public class ProstorZnanja {
	
	@Id
	/** @pdOid 0c5692b5-f53e-4085-b01f-3137c8eef333 */
	private long id;
	
	@OneToOne
	/**
	 * @pdRoleInfo migr=no name=Predmet assc=association9 mult=0..1 type=Aggregation
	 */
	public Predmet predmet;

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

}