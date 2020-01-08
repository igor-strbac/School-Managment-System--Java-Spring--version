package com.example.dnevnikjartest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Poruke;

@Repository("porukeRepository")
public interface PorukeRepository extends JpaRepository<Poruke, Integer>{


    
}
