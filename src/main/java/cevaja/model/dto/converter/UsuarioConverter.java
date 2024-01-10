package cevaja.model.dto.converter;

import cevaja.model.Usuario;
import cevaja.model.dto.UsuarioRequestDTO;
import cevaja.model.dto.UsuarioResponseDTO;
import lombok.Data;

@Data
public class UsuarioConverter {

    public static Usuario converterParaEntidade(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuarioEntity = new Usuario();
        usuarioEntity.setName(usuarioRequestDTO.getName());
        usuarioEntity.setLastName(usuarioRequestDTO.getLastName());
        usuarioEntity.setDateOfBirth(usuarioRequestDTO.getDateOfBirth());
        usuarioEntity.setCpf(usuarioRequestDTO.getCpf());
        usuarioEntity.setUsername(usuarioRequestDTO.getUsername());
        usuarioEntity.setEmail(usuarioRequestDTO.getEmail());
        usuarioEntity.setPassword(usuarioRequestDTO.getPassword());

        return usuarioEntity;
    }

    public static UsuarioResponseDTO converterParaDTO(Usuario usuario) {
        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
        usuarioResponseDTO.setId(usuario.getId());
        usuarioResponseDTO.setName(usuario.getName());
        usuarioResponseDTO.setLastName(usuario.getLastName());
        usuarioResponseDTO.setDataOfBirth(usuario.getDateOfBirth());
        usuarioResponseDTO.setUsername(usuario.getUsername());
        usuarioResponseDTO.setEmail(usuario.getEmail());

        return usuarioResponseDTO;
    }

}
