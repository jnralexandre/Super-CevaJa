package cevaja.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserRequestDTO {

    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private String cpf;
    private String username;
    private String email;
    private String password;

}
