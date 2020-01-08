package com.example.dnevnikjartest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.dnevnikjartest.entity.Admini;
import com.example.dnevnikjartest.entity.Cetvrtak;
import com.example.dnevnikjartest.entity.Direktor;
import com.example.dnevnikjartest.entity.Korisnici;
import com.example.dnevnikjartest.entity.Obavestenja;
import com.example.dnevnikjartest.entity.Odeljenja;
import com.example.dnevnikjartest.entity.Petak;
import com.example.dnevnikjartest.entity.Ponedeljak;
import com.example.dnevnikjartest.entity.Predmeti;
import com.example.dnevnikjartest.entity.Roditelji;
import com.example.dnevnikjartest.entity.Sreda;
import com.example.dnevnikjartest.entity.Subota;
import com.example.dnevnikjartest.entity.Ucenici;
import com.example.dnevnikjartest.entity.Ucitelji;
import com.example.dnevnikjartest.entity.Uloge;
import com.example.dnevnikjartest.entity.Utorak;
import com.example.dnevnikjartest.service.CetvrtakService;
import com.example.dnevnikjartest.service.KorisniciService;
import com.example.dnevnikjartest.service.ObavestenjaService;
import com.example.dnevnikjartest.service.OdeljenjeService;
import com.example.dnevnikjartest.service.PetakService;
import com.example.dnevnikjartest.service.PonedeljakService;
import com.example.dnevnikjartest.service.PredmetiService;
import com.example.dnevnikjartest.service.RoditeljiService;
import com.example.dnevnikjartest.service.SredaService;
import com.example.dnevnikjartest.service.SubotaService;
import com.example.dnevnikjartest.service.UceniciService;
import com.example.dnevnikjartest.service.UciteljiService;
import com.example.dnevnikjartest.service.UlogeService;
import com.example.dnevnikjartest.service.UtorakService;

@Controller
public class AdminController {
    
    
    @Autowired
    private UciteljiService uciteljiService;
    @Autowired
    private RoditeljiService roditeljiService;
    @Autowired
    private PredmetiService predmetiService;
    @Autowired
    private KorisniciService korisniciService;
    @Autowired
    private UceniciService uceniciService;
    @Autowired
    private ObavestenjaService obavestenjaService;
    @Autowired
    private OdeljenjeService odeljenjeService;
    @Autowired
    private UlogeService ulogeService;
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

    @RequestMapping("/admin/listaOdeljenjaZaOdabirRasporeda")
    public String viewSvaOdeljenjaZaRaspored(Model model) {
        List<Odeljenja> listaOdeljenja = odeljenjeService.listAll();

        model.addAttribute("odeljenje", listaOdeljenja);
        return "admin_rasporedi";
    }
    
    @RequestMapping("/admin/rasporedZaOdeljenje/{id}")
    public String getRasporedZaOdeljenje(@PathVariable(name = "id") int id, Model model) {
    	
    	
        List<Ponedeljak> getPonedeljak = ponedeljakService.izlistaj(id);
        List<Utorak> getUtorak = utorakService.izlistaj(id);
        List<Sreda> getSreda = sredaService.izlistaj(id);
        List<Cetvrtak> getCetvrtak = cetvrtakService.izlistaj(id);
        List<Petak> getPetak = petakService.izlistaj(id);
        List<Subota> getSubota = subotaService.izlistaj(id);

        model.addAttribute("ponedeljak", getPonedeljak);
        model.addAttribute("utorak", getUtorak);
        model.addAttribute("sreda", getSreda);
        model.addAttribute("cetvrtak", getCetvrtak);
        model.addAttribute("petak", getPetak);
        model.addAttribute("subota", getSubota);

        return "admin_raspored2";
    }

    @RequestMapping("/admin/noviRaspored")
    public String showViewForAdd(Model model) {
        Odeljenja od = new Odeljenja();

        Ponedeljak pon = new Ponedeljak();
        pon.setOdeljenje(od);

        Utorak utorak = new Utorak();
        utorak.setOdeljenje(od);

        Sreda sreda = new Sreda();
        sreda.setOdeljenje(od);

        Cetvrtak cetvrtak = new Cetvrtak();
        cetvrtak.setOdeljenje(od);

        Petak petak = new Petak();
        petak.setOdeljenje(od);

        Subota subota = new Subota();
        subota.setOdeljenje(od);

        // za select predmeta i odeljenja
        List<Predmeti> getPredmeti = predmetiService.findAll();
        List<Odeljenja> getOdeljenja = odeljenjeService.listAll();

        model.addAttribute("odeljenja", getOdeljenja);
        model.addAttribute("predmeti", getPredmeti);
        model.addAttribute("ponedeljak", pon);
        model.addAttribute("utorak", utorak);
        model.addAttribute("sreda", sreda);
        model.addAttribute("cetvrtak", cetvrtak);
        model.addAttribute("petak", petak);
        model.addAttribute("subota", subota);
        return "admin_noviraspored2";
    }

