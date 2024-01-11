package cevaja.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private LocalDate dateOfBirth;
    @Column
    private String cpf;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;

}