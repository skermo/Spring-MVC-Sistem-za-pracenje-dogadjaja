package com.si.springboot.repository;

import com.si.springboot.entity.Dogadjaj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DogadjajRepository extends JpaRepository <Dogadjaj, Long> {
    Optional<Dogadjaj> findByUrl(String url);
    @Query("SELECT d " +
            "FROM Dogadjaj d " +
            "WHERE d.naziv LIKE CONCAT('%', :query, '%') OR d.opis LIKE CONCAT('%', :query, '%')")
    List<Dogadjaj> pretraziDogadjaje(String query);
}