    @RequestMapping(value = "savePonedeljak", method = RequestMethod.POST)
    public String savePonedeljak(@ModelAttribute("ponedeljak") Ponedeljak raspored) {
        ponedeljakService.savePonedeljak(raspored);

        return "redirect:/admin/noviRaspored";
    }

    @RequestMapping("/admin/deletePonedeljak/{id}")
    public String deletePonedeljak(@PathVariable(name = "id") int id) {

        ponedeljakService.delete(id);

        return "redirect:/admin/listaOdeljenjaZaOdabirRasporeda";
    }

    @RequestMapping(value = "saveUtorak", method = RequestMethod.POST)
    public String saveUtorak(@ModelAttribute("utorak") Utorak raspored) {
        utorakService.saveUtorak(raspored);

        return "redirect:/admin/noviRaspored";
    }

    @RequestMapping("/admin/deleteUtorak/{id}")
    public String deleteUtorak(@PathVariable(name = "id") int id) {

        utorakService.delete(id);

        return "redirect:/admin/listaOdeljenjaZaOdabirRasporeda";
    }

    @RequestMapping(value = "saveSreda", method = RequestMethod.POST)
    public String saveSreda(@ModelAttribute("sreda") Sreda raspored) {
        sredaService.saveSreda(raspored);

        return "redirect:/admin/noviRaspored";
    }

    @RequestMapping("/admin/deleteSreda/{id}")
    public String deleteSreda(@PathVariable(name = "id") int id) {

        sredaService.delete(id);

        return "redirect:/admin/listaOdeljenjaZaOdabirRasporeda";
    }

    @RequestMapping(value = "saveCetvrtak", method = RequestMethod.POST)
    public String saveCetvrtak(@ModelAttribute("cetvrtak") Cetvrtak raspored) {
        cetvrtakService.saveCetvrtak(raspored);

        return "redirect:/admin/noviRaspored";
    }

    @RequestMapping("/admin/deleteCetvrtak/{id}")
    public String deleteCetvrtak(@PathVariable(name = "id") int id) {

        cetvrtakService.delete(id);

        return "redirect:/admin/listaOdeljenjaZaOdabirRasporeda";
    }

    @RequestMapping(value = "savePetak", method = RequestMethod.POST)
    public String savePetak(@ModelAttribute("petak") Petak raspored) {
        petakService.savePetak(raspored);

        return "redirect:/admin/noviRaspored";
    }

    @RequestMapping("/admin/deletePetak/{id}")
    public String deletePetak(@PathVariable(name = "id") int id) {

        petakService.delete(id);

        return "redirect:/admin/listaOdeljenjaZaOdabirRasporeda";
    }

    @RequestMapping(value = "saveSubota", method = RequestMethod.POST)
    public String saveSubota(@ModelAttribute("subota") Subota raspored) {
        subotaService.saveSubota(raspored);

        return "redirect:/admin/noviRaspored";
    }

    @RequestMapping("/admin/deleteSubota/{id}")
    public String deleteSubota(@PathVariable(name = "id") int id) {

        subotaService.delete(id);

        return "redirect:/admin/listaOdeljenjaZaOdabirRasporeda";
    }

    @RequestMapping("/admin/sviUcitelji")
    public String getSviUcitelji(Model model) {
        List<Korisnici> getUcitelji = uciteljiService.listUcitelji();
        model.addAttribute("ucitelji", getUcitelji);
        return "admin_listaucitelja";
    }

    @RequestMapping("/admin/sviRoditelji")
    public String getSviRoditelji(Model model) {
        List<Korisnici> getRoditelji = roditeljiService.listRoditelji();
        model.addAttribute("roditelji", getRoditelji);
        return "admin_listaroditelja";
    }

