package com.si.springboot.dto;

import com.si.springboot.entity.Dogadjaj;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KategorijaDto {
    private Long id;
    @NotEmpty(message = "Naziv ne smije biti prazan!")
    private String naziv;
    private String ikonica;
    private List<DogadjajDto> dogadjajList = new ArrayList<>();
}
