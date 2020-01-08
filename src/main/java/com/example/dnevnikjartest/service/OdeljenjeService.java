package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Odeljenja;
import com.example.dnevnikjartest.repo.OdeljenjeRepository;

@Service("odeljenjeService")
@Transactional
public class OdeljenjeService {

	private OdeljenjeRepository odeljenjeRepository;

	@Autowired
	public OdeljenjeService(OdeljenjeRepository odeljenjeRepository) {
		this.odeljenjeRepository = odeljenjeRepository;
	}

	public List<Odeljenja> listAll() {
		return odeljenjeRepository.findAll();
	}

	public void saveOdeljenje(Odeljenja odeljenje) {
		odeljenjeRepository.save(odeljenje);
	}

	public Odeljenja get(int id_odeljenje) {
		return odeljenjeRepository.findById(id_odeljenje).get();
	}

	public void delete(int id_odeljenje) {
		odeljenjeRepository.deleteById(id_odeljenje);
	}
}
