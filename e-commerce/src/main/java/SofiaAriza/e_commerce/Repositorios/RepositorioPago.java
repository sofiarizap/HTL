package SofiaAriza.e_commerce.Repositorios;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RepositorioPago extends JpaRepository<Pago, Long> {
  // Obtener todos los pagos de un cliente específico
  List<Pago> findByCliente(Cliente cliente);
}
