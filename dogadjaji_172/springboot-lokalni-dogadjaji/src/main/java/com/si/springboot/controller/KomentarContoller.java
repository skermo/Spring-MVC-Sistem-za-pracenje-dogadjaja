package com.si.springboot.controller;

import com.si.springboot.dto.DogadjajDto;
import com.si.springboot.dto.KomentarDto;
import com.si.springboot.service.DogadjajService;
import com.si.springboot.service.KomentarService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KomentarContoller {
    private KomentarService komentarService;
    private DogadjajService dogadjajService;

    public KomentarContoller(KomentarService komentarService, DogadjajService dogadjajService) {
        this.komentarService = komentarService;
        this.dogadjajService = dogadjajService;
    }

    //submit forme za dodavanje komentara
    @PostMapping("/{dogadjajUrl}/komentari")
    public String kreirajKomentar(@PathVariable("dogadjajUrl") String dogadjajUrl,
                                  @Valid @ModelAttribute("komentar") KomentarDto komentarDto,
                                  BindingResult result,
                                  Model model){
        DogadjajDto dogadjajDto = dogadjajService.pronadjiDogadjajPoUrl(dogadjajUrl);
        if(result.hasErrors()){
            model.addAttribute("dogadjaj", dogadjajDto);
            model.addAttribute("komentar", komentarDto);
            return "korisnik/detalji-dogadjaja";
        }
        komentarService.kreirajKomemtar(dogadjajUrl, komentarDto);
        return "redirect:/dogadjaji/" + dogadjajUrl;
    }
}