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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dnevnikjartest.entity.Cetvrtak;
import com.example.dnevnikjartest.entity.Korisnici;
import com.example.dnevnikjartest.entity.Ocene;
import com.example.dnevnikjartest.entity.OtvorenaVrata;
import com.example.dnevnikjartest.entity.Petak;
import com.example.dnevnikjartest.entity.Ponedeljak;
import com.example.dnevnikjartest.entity.Poruke;
import com.example.dnevnikjartest.entity.Predmeti;
import com.example.dnevnikjartest.entity.Sreda;
import com.example.dnevnikjartest.entity.Subota;
import com.example.dnevnikjartest.entity.Ucenici;
import com.example.dnevnikjartest.entity.Utorak;
import com.example.dnevnikjartest.service.CetvrtakService;
import com.example.dnevnikjartest.service.KorisniciService;
import com.example.dnevnikjartest.service.OceneService;
import com.example.dnevnikjartest.service.OtvorenaVrataService;
import com.example.dnevnikjartest.service.PetakService;
import com.example.dnevnikjartest.service.PonedeljakService;
import com.example.dnevnikjartest.service.PorukeService;
import com.example.dnevnikjartest.service.PredmetiService;
import com.example.dnevnikjartest.service.RoditeljiService;
import com.example.dnevnikjartest.service.SredaService;
import com.example.dnevnikjartest.service.SubotaService;
import com.example.dnevnikjartest.service.UceniciService;
import com.example.dnevnikjartest.service.UciteljiService;
import com.example.dnevnikjartest.service.UtorakService;

/**
 *
 * @author Grupa2
 */
@Controller
public class UciteljController {

	@Autowired
	private KorisniciService korisniciService;
	@Autowired
	private OceneService oceneService;
	@Autowired
	private PredmetiService predmetiService;
	@Autowired
	private UceniciService uceniciService;
	@Autowired
	private PonedeljakService ponedeljakService;
	@Autowired
	private UtorakService utorakService;
	@Autowired
	private SredaService sredaService;
	@Autowired
	private CetvrtakService cetvrtakService;
	@Autowired
	private PetakService petakService;
	@Autowired
	private SubotaService subotaService;
        @Autowired
        private PorukeService porukeService;
        @Autowired
        private UciteljiService uciteljiService;
        @Autowired
        private RoditeljiService roditeljiService;
        @Autowired
        private OtvorenaVrataService otvorenaVrataService;

	@RequestMapping("/ucitelj/rasporedZaOdeljenje")
	public String getRasporedZaOdeljenje(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		Korisnici kor = korisniciService.findByUsername(userDetails.getUsername());
		int id = kor.getId_korisnik();

		List<Ponedeljak> getPonedeljak = ponedeljakService.nadjiPoId(id);
		List<Utorak> getUtorak = utorakService.nadjiPoId(id);
		List<Sreda> getSreda = sredaService.nadjiPoId(id);
		List<Cetvrtak> getCetvrtak = cetvrtakService.nadjiPoId(id);
		List<Petak> getPetak = petakService.nadjiPoId(id);
		List<Subota> getSubota = subotaService.nadjiPoId(id);

		model.addAttribute("ponedeljak", getPonedeljak);
		model.addAttribute("utorak", getUtorak);
		model.addAttribute("sreda", getSreda);
		model.addAttribute("cetvrtak", getCetvrtak);
		model.addAttribute("petak", getPetak);
		model.addAttribute("subota", getSubota);

		return "ucitelj_raspored2";
	}

	@RequestMapping("/ucitelj/listaUcenikaZaOdabirOcena")
	public String viewSvaOdeljenjaZaRaspored(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		Korisnici kor = korisniciService.findByUsername(userDetails.getUsername());
		int id = kor.getId_korisnik();

		List<Ucenici> listaUcenika = uceniciService.uceniciPoOdeljenjima(id);

		model.addAttribute("ucenici", listaUcenika);
		return "ucitelj_dnevnikUcenika";
	}

