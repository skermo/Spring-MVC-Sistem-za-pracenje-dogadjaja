package com.si.springboot.service.impl;

import com.si.springboot.dto.DogadjajDto;
import com.si.springboot.entity.Dogadjaj;
import com.si.springboot.entity.Kategorija;
import com.si.springboot.entity.Lokacija;
import com.si.springboot.mapper.DogadjajMapper;
import com.si.springboot.repository.DogadjajRepository;
import com.si.springboot.repository.KategorijaRepository;
import com.si.springboot.repository.LokacijaRepository;
import com.si.springboot.service.DogadjajService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DogadjajServiceImpl implements DogadjajService {

    private DogadjajRepository dogadjajRepository;
    private LokacijaRepository lokacijaRepository;
    private KategorijaRepository kategorijaRepository;

    public DogadjajServiceImpl(DogadjajRepository dogadjajRepository, LokacijaRepository lokacijaRepository, KategorijaRepository kategorijaRepository) {
        this.dogadjajRepository = dogadjajRepository;
        this.lokacijaRepository = lokacijaRepository;
        this.kategorijaRepository = kategorijaRepository;
    }

    @Override
    public List<DogadjajDto> pronadjiSveDogadjaje() {
        List<Dogadjaj> dogadjaji = dogadjajRepository.findAll();
        return dogadjaji.stream().map((DogadjajMapper::mapirajUDogadjajDto)).collect(Collectors.toList());
    }

    @Override
    public void kreirajDogadjaj(Long lokacijaId, Long kategorijaId, DogadjajDto dogadjajDto) {
        Lokacija lokacija = lokacijaRepository.findById(lokacijaId).get();
        Kategorija kategorija = kategorijaRepository.findById(kategorijaId).get();
        Dogadjaj dogadjaj = DogadjajMapper.mapirajUDogadjaj(dogadjajDto);
        dogadjaj.setLokacija(lokacija);
        dogadjaj.setKategorija(kategorija);
        dogadjajRepository.save(dogadjaj);
    }

    @Override
    public DogadjajDto pronadjiDogadjajPoId(Long dogadjajId) {
        Dogadjaj dogadjaj = dogadjajRepository.findById(dogadjajId).get();
        return DogadjajMapper.mapirajUDogadjajDto(dogadjaj);
    }

    @Override
    public void updateDogadjaj(Long lokacijaId, Long kategorijaId, DogadjajDto dogadjajDto) {
        Lokacija lokacija = lokacijaRepository.findById(lokacijaId).get();
        Kategorija kategorija = kategorijaRepository.findById(kategorijaId).get();
        Dogadjaj dogadjaj = DogadjajMapper.mapirajUDogadjaj(dogadjajDto);
        dogadjaj.setLokacija(lokacija);
        dogadjaj.setKategorija(kategorija);
        dogadjajRepository.save(dogadjaj);
    }

    @Override
    public DogadjajDto pronadjiDogadjajPoUrl(String dogadjajUrl) {
        Dogadjaj dogadjaj = dogadjajRepository.findByUrl(dogadjajUrl).get();
        return DogadjajMapper.mapirajUDogadjajDto(dogadjaj);
    }

    @Override
    public List<DogadjajDto> pretraziDogadjaje(String query) {
        List<Dogadjaj> dogadjaji = dogadjajRepository.pretraziDogadjaje(query);
        return dogadjaji.stream().map(DogadjajMapper::mapirajUDogadjajDto).collect(Collectors.toList());
    }

    @Override
    public Long LokacijaId(Long dogadjajId) {
        Dogadjaj dogadjaj = dogadjajRepository.findById(dogadjajId).get();
        return dogadjaj.getLokacija().getId();
    }

    @Override
    public Long KategorijaId(Long dogadjajId) {
        Dogadjaj dogadjaj = dogadjajRepository.findById(dogadjajId).get();
        return dogadjaj.getKategorija().getId();
    }
}
