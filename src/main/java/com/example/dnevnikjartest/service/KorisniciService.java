package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Korisnici;
import com.example.dnevnikjartest.repo.KorisniciRepository;

@Service("korisniciService")
@Transactional
public class KorisniciService {

	private KorisniciRepository korisniciRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public KorisniciService(KorisniciRepository korisniciRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.korisniciRepository = korisniciRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	
	public List<Korisnici> listAll() {
		return korisniciRepository.findAll();
	}

	public void save(Korisnici korisnik) {
		korisnik.setPassword(bCryptPasswordEncoder.encode(korisnik.getPassword()));
		korisniciRepository.save(korisnik);
	}

	public Korisnici get(int id_korisnik) {
		return korisniciRepository.findById(id_korisnik).get();
	}

	public void delete(int id_korisnik) {
		korisniciRepository.deleteById(id_korisnik);
	}


	public Korisnici findByUsername(String username) {
		return korisniciRepository.findByUsername(username);
	}

	

}
