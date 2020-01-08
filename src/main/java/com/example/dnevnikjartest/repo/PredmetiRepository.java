package com.example.dnevnikjartest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Predmeti;

@Repository("predmetiRepository")
public interface PredmetiRepository extends JpaRepository<Predmeti, Integer> {

   
}
