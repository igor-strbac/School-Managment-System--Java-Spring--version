package com.example.dnevnikjartest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Petak;
@Repository
public interface PetakRepository extends JpaRepository<Petak, Integer> {

	@Query(value="select * from petak where id_odeljenje = ?1", nativeQuery = true)
	List<Petak> findAll(int id);
	
		@Query(value="select * from petak p inner join odeljenja o on(p.id_odeljenje=o.id_odeljenje) inner join korisnici k on(k.id_korisnik=o.ucitelj_id_ucitelj) where k.id_korisnik = ?1", nativeQuery = true)
		List<Petak> findById(int id);
	
}
