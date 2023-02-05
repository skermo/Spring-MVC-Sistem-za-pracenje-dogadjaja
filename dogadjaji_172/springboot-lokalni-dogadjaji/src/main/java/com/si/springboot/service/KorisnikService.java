package com.si.springboot.service;

import com.si.springboot.dto.KorisnikDto;
import com.si.springboot.entity.Korisnik;

public interface KorisnikService {
    void sacuvajKorisnika(KorisnikDto korisnikDto);
    Korisnik pretraziPoEmail(String email);
}
