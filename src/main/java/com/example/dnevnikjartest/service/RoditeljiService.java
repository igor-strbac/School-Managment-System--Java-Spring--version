package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Korisnici;
import com.example.dnevnikjartest.repo.RoditeljiRepository;

@Service("roditeljiService")
@Transactional
public class RoditeljiService {

    private RoditeljiRepository roditeljiRepository;

    @Autowired
    public RoditeljiService(RoditeljiRepository roditeljiRepository) {

        this.roditeljiRepository = roditeljiRepository;
    }

    public List<Korisnici> listRoditelji() {
        return roditeljiRepository.findAll();
    }

    public void save(Korisnici korisnik) {
        roditeljiRepository.save(korisnik);
    }
}
