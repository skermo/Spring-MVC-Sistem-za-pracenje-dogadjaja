package com.si.springboot.repository;

import com.si.springboot.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Korisnik findByEmail(String email);
}
