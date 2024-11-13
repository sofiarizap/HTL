package SofiaAriza.e_commerce.Repositorios;

import SofiaAriza.e_commerce.Models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface RepositorioRol extends JpaRepository<Rol, Long> {
  // Buscar un rol por su nombre (ejemplo: ROLE_ADMIN, ROLE_USER)
  Optional<Rol> findByNombre(String nombre);
}
