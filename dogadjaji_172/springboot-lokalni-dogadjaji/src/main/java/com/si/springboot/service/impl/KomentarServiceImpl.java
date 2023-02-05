package com.si.springboot.service.impl;

import com.si.springboot.dto.KomentarDto;
import com.si.springboot.entity.Dogadjaj;
import com.si.springboot.entity.Komentar;
import com.si.springboot.mapper.KomentarMapper;
import com.si.springboot.repository.DogadjajRepository;
import com.si.springboot.repository.KomentarRepository;
import com.si.springboot.service.KomentarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KomentarServiceImpl implements KomentarService {

    private KomentarRepository komentarRepository;
    private DogadjajRepository dogadjajRepository;

    public KomentarServiceImpl(KomentarRepository komentarRepository, DogadjajRepository dogadjajRepository) {
        this.komentarRepository = komentarRepository;
        this.dogadjajRepository = dogadjajRepository;
    }

    @Override
    public void kreirajKomemtar(String dogadjajUrl, KomentarDto komentarDto) {
        Dogadjaj dogadjaj = dogadjajRepository.findByUrl(dogadjajUrl).get();
        Komentar komentar = KomentarMapper.mapirajUKomentar(komentarDto);
        komentar.setDogadjaj(dogadjaj);
        komentarRepository.save(komentar);
    }

    @Override
    public List<KomentarDto> pronadjiSveKomentare() {
        List<Komentar> kometari = komentarRepository.findAll();
        return kometari.stream().map(komentar -> KomentarMapper.mapirajUKomentarDto(komentar)).collect(Collectors.toList());
    }

    @Override
    public void izbrisiKomentar(Long komentarId) {
        komentarRepository.deleteById(komentarId);
    }
}
