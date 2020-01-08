/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dnevnikjartest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Ocene;

/**
 *
 * @author Grupa2
 */
@Repository("oceneRepository")
public interface OceneRepository extends JpaRepository<Ocene, Integer>{
    
    
	@Query(value="select * from ocene where ucenik_id_ucenik = ?1", nativeQuery = true)
	List<Ocene> findByIdUcenika(int id);
	
	@Query(value="select * from ocene o inner join ucenici u on(o.ucenik_id_ucenik=u.id_ucenik) inner join korisnici k on(k.id_korisnik=u.id_roditelj) where k.id_korisnik = ?1 order by predmet_id_predmet", nativeQuery = true)
    List<Ocene> findByIdRoditelj(int id);
}
