/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dnevnikjartest.repo;

import com.example.dnevnikjartest.entity.OtvorenaVrata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("otvorenaVrataRepository")
public interface OtvorenaVrataRepository extends JpaRepository<OtvorenaVrata, Integer>{
    
    
    
}
