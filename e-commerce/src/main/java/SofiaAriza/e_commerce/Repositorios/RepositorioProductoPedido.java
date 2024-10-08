package SofiaAriza.e_commerce.Repositorios;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RepositorioProductoPedido extends JpaRepository<ProductoPedido, Long> {
  // Si necesitas métodos personalizados, puedes agregarlos aquí
}{
}
