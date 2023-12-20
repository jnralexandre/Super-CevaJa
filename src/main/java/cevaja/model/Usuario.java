package cevaja.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nome;
    @Column
    private String sobrenome;
    @Column
    private LocalDate dataNascimento;
    @Column
    private String cpf;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String senha;

}