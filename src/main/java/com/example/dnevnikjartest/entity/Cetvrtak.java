package com.example.dnevnikjartest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cetvrtak")
public class Cetvrtak extends AbstractRaspored {

	public Cetvrtak() {
		// TODO Auto-generated constructor stub
	}

	public Cetvrtak(String pretcas, String prvi, String drugi, String treci, String cetvrti, String peti, String sesti,
			String sedmi) {
		super(pretcas, prvi, drugi, treci, cetvrti, peti, sesti, sedmi);
		// TODO Auto-generated constructor stub
	}

	
}
