package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Ucenici;
import com.example.dnevnikjartest.repo.UceniciRepository;

@Service("uceniciService")
@Transactional
public class UceniciService {

	private UceniciRepository uceniciRepository;

	@Autowired
	public UceniciService(UceniciRepository uceniciRepository) {
		this.uceniciRepository = uceniciRepository;
	}

	public List<Ucenici> listAll() {
		return uceniciRepository.findAll();

	}

	public void saveUcenici(Ucenici ucenici) {
		uceniciRepository.save(ucenici);
	}

	public Ucenici get(int id_ucenik) {
		return uceniciRepository.getOne(id_ucenik);
	}

	public void delete(int id_ucenik) {
		uceniciRepository.deleteById(id_ucenik);
	}

	public List<Ucenici> nadjiPoId(int id) {
		return uceniciRepository.findByIdRoditelja(id);
	}
	public List<Ucenici> uceniciPoOdeljenjima(int id){
		return uceniciRepository.findUcenikePoOdeljenju(id);
	}
}
