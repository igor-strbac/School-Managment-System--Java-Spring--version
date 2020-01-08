/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dnevnikjartest.entity;

import java.util.Date;
import java.util.Objects;

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
@Table(name = "otvorena_vrata")
public class OtvorenaVrata {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_otvorena_vrata")
	private int id_otvorena_vrata;
	@JoinColumn(name = "ucitelj_id_ucitelj")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Korisnici ucitelj; // ucitelj
	@JoinColumn(name = "roditelj_id_roditelj")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Korisnici roditelj; // roditelj
	@Column(name = "odgovor")
	private String odgovor;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "vreme")
        private Date vreme = new Date();

	public OtvorenaVrata() {
	}

	public OtvorenaVrata(String odgovor, Date vreme) {
		this.odgovor = odgovor;
		this.vreme = vreme;
	}

	public int getId_otvorena_vrata() {
		return id_otvorena_vrata;
	}

	public void setId_otvorena_vrata(int id_otvorena_vrata) {
		this.id_otvorena_vrata = id_otvorena_vrata;
	}

        public Korisnici getUcitelj() {
            return ucitelj;
        }

        public void setUcitelj(Korisnici ucitelj) {
            this.ucitelj = ucitelj;
        }

        public Korisnici getRoditelj() {
            return roditelj;
        }

        public void setRoditelj(Korisnici roditelj) {
            this.roditelj = roditelj;
        }

	public String getOdgovor() {
		return odgovor;
	}

	public void setOdgovor(String odgovor) {
		this.odgovor = odgovor;
	}

	public Date getVreme() {
		return vreme;
	}

	public void setVreme(Date vreme) {
		this.vreme = vreme;
	}

	@Override
	public String toString() {
		return "OtvorenaVrata{" + "id_otvorena_vrata=" + id_otvorena_vrata + ", ucitelj="
				+ ucitelj + ", roditelj=" + roditelj + ", odgovor=" + odgovor
				+ ", vreme=" + vreme + '}';
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id_otvorena_vrata;
        hash = 31 * hash + Objects.hashCode(this.ucitelj);
        hash = 31 * hash + Objects.hashCode(this.roditelj);
        hash = 31 * hash + Objects.hashCode(this.odgovor);
        hash = 31 * hash + Objects.hashCode(this.vreme);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OtvorenaVrata other = (OtvorenaVrata) obj;
        if (this.id_otvorena_vrata != other.id_otvorena_vrata) {
            return false;
        }
        if (!Objects.equals(this.odgovor, other.odgovor)) {
            return false;
        }
        if (!Objects.equals(this.ucitelj, other.ucitelj)) {
            return false;
        }
        if (!Objects.equals(this.roditelj, other.roditelj)) {
            return false;
        }
        if (!Objects.equals(this.vreme, other.vreme)) {
            return false;
        }
        return true;
    }

}
