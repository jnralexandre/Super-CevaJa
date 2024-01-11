package cevaja.integration.service;

import cevaja.model.Usuario;
import cevaja.model.dto.UsuarioRequestDTO;
import cevaja.model.dto.UsuarioResponseDTO;
import cevaja.model.dto.converter.UsuarioConverter;
import cevaja.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UsuarioRepository usuarioRepository;

    private static final String MENSAGEM_PARA_NOME_USUARIO_EXISTENTE = "O nome de usuário já possuí um cadastro no Banco de Dados";
    private static final String MENSAGEM_EMAIL_EXISTENTE = "O e-mail já possuí um cadastro no Banco de Dados";
    private static final String MENSAGEM_PARA_USERNAME_INEXISTENTE = "Não é possível deletar um Usuário inexistente.";
    private static final String MENSAGEM_PARA_ID_INEXISTENTE = "Não é possível alterar um Usuário inexistente.";

    public UserService(UsuarioRepository userRepository) {
        this.usuarioRepository = userRepository;
    }

    public Usuario buscarUsuarioPorNomeUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public void cadastrarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        String name = usuarioRequestDTO.getName();
        String lastName = usuarioRequestDTO.getLastName();
        LocalDate dateOfBirth = usuarioRequestDTO.getDateOfBirth();
        String cpf = usuarioRequestDTO.getCpf();
        String username = usuarioRequestDTO.getUsername();
        String email = usuarioRequestDTO.getEmail();
        String password = usuarioRequestDTO.getPassword();

        Usuario usuarioExistentePorUsername = buscarUsuarioPorNomeUsuario(username);
        Usuario usuarioExistentePorEmail = buscarUsuarioPorEmail(email);

        // Verifica se Usuário existe pelo seu nome
        if (usuarioExistentePorUsername != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, MENSAGEM_PARA_NOME_USUARIO_EXISTENTE);
        }

        // Verifica se Usuário existe pelo seu email
        if (usuarioExistentePorEmail != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, MENSAGEM_EMAIL_EXISTENTE);
        }

        // A partir daqui, pode adicionar o Usuário no BD
        Usuario usuarioParaAdicionar = UsuarioConverter.converterParaEntidade(usuarioRequestDTO);
        usuarioRepository.save(usuarioParaAdicionar);
    }

    public List<UsuarioResponseDTO> buscarTodosUsuarios() {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();

        List<UsuarioResponseDTO> listaUsuariosResponseDTO = new ArrayList<>();
        for (Usuario u : listaUsuarios) {
            listaUsuariosResponseDTO.add(UsuarioConverter.converterParaDTO(u));
        }

        return listaUsuariosResponseDTO;
    }

    public void deletarUsuarioPorUsername(String username) {
        Usuario usuarioParaDeletar = usuarioRepository.findByUsername(username);

        if (usuarioParaDeletar == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, MENSAGEM_PARA_USERNAME_INEXISTENTE
            );
        } else {
            usuarioRepository.delete(usuarioParaDeletar);
        }
    }

    public Usuario alterarNomeEOuSobrenomePorId(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        Optional<Usuario> usuarioOptionalParaAlterar = usuarioRepository.findById(id);

        if (usuarioOptionalParaAlterar.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, MENSAGEM_PARA_ID_INEXISTENTE
            );
        } else {
            Usuario usuarioParaAlterar = usuarioOptionalParaAlterar.get();
            String nameUser = usuarioRequestDTO.getName();

            if (nameUser != null) {
                usuarioParaAlterar.setName(nameUser);
            }

            String lastNameUser = usuarioRequestDTO.getLastName();
            if (lastNameUser != null) {
                usuarioParaAlterar.setLastName(lastNameUser);
            }

            usuarioRepository.save(usuarioParaAlterar);

            return usuarioParaAlterar;
        }

    }

}
