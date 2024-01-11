package cevaja.controller;

import cevaja.integration.service.UserService;
import cevaja.model.User;
import cevaja.model.dto.UserRequestDTO;
import cevaja.model.dto.UserResponseDTO;
import cevaja.model.dto.converter.UserConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
public class UserController {

    private UserService usuarioService;

    public UserController(UserService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody UserRequestDTO usuarioRequestDTO) {
        usuarioService.cadastrarUsuario(usuarioRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/buscar-usuarios")
    public ResponseEntity<List<UserResponseDTO>> buscarTodosUsuarios() {
        return ResponseEntity.ok(this.usuarioService.buscarTodosUsuarios());
    }

    @DeleteMapping("/deletar-usuarios/{username}")
    public ResponseEntity<Void> deletarUsuarioPorUsername(@PathVariable("username") String username) {
        this.usuarioService.deletarUsuarioPorUsername(username);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> alterarNomeEOuSobrenomePorId(@PathVariable("id") Long id,
                                                                        @RequestBody UserRequestDTO usuarioDTO) {
        User usuarioAlterado = this.usuarioService.alterarNomeEOuSobrenomePorId(id, usuarioDTO);
        return ResponseEntity.ok(UserConverter.converterParaDTO(usuarioAlterado));
    }

}
