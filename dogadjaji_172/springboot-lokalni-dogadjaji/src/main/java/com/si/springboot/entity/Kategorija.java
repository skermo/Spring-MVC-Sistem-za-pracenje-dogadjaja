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
@Table(name = "Kategorija")
public class Kategorija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String naziv;
    private String ikonica;

    @OneToMany(mappedBy = "kategorija", cascade = CascadeType.REMOVE)
    private List<Dogadjaj> dogadjajList = new ArrayList<>();
}
