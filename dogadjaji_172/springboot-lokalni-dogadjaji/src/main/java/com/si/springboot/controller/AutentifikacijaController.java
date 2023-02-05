package com.si.springboot.controller;

import com.si.springboot.dto.KorisnikDto;
import com.si.springboot.entity.Korisnik;
import com.si.springboot.service.KorisnikService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AutentifikacijaController {

    KorisnikService korisnikService;

    public AutentifikacijaController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }

    //request za registraciju
    @GetMapping("/registracija")
    public String registracijaForma(Model model){
        KorisnikDto korisnikDto = new KorisnikDto();
        model.addAttribute("korisnik", korisnikDto);
        return "registracija";
    }

    //submit forme
    @PostMapping("/registracija/save")
    public String registracija(@Valid @ModelAttribute("korisnik") KorisnikDto korisnikDto,
                               BindingResult result,
                               Model model){
        Korisnik postojeciKorisnik = new Korisnik();
        postojeciKorisnik = korisnikService.pretraziPoEmail(korisnikDto.getEmail());
        if(postojeciKorisnik != null && postojeciKorisnik.getEmail() !=null && !postojeciKorisnik.getEmail().isEmpty()){
           result.rejectValue("email", "null", "Već postoji korisnik sa unešenim emailom.");
        }
        if(result.hasErrors()){
            model.addAttribute("korisnik", korisnikDto);
            return "registracija";
        }
        korisnikService.sacuvajKorisnika(korisnikDto);
        return "redirect:/registracija?success";
    }

    //login request
    @GetMapping("/login")
    public String loginStranica(){
        return "login";
    }
}