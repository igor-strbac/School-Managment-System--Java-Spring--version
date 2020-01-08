package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Petak;
import com.example.dnevnikjartest.repo.PetakRepository;

@Service
@Transactional
public class PetakService {

	
	private PetakRepository petakRepository;

	@Autowired
	public PetakService(PetakRepository petakRepository) {
		super();
		this.petakRepository = petakRepository;
	}
	
	public List<Petak> izlistaj(int id) {
		return petakRepository.findAll(id);
	}
	public void savePetak(Petak petak) {
		petakRepository.save(petak);
	}
	public void delete(int id) {
		petakRepository.deleteById(id);
	}
	public List<Petak> nadjiPoId(int id){
		return petakRepository.findById(id);
	}
}
