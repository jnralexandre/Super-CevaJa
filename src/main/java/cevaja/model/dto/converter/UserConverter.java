package cevaja.model.dto.converter;

import cevaja.model.User;
import cevaja.model.dto.UserRequestDTO;
import cevaja.model.dto.UserResponseDTO;
import lombok.Data;

@Data
public class UserConverter {

    public static User converterParaEntidade(UserRequestDTO usuarioRequestDTO) {
        User usuarioEntity = new User();
        usuarioEntity.setName(usuarioRequestDTO.getName());
        usuarioEntity.setLastName(usuarioRequestDTO.getLastName());
        usuarioEntity.setDateOfBirth(usuarioRequestDTO.getDateOfBirth());
        usuarioEntity.setCpf(usuarioRequestDTO.getCpf());
        usuarioEntity.setUsername(usuarioRequestDTO.getUsername());
        usuarioEntity.setEmail(usuarioRequestDTO.getEmail());
        usuarioEntity.setPassword(usuarioRequestDTO.getPassword());

        return usuarioEntity;
    }

    public static UserResponseDTO converterParaDTO(User usuario) {
        UserResponseDTO usuarioResponseDTO = new UserResponseDTO();
        usuarioResponseDTO.setId(usuario.getId());
        usuarioResponseDTO.setName(usuario.getName());
        usuarioResponseDTO.setLastName(usuario.getLastName());
        usuarioResponseDTO.setDataOfBirth(usuario.getDateOfBirth());
        usuarioResponseDTO.setUsername(usuario.getUsername());
        usuarioResponseDTO.setEmail(usuario.getEmail());

        return usuarioResponseDTO;
    }

}
