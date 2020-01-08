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

@Entity
@Table(name = "poruke")
public class Poruke {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_poruke")
	private int id_poruke;
	@Column(name = "sadrzaj_poruke")
	private String sadrzaj_poruke;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "datum_vreme")
        private Date datum_vreme = new Date();
	@JoinColumn(name = "ucitelj_id_ucitelj")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Korisnici ucitelj; // ucitelj
	@JoinColumn(name = "roditelj_id_roditelj")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Korisnici roditelj; // roditelj

	public Poruke() {
	}

	public Poruke(String sadrzaj_poruke, Date datum_vreme) {
		this.sadrzaj_poruke = sadrzaj_poruke;
		this.datum_vreme = datum_vreme;
	}

	public int getId_poruke() {
		return id_poruke;
	}

	public void setId_poruke(int id_poruke) {
		this.id_poruke = id_poruke;
	}

	public String getSadrzaj_poruke() {
		return sadrzaj_poruke;
	}

	public void setSadrzaj_poruke(String sadrzaj_poruke) {
		this.sadrzaj_poruke = sadrzaj_poruke;
	}

	public Date getDatum_vreme() {
		return datum_vreme;
	}

	public void setDatum_vreme(Date datum_vreme) {
		this.datum_vreme = datum_vreme;
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

	@Override
	public String toString() {
		return "Poruke{" + "id_poruke=" + id_poruke + ", sadrzaj_poruke=" + sadrzaj_poruke + ", datum_vreme="
				+ datum_vreme + ", ucitelj=" + ucitelj + ", roditelj="
				+ roditelj + '}';
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id_poruke;
        hash = 59 * hash + Objects.hashCode(this.sadrzaj_poruke);
        hash = 59 * hash + Objects.hashCode(this.datum_vreme);
        hash = 59 * hash + Objects.hashCode(this.ucitelj);
        hash = 59 * hash + Objects.hashCode(this.roditelj);
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
        final Poruke other = (Poruke) obj;
        if (this.id_poruke != other.id_poruke) {
            return false;
        }
        if (!Objects.equals(this.sadrzaj_poruke, other.sadrzaj_poruke)) {
            return false;
        }
        if (!Objects.equals(this.datum_vreme, other.datum_vreme)) {
            return false;
        }
        if (!Objects.equals(this.ucitelj, other.ucitelj)) {
            return false;
        }
        if (!Objects.equals(this.roditelj, other.roditelj)) {
            return false;
        }
        return true;
    }

}
