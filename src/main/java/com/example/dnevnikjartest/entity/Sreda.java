package com.example.dnevnikjartest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sreda")
public class Sreda extends AbstractRaspored {

	public Sreda() {
		// TODO Auto-generated constructor stub
	}

	public Sreda(String pretcas, String prvi, String drugi, String treci, String cetvrti, String peti, String sesti,
			String sedmi) {
		super(pretcas, prvi, drugi, treci, cetvrti, peti, sesti, sedmi);
		// TODO Auto-generated constructor stub
	}

	
}
