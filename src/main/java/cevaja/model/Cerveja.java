package cevaja.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "cerveja")
@Data
public class Cerveja {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String type;
    @Column
    private BigDecimal price;

}
