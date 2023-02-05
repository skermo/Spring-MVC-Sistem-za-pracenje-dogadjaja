package com.si.springboot.mapper;

import com.si.springboot.dto.LokacijaDto;
import com.si.springboot.entity.Lokacija;

import java.util.stream.Collectors;

public class LokacijaMapper {

    public static LokacijaDto mapirajULokacijaDto(Lokacija lokacija){
        return LokacijaDto.builder()
                .id(lokacija.getId())
                .naziv(lokacija.getNaziv())
                .opis(lokacija.getOpis())
                .slika(lokacija.getSlika())
                .dogadjajList(lokacija.getDogadjajList().stream().map(dogadjaj -> DogadjajMapper.mapirajUDogadjajDto(dogadjaj)).collect(Collectors.toList()))
                .build();
    }

    public static Lokacija mapirajULokacija(LokacijaDto lokacijaDto){
        return Lokacija.builder()
                .id(lokacijaDto.getId())
                .naziv(lokacijaDto.getNaziv())
                .opis(lokacijaDto.getOpis())
                .slika(lokacijaDto.getSlika())
                .build();
    }
}
