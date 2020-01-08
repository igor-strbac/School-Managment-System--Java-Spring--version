package com.example.dnevnikjartest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Sreda;
@Repository
public interface SredaRepository extends JpaRepository<Sreda, Integer> {

	@Query(value="select * from sreda where id_odeljenje = ?1", nativeQuery = true)
	List<Sreda> findAll(int id);
	
		@Query(value="select * from sreda p inner join odeljenja o on(p.id_odeljenje=o.id_odeljenje) inner join korisnici k on(k.id_korisnik=o.ucitelj_id_ucitelj) where k.id_korisnik = ?1", nativeQuery = true)
		List<Sreda> findById(int id);
	
}
