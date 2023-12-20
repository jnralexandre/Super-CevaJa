package cevaja.model.dto.converter;

import cevaja.model.Usuario;
import cevaja.model.dto.UsuarioRequestDTO;
import cevaja.model.dto.UsuarioResponseDTO;
import lombok.Data;

@Data
public class UsuarioConverter {

    public static Usuario converterParaEntidade(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuarioEntity = new Usuario();
        usuarioEntity.setNome(usuarioRequestDTO.getNome());
        usuarioEntity.setSobrenome(usuarioRequestDTO.getSobrenome());
        usuarioEntity.setDataNascimento(usuarioRequestDTO.getDataNascimento());
        usuarioEntity.setCpf(usuarioRequestDTO.getCpf());
        usuarioEntity.setUsername(usuarioRequestDTO.getUsername());
        usuarioEntity.setEmail(usuarioRequestDTO.getEmail());
        usuarioEntity.setSenha(usuarioRequestDTO.getSenha());

        return usuarioEntity;
    }

    public static UsuarioResponseDTO converterParaDTO(Usuario usuario) {
        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
        usuarioResponseDTO.setNome(usuario.getNome());
        usuarioResponseDTO.setSobrenome(usuario.getSobrenome());
        usuarioResponseDTO.setDataNascimento(usuario.getDataNascimento());
        usuarioResponseDTO.setUsername(usuario.getUsername());
        usuarioResponseDTO.setEmail(usuario.getEmail());

        return usuarioResponseDTO;
    }

}