	@RequestMapping("/ucitelj/oceneZaUcenika/{id}")
	public String viewOcene(@PathVariable(name = "id") int id, Model model) {

		List<Ocene> listaOcena = oceneService.izlistaj(id);
		model.addAttribute("ocene", listaOcena);

		return "ucitelj_dnevnikOcena";
	}

	@RequestMapping("/ucitelj/ocene")
	public String ocene(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		Korisnici kor = korisniciService.findByUsername(userDetails.getUsername());
		int id = kor.getId_korisnik();

		List<Predmeti> getPredmeti = predmetiService.findAll();
		List<Ucenici> getUcenici = uceniciService.nadjiPoId(id);
		Ocene theOcene = new Ocene();
		model.addAttribute("predmeti", getPredmeti);
		model.addAttribute("ucenici", getUcenici);
		model.addAttribute("ocene", theOcene);
		return "ucitelj_ocene";

	}

	@RequestMapping(value = "saveOcene", method = RequestMethod.POST)
	public String saveOcene(@ModelAttribute("ocene") Ocene theOcene) {

		oceneService.saveOcene(theOcene);

		return "redirect:/ucitelj/ocene";
	}
        
        @RequestMapping("/ucitelj/listaPoruka")
	public String getViewUciteljPoruke(Model model) {
		List<Poruke> getPoruke = porukeService.findAll();
		model.addAttribute("poruke", getPoruke);
		return "ucitelj_listaporuka";
	}

	@RequestMapping("/ucitelj/novaPoruka")
	public String addUciteljPoruka(Model model) {
		Poruke thePoruka = new Poruke();
                Korisnici kor = new Korisnici();
                thePoruka.setUcitelj(kor);
                thePoruka.setRoditelj(kor);
                List<Korisnici> listaUcitelja = uciteljiService.listUcitelji();
                List<Korisnici> listaRoditelja = roditeljiService.listRoditelji();
		model.addAttribute("poruka", thePoruka);
                model.addAttribute("ucitelj", listaUcitelja);
                model.addAttribute("roditelj", listaRoditelja);
		return "ucitelj_novaporuka";
	}

	@RequestMapping(value = "sendUciteljPoruka", method = RequestMethod.POST)
	public String saveUciteljPoruka(@ModelAttribute("poruka") Poruke thePoruka) {

		porukeService.sendPoruke(thePoruka);

		return "redirect:/ucitelj/listaPoruka";
	}
        
        @RequestMapping("/ucitelj/listaZakazivanja")
	public String getUciteljZakazivanje(Model model) {
		List<OtvorenaVrata> getOtvorenaVrata = otvorenaVrataService.listAll();
		model.addAttribute("otvorenaVrata", getOtvorenaVrata);
		return "ucitelj_listazakazivanja";
	}
        
        @RequestMapping("/ucitelj/otvorenaVrata")
	public String addUciteljOtvorenaVrata(Model model) {
		OtvorenaVrata theOtvorenaVrata = new OtvorenaVrata();
                Korisnici kor = new Korisnici();
                theOtvorenaVrata.setUcitelj(kor);
                theOtvorenaVrata.setRoditelj(kor);
                List<Korisnici> listaUcitelja = uciteljiService.listUcitelji();
                List<Korisnici> listaRoditelja = roditeljiService.listRoditelji();
		model.addAttribute("otvorenaVrata", theOtvorenaVrata);
                model.addAttribute("ucitelj", listaUcitelja);
                model.addAttribute("roditelj", listaRoditelja);
		return "ucitelj_otvorenavrata";
	}
        
        @RequestMapping(value = "sendUciteljZakazivanje", method = RequestMethod.POST)
	public String saveUciteljZakazivanje(@ModelAttribute("otvorenaVrata") OtvorenaVrata theOtvorenaVrata) {

                otvorenaVrataService.saveOtvorenaVrata(theOtvorenaVrata);

                return "redirect:/ucitelj/listaZakazivanja";
        }
}
