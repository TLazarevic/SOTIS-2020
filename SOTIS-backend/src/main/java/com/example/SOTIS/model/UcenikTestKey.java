package com.example.SOTIS.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UcenikTestKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4058194262001438325L;

	@Column(name = "ucenik_id")
	private Long ucenikId;

	@Column(name = "test_id")
	private Long testId;

	public UcenikTestKey() {
		super();
	}

	public Long getUcenikId() {
		return ucenikId;
	}

	public void setUcenikId(Long ucenikId) {
		this.ucenikId = ucenikId;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((testId == null) ? 0 : testId.hashCode());
		result = prime * result + ((ucenikId == null) ? 0 : ucenikId.hashCode());
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
		UcenikTestKey other = (UcenikTestKey) obj;
		if (testId == null) {
			if (other.testId != null)
				return false;
		} else if (!testId.equals(other.testId))
			return false;
		if (ucenikId == null) {
			if (other.ucenikId != null)
				return false;
		} else if (!ucenikId.equals(other.ucenikId))
			return false;
		return true;
	}
}
