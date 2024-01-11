package cevaja.model.dto.converter;

import cevaja.model.Cerveja;
import cevaja.model.Usuario;
import cevaja.model.dto.CervejaRequestDTO;
import cevaja.model.dto.CervejaResponseDTO;
import cevaja.model.dto.UsuarioRequestDTO;
import lombok.Data;

@Data
public class CervejaConverter {

    public static Cerveja converterParaEntidade(CervejaRequestDTO cervejaRequestDTO) {
        Cerveja cervejaEntity = new Cerveja();
        cervejaEntity.setType(cervejaRequestDTO.getType());
        cervejaEntity.setPrice(cervejaRequestDTO.getPrice());

        return cervejaEntity;
    }

    public static CervejaResponseDTO converterParaDTO(Cerveja cerveja) {
        CervejaResponseDTO cervejaResponseDTO = new CervejaResponseDTO();
        cervejaResponseDTO.setId(cerveja.getId());
        cervejaResponseDTO.setType(cerveja.getType());
        cervejaResponseDTO.setPrice(cerveja.getPrice());

        return cervejaResponseDTO;
    }

}
