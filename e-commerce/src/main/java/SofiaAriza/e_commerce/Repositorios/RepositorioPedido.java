package SofiaAriza.e_commerce.Repositorios;

import SofiaAriza.e_commerce.Models.Cliente;
import SofiaAriza.e_commerce.Models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface RepositorioPedido extends JpaRepository<Pedido, Long> {
  List<Pedido> findByClienteId(Long clienteId);

  List<Pedido> findByCliente(Cliente cliente);
}

