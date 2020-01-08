package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Ponedeljak;
import com.example.dnevnikjartest.repo.PonedeljakRepository;

@Service
@Transactional
public class PonedeljakService {

	private PonedeljakRepository ponedeljakRepository;

	@Autowired
	public PonedeljakService(PonedeljakRepository ponedeljakRepository) {
		
		this.ponedeljakRepository = ponedeljakRepository;
	}
	
	public List<Ponedeljak> izlistaj(int id){
		return ponedeljakRepository.findAll(id);
	}
	public void savePonedeljak(Ponedeljak pon) {
	   ponedeljakRepository.save(pon);
	}
	public void delete(int id) {
		ponedeljakRepository.deleteById(id);
	}
	
	public List<Ponedeljak> nadjiPoId(int id){
		return ponedeljakRepository.findById(id);
	}
}
