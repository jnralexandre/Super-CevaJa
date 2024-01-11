package cevaja.repository;

import cevaja.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    User findByEmail(String email);
    User findByUsername(String username);
}
