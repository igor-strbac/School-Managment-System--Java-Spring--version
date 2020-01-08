package com.example.dnevnikjartest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DirektorController {

    @RequestMapping("/direktor/statistika")
    public String barGraph(Model model) {
        Map<String, Double> surveyMap = new LinkedHashMap<>();
        surveyMap.put("Matematika", 4.0);
        surveyMap.put("Srpski", 2.7);
        surveyMap.put("Engleski", 2.0);
        surveyMap.put("Muzicko", 1.9);
        surveyMap.put("Gradjansko", 5.);
        surveyMap.put("Veronauka", 3.2);
        surveyMap.put("Likovno", 2.);
        surveyMap.put("Fizicko", 1.3);
        model.addAttribute("surveyMap", surveyMap);
        return "direktor_statistika";
    }

    @RequestMapping("/direktor/statistika2")
    public String pieChart(Model model) {
        model.addAttribute("I1", 45);
        model.addAttribute("II3", 25);
        model.addAttribute("V2", 15);
        model.addAttribute("III4", 15);
        return "direktor_statistika2";
    }
}
