package com.si.springboot.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Dogadjaj")
public class Dogadjaj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String naziv;
    private LocalDate datum;
    @Lob
    @Column(nullable = false)
    private String opis;
    private String slika;
    private String url;

    @OneToMany(mappedBy = "dogadjaj", cascade = CascadeType.REMOVE)
    Set<Komentar> kometari = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "lokacija_id", nullable = false)
    private Lokacija lokacija;

    @ManyToOne
    @JoinColumn(name = "kategorija_id", nullable = false)
    private Kategorija kategorija;
}
