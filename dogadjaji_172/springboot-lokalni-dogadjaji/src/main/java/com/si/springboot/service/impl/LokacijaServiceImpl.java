package com.si.springboot.service.impl;

import com.si.springboot.dto.LokacijaDto;
import com.si.springboot.entity.Lokacija;
import com.si.springboot.mapper.LokacijaMapper;
import com.si.springboot.repository.LokacijaRepository;
import com.si.springboot.service.LokacijaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LokacijaServiceImpl implements LokacijaService {

    private LokacijaRepository lokacijaRepository;

    public LokacijaServiceImpl(LokacijaRepository lokacijaRepository) {
        this.lokacijaRepository = lokacijaRepository;
    }

    @Override
    public List<LokacijaDto> pronadjiSveLokacije() {
        List<Lokacija> lokacije = lokacijaRepository.findAll();
        return lokacije.stream().map(lokacija -> LokacijaMapper.mapirajULokacijaDto(lokacija)).collect(Collectors.toList());
    }

    @Override
    public void kreirajLokaciju(LokacijaDto lokacijaDto) {
        Lokacija lokacija = LokacijaMapper.mapirajULokacija(lokacijaDto);
        lokacijaRepository.save(lokacija);
    }

    @Override
    public LokacijaDto pronadjiLokacijuPoId(Long lokacijaId) {
        Lokacija lokacija = lokacijaRepository.findById(lokacijaId).get();
        return LokacijaMapper.mapirajULokacijaDto(lokacija);
    }

    @Override
    public void updateLokacija(LokacijaDto lokacijaDto) {
        Lokacija lokacija = LokacijaMapper.mapirajULokacija(lokacijaDto);
        lokacijaRepository.save(lokacija);
    }

}