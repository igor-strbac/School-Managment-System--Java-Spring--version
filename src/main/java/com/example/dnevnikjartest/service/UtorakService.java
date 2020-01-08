package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Utorak;
import com.example.dnevnikjartest.repo.UtorakRepository;

@Service
@Transactional
public class UtorakService {

	private UtorakRepository utorakRepository;

	@Autowired
	public UtorakService(UtorakRepository utorakRepository) {
		super();
		this.utorakRepository = utorakRepository;
	}
	
	public List<Utorak> izlistaj(int id) {
		return utorakRepository.findAll(id);
	}
	public void saveUtorak(Utorak utorak) {
		utorakRepository.save(utorak);
	}
	public void delete(int id) {
		utorakRepository.deleteById(id);
	}
	public List<Utorak> nadjiPoId(int id){
		return utorakRepository.findById(id);
	}
}
