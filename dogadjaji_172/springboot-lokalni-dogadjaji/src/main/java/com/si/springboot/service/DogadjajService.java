package com.si.springboot.service;

import com.si.springboot.dto.DogadjajDto;

import java.util.List;

public interface DogadjajService {
    List<DogadjajDto> pronadjiSveDogadjaje();
    void kreirajDogadjaj(Long lokacijaId, Long kategorijaId,DogadjajDto dogadjajDto);
    DogadjajDto pronadjiDogadjajPoId(Long dogadjajId);
    void updateDogadjaj(Long lokacijaId, Long kategorijaId,DogadjajDto dogadjajDto);
    DogadjajDto pronadjiDogadjajPoUrl(String dogadjajUrl);
    List<DogadjajDto> pretraziDogadjaje(String query);
    Long LokacijaId(Long dogadjajId);
    Long KategorijaId(Long dogadjajId);
}
