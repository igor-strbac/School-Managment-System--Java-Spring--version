package com.example.dnevnikjartest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Korisnici;

@Repository("korisniciRepository")
public interface KorisniciRepository extends JpaRepository<Korisnici, Integer> {

public Korisnici findByUsername(String username);

}