    @RequestMapping("/admin/sviPredmeti")
    public String getViewPredmeti(Model model) {
        List<Predmeti> getPredmeti = predmetiService.findAll();
        model.addAttribute("predmeti", getPredmeti);
        return "admin_listapredmeta";
    }

    @RequestMapping("/admin/noviPredmet")
    public String addPredmet(Model model) {
        Predmeti thePredmet = new Predmeti();

        model.addAttribute("predmet", thePredmet);
        return "admin_novipredmet";
    }

    @RequestMapping(value = "savePredmet", method = RequestMethod.POST)
    public String savePredmet(@ModelAttribute("predmet") Predmeti thePredmet) {

        predmetiService.savePredmeti(thePredmet);

        return "redirect:/admin/sviPredmeti";
    }

    @RequestMapping("/admin/editPredmet/{id_predmet}")
    public ModelAndView showEditPredmetForm(@PathVariable(name = "id_predmet") int id_predmet) {
        ModelAndView mav = new ModelAndView("admin_editpredmet");

        Predmeti thePredmet = predmetiService.get(id_predmet);
        mav.addObject("predmet", thePredmet);

        return mav;
    }

    @RequestMapping("/admin/deletePredmet/{id_predmet}")
    public String deletePredmet(@PathVariable(name = "id_predmet") int id_predmet) {

        predmetiService.delete(id_predmet);

        return "redirect:/admin/sviPredmeti";
    }

    @RequestMapping("/admin/sviKorisnici")
    public String viewSviKorisnici(Model model) {

        List<Korisnici> listaKorisnika = korisniciService.listAll();

        model.addAttribute("korisnici", listaKorisnika);
        return "admin_listakorisnika";
    }

    @RequestMapping("/admin/noviKorisnik")
    public String showAddForm(Model model) {
        Korisnici theKorisnik = new Korisnici();
        Uloge ul = new Uloge();
        theKorisnik.setUloge(ul);
        // ovo je samo zbog selekta u html-dropdown box
        List<Uloge> listaUloga = ulogeService.findAll();

        model.addAttribute("uloge", listaUloga);
        model.addAttribute("korisnik", theKorisnik);
        return "admin_novikorisnik";
    }

    @RequestMapping(value = "saveKorisnik", method = RequestMethod.POST)
    public String saveKorisnika(@ModelAttribute("korisnik") Korisnici theKorisnik) {

        switch (theKorisnik.getUloge().getId_uloga()) {
            case 1:
                Roditelji roditelj = new Roditelji();
                roditelj.setKorisnik(theKorisnik);
                theKorisnik.setRoditelj(roditelj);
                break;
            case 2:
                Ucitelji ucitelj = new Ucitelji();
                ucitelj.setKorisnik(theKorisnik);
                theKorisnik.setUcitelj(ucitelj);
                break;
            case 3:
                Admini admin = new Admini();
                admin.setKorisnik(theKorisnik);
                theKorisnik.setAdmin(admin);
                break;
            case 4:
                Direktor direktor = new Direktor();
                direktor.setKorisnik(theKorisnik);
                theKorisnik.setDirektor(direktor);
                break;
        }
        korisniciService.save(theKorisnik);
        return "redirect:/admin/sviKorisnici";
    }

    @RequestMapping("/admin/editKorisnik/{id_korisnik}")
    public ModelAndView showEditKorisnikForm(@PathVariable(name = "id_korisnik") int id_korisnik) {
        ModelAndView mav = new ModelAndView("admin_editkorisnik");

        // ovo je samo zbog selekta u html-dropdown box
        List<Uloge> listaUloga = ulogeService.findAll();

        Korisnici theKorisnik = korisniciService.get(id_korisnik);

        mav.addObject("korisnik", theKorisnik);
        mav.addObject("uloge", listaUloga);
        return mav;
    }

    @RequestMapping("/admin/deleteKorisnik/{id_korisnik}")
    public String deleteKorisnik(@PathVariable(name = "id_korisnik") int id_korisnik) {

        korisniciService.delete(id_korisnik);

        return "redirect:/admin/sviKorisnici";
    }

    @RequestMapping("/admin/sviUcenici")
    public String viewSviUcenici(Model model) {
        List<Ucenici> listaUcenika = uceniciService.listAll();
        model.addAttribute("ucenici", listaUcenika);
        return "admin_listaucenika";
    }

