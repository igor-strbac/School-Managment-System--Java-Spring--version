package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Poruke;
import com.example.dnevnikjartest.repo.PorukeRepository;

@Service("porukeService")
@Transactional
public class PorukeService {

    private PorukeRepository porukeRepository;
    
    @Autowired
    public PorukeService(PorukeRepository porukeRepository) {
            this.porukeRepository = porukeRepository;
    }
    
    public List<Poruke> findAll() {
            return porukeRepository.findAll();
    }
    
    public void sendPoruke(Poruke poruka) {
                porukeRepository.save(poruka);
        }
    
    public Poruke getView(int id_poruke) {
            return porukeRepository.findById(id_poruke).get();
    }
    
}
