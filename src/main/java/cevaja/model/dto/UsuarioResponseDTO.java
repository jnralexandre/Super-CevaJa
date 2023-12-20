package cevaja.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioResponseDTO {

    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String username;
    private String email;

}
