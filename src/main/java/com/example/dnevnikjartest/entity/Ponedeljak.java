package com.example.dnevnikjartest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ponedeljak")
public class Ponedeljak extends AbstractRaspored {

	public Ponedeljak() {
		super();
		
	}

	public Ponedeljak(String pretcas, String prvi, String drugi, String treci, String cetvrti, String peti,
			String sesti, String sedmi) {
		super(pretcas, prvi, drugi, treci, cetvrti, peti, sesti, sedmi);
		// TODO Auto-generated constructor stub
	}


	
	
}