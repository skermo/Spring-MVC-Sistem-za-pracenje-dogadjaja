package com.si.springboot.service;



import com.si.springboot.dto.KategorijaDto;
import com.si.springboot.dto.LokacijaDto;

import java.util.List;

public interface KategorijaService {
    List<KategorijaDto> pronadjiSveKategorije();
    void kreirajKategoriju(KategorijaDto kategorijaDto);
    KategorijaDto pronadjiKategorijuPoId(Long kategorijaId);
    void updateKategorija(KategorijaDto kategorijaDto);
}
