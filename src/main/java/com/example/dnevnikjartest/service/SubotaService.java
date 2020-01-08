package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Subota;
import com.example.dnevnikjartest.repo.SubotaRepository;

@Service
@Transactional
public class SubotaService {

	
	private SubotaRepository subotaRepository;

	@Autowired
	public SubotaService(SubotaRepository subotaRepository) {
		super();
		this.subotaRepository = subotaRepository;
	}
	
	public List<Subota> izlistaj(int id) {
		return subotaRepository.findAll(id);
	}
	public void saveSubota(Subota subota) {
		subotaRepository.save(subota);
	}
	public void delete(int id) {
		subotaRepository.deleteById(id);
	}
	public List<Subota> nadjiPoId(int id){
		return subotaRepository.findById(id);
	}
}
