package com.si.springboot.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DogadjajDto {
    private Long id;
    @NotEmpty(message = "Naziv ne smije biti prazan!")
    private String naziv;
    @NotNull(message = "Datum ne smije biti prazan!")
    private LocalDate datum;
    @NotEmpty(message = "Opis ne smije biti prazan!")
    private String opis;
    @NotEmpty(message = "Slika ne smije biti prazna!")
    private String slika;
    private String url;
    private Set<KomentarDto> komentari;
    private LokacijaDto lokacija;
    private KategorijaDto kategorija;
}
