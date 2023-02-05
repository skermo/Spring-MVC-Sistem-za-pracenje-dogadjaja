package com.si.springboot.controller;

import com.si.springboot.dto.DogadjajDto;
import com.si.springboot.dto.KomentarDto;
import com.si.springboot.service.DogadjajService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KorisnikModulController {

    private DogadjajService dogadjajService;

    public KorisnikModulController(DogadjajService dogadjajService) {
        this.dogadjajService = dogadjajService;
    }

    //prikazuje sve dogadjaje
    @GetMapping("/")
    public String ispisDogadjaja(Model model){
        List<DogadjajDto> dogadjaji = dogadjajService.pronadjiSveDogadjaje();
        model.addAttribute("dogadjaji", dogadjaji);
        return "korisnik/dogadjaji";
    }

    //view dogadjaj request
    @GetMapping("/dogadjaji/{dogadjajUrl}")
    public String prikaziDogadjaj(@PathVariable("dogadjajUrl") String dogadjajUrl, Model model){
        DogadjajDto dogadjajDto = dogadjajService.pronadjiDogadjajPoUrl(dogadjajUrl);
        KomentarDto komentarDto = new KomentarDto();
        model.addAttribute("dogadjaj", dogadjajDto);
        model.addAttribute("komentar", komentarDto);
        return "korisnik/detalji-dogadjaja";
    }

    //pretraga dogadjaja
    @GetMapping("/dogadjaji/pretraga")
    public String pretraziDogadjaje(@RequestParam(value = "query") String query, Model model){
        List<DogadjajDto> dogadjaji = dogadjajService.pretraziDogadjaje(query);
        model.addAttribute("dogadjaji", dogadjaji);
        return "korisnik/dogadjaji";
    }
}
