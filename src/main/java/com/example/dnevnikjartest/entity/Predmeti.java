package com.example.dnevnikjartest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "predmeti")
public class Predmeti {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_predmet")
	private int id_predmet;

	@Column(name = "naziv")
	private String naziv;

	public Predmeti() {
	}
        

	public Predmeti(String naziv) {

		this.naziv = naziv;
	}

	public int getId_predmet() {
		return id_predmet;
	}

	public void setId_predmet(int id_predmet) {
		this.id_predmet = id_predmet;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "Predmeti [id_predmet=" + id_predmet + ", naziv=" + naziv + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_predmet;
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
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
		Predmeti other = (Predmeti) obj;
		if (id_predmet != other.id_predmet)
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		return true;
	}

}
