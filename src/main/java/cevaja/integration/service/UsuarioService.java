package cevaja.integration.service;

import cevaja.model.Usuario;
import cevaja.model.dto.UsuarioRequestDTO;
import cevaja.model.dto.converter.UsuarioConverter;
import cevaja.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private static final String MENSAGEM_PARA_NOME_EXISTENTE = "O nome de usuário já possuí um cadastro no Banco de Dados";

    private static final String MENSAGEM_EMAIL_NOME_EXISTENTE = "O e-mail já possuí um cadastro no Banco de Dados";

    public UsuarioService(UsuarioRepository userRepository) {
        this.usuarioRepository = userRepository;
    }

    public Usuario buscarUsuarioPorNomeUsuario(String nome) {
        return usuarioRepository.findByNomeUsuario(nome);
    }

    public Usuario buscarUsuarioPorEmail(String nome) {
        return usuarioRepository.findByEmail(nome);
    }

    public Usuario cadastrarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        String nome = usuarioRequestDTO.getNome();
        String sobrenome = usuarioRequestDTO.getSobrenome();
        LocalDate dataNascimentoUsuario = usuarioRequestDTO.getDataNascimento();
        String nomeUsuario = usuarioRequestDTO.getUsername();
        String email = usuarioRequestDTO.getEmail();

        Usuario usuarioExistentePorUsername = buscarUsuarioPorNomeUsuario(nomeUsuario);
        Usuario usuarioExistentePorEmail = buscarUsuarioPorEmail(email);

        // Verifica se Usuário existe pelo seu nome
        if (usuarioExistentePorUsername != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, MENSAGEM_PARA_NOME_EXISTENTE);
        }

        // Verifica se Usuário existe pelo seu email
        if (usuarioExistentePorEmail != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, MENSAGEM_EMAIL_NOME_EXISTENTE);
        }

        // A partir daqui, pode adicionar o Usuário no BD
        Usuario usuarioParaAdicionar = UsuarioConverter.converterParaEntidade(usuarioRequestDTO);
        return usuarioRepository.save(usuarioParaAdicionar);
    }
}
