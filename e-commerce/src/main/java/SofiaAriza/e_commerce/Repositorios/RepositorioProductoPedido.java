package SofiaAriza.e_commerce.Repositorios;

import SofiaAriza.e_commerce.Models.ProductoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RepositorioProductoPedido extends JpaRepository<ProductoPedido, Long> {
  // Si necesitas métodos personalizados, puedes agregarlos aquí
}
