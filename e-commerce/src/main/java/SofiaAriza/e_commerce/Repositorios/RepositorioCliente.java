package SofiaAriza.e_commerce.Repositorios;

import SofiaAriza.e_commerce.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RepositorioCliente extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email);
}
