package com.example.SOTIS.model.DTO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.SOTIS.model.Predmet;
import com.example.SOTIS.model.Test;
import com.example.SOTIS.model.Ucenik;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MarkovljevProstorZnanja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JsonIgnore
	private Ucenik ucenik;

	@ManyToOne
	@JsonIgnore
	private Test test;

	@Column
	private String pz;

	@Column
	private Double verovatnoca;

	public MarkovljevProstorZnanja() {
		super();
	}

	public MarkovljevProstorZnanja(Ucenik ucenik, Test test, List<String> list, Double double1) {
		super();
		this.ucenik = ucenik;
		this.test = test;
		this.verovatnoca = double1;
		String pz = "";
		for (String l : list) {
			pz += l + " ";
		}
		this.pz = pz;
	}

	@Override
	public String toString() {
		return "MarkovljevProstorZnanja [id=" + id + ", ucenik=" + ucenik + ", pz=" + pz + ", verovatnoca="
				+ verovatnoca + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public String getPz() {
		return pz;
	}

	public void setPz(String pz) {
		this.pz = pz;
	}

	public Double getVerovatnoca() {
		return verovatnoca;
	}

	public void setVerovatnoca(Double verovatnoca) {
		this.verovatnoca = verovatnoca;
	}

}
