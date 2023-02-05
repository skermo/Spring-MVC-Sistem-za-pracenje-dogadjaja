package com.si.springboot.repository;

import com.si.springboot.entity.Kategorija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategorijaRepository extends JpaRepository<Kategorija, Long> {

}
