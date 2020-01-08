package com.example.dnevnikjartest.entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public class AbstractRaspored {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String pretcas;
	private String prvi;
	private String drugi;
	private String treci;
	private String cetvrti;
	private String peti;
	private String sesti;
	private String sedmi;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="id_odeljenje")
	private Odeljenja odeljenje;


	public AbstractRaspored() {
		
	}

	public AbstractRaspored(String pretcas, String prvi, String drugi, String treci, String cetvrti, String peti,
			String sesti, String sedmi) {
		super();
		this.pretcas = pretcas;
		this.prvi = prvi;
		this.drugi = drugi;
		this.treci = treci;
		this.cetvrti = cetvrti;
		this.peti = peti;
		this.sesti = sesti;
		this.sedmi = sedmi;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPretcas() {
		return pretcas;
	}

	public void setPretcas(String pretcas) {
		this.pretcas = pretcas;
	}

	public String getPrvi() {
		return prvi;
	}

	public void setPrvi(String prvi) {
		this.prvi = prvi;
	}

	public String getDrugi() {
		return drugi;
	}

	public void setDrugi(String drugi) {
		this.drugi = drugi;
	}

	public String getTreci() {
		return treci;
	}

	public void setTreci(String treci) {
		this.treci = treci;
	}

	public String getCetvrti() {
		return cetvrti;
	}

	public void setCetvrti(String cetvrti) {
		this.cetvrti = cetvrti;
	}

	public String getPeti() {
		return peti;
	}

	public void setPeti(String peti) {
		this.peti = peti;
	}

	public String getSesti() {
		return sesti;
	}

	public void setSesti(String sesti) {
		this.sesti = sesti;
	}

	public String getSedmi() {
		return sedmi;
	}

	public void setSedmi(String sedmi) {
		this.sedmi = sedmi;
	}

	public Odeljenja getOdeljenje() {
		return odeljenje;
	}

	public void setOdeljenje(Odeljenja odeljenje) {
		this.odeljenje = odeljenje;
	}

	@Override
	public String toString() {
		return "AbstractRaspored [id=" + id + ", pretcas=" + pretcas + ", prvi=" + prvi + ", drugi=" + drugi
				+ ", treci=" + treci + ", cetvrti=" + cetvrti + ", peti=" + peti + ", sesti=" + sesti + ", sedmi="
				+ sedmi + ", odeljenje=" + odeljenje + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cetvrti == null) ? 0 : cetvrti.hashCode());
		result = prime * result + ((drugi == null) ? 0 : drugi.hashCode());
		result = prime * result + id;
		result = prime * result + ((odeljenje == null) ? 0 : odeljenje.hashCode());
		result = prime * result + ((peti == null) ? 0 : peti.hashCode());
		result = prime * result + ((pretcas == null) ? 0 : pretcas.hashCode());
		result = prime * result + ((prvi == null) ? 0 : prvi.hashCode());
		result = prime * result + ((sedmi == null) ? 0 : sedmi.hashCode());
		result = prime * result + ((sesti == null) ? 0 : sesti.hashCode());
		result = prime * result + ((treci == null) ? 0 : treci.hashCode());
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
		AbstractRaspored other = (AbstractRaspored) obj;
		if (cetvrti == null) {
			if (other.cetvrti != null)
				return false;
		} else if (!cetvrti.equals(other.cetvrti))
			return false;
		if (drugi == null) {
			if (other.drugi != null)
				return false;
		} else if (!drugi.equals(other.drugi))
			return false;
		if (id != other.id)
			return false;
		if (odeljenje == null) {
			if (other.odeljenje != null)
				return false;
		} else if (!odeljenje.equals(other.odeljenje))
			return false;
		if (peti == null) {
			if (other.peti != null)
				return false;
		} else if (!peti.equals(other.peti))
			return false;
		if (pretcas == null) {
			if (other.pretcas != null)
				return false;
		} else if (!pretcas.equals(other.pretcas))
			return false;
		if (prvi == null) {
			if (other.prvi != null)
				return false;
		} else if (!prvi.equals(other.prvi))
			return false;
		if (sedmi == null) {
			if (other.sedmi != null)
				return false;
		} else if (!sedmi.equals(other.sedmi))
			return false;
		if (sesti == null) {
			if (other.sesti != null)
				return false;
		} else if (!sesti.equals(other.sesti))
			return false;
		if (treci == null) {
			if (other.treci != null)
				return false;
		} else if (!treci.equals(other.treci))
			return false;
		return true;
	}
	
	
	
}
