/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dnevnikjartest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Grupa2
 */

@Entity
@Table(name = "ocene")
public class Ocene {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ocena")
	private int id_ocena;

	@Column(name = "ocena")
	private Integer ocena;

	@Column(name = "datum")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datum = new Date();

	@Column(name = "zaklj_ocena")
	private Integer zaklj_ocena;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ucenik_id_ucenik")
	private Ucenici ucenici;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "predmet_id_predmet")
	private Predmeti predmet;

	public Ucenici getUcenici() {
		return ucenici;
	}

	public void setUcenici(Ucenici ucenici) {
		this.ucenici = ucenici;
	}

	public Predmeti getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmeti predmet) {
		this.predmet = predmet;
	}

	public Ocene() {
	}

	public Ocene(Integer ocena, Date datum, Integer zaklj_ocena) {

		this.ocena = ocena;
		this.datum = datum;

		this.zaklj_ocena = zaklj_ocena;
	}

	public int getId_ocena() {
		return id_ocena;
	}

	public void setId_ocena(int id_ocena) {
		this.id_ocena = id_ocena;
	}

	public Integer getOcena() {
		return ocena;
	}

	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Integer getZaklj_ocena() {
		return zaklj_ocena;
	}

	public void setZaklj_ocena(Integer zaklj_ocena) {
		this.zaklj_ocena = zaklj_ocena;
	}

	@Override
	public String toString() {
		return "Ocene{" + "id_ocena=" + id_ocena + ", ocena=" + ocena + ", datum=" + datum + ",  zaklj_ocena="
				+ zaklj_ocena + '}';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + id_ocena;
		result = prime * result + ((ocena == null) ? 0 : ocena.hashCode());
		result = prime * result + ((predmet == null) ? 0 : predmet.hashCode());
		result = prime * result + ((ucenici == null) ? 0 : ucenici.hashCode());
		result = prime * result + ((zaklj_ocena == null) ? 0 : zaklj_ocena.hashCode());
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
		Ocene other = (Ocene) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (id_ocena != other.id_ocena)
			return false;
		if (ocena == null) {
			if (other.ocena != null)
				return false;
		} else if (!ocena.equals(other.ocena))
			return false;
		if (predmet == null) {
			if (other.predmet != null)
				return false;
		} else if (!predmet.equals(other.predmet))
			return false;
		if (ucenici == null) {
			if (other.ucenici != null)
				return false;
		} else if (!ucenici.equals(other.ucenici))
			return false;
		if (zaklj_ocena == null) {
			if (other.zaklj_ocena != null)
				return false;
		} else if (!zaklj_ocena.equals(other.zaklj_ocena))
			return false;
		return true;
	}

}
