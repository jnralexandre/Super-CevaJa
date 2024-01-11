package cevaja.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CervejaRequestDTO {

    private String type;
    private BigDecimal price;

}
