package com.example.dnevnikjartest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Korisnici;
@Repository
public interface UciteljiRepository extends JpaRepository<Korisnici, Integer> {

	@Query(value="select * from korisnici k where k.uloge_uloga_id=2",
			nativeQuery=true)
	List<Korisnici> findAll();
}
