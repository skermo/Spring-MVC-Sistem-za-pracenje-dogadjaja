package com.si.springboot.service.impl;

import com.si.springboot.dto.KategorijaDto;
import com.si.springboot.dto.LokacijaDto;
import com.si.springboot.entity.Dogadjaj;
import com.si.springboot.entity.Kategorija;
import com.si.springboot.mapper.KategorijaMapper;
import com.si.springboot.mapper.KomentarMapper;
import com.si.springboot.repository.KategorijaRepository;
import com.si.springboot.service.KategorijaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KategorijaServiceImpl implements KategorijaService {

    KategorijaRepository kategorijaRepository;

    public KategorijaServiceImpl(KategorijaRepository kategorijaRepository) {
        this.kategorijaRepository = kategorijaRepository;
    }


    @Override
    public List<KategorijaDto> pronadjiSveKategorije() {
        List<Kategorija> kategorije = kategorijaRepository.findAll();
        return kategorije.stream().map(kategorija -> KategorijaMapper.mapirajUKategorijaDto(kategorija)).collect(Collectors.toList());
    }

    @Override
    public void kreirajKategoriju(KategorijaDto kategorijaDto) {
        Kategorija kategorija = KategorijaMapper.mapirajUKategorija(kategorijaDto);
        kategorijaRepository.save(kategorija);
    }

    @Override
    public KategorijaDto pronadjiKategorijuPoId(Long kategorijaId) {
        Kategorija kategorija = kategorijaRepository.findById(kategorijaId).get();
        return KategorijaMapper.mapirajUKategorijaDto(kategorija);
    }

    @Override
    public void updateKategorija(KategorijaDto kategorijaDto) {
        Kategorija kategorija = KategorijaMapper.mapirajUKategorija(kategorijaDto);
        kategorijaRepository.save(kategorija);
    }


}
