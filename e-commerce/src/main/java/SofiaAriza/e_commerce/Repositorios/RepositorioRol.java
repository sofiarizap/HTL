package SofiaAriza.e_commerce.Repositorios;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RepositorioRol extends JpaRepository<Rol, Long> {
  // Buscar un rol por su nombre (ejemplo: ROLE_ADMIN, ROLE_USER)
  Optional<Rol> findByNombre(String nombre);
} {
}
