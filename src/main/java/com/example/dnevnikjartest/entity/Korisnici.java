package com.example.dnevnikjartest.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "korisnici")
public class Korisnici {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_korisnik")
	private int id_korisnik;
	@Column(name = "ime")
	private String ime;
	@Column(name = "prezime")
	private String prezime;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "adresa")
	private String adresa;
	@Column(name = "telefon")
	private String telefon;
	@Column(name = "email")
	private String email;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "uloge_uloga_id")
	private Uloge uloge;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "korisnik")
	private Admini admin;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "korisnik")
	private Direktor direktor;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "korisnik")
	private Roditelji roditelj;

	@OneToOne(mappedBy = "korisnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Ucitelji ucitelj;

	public Korisnici() {
	}

	public Korisnici(String ime, String prezime, String username, String password, String adresa, String telefon,
			String email) {

		this.ime = ime;
		this.prezime = prezime;
		this.username = username;
		this.password = password;
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;

	}

	public Ucitelji getUcitelj() {
		return ucitelj;
	}

	public void setUcitelj(Ucitelji ucitelj) {
		this.ucitelj = ucitelj;
		ucitelj.setKorisnik(this);
	}

	public Roditelji getRoditelj() {
		return roditelj;
	}

	public void setRoditelj(Roditelji roditelj) {
		this.roditelj = roditelj;
		roditelj.setKorisnik(this);
	}

	public Direktor getDirektor() {
		return direktor;
	}

	public void setDirektor(Direktor direktor) {
		this.direktor = direktor;
		direktor.setKorisnik(this);
	}

	public Admini getAdmin() {
		return admin;
	}

	public void setAdmin(Admini admin) {
		this.admin = admin;
		admin.setKorisnik(this);
	}

	public int getId_korisnik() {
		return id_korisnik;
	}

	public void setId_korisnik(int id_korisnik) {
		this.id_korisnik = id_korisnik;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Uloge getUloge() {
		return uloge;
	}

	public void setUloge(Uloge uloge) {
		this.uloge = uloge;
	}

	@Override
	public String toString() {
		return "Korisnici [id_korisnik=" + id_korisnik + ", ime=" + ime + ", prezime=" + prezime + ", username="
				+ username + ", password=" + password + ", adresa=" + adresa + ", telefon=" + telefon + ", email="
				+ email + ", uloge=" + uloge + ", admin=" + admin + ", direktor=" + direktor + ", roditelj=" + roditelj
				+ ", ucitelj=" + ucitelj + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + ((adresa == null) ? 0 : adresa.hashCode());
		result = prime * result + ((direktor == null) ? 0 : direktor.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id_korisnik;
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());

		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
		result = prime * result + ((roditelj == null) ? 0 : roditelj.hashCode());
		result = prime * result + ((telefon == null) ? 0 : telefon.hashCode());
		result = prime * result + ((ucitelj == null) ? 0 : ucitelj.hashCode());
		result = prime * result + ((uloge == null) ? 0 : uloge.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Korisnici other = (Korisnici) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (adresa == null) {
			if (other.adresa != null)
				return false;
		} else if (!adresa.equals(other.adresa))
			return false;
		if (direktor == null) {
			if (other.direktor != null)
				return false;
		} else if (!direktor.equals(other.direktor))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id_korisnik != other.id_korisnik)
			return false;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;

		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		if (roditelj == null) {
			if (other.roditelj != null)
				return false;
		} else if (!roditelj.equals(other.roditelj))
			return false;
		if (telefon == null) {
			if (other.telefon != null)
				return false;
		} else if (!telefon.equals(other.telefon))
			return false;
		if (ucitelj == null) {
			if (other.ucitelj != null)
				return false;
		} else if (!ucitelj.equals(other.ucitelj))
			return false;
		if (uloge == null) {
			if (other.uloge != null)
				return false;
		} else if (!uloge.equals(other.uloge))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
