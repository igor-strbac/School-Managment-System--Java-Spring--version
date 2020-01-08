package com.example.dnevnikjartest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Ucenici;

@Repository("uceniciRepository")
public interface UceniciRepository extends JpaRepository<Ucenici, Integer> {
        
	@Query(value="select * from ucenici u inner join odeljenja o on(u.odeljenje_id_odeljenje=o.id_odeljenje) inner join korisnici k on(k.id_korisnik=o.ucitelj_id_ucitelj) where k.id_korisnik = ?1", nativeQuery = true)
	List<Ucenici> findByIdRoditelja(int id);
	
    @Query(value="select * from ucenici u inner join odeljenja o on(u.odeljenje_id_odeljenje = o.id_odeljenje) where o.ucitelj_id_ucitelj=?1", nativeQuery = true)
    List<Ucenici> findUcenikePoOdeljenju(int id);
}


      