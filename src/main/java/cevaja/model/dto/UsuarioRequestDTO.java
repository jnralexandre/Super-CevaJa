package cevaja.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioRequestDTO {

    private String nome;

    private String sobrenome;

    private LocalDate dataNascimento;

    private String username;

    private String email;

}
