package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Cetvrtak;
import com.example.dnevnikjartest.repo.CetvrtakRepository;

@Service
@Transactional
public class CetvrtakService {

	
	private CetvrtakRepository cetvrtakRepository;

	@Autowired
	public CetvrtakService(CetvrtakRepository cetvrtakRepository) {
		super();
		this.cetvrtakRepository = cetvrtakRepository;
	}
	
	public List<Cetvrtak> izlistaj(int id) {
		return cetvrtakRepository.findAll(id);
	}
	public void saveCetvrtak(Cetvrtak cetvrtak) {
		cetvrtakRepository.save(cetvrtak);
	}
	public void delete(int id) {
		cetvrtakRepository.deleteById(id);
	}
	public List<Cetvrtak> nadjiPoId(int id){
		return cetvrtakRepository.findById(id);
	}
}
