/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dnevnikjartest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Grupa2
 */
@Entity
@Table(name = "odeljenja")
public class Odeljenja implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_odeljenje")
	private int id_odeljenje;
	
	@Column(name = "naziv")
	private String naziv;

	@JoinColumn(name = "ucitelj_id_ucitelj")
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	private Korisnici korisnik; // ucitelj

	public Odeljenja() {
	}

	public Odeljenja(String naziv) {
		this.naziv = naziv;

	}

	public int getId_odeljenje() {
		return id_odeljenje;
	}

	public void setId_odeljenje(int id_odeljenje) {
		this.id_odeljenje = id_odeljenje;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Korisnici getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnici korisnik) {
		this.korisnik = korisnik;
	}

	@Override
	public String toString() {
		return "Odeljenja [id_odeljenje=" + id_odeljenje + ", naziv=" + naziv + ", korisnik=" + korisnik + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_odeljenje;
		result = prime * result + ((korisnik == null) ? 0 : korisnik.hashCode());
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
		Odeljenja other = (Odeljenja) obj;
		if (id_odeljenje != other.id_odeljenje)
			return false;
		if (korisnik == null) {
			if (other.korisnik != null)
				return false;
		} else if (!korisnik.equals(other.korisnik))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		return true;
	}

}
