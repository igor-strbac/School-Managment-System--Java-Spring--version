package com.example.dnevnikjartest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uloge")
public class Uloge {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_uloga")
	private int id_uloga;

	@Column(name = "uloga")
	private String uloga;

	public Uloge() {
	}

	public Uloge(String uloga) {

		this.uloga = uloga;
	}

	public int getId_uloga() {
		return id_uloga;
	}

	public void setId_uloga(int id_uloga) {
		this.id_uloga = id_uloga;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

	@Override
	public String toString() {
		return "Uloge [id_uloga=" + id_uloga + ", uloga=" + uloga + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_uloga;
		result = prime * result + ((uloga == null) ? 0 : uloga.hashCode());
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
		Uloge other = (Uloge) obj;
		if (id_uloga != other.id_uloga)
			return false;
		if (uloga == null) {
			if (other.uloga != null)
				return false;
		} else if (!uloga.equals(other.uloga))
			return false;
		return true;
	}

	
}
