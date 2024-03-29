package cevaja.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CervejaResponseDTO {

    private Long id;
    private String type;
    private BigDecimal price;

}
