package com.si.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KorisnikDto {
    private Long id;
    @NotEmpty(message = "Ime ne smije biti prazno!")
    private String ime;
    @NotEmpty(message = "Prezime ne smije biti prazno!")
    private String prezime;
    @NotEmpty(message = "Email ne smije biti prazan!")
    @Email
    private String email;
    @NotEmpty(message = "Password ne smije biti prazan!")
    private String password;
}
