package com.si.springboot.service.impl;

import com.si.springboot.dto.KorisnikDto;
import com.si.springboot.entity.Korisnik;
import com.si.springboot.entity.Role;
import com.si.springboot.repository.KorisnikRepository;
import com.si.springboot.repository.RoleRepository;
import com.si.springboot.service.KorisnikService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class KorisikServiceImpl implements KorisnikService {

    private KorisnikRepository korisnikRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public KorisikServiceImpl(KorisnikRepository korisnikRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.korisnikRepository = korisnikRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void sacuvajKorisnika(KorisnikDto korisnikDto) {
        Korisnik korisnik = new Korisnik();
        korisnik.setIme(korisnikDto.getIme());
        korisnik.setPrezime(korisnikDto.getPrezime());
        korisnik.setEmail(korisnikDto.getEmail());
        korisnik.setPassword(passwordEncoder.encode(korisnikDto.getPassword()));
        Role role = roleRepository.findByNaziv("ROLE_GUEST");
        korisnik.setRole(Arrays.asList(role));
        korisnikRepository.save(korisnik);
    }

    @Override
    public Korisnik pretraziPoEmail(String email) {
        return korisnikRepository.findByEmail(email);
    }
}
