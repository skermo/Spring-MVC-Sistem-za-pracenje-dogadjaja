package com.si.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KomentarDto {
    private Long id;
    @NotEmpty(message = "Email ne smije biti prazan!")
    @Email
    private String email;
    @NotEmpty(message = "Tekst ne smije biti prazan!")
    private String tekst;
    private LocalDate datum;
}
