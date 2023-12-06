package cevaja.model.dto.converter;

import cevaja.model.Usuario;
import cevaja.model.dto.UsuarioRequestDTO;
import lombok.Data;

@Data
public class UsuarioConverter {

    public static Usuario converterParaEntidade(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuarioEntity = new Usuario();
        usuarioEntity.setNome(usuarioRequestDTO.getNome());
        usuarioEntity.setSobrenome(usuarioRequestDTO.getSobrenome());
        usuarioEntity.setDataNascimento(usuarioRequestDTO.getDataNascimento());
        usuarioEntity.setUsername(usuarioRequestDTO.getUsername());
        usuarioEntity.setEmail(usuarioRequestDTO.getEmail());

        return usuarioEntity;
    }

}
