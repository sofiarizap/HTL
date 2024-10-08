package SofiaAriza.e_commerce.Repositorios;

import SofiaAriza.e_commerce.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
  // Buscar un usuario por su nombre de usuario (username)
  Optional<Usuario> findByUsername(String username);
}
