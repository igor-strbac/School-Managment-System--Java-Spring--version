/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Korisnici;
import com.example.dnevnikjartest.repo.DirektorRepository;

@Service
@Transactional
public class DirektorService {

    private DirektorRepository direktorRepository;

    @Autowired
    public DirektorService(DirektorRepository direktorRepository) {

        this.direktorRepository = direktorRepository;
    }

    public List<Korisnici> listDirektor() {
        return direktorRepository.findAll();
    }
}
