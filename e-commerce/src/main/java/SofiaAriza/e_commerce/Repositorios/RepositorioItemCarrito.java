package SofiaAriza.e_commerce.Repositorios;

import SofiaAriza.e_commerce.Models.ItemCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RepositorioItemCarrito extends JpaRepository<ItemCarrito, Long> {
}
