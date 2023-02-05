package com.si.springboot.mapper;

import com.si.springboot.dto.DogadjajDto;
import com.si.springboot.entity.Dogadjaj;

import java.util.stream.Collectors;

public class DogadjajMapper {

    //mapira Dogadjaj u DogadjajDto
    public static DogadjajDto mapirajUDogadjajDto(Dogadjaj dogadjaj){
        return DogadjajDto.builder()
                .id(dogadjaj.getId())
                .naziv(dogadjaj.getNaziv())
                .datum(dogadjaj.getDatum())
                .opis(dogadjaj.getOpis())
                .slika(dogadjaj.getSlika())
                .url(dogadjaj.getUrl())
                .komentari(dogadjaj.getKometari().stream().map(KomentarMapper::mapirajUKomentarDto).collect(Collectors.toSet()))
              //  .lokacija(LokacijaMapper.mapirajULokacijaDto(dogadjaj.getLokacija()))
                .build();
    }

    //mapira DogadjajDto u Dogadjaj
    public static Dogadjaj mapirajUDogadjaj(DogadjajDto dogadjajDto){
        return Dogadjaj.builder()
                .id(dogadjajDto.getId())
                .naziv(dogadjajDto.getNaziv())
                .datum(dogadjajDto.getDatum())
                .opis(dogadjajDto.getOpis())
                .slika(dogadjajDto.getSlika())
                .url(dogadjajDto.getUrl())
                .build();
    }
}
