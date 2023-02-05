package com.si.springboot.controller;

import com.si.springboot.dto.DogadjajDto;
import com.si.springboot.dto.KategorijaDto;
import com.si.springboot.dto.KomentarDto;
import com.si.springboot.dto.LokacijaDto;
import com.si.springboot.entity.Dogadjaj;
import com.si.springboot.service.DogadjajService;
import com.si.springboot.service.KategorijaService;
import com.si.springboot.service.KomentarService;
import com.si.springboot.service.LokacijaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DogadjajController {
    private DogadjajService dogadjajService;
    private KomentarService komentarService;
    private LokacijaService lokacijaService;
    private KategorijaService kategorijaService;

    public DogadjajController(DogadjajService dogadjajService, KomentarService komentarService, LokacijaService lokacijaService, KategorijaService kategorijaService) {
        this.dogadjajService = dogadjajService;
        this.komentarService = komentarService;
        this.lokacijaService = lokacijaService;
        this.kategorijaService = kategorijaService;
    }

    //Get metoda za sve dogadjaje
    @GetMapping("/admin/dogadjaj")
    public String dogadjaji(Model model){
        List<DogadjajDto> dogadjaji = dogadjajService.pronadjiSveDogadjaje();
        model.addAttribute("dogadjaji", dogadjaji);
        return "/admin/dogadjaji";
    }

    //izaberi lokaciju pri dodavanju dogadjaja
    @GetMapping("/admin/dogadjaj/izaberi")
    public String dodajDogadjajIzaberiLokaciju(Model model){
        List<LokacijaDto> lokacije = lokacijaService.pronadjiSveLokacije();
        model.addAttribute("lokacije", lokacije);
        return "admin/izaberi-lokaciju";
    }

    //izaberi kategoriju pri dodavanju dogadjaja
    @GetMapping("/admin/dogadjaj/izaberi/{lokacijaId}")
    public String dodajDogadjajIzaberiKategoriju(@PathVariable("lokacijaId") Long lokacijaId, Model model){
        List<KategorijaDto> kategorije = kategorijaService.pronadjiSveKategorije();
        model.addAttribute("kategorije", kategorije);
        model.addAttribute("lokacijaId", lokacijaId);
        return "admin/izaberi-kategoriju";
    }

    //request za novi dogadjaj
    @GetMapping("/admin/dogadjaj/izaberi/{lokacijaId}/{kategorijaId}")
    public String dodajDogadjajForma(@PathVariable("lokacijaId") Long lokacijaId,
                                     @PathVariable("kategorijaId") Long kategorijaId,
                                     Model model){
        model.addAttribute("lokacijaId", lokacijaId);
        model.addAttribute("kategorijaId", kategorijaId);
        DogadjajDto dogadjajDto = new DogadjajDto();
        model.addAttribute("dogadjaj", dogadjajDto);
        return "admin/kreiraj-dogadjaj";
    }


    //submit novog dogadjaja
    @PostMapping("/admin/dogadjaji/{lokacijaId}/{kategorijaId}")
    public String kreirajDogadjaj(@PathVariable("lokacijaId") Long lokacijaId,
                                  @PathVariable("kategorijaId") Long kategorijaId,
                                  @Valid @ModelAttribute("dogadjaj") DogadjajDto dogadjajDto,
                                  BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("dogadjaj", dogadjajDto);
            model.addAttribute("lokacijaId", lokacijaId);
            model.addAttribute("kategorijaId", kategorijaId);
            return "/admin/kreiraj-dogadjaj";
        }
        LokacijaDto lokacija = lokacijaService.pronadjiLokacijuPoId(lokacijaId);
        KategorijaDto kategorija = kategorijaService.pronadjiKategorijuPoId(kategorijaId);
        dogadjajDto.setUrl(getUrl(dogadjajDto.getNaziv()));
        dogadjajService.kreirajDogadjaj(lokacijaId, kategorijaId, dogadjajDto);
        return "redirect:/admin/dogadjaj";
    }

    //edit dogadjaj request
    @GetMapping("/admin/dogadjaji/{dogadjajId}/uredi")
    public String urediDogadjajForma(@PathVariable("dogadjajId") Long dogadjajId, Model model){
        DogadjajDto dogadjajDto = dogadjajService.pronadjiDogadjajPoId(dogadjajId);
        model.addAttribute("dogadjaj", dogadjajDto);
        return "/admin/uredi-dogadjaj";
    }

    //edit dogadjaj
    @PostMapping("/admin/dogadjaji/{dogadjajId}")
    public String urediDogadjaj(@PathVariable("dogadjajId") Long dogadjajId,
                                @Valid @ModelAttribute("dogadjaj") DogadjajDto dogadjajDto,
                                BindingResult result,
                                Model model){
        if(result.hasErrors()){
            model.addAttribute("dogadjaj", dogadjajDto);
            return "/admin/uredi-dogadjaj";
        }
        Long lokacijaId = dogadjajService.LokacijaId(dogadjajId);
        Long kategorijaId = dogadjajService.KategorijaId(dogadjajId);
        dogadjajDto.setId(dogadjajId);
        dogadjajService.updateDogadjaj(lokacijaId, kategorijaId, dogadjajDto);
        return "redirect:/admin/dogadjaj";
    }

    //view dogadjaj request
    @GetMapping("/admin/dogadjaji/{dogadjajUrl}/detalji")
    public String detaljiDogadjaja(@PathVariable("dogadjajUrl") String dogadjajUrl, Model model){
        DogadjajDto dogadjajDto = dogadjajService.pronadjiDogadjajPoUrl(dogadjajUrl);
        model.addAttribute("dogadjaj", dogadjajDto);
        return "admin/detalji-dogadjaja";
    }

    //search dogadjaj request
    @GetMapping("/admin/dogadjaji/pretraga")
    public String pretraziDogadjaje(@RequestParam(value = "query") String query, Model model) {
        List<DogadjajDto> dogadjaji = dogadjajService.pretraziDogadjaje(query);
        model.addAttribute("dogadjaji", dogadjaji);
        return "admin/dogadjaji";
    }

    //request za prikaz svih komentara
    @GetMapping("/admin/dogadjaj/komentari")
    public String komentari(Model model){
        List<KomentarDto> komentari = komentarService.pronadjiSveKomentare();
        model.addAttribute("komentari", komentari);
        return "admin/komentari";
    }

    //request za brisanje komentara
    @GetMapping("/admin/dogadjaj/komentari/{komentarId}")
    public String izbrisiKomentar(@PathVariable("komentarId") Long komentarId){
        komentarService.izbrisiKomentar(komentarId);
        return "redirect:/admin/dogadjaj/komentari";
    }

    //Get metoda za sve lokacije
    @GetMapping("/admin/lokacije")
    public String lokacije(Model model){
        List<LokacijaDto> lokacije = lokacijaService.pronadjiSveLokacije();
        model.addAttribute("lokacije", lokacije);
        return "admin/lokacije";
    }

    //Get metoda za sve kategorije
    @GetMapping("/admin/kategorije")
    public String kategorije(Model model){
        List<KategorijaDto> kategorije = kategorijaService.pronadjiSveKategorije();
        model.addAttribute("kategorije", kategorije);
        return "admin/kategorije";
    }

    //handle-a request za novu lokaciju
    @GetMapping("/admin/lokacija")
    public String dodajLokacijuForma(Model model){
        LokacijaDto lokacijaDto = new LokacijaDto();
        model.addAttribute("lokacija", lokacijaDto);
        return "admin/kreiraj-lokaciju";
    }

    //handle-a request za novu kategoriju
    @GetMapping("/admin/kategorija")
    public String dodajKategorijuForma(Model model){
        KategorijaDto kategorijaDto = new KategorijaDto();
        model.addAttribute("kategorija", kategorijaDto);
        return "admin/kreiraj-kategoriju";
    }

    //submit nove lokacije
    @PostMapping("/admin/nova/lokacija")
    public String kreirajLokaciju(@Valid @ModelAttribute("lokacija") LokacijaDto lokacijaDto,
                                  BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("lokacija", lokacijaDto);
            return "/admin/kreiraj-lokaciju";
        }
        lokacijaService.kreirajLokaciju(lokacijaDto);
        return "redirect:/admin/dogadjaj";
    }

    //submit nove kategorije
    @PostMapping("/admin/nova/kategorija")
    public String kreirajKategoriju(@Valid @ModelAttribute("kategorija") KategorijaDto kategorijaDto,
                                  BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("kategorija", kategorijaDto);
            return "/admin/kreiraj-kategoriju";
        }
        kategorijaService.kreirajKategoriju(kategorijaDto);
        return "redirect:/admin/dogadjaj";
    }

    //edit lokaciju request
    @GetMapping("/admin/lokacije/{lokacijaId}/uredi")
    public String urediLokacijuForma(@PathVariable("lokacijaId") Long lokacijaId, Model model){
        LokacijaDto lokacijaDto = lokacijaService.pronadjiLokacijuPoId(lokacijaId);
        model.addAttribute("lokacija", lokacijaDto);
        return "/admin/uredi-lokaciju";
    }

    //edit kategoriju request
    @GetMapping("/admin/kategorije/{kategorijaId}/uredi")
    public String urediKategorijuForma(@PathVariable("kategorijaId") Long kategorijaId, Model model){
        KategorijaDto kategorijaDto = kategorijaService.pronadjiKategorijuPoId(kategorijaId);
        model.addAttribute("kategorija", kategorijaDto);
        return "/admin/uredi-kategoriju";
    }

    //edit lokaciju
    @PostMapping("/admin/lokacije/{lokacijaId}")
    public String urediLokaciju(@PathVariable("lokacijaId") Long lokacijaId,
                                @Valid @ModelAttribute("lokacija") LokacijaDto lokacijaDto,
                                BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("lokacija", lokacijaDto);
            return "/admin/uredi-lokaciju";
        }
        lokacijaDto.setId(lokacijaId);
        lokacijaService.updateLokacija(lokacijaDto);
        return "redirect:/admin/lokacije";
    }
    //edit kategoriju
    @PostMapping("/admin/kategorije/{kategorijaId}")
    public String urediKategoiju(@PathVariable("kategorijaId") Long kategorijaId,
                                @Valid @ModelAttribute("kategorija") KategorijaDto kategorijaDto,
                                BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("kategorija", kategorijaDto);
            return "/admin/uredi-kategoriju";
        }
        kategorijaDto.setId(kategorijaId);
        kategorijaService.updateKategorija(kategorijaDto);
        return "redirect:/admin/kategorije";
    }

    //kreira url na osnovu naziva dogadjaja
    private static String getUrl(String nazivDogadjaja){
        String url = nazivDogadjaja.trim().toLowerCase();
        url = url.replaceAll("\\s+", "-");
        url = url.replaceAll("[^A-Za-z0-9]", "-");
        return url;
    }


}
