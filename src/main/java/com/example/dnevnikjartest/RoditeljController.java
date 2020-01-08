/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dnevnikjartest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dnevnikjartest.entity.Korisnici;
import com.example.dnevnikjartest.entity.Obavestenja;
import com.example.dnevnikjartest.entity.Ocene;
import com.example.dnevnikjartest.entity.OtvorenaVrata;
import com.example.dnevnikjartest.entity.Poruke;
import com.example.dnevnikjartest.service.KorisniciService;
import com.example.dnevnikjartest.service.ObavestenjaService;
import com.example.dnevnikjartest.service.OceneService;
import com.example.dnevnikjartest.service.OtvorenaVrataService;
import com.example.dnevnikjartest.service.PorukeService;
import com.example.dnevnikjartest.service.RoditeljiService;
import com.example.dnevnikjartest.service.UciteljiService;

/**
 *
 * @author Grupa2
 */
@Controller
public class RoditeljController {

	@Autowired
	private KorisniciService korisniciService;
	@Autowired
	private OceneService oceneService;
        @Autowired
        private ObavestenjaService obavestenjaService;
        @Autowired
        private PorukeService porukeService;
        @Autowired
        private UciteljiService uciteljiService;
        @Autowired
        private RoditeljiService roditeljiService;
        @Autowired
        private OtvorenaVrataService otvorenaVrataService;

    @RequestMapping("/roditelj/listaObavestenja")
    public String viewSvaObavestenja(Model model) {
        List<Obavestenja> listaObavestenja = obavestenjaService.listObavestenja();
        model.addAttribute("obavestenja", listaObavestenja);
        return "roditelj_listaobavestenja";
    }

    @RequestMapping("/roditelj/djackaKnjizica")
    public String viewOcene(Model model) {
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Korisnici kor = korisniciService.findByUsername(userDetails.getUsername());
        int id = kor.getId_korisnik();
        
        List<Ocene> listaOcena = oceneService.nadjiPoId(id);
        model.addAttribute("ocene", listaOcena);
           
        
        return "roditelj_djackaknjizica";
    }
    
    @RequestMapping("/roditelj/listaPoruka")
	public String getViewRoditeljPoruke(Model model) {
		List<Poruke> getPoruke = porukeService.findAll();
		model.addAttribute("poruke", getPoruke);
		return "roditelj_listaporuka";
	}

	@RequestMapping("/roditelj/novaPoruka")
	public String addRoditeljPoruka(Model model) {
		Poruke thePoruka = new Poruke();
                Korisnici kor = new Korisnici();
                thePoruka.setUcitelj(kor);
                thePoruka.setRoditelj(kor);
                List<Korisnici> listaUcitelja = uciteljiService.listUcitelji();
                List<Korisnici> listaRoditelja = roditeljiService.listRoditelji();
		model.addAttribute("poruka", thePoruka);
                model.addAttribute("ucitelj", listaUcitelja);
                model.addAttribute("roditelj", listaRoditelja);
		return "roditelj_novaporuka";
	}

	@RequestMapping(value = "sendRoditeljPoruka", method = RequestMethod.POST)
	public String saveRoditeljPoruka(@ModelAttribute("poruka") Poruke thePoruka) {

		porukeService.sendPoruke(thePoruka);

		return "redirect:/roditelj/listaPoruka";
	}
    
        @RequestMapping("/roditelj/listaZakazivanja")
	public String getRoditeljZakazivanje(Model model) {
		List<OtvorenaVrata> getOtvorenaVrata = otvorenaVrataService.listAll();
		model.addAttribute("otvorenaVrata", getOtvorenaVrata);
		return "roditelj_listazakazivanja";
	}
        
        @RequestMapping("/roditelj/otvorenaVrata")
	public String addRoditeljOtvorenaVrata(Model model) {
		OtvorenaVrata theOtvorenaVrata = new OtvorenaVrata();
                Korisnici kor = new Korisnici();
                theOtvorenaVrata.setUcitelj(kor);
                theOtvorenaVrata.setRoditelj(kor);
                List<Korisnici> listaUcitelja = uciteljiService.listUcitelji();
                List<Korisnici> listaRoditelja = roditeljiService.listRoditelji();
		model.addAttribute("otvorenaVrata", theOtvorenaVrata);
                model.addAttribute("ucitelj", listaUcitelja);
                model.addAttribute("roditelj", listaRoditelja);
		return "roditelj_otvorenavrata";
	}
        
        @RequestMapping(value = "sendRoditeljZakazivanje", method = RequestMethod.POST)
	public String saveRoditeljZakazivanje(@ModelAttribute("otvorenaVrata") OtvorenaVrata theOtvorenaVrata) {

                otvorenaVrataService.saveOtvorenaVrata(theOtvorenaVrata);

		return "redirect:/roditelj/listaZakazivanja";
        }
        
}
