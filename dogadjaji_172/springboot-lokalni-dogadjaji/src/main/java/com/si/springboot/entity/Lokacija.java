package com.si.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Lokacija")
public class Lokacija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String naziv;
    @Lob
    private String opis;
    private String slika;

    @OneToMany(mappedBy = "lokacija", cascade = CascadeType.REMOVE)
    private List<Dogadjaj> dogadjajList = new ArrayList<>();
}
