package SofiaAriza.e_commerce.Repositorios;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RepositorioItemCarrito extends JpaRepository<ItemCarrito, Long> {
}
