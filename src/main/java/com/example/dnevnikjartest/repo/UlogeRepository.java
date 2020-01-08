package com.example.dnevnikjartest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Uloge;

@Repository("ulogeRepository")
public interface UlogeRepository extends JpaRepository<Uloge, Integer> {

	
}
