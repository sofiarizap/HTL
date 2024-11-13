package SofiaAriza.e_commerce.Repositorios;

import SofiaAriza.e_commerce.Models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RepositorioProducto extends JpaRepository<Producto, Long> {
  // Puedes agregar métodos personalizados si es necesario
}
