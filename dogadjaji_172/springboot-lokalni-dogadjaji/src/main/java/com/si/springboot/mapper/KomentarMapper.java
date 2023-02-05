package com.si.springboot.mapper;

import com.si.springboot.dto.KomentarDto;
import com.si.springboot.entity.Komentar;

public class KomentarMapper {

    //mapira Komentar u KomentarDto
    public static KomentarDto mapirajUKomentarDto(Komentar komentar){
        return KomentarDto.builder()
                .id(komentar.getId())
                .email(komentar.getEmail())
                .datum(komentar.getDatum())
                .tekst(komentar.getTekst())
                .build();
    }

    //mapira KomentarDto u Komentar
    public static Komentar mapirajUKomentar(KomentarDto komentarDto){
        return Komentar.builder()
                .id(komentarDto.getId())
                .email(komentarDto.getEmail())
                .datum(komentarDto.getDatum())
                .tekst(komentarDto.getTekst())
                .build();
    }
}
