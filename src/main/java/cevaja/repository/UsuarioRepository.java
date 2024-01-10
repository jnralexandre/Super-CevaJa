package cevaja.repository;

import cevaja.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByName(String name);
    Usuario findByEmail(String email);
    Usuario findByUsername(String username);
}
