package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Uloge;
import com.example.dnevnikjartest.repo.UlogeRepository;

@Service
@Transactional
public class UlogeService {

	@Autowired
	private UlogeRepository ulogeRepository;

	public List<Uloge> findAll() {
		return ulogeRepository.findAll();
	}

}
