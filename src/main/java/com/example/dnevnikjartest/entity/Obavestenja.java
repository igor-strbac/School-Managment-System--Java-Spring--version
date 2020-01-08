package com.example.dnevnikjartest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "obavestenja")
public class Obavestenja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_obavestenje")
	private int id_obavestenja;
	
	@Column(name = "sadrzaj_obavestenja")
	private String sadrzaj_obavestenja;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "datum")
	private Date datum = new Date();
	
	private int admin_id_admin;

	public Obavestenja() {
	}

	public Obavestenja(String sadrzaj_obavestenja, Date datum, int admin_id_admin) {
		this.sadrzaj_obavestenja = sadrzaj_obavestenja;
		this.datum = datum;
		this.admin_id_admin = admin_id_admin;
	}

	public int getId_obavestenja() {
		return id_obavestenja;
	}

	public void setId_obavestenja(int id_obavestenja) {
		this.id_obavestenja = id_obavestenja;
	}

	public String getSadrzaj_obavestenja() {
		return sadrzaj_obavestenja;
	}

	public void setSadrzaj_obavestenja(String sadrzaj_obavestenja) {
		this.sadrzaj_obavestenja = sadrzaj_obavestenja;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public int getAdmin_id_admin() {
		return admin_id_admin;
	}

	public void setAdmin_id_admin(int admin_id_admin) {
		this.admin_id_admin = admin_id_admin;
	}

	@Override
	public String toString() {
		return "Obavestenja{" + "id_obavestenja=" + id_obavestenja + ", sadrzaj_obavestenja=" + sadrzaj_obavestenja
				+ ", datum=" + datum + ", admin_id_admin=" + admin_id_admin + '}';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + admin_id_admin;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + id_obavestenja;
		result = prime * result + ((sadrzaj_obavestenja == null) ? 0 : sadrzaj_obavestenja.hashCode());
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
		Obavestenja other = (Obavestenja) obj;
		if (admin_id_admin != other.admin_id_admin)
			return false;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (id_obavestenja != other.id_obavestenja)
			return false;
		if (sadrzaj_obavestenja == null) {
			if (other.sadrzaj_obavestenja != null)
				return false;
		} else if (!sadrzaj_obavestenja.equals(other.sadrzaj_obavestenja))
			return false;
		return true;
	}

	
}
