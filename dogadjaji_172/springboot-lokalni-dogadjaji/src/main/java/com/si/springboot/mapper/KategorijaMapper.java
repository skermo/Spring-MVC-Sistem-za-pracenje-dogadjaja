package com.si.springboot.mapper;

import com.si.springboot.dto.KategorijaDto;
import com.si.springboot.entity.Kategorija;

import java.util.stream.Collectors;

public class KategorijaMapper {

    public static KategorijaDto mapirajUKategorijaDto(Kategorija kategorija){
        return KategorijaDto.builder()
                .id(kategorija.getId())
                .naziv(kategorija.getNaziv())
                .ikonica(kategorija.getIkonica())
                .dogadjajList(kategorija.getDogadjajList().stream().map(dogadjaj -> DogadjajMapper.mapirajUDogadjajDto(dogadjaj)).collect(Collectors.toList()))
                .build();
    }

    public static Kategorija mapirajUKategorija(KategorijaDto kategorijaDto){
        return Kategorija.builder()
                .id(kategorijaDto.getId())
                .naziv(kategorijaDto.getNaziv())
                .ikonica(kategorijaDto.getIkonica())
                .build();
    }
}
