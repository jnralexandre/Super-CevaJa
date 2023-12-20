package cevaja.controller;

import cevaja.integration.service.UsuarioService;
import cevaja.model.Usuario;
import cevaja.model.dto.UsuarioRequestDTO;
import cevaja.model.dto.UsuarioResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        usuarioService.cadastrarUsuario(usuarioRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/buscar-usuarios")
    public ResponseEntity<List<UsuarioResponseDTO>> buscarTodosUsuarios() {
        return ResponseEntity.ok(this.usuarioService.buscarTodosUsuarios());
    }

    @DeleteMapping("/deletar-usuarios/{username}")
    public ResponseEntity<Void> deletarUsuarioPorUsername(@PathVariable("username") String username) {
        this.usuarioService.deletarUsuarioPorUsername(username);
        return ResponseEntity.accepted().build();
    }

}
