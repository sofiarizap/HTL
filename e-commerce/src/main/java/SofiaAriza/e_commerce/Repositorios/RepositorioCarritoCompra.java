package SofiaAriza.e_commerce.Repositorios;

import SofiaAriza.e_commerce.Models.CarritoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface RepositorioCarritoCompra extends JpaRepository<CarritoCompra, Long> {
  // Buscar el carrito de un cliente específico
  Optional<CarritoCompra> findByClienteId(Long clienteId);
}
