package com.example.dnevnikjartest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="subota")
public class Subota extends AbstractRaspored {

	public Subota() {
		// TODO Auto-generated constructor stub
	}

	public Subota(String pretcas, String prvi, String drugi, String treci, String cetvrti, String peti, String sesti,
			String sedmi) {
		super(pretcas, prvi, drugi, treci, cetvrti, peti, sesti, sedmi);
		// TODO Auto-generated constructor stub
	}

	

}
