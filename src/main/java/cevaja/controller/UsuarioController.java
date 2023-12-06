package cevaja.controller;

import cevaja.integration.service.UsuarioService;
import cevaja.model.Usuario;
import cevaja.model.dto.UsuarioRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        usuarioService.cadastrarUsuario(usuarioRequestDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