    @RequestMapping("/admin/noviUcenik")
    public String showAddFormUcenika(Model model) {
        Ucenici theUcenik = new Ucenici();
        Korisnici kor = new Korisnici();
        Odeljenja od = new Odeljenja();
        theUcenik.setKorisnik(kor);
        theUcenik.setOdeljenje(od);
        model.addAttribute("ucenik", theUcenik);
        return "admin_noviucenici";
    }

    @RequestMapping(value = "saveUcenik", method = RequestMethod.POST)
    public String saveUcenika(@ModelAttribute("ucenik") Ucenici theUcenik) {

        uceniciService.saveUcenici(theUcenik);

        return "redirect:/admin/sviKorisnici";
    }

    @RequestMapping("/admin/editUcenik/{id_ucenik}")
    public ModelAndView showEditUcenikForm(@PathVariable(name = "id_ucenik") int id_ucenik) {
        ModelAndView mav = new ModelAndView("admin_editucenik");

        Ucenici theUcenik = uceniciService.get(id_ucenik);

        mav.addObject("ucenik", theUcenik);

        return mav;
    }

    @RequestMapping("/admin/deleteUcenik/{id_ucenik}")
    public String deleteUcenik(@PathVariable(name = "id_ucenik") int id_ucenik) {

        uceniciService.delete(id_ucenik);

        return "redirect:/admin/sviKorisnici";
    }

    @RequestMapping("/admin/listaObavestenja")
    public String viewSvaObavestenja(Model model) {
        List<Obavestenja> listaObavestenja = obavestenjaService.listObavestenja();

        model.addAttribute("obavestenja", listaObavestenja);
        return "admin_listaobavestenja";
    }
    @RequestMapping(value = "saveObavestenja", method = RequestMethod.POST)
    public String saveObavestenja(@ModelAttribute("obavestenja") Obavestenja theObavestenja) {

        obavestenjaService.save(theObavestenja);

        return "redirect:/admin/sviKorisnici";
    }

    @RequestMapping("/admin/obavestenja")
    public String showAddFormObavestenja(Model model) {
        Obavestenja theObavestenja = new Obavestenja();

        model.addAttribute("obavestenja", theObavestenja);
        return "admin_obavestenja";
    }
    
    @RequestMapping("/admin/deleteObavestenje/{id_obavestenja}")
    public String deleteObavestenje(@PathVariable(name = "id_obavestenja") int id_obavestenja) {

        obavestenjaService.delete(id_obavestenja);

        return "redirect:/admin/sviKorisnici";
    }

    @RequestMapping("/admin/svaOdeljenja")
    public String viewSvaOdeljenja(Model model) {
        List<Odeljenja> listaOdeljenja = odeljenjeService.listAll();

        model.addAttribute("odeljenje", listaOdeljenja);
        return "admin_listaodeljenja";
    }

    @RequestMapping("/admin/novoOdeljenje")
    public String showAddFormOdeljenje(Model model) {
        Odeljenja theOdeljenje = new Odeljenja();
        Korisnici kor = new Korisnici();
        theOdeljenje.setKorisnik(kor);
        // ovo je samo zbog selekta u html-dropdown box
        List<Korisnici> listaUcitelja = uciteljiService.listUcitelji();
        model.addAttribute("odeljenje", theOdeljenje);
        model.addAttribute("ucitelj", listaUcitelja);
        return "admin_novoodeljenje";
    }

    @RequestMapping(value = "saveOdeljenje", method = RequestMethod.POST)
    public String saveOdeljenje(@ModelAttribute("odeljenje") Odeljenja theOdeljenje) {

        odeljenjeService.saveOdeljenje(theOdeljenje);

        return "redirect:/admin/sviKorisnici";
    }

    @RequestMapping("/admin/editOdeljenja/{id_odeljenje}")
    public ModelAndView showEditOdeljenjeForm(@PathVariable(name = "id_odeljenje") int id_odeljenje) {
        ModelAndView mav = new ModelAndView("admin_editodeljenje");

        Odeljenja theOdeljenje = odeljenjeService.get(id_odeljenje);

        mav.addObject("odeljenje", theOdeljenje);

        return mav;
    }

    @RequestMapping("/admin/deleteOdeljenja/{id_odeljenje}")
    public String deleteOdeljenje(@PathVariable(name = "id_odeljenje") int id_odeljenje) {

        odeljenjeService.delete(id_odeljenje);

        return "redirect:/admin/sviKorisnici";
    }
}
