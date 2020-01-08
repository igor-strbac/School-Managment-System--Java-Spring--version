package com.example.dnevnikjartest.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roditelji")
public class Roditelji implements Serializable{

	@Id
	@JoinColumn(name="id_roditelj", referencedColumnName = "id_korisnik", insertable = false, nullable = false)
	@OneToOne(optional = false,fetch = FetchType.LAZY)
	private Korisnici korisnik;

	public Roditelji() {}

	public Korisnici getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnici korisnik) {
		this.korisnik = korisnik;
	}

	
	
	@Override
	public String toString() {
		return "Roditelji [korisnik=" + korisnik + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((korisnik == null) ? 0 : korisnik.hashCode());
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
		Roditelji other = (Roditelji) obj;
		if (korisnik == null) {
			if (other.korisnik != null)
				return false;
		} else if (!korisnik.equals(other.korisnik))
			return false;
		return true;
	}
	
	
}
