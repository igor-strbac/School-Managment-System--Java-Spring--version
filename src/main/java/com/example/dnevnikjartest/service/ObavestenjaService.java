/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Obavestenja;
import com.example.dnevnikjartest.repo.ObavestenjaRepository;

/**
 *
 * @author Grupa2
 */
@Service("obavestenjaService")
@Transactional
public class ObavestenjaService {

	private ObavestenjaRepository obavestenjaRepository;

	@Autowired
	public ObavestenjaService(ObavestenjaRepository obavestenjaRepository) {

		this.obavestenjaRepository = obavestenjaRepository;
	}

	public List<Obavestenja> listObavestenja() {
		return obavestenjaRepository.findAll();
	}

	public void save(Obavestenja obavestenja) {
		obavestenjaRepository.save(obavestenja);
	}

	public void delete(int id_obavestenja) {
		obavestenjaRepository.deleteById(id_obavestenja);
	}
}