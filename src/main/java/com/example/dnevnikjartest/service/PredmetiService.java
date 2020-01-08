package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Predmeti;
import com.example.dnevnikjartest.repo.PredmetiRepository;

@Service("predmetiService")
@Transactional
public class PredmetiService {

	private PredmetiRepository predmetiRepository;

	@Autowired
	public PredmetiService(PredmetiRepository predmetiRepository) {
		this.predmetiRepository = predmetiRepository;
	}

	public List<Predmeti> findAll() {

		return predmetiRepository.findAll();
	}

	public void savePredmeti(Predmeti predmet) {
		predmetiRepository.save(predmet);
	}

	public Predmeti get(int id_predmet) {
		return predmetiRepository.findById(id_predmet).get();
	}

	public void delete(int id_predmet) {
		predmetiRepository.deleteById(id_predmet);
	}

}
