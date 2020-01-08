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

import com.example.dnevnikjartest.entity.Ocene;
import com.example.dnevnikjartest.repo.OceneRepository;

/**
 *
 * @author Grupa2
 */
@Service
@Transactional
public class OceneService {

	private OceneRepository  oceneRepository;

	@Autowired
	public OceneService(OceneRepository oceneRepository) {
	
		this.oceneRepository =oceneRepository;
	}
	
	public List<Ocene> izlistaj(int id) {
		return oceneRepository.findByIdUcenika(id);
	}
	public void saveOcene(Ocene ocene) {
		oceneRepository.save(ocene);
	}
	public List<Ocene> nadjiPoId(int id){
		return oceneRepository.findByIdRoditelj(id);
	}

}