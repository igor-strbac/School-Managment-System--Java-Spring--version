package com.example.dnevnikjartest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Korisnici;

@Repository("direktorRepository")
public interface DirektorRepository extends JpaRepository<Korisnici, Integer> {

    @Query(value = "select * from korisnici k where k.uloge_uloga_id=4",
            nativeQuery = true)
    List<Korisnici> findAll();

}
