package SofiaAriza.e_commerce.Repositorios;

import SofiaAriza.e_commerce.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface RepositorioCliente extends JpaRepository<Cliente, Long> {
    List<Cliente> findByEmail(String email);

}
