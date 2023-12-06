package cevaja.repository;

import cevaja.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNomeUsuario(String nome);
    Usuario findByEmail(String email);
}
