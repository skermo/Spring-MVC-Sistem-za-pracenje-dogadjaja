package com.si.springboot.service;


import com.si.springboot.dto.LokacijaDto;

import java.util.List;

public interface LokacijaService {
    List<LokacijaDto> pronadjiSveLokacije();
    void kreirajLokaciju(LokacijaDto lokacijaDto);
    LokacijaDto pronadjiLokacijuPoId(Long lokacijaId);
    void updateLokacija(LokacijaDto lokacijaDto);
}
