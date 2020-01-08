package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Korisnici;
import com.example.dnevnikjartest.repo.UciteljiRepository;

@Service
@Transactional
public class UciteljiService {

	private UciteljiRepository uciteljiRepository;

	@Autowired
	public UciteljiService(UciteljiRepository uciteljiRepository) {
		
		this.uciteljiRepository = uciteljiRepository;
	}
	
	public List<Korisnici> listUcitelji(){
		return uciteljiRepository.findAll();
	}
	
}
