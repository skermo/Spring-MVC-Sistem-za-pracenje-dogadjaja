package com.si.springboot.service;

import com.si.springboot.dto.KomentarDto;

import java.util.List;

public interface KomentarService {
    void kreirajKomemtar(String dogadjajUrl, KomentarDto komentarDto);
    List<KomentarDto> pronadjiSveKomentare();
    void izbrisiKomentar(Long komentarId);
}
