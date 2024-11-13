package SofiaAriza.e_commerce.Repositorios;

import SofiaAriza.e_commerce.Models.Cliente;
import SofiaAriza.e_commerce.Models.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface RepositorioPago extends JpaRepository<Pago, Long> {
  List<Pago> findByClienteId(Long clienteId);
}
