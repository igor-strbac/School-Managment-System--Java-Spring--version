package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Sreda;
import com.example.dnevnikjartest.repo.SredaRepository;

@Service
@Transactional
public class SredaService {

	private SredaRepository sredaRepository;

	@Autowired
	public SredaService(SredaRepository sredaRepository) {
		super();
		this.sredaRepository = sredaRepository;
	}
	
	public List<Sreda> izlistaj(int id) {
		return sredaRepository.findAll(id);
	}
	public void saveSreda(Sreda sreda) {
		sredaRepository.save(sreda);
	}
	public void delete(int id) {
		sredaRepository.deleteById(id);
	}
	public List<Sreda> nadjiPoId(int id){
		return sredaRepository.findById(id);
	}
}
