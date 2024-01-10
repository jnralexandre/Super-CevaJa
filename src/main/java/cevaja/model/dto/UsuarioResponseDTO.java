package cevaja.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioResponseDTO {

    private Long id;
    private String name;
    private String lastName;
    private LocalDate dataOfBirth;
    private String username;
    private String email;

}
