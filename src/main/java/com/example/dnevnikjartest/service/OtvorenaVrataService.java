package com.example.dnevnikjartest.service;

import com.example.dnevnikjartest.entity.OtvorenaVrata;
import com.example.dnevnikjartest.repo.OtvorenaVrataRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("otvorenaVrataService")
@Transactional
public class OtvorenaVrataService {
    
    private OtvorenaVrataRepository otvorenaVrataRepository;
    
    @Autowired
    public OtvorenaVrataService(OtvorenaVrataRepository otvorenaVrataRepository) {
            this.otvorenaVrataRepository = otvorenaVrataRepository;
    }
    
    public List<OtvorenaVrata> listAll() {
            return otvorenaVrataRepository.findAll();
    }
    
    public void saveOtvorenaVrata(OtvorenaVrata otvorenaVrata) {
		otvorenaVrataRepository.save(otvorenaVrata);
	}

	public OtvorenaVrata get(int id_otvorena_vrata) {
		return otvorenaVrataRepository.findById(id_otvorena_vrata).get();
	}

	public void delete(int id_otvorena_vrata) {
		otvorenaVrataRepository.deleteById(id_otvorena_vrata);
	}
    
}
